CREATE TABLE `article`.`articleTag`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `articleId` bigint(0) NULL COMMENT '文章ID',
  `tagId` bigint(0) NULL COMMENT '标签ID',
  `tagName` varchar(64) NULL  COMMENT  '标签名称',
  `deleted` varchar(1) NULL COMMENT '是否删除: Y/N',
  `createBy` varchar(32) NULL COMMENT '创建人',
  `createTime` datetime(0) NULL COMMENT '创建时间',
  `modifyBy` varchar(32) NULL COMMENT '修改人',
  `modifyTime` datetime(0) NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
);