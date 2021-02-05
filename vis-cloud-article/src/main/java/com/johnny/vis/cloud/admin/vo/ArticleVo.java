package com.johnny.vis.cloud.admin.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * web-article项目所需实体
 *
 * @author Johnny
 * @date 2021-01-19
 */
@Data
public class ArticleVo implements Serializable {

    private static final long serialVersionUID = -5543378481004771535L;

    private Long id;
    private String title;
    private String author;
    private String content;
    private Date modifyTime;
    private List<String> tagList;
}
