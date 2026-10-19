package com.heian.blog.config;

import com.heian.blog.interceptor.JwtInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册 JWT 拦截器...");
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/auth/login", "/auth/register",
                        "/settings/public",
                        "/articles", "/articles/hot", "/articles/latest",
                        "/articles/recommend", "/articles/archives", "/articles/search",
                        "/articles/*", "/articles/*/neighbors", "/articles/*/like",
                        "/categories", "/tags", "/tags/hot",
                        "/comments/tree/*", "/comments/latest",
                        "/error", "/favicon.ico"
                );
    }
}