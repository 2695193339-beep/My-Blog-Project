package com.heian.blog.annotation;

import java.lang.annotation.*;

/**
 * 标记接口需要管理员权限
 * 加在 Controller 方法上, 拦截器会检查当前登录用户的 role 是否为 ADMIN
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequireAdmin {
}