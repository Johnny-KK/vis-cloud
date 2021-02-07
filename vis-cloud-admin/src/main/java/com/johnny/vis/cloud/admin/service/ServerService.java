package com.johnny.vis.cloud.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johnny.vis.cloud.admin.dao.ServerMapper;
import com.johnny.vis.cloud.admin.entity.ServerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Johnny
 * @date 2021-02-05
 */
@Service
public class ServerService extends ServiceImpl<ServerMapper, ServerEntity> {

    /**
     * 条件查询服务器信息列表
     *
     * @param entity entity
     */
    public List<ServerEntity> queryServerList(ServerEntity entity) {
        return this.baseMapper.selectList(new QueryWrapper<ServerEntity>().lambda());
    }
}
