package com.johnny.vis.cloud.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * 自动填充公共字段
 *
 * @author Johnny
 * @date 2020-09-23
 */
@Component
public class EntityMetaObjectHandler implements MetaObjectHandler {
    private static final String FIELD_DELETED = "deleted";
    private static final String FIELD_CREATE_BY = "createBy";
    private static final String FIELD_MODIFY_BY = "modifyBy";
    private static final String FIELD_CREATE_TIME = "createTime";
    private static final String FIELD_MODIFY_TIME = "modifyTime";

    /**
     * TODO 注入登陆人信息
     */
    String userCode = "admin";

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName(FIELD_DELETED, "N", metaObject);
        setFieldValByName(FIELD_CREATE_BY, userCode, metaObject);
        setFieldValByName(FIELD_CREATE_TIME, new Timestamp(System.currentTimeMillis()), metaObject);
        setFieldValByName(FIELD_MODIFY_BY, userCode, metaObject);
        setFieldValByName(FIELD_MODIFY_TIME, new Timestamp(System.currentTimeMillis()), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName(FIELD_MODIFY_BY, userCode, metaObject);
        setFieldValByName(FIELD_MODIFY_TIME, new Timestamp(System.currentTimeMillis()), metaObject);
    }
}

