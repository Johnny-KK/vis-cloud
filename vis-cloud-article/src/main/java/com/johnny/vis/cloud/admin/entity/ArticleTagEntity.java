package com.johnny.vis.cloud.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.johnny.vis.cloud.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;


/**
 * @author Johnny
 * @date 2021-01-19
 */
@Getter
@Setter
@TableName("articleTag")
public class ArticleTagEntity extends BaseEntity {

    private static final long serialVersionUID = 5565169844749699699L;

    /**
     * 主键
     */
    @TableId
    @TableField("id")
    private Long id;

    /**
     * 文章ID
     */
    @TableField("articleId")
    private Long articleId;

    /**
     * 标签ID
     */
    @TableField("tagId")
    private Long tagId;

    /**
     * 标签名称
     */
    @TableField("tagName")
    private String tagName;
}
