package com.johnny.vis.cloud.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.johnny.vis.cloud.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnny
 */
@Setter
@Getter
@TableName("serve")
public class ServeEntity extends BaseEntity {

    private static final long serialVersionUID = 8753115384157545792L;

    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private Long id;

    /**
     * 所属服务器ID
     */
    @TableField("serverId")
    private Long serverId;

    /**
     * 服务名
     */
    @TableField("name")
    private String name;

    /**
     * 端口号
     */
    @TableField("port")
    private String port;

    /**
     * 是否为docker服务 Y/N
     */
    @TableField("isDocker")
    private String isDocker;

    /**
     * 备注
     */
    @TableField("rmk")
    private String rmk;
}
