package com.johnny.vis.cloud.article.controller;

import com.johnny.vis.cloud.article.entity.ArticleTagEntity;
import com.johnny.vis.cloud.article.service.ArticleTagService;
import com.johnny.vis.cloud.common.constant.Response;
import com.johnny.vis.cloud.common.entity.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johnny
 * @date 2021-01-19
 */
@RestController
@RequestMapping("ArticleTag")
@Api("文章标签关系")
public class ArticleTagController {

    private final ArticleTagService articleTagService;

    public ArticleTagController(ArticleTagService articleTagService) {
        this.articleTagService = articleTagService;
    }

    @ApiOperation("新增文章标签对应关系")
    @PostMapping("addArticleTag")
    public ResponseData<ArticleTagEntity> addArticleTag(ArticleTagEntity entity) {
        articleTagService.save(entity);
        return ResponseData.success(Response.SUCCESS_SAVE, entity);
    }

}
