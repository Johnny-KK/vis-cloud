package com.johnny.vis.cloud.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.johnny.vis.cloud.admin.entity.ServerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Johnny
 * @date 2021-02-05
 */
@Repository
public interface ServerMapper extends BaseMapper<ServerEntity> {

    /**
     * 条件查询服务器列表以及下属服务列表
     *
     * @return ServerVo[]
     */
    List<Map<String, Object>> queryServerListWithServe();
}
