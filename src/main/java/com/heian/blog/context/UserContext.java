package com.heian.blog.context;

/**
 * 当前登录用户上下文
 * 拦截器解析 token 后写入, Controller/Service 直接读取, 不用再解析 token
 */
public class UserContext {

    private static final ThreadLocal<Long> USER_ID = new ThreadLocal<>();
    private static final ThreadLocal<String> ROLE = new ThreadLocal<>();

    public static void setUserId(Long userId) { USER_ID.set(userId); }
    public static Long getUserId() { return USER_ID.get(); }

    public static void setRole(String role) { ROLE.set(role); }
    public static String getRole() { return ROLE.get(); }

    public static boolean isAdmin() { return "ADMIN".equals(ROLE.get()); }

    /** ★ 必须在请求结束时清理, 否则 Tomcat 线程复用会串号 */
    public static void clear() {
        USER_ID.remove();
        ROLE.remove();
    }
}