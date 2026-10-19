package com.heian.blog.interceptor;

import com.heian.blog.annotation.RequireAdmin;
import com.heian.blog.constant.JwtClaimsConstant;
import com.heian.blog.context.UserContext;
import com.heian.blog.properties.JwtProperties;
import com.heian.blog.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;



@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtProperties jwtProperties;

	/**
	 * 校验jwt
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//判断当前拦截到的是Controller的方法还是其他资源
		if (!(handler instanceof HandlerMethod)) {
			//当前拦截到的不是动态方法，直接放行
			return true;
		}

		//1、从请求头中获取令牌
		String header = request.getHeader(jwtProperties.getBlogTokenName());
		if (header == null || header.isBlank()) {
			writeError(response,401,"未登录，请先登录");
			return false;
		}
		// 前端发的是 "Bearer xxx", 需要切掉前缀
		String token = header.startsWith("Bearer ") ? header.substring(7).trim() : header;


		//2、校验令牌
		try {
			log.info("jwt校验:{}", token);
			Claims claims = JwtUtil.parseJWT(jwtProperties.getBlogSecretKey(), token);
			Long userId = Long.valueOf(claims.get(JwtClaimsConstant.USER_ID).toString());
			String role = String.valueOf(claims.get(JwtClaimsConstant.ROLE));
			UserContext.setUserId(userId);
			UserContext.setRole(role);
			log.info("当前登录用户id：", userId);

			// 3、检查是否需要管理员权限
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			boolean needAdmin = handlerMethod.hasMethodAnnotation(RequireAdmin.class)
					|| handlerMethod.getBeanType().isAnnotationPresent(RequireAdmin.class);

			if (needAdmin && !UserContext.isAdmin()) {
				writeError(response, 403, "无权限访问, 需要管理员身份");
				return false;
			}

			//3、通过，放行
			return true;
		} catch (Exception ex) {
			//4、不通过，响应401状态码
			response.setStatus(401);
			return false;
		}
	}


	//清理线程
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
								Object handler, Exception ex) {
		UserContext.clear();
	}

	private void writeError(HttpServletResponse response, int code, String message) throws Exception {
		response.setStatus(code);                                  // HTTP 状态码 401 / 403
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(
				String.format("{\"code\":%d,\"message\":\"%s\",\"data\":null}", code, message)
		);
	}
}