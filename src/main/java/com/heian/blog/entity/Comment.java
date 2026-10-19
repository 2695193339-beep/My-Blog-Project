package com.heian.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 评论
 * 两级结构：parentId 为 null 是顶层评论，否则是回复
 * 注意：articleTitle 不在此表，后台列表查询时 join article 得到
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 所属文章 ID */
    private Long articleId;

    /** 评论人 ID（游客评论为 null） */
    private Long userId;

    /** 评论人昵称（游客必填） */
    private String nickname;

    private String email;

    private String avatar;

    /** 个人网站（选填） */
    private String website;

    /** 评论内容 */
    private String content;

    /** 父评论 ID：null 表示顶层评论 */
    private Long parentId;

    /** 回复给谁的昵称，如：回复 @云深不知处 */
    private String replyToUser;

    /** 点赞数 */
    private Integer likeCount;

    /** 状态：0 待审核 / 1 已通过 / 2 已拒绝 */
    private Integer status;

    /** 评论者 IP */
    private String ip;

    /** IP 归属地，如：北京市 联通 */
    private String location;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}