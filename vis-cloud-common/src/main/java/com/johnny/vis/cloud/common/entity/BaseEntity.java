package com.johnny.vis.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Johnny
 * @date 2020-12-23
 */
@Getter
@Setter
public class BaseEntity extends Model {

    private static final long serialVersionUID = 2581119343064029457L;

    /**
     * 是否使用
     */
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    private String deleted;

    /**
     * 创建人
     */
    @TableField(value = "createBy", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改人
     */
    @TableField(value = "modifyBy", fill = FieldFill.INSERT_UPDATE)
    private String modifyBy;

    /**
     * 修改时间
     */
    @TableField(value = "modifyTime", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;
}

