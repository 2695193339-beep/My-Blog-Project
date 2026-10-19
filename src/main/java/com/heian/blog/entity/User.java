package com.heian.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户
 * role: ADMIN 管理员 / USER 普通用户
 * status: 0 禁用 / 1 正常
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 登录名 */
    private String username;

    /** 密码（BCrypt 加密后，60 位左右） */
    private String password;

    /** 昵称（展示在文章和评论中） */
    private String nickname;

    private String email;

    private String avatar;

    /** 角色：ADMIN / USER */
    private String role;

    /** 状态：0 禁用 / 1 正常 */
    private Integer status;

    /** 个人简介 */
    private String bio;

    private String github;

    private String website;

    /** 最后登录时间 */
    private LocalDateTime lastLoginTime;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer deleted;
}