package com.heian.blog.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis-Plus 配置
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        // ★ 分页插件
        PaginationInnerInterceptor pagination = new PaginationInnerInterceptor(DbType.MYSQL);

        // 单页最大条数: 防止前端传 size=999999 把数据库拖垮 (超了会被自动限制为 100)
        pagination.setMaxLimit(100L);

        // 溢出处理: 请求页码超过总页数时, 返回空数据而不是回到第一页
        pagination.setOverflow(false);

        interceptor.addInnerInterceptor(pagination);

        return interceptor;
    }
}