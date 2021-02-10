CREATE TABLE `visAdmin`.`serve`
(
    `id`         bigint(0)    NOT NULL COMMENT 'ID',
    `serverId`   bigint(0)    NULL COMMENT '服务器ID',
    `name`       varchar(64)  NULL COMMENT '服务名',
    `port`       varchar(8)   NULL COMMENT '端口号',
    `isDocker`   varchar(1)   NULL COMMENT '是否为docker服务',
    `rmk`        varchar(512) NULL COMMENT '备注',
    `deleted`    varchar(1)   NULL COMMENT '是否删除: Y/N',
    `createBy`   varchar(32)  NULL COMMENT '创建人',
    `createTime` datetime(0)  NULL COMMENT '创建时间',
    `modifyBy`   varchar(32)  NULL COMMENT '修改人',
    `modifyTime` datetime(0)  NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
);