package com.fseer.dn.dn_cms.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.fseer.dn.dn_cms.entity.Channel;

/**
 * @author simonw
 * @version 2014年7月29日 下午8:25:22
 */
public interface ChannelMapper {

	public Channel selectById(int id) throws DataAccessException;

	public List<Channel> selectAll() throws DataAccessException;

	/*
	 * int deleteByPrimaryKey(Integer id);
	 * 
	 * int insert(Channel record);
	 * 
	 * int insertSelective(Channel record);
	 * 
	 * Channel selectByPrimaryKey(Integer id);
	 * 
	 * int updateByPrimaryKeySelective(Channel record);
	 * 
	 * int updateByPrimaryKey(Channel record);
	 */
}