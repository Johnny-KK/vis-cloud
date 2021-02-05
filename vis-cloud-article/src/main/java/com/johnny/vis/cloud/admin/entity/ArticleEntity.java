package com.johnny.vis.cloud.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.johnny.vis.cloud.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Johnny
 * @date 2020-12-21
 */
@Getter
@Setter
@TableName("article")
public class ArticleEntity extends BaseEntity {

    private static final long serialVersionUID = 1004504913476913232L;

    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private Long id;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 作者
     */
    @TableField("author")
    private String author;

    /**
     * 内容
     */
    @TableField("content")
    private String content;
}
