package com.johnny.vis.cloud.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johnny.vis.cloud.admin.dao.ServeMapper;
import com.johnny.vis.cloud.admin.entity.ServeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Johnny
 * @date 2021-02-09
 */
@Service
public class ServeService extends ServiceImpl<ServeMapper, ServeEntity> {

    /**
     * 条件查询服务信息列表
     */
    public List<ServeEntity> queryServeList(ServeEntity entity) {
        return this.baseMapper.selectList(new QueryWrapper<ServeEntity>().lambda());
    }
}
