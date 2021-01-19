package com.johnny.vis.cloud.article.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johnny.vis.cloud.article.dao.ArticleMapper;
import com.johnny.vis.cloud.article.entity.ArticleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Johnny
 * @date 2020-12-23
 */
@Service
public class ArticleService extends ServiceImpl<ArticleMapper, ArticleEntity> {

    /**
     * 条件获取文章列表
     *
     * @param fuzzy 模糊搜索 模糊匹配title、content字段
     * @return ArticleEntity[]
     */
    public List<ArticleEntity> getArticleList(String fuzzy) {
        return this.baseMapper.selectList(new QueryWrapper<ArticleEntity>().lambda()
                .and(StrUtil.isNotBlank(fuzzy),
                        i -> i.like(ArticleEntity::getTitle, fuzzy).or().like(ArticleEntity::getContent, fuzzy))
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
