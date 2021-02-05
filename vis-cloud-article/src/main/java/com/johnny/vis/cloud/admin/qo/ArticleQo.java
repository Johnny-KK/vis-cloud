package com.johnny.vis.cloud.admin.qo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Johnny
 * @date 2021-01-19
 */
@Getter
@Setter
public class ArticleQo implements Serializable {
    private static final long serialVersionUID = -8289581105256110539L;

    /**
     * 模糊搜索 模糊匹配title、content字段
     */
    private String fuzzy;

    /**
     * 标签列表
     */
    private List<String> tagList;
}
