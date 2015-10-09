package com.fseer.dn.dn_cms.controller;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fseer.dn.dn_cms.entity.Admin;
import com.fseer.dn.dn_cms.service.LoginService;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * @Title: LoginController
 * @Description: TODO
 * @author simonw
 * @version 2014年7月3日 上午11:33:51
 */
@Controller
public class LoginController {

	@Resource
	private LoginService loginService;

	// Kaptcha的API
	@Resource
	private Producer captchaProducer = null;

	private static Logger logger = LogManager.getLogger(LoginController.class);

	/**
	 * @Title: index
	 * @Description: app入口自动转到主登陆页
	 * @return type: ModelAndView
	 */
	@RequestMapping("")
	public ModelAndView index() throws Exception {
		return new ModelAndView("/ftl/index");
	}

	/**
	 * @Title: toLogin
	 * @Description: 登陆判断
	 * @param admin
	 * @param captcha
	 * @param request
	 * @return type: ModelAndView
	 */
	@RequestMapping("/toLogin")
	public ModelAndView toLogin(Admin admin, String captcha,
			HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		// 验证码判断
		HttpSession session = request.getSession();
		String code = (String) session
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (!captcha.equals(code)) {
			mv.setViewName("/ftl/index");
			mv.addObject("hintInfo", "验证码错误!");
			return mv;
		}
		int flag = loginService.checkAdmin(admin);
		if (flag == 0) {
			mv.setViewName("/ftl/index");
			mv.addObject("hintInfo", "用户名或密码错误!");
		} else if (flag == 1) {
			session.setAttribute("ADMIN_LOGIN_SUCCESS", admin);
			logger.info(admin.getLoginId() + "已登录系统");
			mv.setViewName("redirect:/management");
		}
		return mv;
	}

	/**
	 * @Title: getKaptchaImage
	 * @Description: 验证码生成及刷新
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             type: String
	 */
	@RequestMapping("/getKaptchaImage")
	public String getKaptchaImage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		/*
		 * String code =
		 * (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		 * System.out.println("验证码是: "+code);
		 */
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		// return a jpeg
		response.setContentType("image/jpeg");
		// create the text for the image
		String capText = captchaProducer.createText();
		/* System.out.println("capText:"+capText); */
		// store the text in the session
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		// create the image with the text
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		// write the data out
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}

	/**
	 * @Title: logout
	 * @Description: 登出
	 * @param request
	 * @return type: String
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("ADMIN_LOGIN_SUCCESS");
		session.removeAttribute("ADMIN_LOGIN_SUCCESS");
		logger.info(admin.getLoginId() + "登出系统");
		return "/ftl/index";
	}

	/**
	 * @Title: loginAgin
	 * @Description: 被拦截未登录，转到登陆页面
	 * @param request
	 * @return type: ModelAndView
	 */
	@RequestMapping("/loginAgin")
	public ModelAndView loginAgin(HttpServletRequest request) throws Exception {
		return new ModelAndView("/ftl/index", "hintInfo", "未登录，请重新登陆!");
	}

	/**
	 * 异常测试
	 */
	/*
	 * @RequestMapping("/e") public void ex() throws Exception { Exception e =
	 * new Exception("..exception test.."); throw e; }
	 */
}
