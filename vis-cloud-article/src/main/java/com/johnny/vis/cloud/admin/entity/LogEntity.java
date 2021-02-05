package com.johnny.vis.cloud.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Johnny
 */
@Getter
@Setter
@TableName("log")
public class LogEntity implements Serializable {

    private static final long serialVersionUID = -6605284419522541349L;

    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private Long id;

    /**
     * 用户编码
     */
    @TableField("userCode")
    private String userCode;

    /**
     * 模块名称
     */
    @TableField("moduleName")
    private String moduleName;

    /**
     * 日志名称
     */
    @TableField("logName")
    private String logName;

    /**
     * 访问路径
     */
    @TableField("path")
    private String path;

    /**
     * 类名称
     */
    @TableField("className")
    private String className;

    /**
     * 方法名称
     */
    @TableField("methodName")
    private String methodName;

    /**
     * IP
     */
    @TableField("ip")
    private String ip;

    /**
     * 方法是否成功 Y/N
     */
    @TableField("succeed")
    private String succeed;

    /**
     * 方法开始时间
     */
    @TableField("startTime")
    private Date startTime;

    /**
     * 方法操作耗时
     */
    @TableField("optTime")
    private Long optTime;

    /**
     * 备注
     */
    @TableField("rmk")
    private String rmk;
}
