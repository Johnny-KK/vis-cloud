package com.johnny.vis.cloud.article.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johnny.vis.cloud.article.dao.TagMapper;
import com.johnny.vis.cloud.article.entity.TagEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Johnny
 * @date 2020-12-27
 */
@Service
public class TagService extends ServiceImpl<TagMapper, TagEntity> {

    /**
     * 条件查询tag列表
     */
    public List<TagEntity> queryTagList(TagEntity entity) {
        return this.baseMapper.selectList(new QueryWrapper<TagEntity>().lambda()
                .eq(StrUtil.isNotBlank(entity.getName()), TagEntity::getName, entity.getName())
        );
    }
}
