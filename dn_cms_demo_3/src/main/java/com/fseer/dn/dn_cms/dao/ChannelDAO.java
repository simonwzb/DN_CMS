package com.fseer.dn.dn_cms.dao;

import java.util.List;

import com.fseer.dn.dn_cms.entity.Channel;

/**
 * @Title: ChannelDAO
 * @Description: TODO
 * @author simonw
 * @version 2014年6月30日 下午12:00:51
 */
public interface ChannelDAO {
	
	/**
	 * @Title: findById
	 * @Description: 查找（按id）  
	 * @param id
	 * @return type: List<Article> 
	 */
	Channel findById(int id) ;

	
	/**
	 * @Title: findAll
	 * @Description: 查找所有  
	 * @return type: List<Article> 
	 */
	List<Channel> findAll();
}
