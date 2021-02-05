package com.johnny.vis.cloud.article.trans;

import com.johnny.vis.cloud.article.entity.ArticleEntity;
import com.johnny.vis.cloud.article.vo.ArticleVo;

/**
 * @author Johnny
 * @date 2021-01-19
 */
public interface ArticleTrans {

    /**
     *
     * @param entity ArticleEntity
     * @return ArticleVo
     */
    ArticleVo entityTransVo(ArticleEntity entity);
}
