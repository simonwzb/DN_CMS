package com.fseer.dn.dn_cms.dao;

import java.util.List;


import com.fseer.dn.dn_cms.entity.Article;

/**
 * @Title: ArticleDAO
 * @Description: TODO
 * @author simonw
 * @version 2014年6月28日 上午11:33:24
 */
public interface ArticleDAO {
	
	/**
	 * @Title: findById
	 * @Description: 查找（按id）  
	 * @param id
	 * @return type: List<Article> 
	 */
	Article findById(int id) ;

	/**
	 * @Title: findMaxId
	 * @Description: 查找最大ID值  
	 * @return type: int 
	 */
	int findMaxId();

	
	/**
	 * @Title: insert
	 * @Description: 添加  
	 * @param article
	 * @return type: int 
	 */
	int insert(Article article);
	

	/**
	 * @Title: updateById
	 * @Description: 更新  
	 * @param article
	 * @return type: int 
	 */
	int update(Article article);

	
	/**
	 * @Title: deleteById
	 * @Description: 删除  
	 * @param id
	 * @return type: int 
	 */
	int deleteByIds(int[] ids);

	
	/**
	 * @Title: findPgnAll
	 * @Description: 分页查询(无WHERE条件)  
	 * @param first
	 * @param num
	 * @param orderField
	 * @param orderDerection
	 * @return type: List<Article> 返回记录包含关联的Channel的name（连接查询)
	 */
	List<Article> findPgnAll(Integer first, Integer num, String orderField, String orderDerection);

	/**
	 * @Title: findCount
	 * @Description: 查找总数  
	 * @return type: int 
	 */
	int findCount();
	
	/**
	 * @Title: findPgnChannelId
	 * @Description: 分页查询,某一栏目 
	 * @param channelId
	 * @param first
	 * @param num
	 * @param orderField
	 * @param orderDerection
	 * @return type: List<Article> 
	 */
	List<Article> findPgnChannelId(Integer channelId, Integer first, Integer num, String orderField, String orderDerection);
	
	/**
	 * @Title: findCountChannelId
	 * @Description: 查找某一栏目总文章数  
	 * @param channelId
	 * @return type: int 
	 */
	int findCountChannelId(int channelId);
}
