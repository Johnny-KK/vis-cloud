package com.johnny.vis.cloud.admin.trans;

import com.johnny.vis.cloud.admin.entity.ArticleEntity;
import com.johnny.vis.cloud.admin.vo.ArticleVo;

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
