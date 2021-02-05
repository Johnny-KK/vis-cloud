package com.johnny.vis.cloud.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.johnny.vis.cloud.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnny
 * @date 2020-12-27
 */
@Getter
@Setter
@TableName("tag")
public class TagEntity extends BaseEntity {

    private static final long serialVersionUID = 6892139912913064291L;

    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private Long id;

    /**
     * 标签编码
     */
    @TableField("code")
    private String code;

    /**
     * 标签名称
     */
    @TableField("name")
    private String name;

    /**
     * 标签颜色
     */
    @TableField("color")
    private String color;

    /**
     * 标签排序
     */
    @TableField("ord")
    private Integer ord;
}
