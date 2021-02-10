package com.johnny.vis.cloud.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.johnny.vis.cloud.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnny
 * @date 2021-02-05
 */
@Getter
@Setter
@TableName("server")
public class ServerEntity extends BaseEntity {

    private static final long serialVersionUID = -3468798825328612087L;

    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private Long id;

    /**
     * 服务器名
     */
    @TableField("name")
    private String name;

    /**
     * 操作系统
     */
    @TableField("os")
    private String os;

    /**
     * 服务器IP
     */
    @TableField("ip")
    private String ip;

    /**
     * 域名
     */
    @TableField("domain")
    private String domain;

    /**
     * 备注
     */
    @TableField("rmk")
    private String rmk;
}
