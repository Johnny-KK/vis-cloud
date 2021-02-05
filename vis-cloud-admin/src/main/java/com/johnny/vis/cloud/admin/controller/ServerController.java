package com.johnny.vis.cloud.admin.controller;

import com.johnny.vis.cloud.admin.service.ServerService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johnny
 * @date 2021-02-05
 */
@RestController
@RequestMapping("Server")
@Api("服务器")
public class ServerController {
    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }
}
