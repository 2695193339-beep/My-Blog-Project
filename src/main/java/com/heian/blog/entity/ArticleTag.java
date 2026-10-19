package com.heian.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 文章-标签 关联表
 * 多对多中间表：一篇文章多个标签，一个标签多篇文章
 *
 * 注意：这张表是联合主键，没有 id 字段，也没有 deleted
 * 所以不用 @TableId / @TableLogic
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("article_tag")
public class ArticleTag implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 文章 ID */
    private Long articleId;

    /** 标签 ID */
    private Long tagId;
}