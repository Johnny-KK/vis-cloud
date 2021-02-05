package com.johnny.vis.cloud.article.controller;

import com.johnny.vis.cloud.article.entity.TagEntity;
import com.johnny.vis.cloud.article.service.TagService;
import com.johnny.vis.cloud.common.constant.Response;
import com.johnny.vis.cloud.common.entity.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Johnny
 * @date 2020-12-27
 */
@RestController
@RequestMapping("tag")
@Api("标签")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @ApiOperation(value = "条件查询标签列表")
    @GetMapping("queryTagList")
    public ResponseData queryTagList(TagEntity entity) {
        return ResponseData.success(tagService.queryTagList(entity));
    }

    @ApiOperation(value = "新增标签")
    @PostMapping(value = "addTag")
    public ResponseData addTag(@RequestBody TagEntity tagEntity) {
        List<TagEntity> list = tagService.queryTagList(tagEntity);
        if (!list.isEmpty()) {
            return ResponseData.error("标签名不能重复");
        }
        return  ResponseData.success(Response.SUCCESS_SAVE, tagService.save(tagEntity));
    }
}
