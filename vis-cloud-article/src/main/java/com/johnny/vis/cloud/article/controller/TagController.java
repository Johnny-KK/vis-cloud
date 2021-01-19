package com.johnny.vis.cloud.article.controller;

import com.johnny.vis.cloud.article.entity.TagEntity;
import com.johnny.vis.cloud.article.service.TagService;
import com.johnny.vis.cloud.common.entity.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "条件查询标签列表")
    @GetMapping("queryTagList")
    public ResponseData<List<TagEntity>> queryTagList() {
        return ResponseData.success(tagService.queryTagList());
    }

    @ApiOperation(value = "新增标签")
    @PostMapping(value = "addTag")
    public ResponseData<TagEntity> addTag(@RequestBody TagEntity tagEntity) {
        tagService.save(tagEntity);
        return  ResponseData.success(Response.SUCCESS_SAVE, tagEntity);
    }
}
