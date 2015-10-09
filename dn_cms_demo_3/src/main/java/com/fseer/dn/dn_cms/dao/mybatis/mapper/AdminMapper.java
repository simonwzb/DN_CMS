package com.fseer.dn.dn_cms.dao.mybatis.mapper;

import org.springframework.dao.DataAccessException;

import com.fseer.dn.dn_cms.entity.Admin;


public interface AdminMapper {

	public int selectByLoginIdAndPassWord(Admin admin) throws DataAccessException;

	/*
	 * int deleteByPrimaryKey(String loginId);
	 * 
	 * int insert(Admin record);
	 * 
	 * int insertSelective(Admin record);
	 * 
	 * Admin selectByPrimaryKey(String loginId);
	 * 
	 * int updateByPrimaryKeySelective(Admin record);
	 * 
	 * int updateByPrimaryKey(Admin record);
	 */
}