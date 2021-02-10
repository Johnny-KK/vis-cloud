CREATE TABLE `visAdmin`.`server`
(
    `id`         bigint(0)    NOT NULL COMMENT 'ID',
    `name`       varchar(64)  NULL COMMENT '服务器名',
    `os`         varchar(32)  NULL COMMENT '操作系统',
    `ip`         varchar(15)  NULL COMMENT '服务器IP',
    `domain`     varchar(128) NULL COMMENT '域名',
    `rmk`        varchar(512) NULL COMMENT '备注',
    `deleted`    varchar(1)   NULL COMMENT '是否删除: Y/N',
    `createBy`   varchar(32)  NULL COMMENT '创建人',
    `createTime` datetime(0)  NULL COMMENT '创建时间',
    `modifyBy`   varchar(32)  NULL COMMENT '修改人',
    `modifyTime` datetime(0)  NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
);