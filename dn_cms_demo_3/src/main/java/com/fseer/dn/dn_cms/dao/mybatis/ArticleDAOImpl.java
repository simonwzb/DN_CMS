package com.fseer.dn.dn_cms.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.fseer.dn.dn_cms.dao.ArticleDAO;
import com.fseer.dn.dn_cms.dao.mybatis.mapper.ArticleMapper;
import com.fseer.dn.dn_cms.entity.Article;

/**
 * @author simonw
 * @version 2014年7月29日 下午8:25:22
 */
@Repository("articleDAO")
public class ArticleDAOImpl implements ArticleDAO {

	@Resource
	private ArticleMapper articleMapper;

	private final static Logger logger = LogManager
			.getLogger(ArticleDAOImpl.class);

	@Override
	public int insert(Article article) {
		int result = 0;
		try {
			result = articleMapper.insertSelective(article);
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return result;
	}

	@Override
	public int update(Article article) {
		int result = 0;
		try {
			result = articleMapper.updateByIdSelective(article);
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return result;
	}

	@Override
	public int deleteByIds(int[] ids) {
		int result = 0;
		try {
			result = articleMapper.deleteByIds(ids);
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return result;
	}

	@Override
	public Article findById(int id) {
		Article article = null;
		try {
			article = articleMapper.selectById(id);
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return article;
	}

	@Override
	public int findMaxId() {
		int result = 0;
		try {
			result = articleMapper.selectMaxId();
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return result;
	}

	@Override
	public int findCount() {
		int result = 0;
		try {
			result = articleMapper.selectCount();
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return result;
	}

	@Override
	public int findCountChannelId(int channelId) {
		int result = 0;
		try {
			result = articleMapper.selectCountByChannelId(channelId);
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return result;
	}

	@Override
	public List<Article> findPgnAll(Integer first, Integer num,
			String orderField, String orderDerection) {
		List<Article> articles = null;
		try {
			// mybatis会自动过滤掉channelId值为-1的情况。
			articles = articleMapper.selectPgnGeneral(-1, first, num,
					orderField, orderDerection);
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return articles;
	}

	@Override
	public List<Article> findPgnChannelId(Integer channelId, Integer first,
			Integer num, String orderField, String orderDerection) {
		List<Article> articles = null;
		try {
			articles = articleMapper.selectPgnGeneral(channelId, first, num,
					orderField, orderDerection);
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return articles;
	}

}
