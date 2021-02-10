package com.johnny.vis.cloud.admin.controller;

import com.johnny.vis.cloud.admin.entity.ServerEntity;
import com.johnny.vis.cloud.admin.service.ServerService;
import com.johnny.vis.cloud.admin.vo.ServerVo;
import com.johnny.vis.cloud.common.constant.Response;
import com.johnny.vis.cloud.common.entity.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Johnny
 * @date 2021-02-05
 */
@RestController
@RequestMapping("server")
@Api("服务器")
public class ServerController {
    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @ApiOperation("保存服务器信息")
    @PostMapping("saveServer")
    public ResponseData<Object> saveServer(@RequestBody ServerEntity entity) {
        this.serverService.saveOrUpdate(entity);
        return ResponseData.success(Response.SUCCESS_SAVE);
    }

    @ApiOperation("条件查询服务器信息列表")
    @GetMapping("queryServerList")
    public ResponseData<List<ServerEntity>> queryServerList(ServerEntity entity) {
        return ResponseData.success(serverService.queryServerList(entity));
    }

    @ApiOperation("条件查询服务器列表以及下属服务列表")
    @GetMapping("queryServerListWithServe")
    public ResponseData<List<ServerVo>> queryServerListWithServe() {
        return ResponseData.success(serverService.queryServerListWithServe());
    }
}
