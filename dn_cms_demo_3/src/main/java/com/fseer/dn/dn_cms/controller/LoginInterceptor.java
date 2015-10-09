package com.fseer.dn.dn_cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fseer.dn.dn_cms.entity.Admin;

/**
 * @Title: LoginInterceptor
 * @Description: TODO
 * @author simonw
 * @version 2014年7月7日 下午8:47:11
 */
public class LoginInterceptor implements HandlerInterceptor{
	
	private static Logger logger = LogManager.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("ADMIN_LOGIN_SUCCESS"); 
		if(admin == null) {
			logger.info("请求被拦截，登录验证失败.");
			response.sendRedirect("/loginAgin");
			return false;
		}
		logger.info("拦截器放行.");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
