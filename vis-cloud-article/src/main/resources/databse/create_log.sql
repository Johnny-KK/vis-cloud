CREATE TABLE `article`.`log`  (
  `id` bigint(0) NOT NULL COMMENT 'ID',
  `userCode` varchar(32) NULL COMMENT '用户编码',
  `moduleName` varchar(64) NULL COMMENT '模块名称',
  `logName` varchar(64) NULL COMMENT '日志名称',
  `path` varchar(256) NULL COMMENT '访问路径',
  `className` varchar(256) NULL COMMENT '类名称',
  `methodName` varchar(256) NULL COMMENT '方法名称',
  `ip` varchar(16) NULL COMMENT 'IP',
  `succeed` varchar(1) NULL COMMENT '方法是否成功 Y/N',
  `startTime` datetime(0) NULL COMMENT '方法开始时间',
  `optTime` bigint(0) NULL COMMENT '方法操作耗时',
  `rmk` varchar(256) NULL COMMENT '备注',
  PRIMARY KEY (`id`)
);