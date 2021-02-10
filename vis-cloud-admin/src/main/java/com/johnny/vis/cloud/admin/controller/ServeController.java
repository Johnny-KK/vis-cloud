package com.johnny.vis.cloud.admin.controller;

import com.johnny.vis.cloud.admin.entity.ServeEntity;
import com.johnny.vis.cloud.admin.service.ServeService;
import com.johnny.vis.cloud.common.constant.Response;
import com.johnny.vis.cloud.common.entity.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Johnny
 * @date 2021-02-09
 */
@Api("服务")
@RestController
@RequestMapping("serve")
public class ServeController {

    private final ServeService serveService;

    public ServeController(ServeService serveService) {
        this.serveService = serveService;
    }

    @ApiOperation("保存服务信息")
    @PostMapping("saveServe")
    public ResponseData<Object> saveServe(@RequestBody ServeEntity entity) {
        this.serveService.saveOrUpdate(entity);
        return ResponseData.success(Response.SUCCESS_SAVE);
    }

    @ApiOperation("条件查询服务信息列表")
    @GetMapping("queryServeList")
    public ResponseData<List<ServeEntity>> queryServeList(ServeEntity entity) {
        return ResponseData.success(serveService.queryServeList(entity));
    }
}
