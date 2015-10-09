package com.fseer.dn.dn_cms.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.fseer.dn.dn_cms.entity.Article;

/**
 * @author simonw
 * @version 2014年7月29日 下午8:25:22
 */
public interface ArticleMapper {

	public int insertSelective(Article article) throws DataAccessException;

	public int updateByIdSelective(Article article) throws DataAccessException;

	public int deleteByIds(int[] ids) throws DataAccessException;

	Article selectById(int id) throws DataAccessException;

	int selectMaxId() throws DataAccessException;

	int selectCount() throws DataAccessException;

	int selectCountByChannelId(int channelId) throws DataAccessException;

	/*
	 * List<Article> findPgnAll(Integer first, Integer num, String orderField,
	 * String orderDerection) throws DataAccessException;
	 */

	List<Article> selectPgnGeneral(
			@Param("channelId") Integer channelId,
			@Param("first") Integer first, 
			@Param("num") Integer num,
			@Param("orderField") String orderField,
			@Param("orderDerection") String orderDerection)
			throws DataAccessException;

	/*
	 * int deleteByPrimaryKey(Integer id);
	 * 
	 * int insert(Article record);
	 * 
	 * int insertSelective(Article record);
	 * 
	 * Article selectByPrimaryKey(Integer id);
	 * 
	 * int updateByPrimaryKeySelective(Article record);
	 * 
	 * int updateByPrimaryKeyWithBLOBs(Article record);
	 * 
	 * int updateByPrimaryKey(Article record);
	 */
}