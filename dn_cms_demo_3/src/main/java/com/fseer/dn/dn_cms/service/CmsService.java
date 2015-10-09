package com.fseer.dn.dn_cms.service;

import java.util.List;


import com.fseer.dn.dn_cms.entity.Article;
import com.fseer.dn.dn_cms.entity.ArticlePgn;
import com.fseer.dn.dn_cms.entity.Channel;

/**
 * @author simonw
 * @version 2014年6月29日 上午9:51:13
 */
public interface CmsService {
	
	
	/**
	 * @Title: listAll
	 * @Description: 处理分页相关,不分模块
	 * @param articlePgn
	 * @return type: ArticlePgn 
	 */
	ArticlePgn listAll(ArticlePgn articlePgn);
	
	/**
	 * @Title: getNewid
	 * @Description: 用于内部类AddDTO  
	 * @return type: int 
	 */
	int getNewid();
	
	/**
	 * @Title: getChannels
	 * @Description: 用于内部类AddDTO
	 * @return type: List<Channel> 
	 */
	List<Channel> getChannels();
	
	
	/**
	 * @Title: insertArticle
	 * @Description: insert一篇文章
	 * @param article
	 * @return type: int 
	 */
	int insertArticle(Article article); 
	
	/**
	 * @Title: deleteAticle
	 * @Description: 删除文章
	 * @param id
	 * @return type: int 
	 */
	int deleteAticle(int[] ids);

	
	/**
	 * @Title: findArticle
	 * @Description: 查询文章信息，用于modify页面的预览  
	 * @param id
	 * @return type: Article 
	 */
	Article findArticle(int id);
	
	/**
	 * @Title: modifyArticle
	 * @Description: 提交页面modify
	 * @param article
	 * @return type: int 
	 */
	int modifyArticle(Article article);
	
	/**
	 * @Title: listAChannel
	 * @Description: 分页，按模块  
	 * @param articlePgn
	 * @return type: ArticlePgn 
	 */
	ArticlePgn listAChannel(ArticlePgn articlePgn, int channelId);
}
