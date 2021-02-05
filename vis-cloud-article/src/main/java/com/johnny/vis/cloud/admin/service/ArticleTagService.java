package com.johnny.vis.cloud.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johnny.vis.cloud.admin.dao.ArticleTagMapper;
import com.johnny.vis.cloud.admin.entity.ArticleTagEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny
 * @date 2021-01-19
 */
@Service
public class ArticleTagService extends ServiceImpl<ArticleTagMapper, ArticleTagEntity> {

    /**
     * 根据标签名列表查询
     *
     * @param tagNameList 标签名列表
     */
    public List<ArticleTagEntity> queryListByNameList(List<String> tagNameList) {
        if (tagNameList == null || tagNameList.isEmpty()) {
            return null;
        }
        return this.baseMapper.selectList(new QueryWrapper<ArticleTagEntity>().lambda().in(ArticleTagEntity::getTagName, tagNameList));
    }

    /**
     * 根据articleId查询列表
     *
     * TODO 添加cache
     */
    public List<ArticleTagEntity> queryListByArticleId(Long articleId) {
        if (articleId == null) {
            return new ArrayList<>();
        }
        return this.baseMapper.selectList(new QueryWrapper<ArticleTagEntity>().lambda().eq(ArticleTagEntity::getArticleId, articleId));
    }
}
