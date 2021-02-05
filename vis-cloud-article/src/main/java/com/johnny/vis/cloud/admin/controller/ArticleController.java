package com.johnny.vis.cloud.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.johnny.vis.cloud.admin.entity.ArticleEntity;
import com.johnny.vis.cloud.admin.entity.ArticleTagEntity;
import com.johnny.vis.cloud.admin.qo.ArticleQo;
import com.johnny.vis.cloud.admin.service.ArticleService;
import com.johnny.vis.cloud.admin.service.ArticleTagService;
import com.johnny.vis.cloud.admin.trans.ArticleTrans;
import com.johnny.vis.cloud.admin.vo.ArticleVo;
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
public class ArticleController implements ArticleTrans {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleTagService articleTagService;

    @GetMapping("getArticleList")
    @ApiOperation(value = "条件获取文章列表", notes = "条件获取文章列表 列表去除文章内容字段以减少传输体积")
    public ResponseData<List<ArticleEntity>> getArticleList(ArticleQo param) {
        return ResponseData.success(articleService.getArticleList(param).stream().peek(x -> x.setContent(null)).collect(Collectors.toList()));
    }

    @GetMapping("getArticleById")
    @ApiOperation(value = "根据ID获取文章--entity")
    public ResponseData<ArticleEntity> getArticleById(Long id) {
        return ResponseData.success(articleService.getById(id));
    }

    @GetMapping("getArticleVoById")
    @ApiOperation("根据ID获取文章--vo")
    public ResponseData<ArticleVo> getArticleVoById(Long id) {
        ArticleEntity entity = articleService.getById(id);
        return ResponseData.success(entityTransVo(entity));
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

    @Override
    public ArticleVo entityTransVo(ArticleEntity entity) {
        ArticleVo vo = new ArticleVo();
        BeanUtil.copyProperties(entity, vo);
        if (vo.getModifyTime() == null) {
            vo.setModifyTime(entity.getCreateTime());
        }
        List<ArticleTagEntity> list = articleTagService.queryListByArticleId(entity.getId());
        if (!list.isEmpty()) {
            vo.setTagList(list.stream().map(ArticleTagEntity::getTagName).collect(Collectors.toList()));
        }
        return vo;
    }
}
