package com.heian.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 分类
 * 注意：articleCount（分类下文章数）不在此表，查询时统计
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 分类名，如：前端开发 */
    private String name;

    /** URL 标识，如：frontend */
    private String slug;

    /** 分类描述 */
    private String description;

    /** 图标颜色，如：#3b82f6 */
    private String color;

    /** Element Plus 图标名，如：Monitor */
    private String icon;

    /** 排序值，越小越靠前 */
    private Integer sort;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}