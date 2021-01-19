package com.johnny.vis.cloud.article.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johnny.vis.cloud.article.dao.LogMapper;
import com.johnny.vis.cloud.article.entity.LogEntity;
import org.springframework.stereotype.Service;

/**
 * @author Johnny
 * @date 2020-12-26
 */
@Service
public class LogService extends ServiceImpl<LogMapper, LogEntity> {
}
