package com.heian.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文章
 * 注意：categoryName / authorName / tags 都不在此表，属于其他表或关联表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 标题，最多 120 字 */
    private String title;

    /** URL 标识，如：vue3-composition-api-practice */
    private String slug;

    /** 摘要 */
    private String summary;

    /** Markdown 正文（大字段，列表查询时不查它） */
    private String content;

    /** 封面图 URL */
    private String coverUrl;

    /** 分类 ID（外键） */
    private Long categoryId;

    /** 作者 ID（外键） */
    private Long authorId;

    /** 状态：0 草稿 / 1 已发布 / 2 已下架 */
    private Integer status;

    /** 是否置顶：0 否 / 1 是 */
    private Integer isTop;

    /** 是否推荐：0 否 / 1 是 */
    private Integer isRecommend;

    /** 浏览量 */
    private Integer views;

    /** 点赞数 */
    private Integer likes;

    /** 收藏数 */
    private Integer collects;

    /** 评论数（仅统计已通过的评论） */
    private Integer commentCount;

    /** 字数 */
    private Integer wordCount;

    /** 阅读时长（分钟） */
    private Integer readTime;

    /** 发布时间 */
    private LocalDateTime publishTime;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}