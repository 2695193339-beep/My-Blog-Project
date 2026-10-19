package com.heian.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 标签
 * 注意：count（标签下文章数）不在此表，查询时统计
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tag")
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 标签名，如：Vue3 */
    private String name;

    /** URL 标识，如：vue3 */
    private String slug;

    /** 标签颜色，如：#42B883 */
    private String color;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}