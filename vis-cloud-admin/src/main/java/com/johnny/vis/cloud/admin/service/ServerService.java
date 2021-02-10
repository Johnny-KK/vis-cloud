package com.johnny.vis.cloud.admin.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johnny.vis.cloud.admin.dao.ServerMapper;
import com.johnny.vis.cloud.admin.entity.ServerEntity;
import com.johnny.vis.cloud.admin.vo.ServerWithServeVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    /**
     * 条件查询服务器列表以及下属服务列表
     */
    public List<ServerWithServeVo> queryServerListWithServe() {
        List<Map<String, Object>> maps = this.baseMapper.queryServerListWithServe();
        List<ServerWithServeVo> result = new ArrayList<>();
        if (maps.isEmpty()) {
            return result;
        }
        for (Map<String, Object> item : maps) {
            Optional<ServerWithServeVo> op = result.stream().filter(x -> x.getId().equals(item.get("id"))).findFirst();
            if (!op.isPresent()) {
                ServerWithServeVo vo = new ServerWithServeVo(item);
                result.add(vo);
            } else {
                ServerWithServeVo.ServeVo vo = new ServerWithServeVo.ServeVo();
                BeanUtil.copyProperties(item, vo);
                op.get().getServeList().add(vo);
            }
        }
        return result;
    }
}
