package com.fseer.dn.dn_cms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fseer.dn.dn_cms.entity.Admin;
import com.fseer.dn.dn_cms.entity.Article;
import com.fseer.dn.dn_cms.entity.ArticlePgn;
import com.fseer.dn.dn_cms.entity.Channel;
import com.fseer.dn.dn_cms.service.CmsService;

@Controller
@RequestMapping("/management")
public class CmsController {

	/**
	 * 自动注入业务逻辑层组件
	 */
	@Resource
	private CmsService cmsService;

	/**
	 * @Title: management
	 * @Description: 转到主操作页
	 * @return type: String
	 */

	@RequestMapping("")
	public ModelAndView management(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("ADMIN_LOGIN_SUCCESS");
		ModelAndView mv = new ModelAndView("/ftl/management");
		mv.addObject("admin", admin);
		return mv;
	}

	/**
	 * @Title: listAll
	 * @Description: 文章库
	 * @param articlePgn
	 * @return type: ModelAndView
	 */
	@RequestMapping("/listAll")
	public ModelAndView listAll(ArticlePgn articlePgn) throws Exception {
		ArticlePgn result = cmsService.listAll(articlePgn);
		return new ModelAndView("/ftl/listAll", "articlePgn", result);
	}

	/**
	 * @Title: add
	 * @Description: 新增文章页面
	 * @return type: ModelAndView
	 */
	@RequestMapping("/add")
	public ModelAndView add() throws Exception {
		/*
		 * AddDTO addDTO = new AddDTO(); addDTO.setNewid(cmsService.getNewid());
		 * addDTO.setChannels(cmsService.getChannels());
		 */

		ModelAndView mv = new ModelAndView("/ftl/add");
		mv.addObject("newid", cmsService.getNewid());
		mv.addObject("channels", cmsService.getChannels());

		return mv;
	}

	/**
	 * @Title: addAjax
	 * @Description: insert文章
	 * @param article
	 * @return type: int
	 */
	@RequestMapping("/addAjax")
	@ResponseBody
	public ModelMap addAjax(Article article) throws Exception {
		int flag = cmsService.insertArticle(article);
		ModelMap mp = new ModelMap();
		switch (flag) {
		case 1: {
			mp.addAttribute("statusCode", 200);
			mp.addAttribute("message", "ok,添加一篇文章。");
			break;
		}
		case 0: {
			mp.addAttribute("statusCode", 304);
			mp.addAttribute("message", "error：添加文章失败。");
			break;
		}
		}
		return mp;
	}

	/**
	 * @Title: deleteAjax
	 * @Description: TODO
	 * @param ids
	 * @return type: ModelMap
	 */
	@RequestMapping("/deleteAjax")
	@ResponseBody
	public ModelMap deleteAjax(String ids) throws Exception {
		int[] t = parseIds(ids);
		int flag = cmsService.deleteAticle(t);
		ModelMap mp = new ModelMap();
		switch (flag) {
		case 0: {
			mp.addAttribute("statusCode", 304);
			mp.addAttribute("message", "error：删除文章失败。");
			break;
		}
		default: {
			mp.addAttribute("statusCode", 200);
			mp.addAttribute("message", "ok,删除" + flag + "篇文章。");
		}
		}
		return mp;
	}

	/**
	 * @Title: parseIds
	 * @Description: 用于批量删除（deleteAjax方法），解析请求的id串
	 * @param ids
	 * @return type: int[]
	 */
	protected int[] parseIds(String ids) {
		String[] t1 = ids.split(",");
		int[] t2 = new int[t1.length];
		for (int i = 0; i < t1.length; i++) {
			t2[i] = Integer.parseInt(t1[i]);
		}
		return t2;
	}

	/**
	 * @Title: modify
	 * @Description: 修改文章页面
	 * @param id
	 * @return type: ModelAndView
	 */
	@RequestMapping("/modify")
	public ModelAndView modify(int id) throws Exception {
		// 获取该id文章信息
		Article article = cmsService.findArticle(id);
		// 获取全部栏目名
		List<Channel> channels = cmsService.getChannels();
		ModelAndView mv = new ModelAndView("/ftl/modify");
		mv.addObject("article", article);
		mv.addObject("channels", channels);
		return mv;
	}

	/**
	 * @Title: modifyAjax
	 * @Description: 执行更新文章
	 * @param article
	 * @return type: ModelMap
	 */
	@RequestMapping("/modifyAjax")
	@ResponseBody
	public ModelMap modifyAjax(Article article) throws Exception {
		int flag = cmsService.modifyArticle(article);
		ModelMap mp = new ModelMap();
		switch (flag) {
		case 1: {
			mp.addAttribute("statusCode", 200);
			mp.addAttribute("message", "ok,更新一篇文章。");
			break;
		}
		case 0: {
			mp.addAttribute("statusCode", 304);
			mp.addAttribute("message", "error：更新文章失败。");
			break;
		}
		}
		return mp;
	}

	@RequestMapping("/listAChannel")
	public ModelAndView listAChannel(ArticlePgn articlePgn) throws Exception {
		int channelId = articlePgn.getChannel_id();
		ArticlePgn result = cmsService.listAChannel(articlePgn, channelId);
		ModelAndView mv = new ModelAndView("/ftl/listAChannel");
		mv.addObject("articlePgn", result);
		return mv;
	}

	/**
	 * @Title: addDTO
	 * @Description: 内部类，仅用于本方法向叶面传递封装的数据
	 * @author simonw
	 * @version 2014年6月30日 下午3:05:04
	 */
	/*
	 * public class AddDTO{
	 *//**
	 * 用于新文章的id
	 */
	/*
	 * private int newid;
	 *//**
	 * 用于模块名下拉列表
	 */
	/*
	 * private List<Channel> channels;
	 * 
	 * public int getNewid() { return newid; } public void setNewid(int newid) {
	 * this.newid = newid; } public List<Channel> getChannels() { return
	 * channels; } public void setChannels(List<Channel> channels) {
	 * this.channels = channels; } }
	 */

}
