package com.fseer.dn.dn_cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fseer.dn.dn_cms.dao.ArticleDAO;
import com.fseer.dn.dn_cms.dao.ChannelDAO;
import com.fseer.dn.dn_cms.entity.Article;
import com.fseer.dn.dn_cms.entity.ArticlePgn;
import com.fseer.dn.dn_cms.entity.Channel;
import com.fseer.dn.dn_cms.service.CmsService;

/**
 * @author simonw
 * @version 2014年6月29日 上午9:51:13
 */
@Service("cmsService")
public class CmsServiceImpl implements CmsService {
	
	@Resource
	private ArticleDAO articleDAO;
	
	@Resource
	private ChannelDAO channelDAO;

	@Override
	@Transactional
	public ArticlePgn listAll(ArticlePgn articlePgn) {
		

		
		//从前端传的BO类articlePgn中取出分页查询相关参数
		int first = (articlePgn.getPageNum() - 1)*articlePgn.getNumPerPage() ;
		int num = articlePgn.getNumPerPage();
		String orderField = articlePgn.getOrderField();
		String orderDerection = articlePgn.getOrderDirection();
		//分页查询，并将结果记录集存入articlePgn中
		List<Article> articles = articleDAO.findPgnAll(first, num, orderField, orderDerection);
		articlePgn.setArticles(articles);
		//查询总记录数，并存入articlePgn
		int count = articleDAO.findCount();
		articlePgn.setTotalCount(count);
		
		return articlePgn;
	}
	
	@Override
	public int getNewid() {
		//新增文章被指定的id应该是最大id+1
		return articleDAO.findMaxId() + 1;
	}
	
	@Override
	public List<Channel> getChannels() {
		return channelDAO.findAll();
	}

	@Override
	public int insertArticle(Article article) {
		return articleDAO.insert(article);
	}

	@Override
	public int deleteAticle(int[] ids) {
		return articleDAO.deleteByIds(ids);
	}

	@Override
	public Article findArticle(int id) {
		return articleDAO.findById(id);
	}

	@Override
	public int modifyArticle(Article article) {
		return articleDAO.update(article);
	}

	@Override
	public ArticlePgn listAChannel(ArticlePgn articlePgn, int channelId) {
		//同listAll()方法
		int first = (articlePgn.getPageNum() - 1)*articlePgn.getNumPerPage() ;
		int num = articlePgn.getNumPerPage();
		String orderField = articlePgn.getOrderField();
		String orderDerection = articlePgn.getOrderDirection();

		List<Article> articles = articleDAO.findPgnChannelId(channelId, first, num, orderField, orderDerection);
		articlePgn.setArticles(articles);

		int count = articleDAO.findCountChannelId(channelId);
		articlePgn.setTotalCount(count);
		
		return articlePgn;
	}
	
	

}
