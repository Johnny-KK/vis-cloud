package com.johnny.vis.cloud.article.controller;

import com.johnny.vis.cloud.article.entity.ArticleEntity;
import com.johnny.vis.cloud.article.service.ArticleService;
import com.johnny.vis.cloud.common.entity.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Johnny
 * @date 2020-12-23
 */
@RestController
@RequestMapping("article")
@Api("文章")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("getArticleList")
    @ApiOperation(value = "条件获取文章列表", notes = "条件获取文章列表 列表去除文章内容字段以减少传输体积")
    public ResponseData<List<ArticleEntity>> getArticleList(String fuzzy) {
        return ResponseData.success(articleService.getArticleList(fuzzy).stream().peek(x -> x.setContent(null)).collect(Collectors.toList()));
    }

    @GetMapping("getArticleById")
    @ApiOperation(value = "根据ID获取文章内容")
    public ResponseData<ArticleEntity> getArticleById(Long id) {
        return ResponseData.success(articleService.getById(id));
    }

    @PostMapping("addArticle")
    @ApiOperation(value = "新增文章")
    public ResponseData<ArticleEntity> addArticle(@RequestBody ArticleEntity entity) {
        return ResponseData.success(articleService.addArticle(entity));
    }

    @PostMapping("updateArticle")
    @ApiOperation(value = "更新文章")
    public ResponseData<ArticleEntity> updateArticle(@RequestBody ArticleEntity entity) {
        return ResponseData.success(articleService.updateArticle(entity));
    }
}
