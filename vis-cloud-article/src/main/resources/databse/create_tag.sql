CREATE TABLE `visArticle`.`tag`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `code` varchar(64) NULL COMMENT '标签编码',
  `name` varchar(64) NULL COMMENT '标签名称',
  `color` varchar(16) NULL COMMENT '标签颜色',
  `ord` int(0) NULL COMMENT '标签排序',
  `deleted` varchar(1) NULL COMMENT '是否删除: Y/N',
  `createBy` varchar(32) NULL COMMENT '创建人',
  `createTime` datetime(0) NULL COMMENT '创建时间',
  `modifyBy` varchar(32) NULL COMMENT '修改人',
  `modifyTime` datetime(0) NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
);