package com.johnny.vis.cloud.article.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johnny.vis.cloud.article.dao.ArticleMapper;
import com.johnny.vis.cloud.article.entity.ArticleEntity;
import com.johnny.vis.cloud.article.entity.ArticleTagEntity;
import com.johnny.vis.cloud.article.qo.ArticleQo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Johnny
 * @date 2020-12-23
 */
@Service
public class ArticleService extends ServiceImpl<ArticleMapper, ArticleEntity> {

    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 条件获取文章列表
     *
     * @param param 查询参数
     * @return ArticleEntity[]
     */
    public List<ArticleEntity> getArticleList(ArticleQo param) {
        List<Long> ids = null;
        if (param.getTagList() != null && !param.getTagList().isEmpty()) {
            ids = articleTagService.queryListByNameList(param.getTagList()).stream().map(ArticleTagEntity::getArticleId).collect(Collectors.toList());
        }
        return this.baseMapper.selectList(new QueryWrapper<ArticleEntity>().lambda()
                .and(StrUtil.isNotBlank(param.getFuzzy()),
                        i -> i.like(ArticleEntity::getTitle, param.getFuzzy()).or().like(ArticleEntity::getContent, param.getFuzzy()))
                .in(ids != null && !ids.isEmpty(), ArticleEntity::getId, ids)
                .orderByDesc(ArticleEntity::getModifyTime));
    }

    /**
     * 新增文章
     */
    public ArticleEntity addArticle(ArticleEntity entity) {
        this.baseMapper.insert(entity);
        return entity;
    }

    /**
     * 更新文章
     */
    public ArticleEntity updateArticle(ArticleEntity entity) {
        this.baseMapper.updateById(entity);
        return entity;
    }
}
