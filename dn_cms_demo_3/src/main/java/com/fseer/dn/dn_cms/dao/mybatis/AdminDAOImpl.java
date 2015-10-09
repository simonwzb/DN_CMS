package com.fseer.dn.dn_cms.dao.mybatis;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.fseer.dn.dn_cms.dao.AdminDAO;
import com.fseer.dn.dn_cms.dao.mybatis.mapper.AdminMapper;
import com.fseer.dn.dn_cms.entity.Admin;

/**
 * @author simonw
 * @version 2014年7月29日 下午8:25:22
 */
@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Resource
	private AdminMapper adminMapper;

	private final static Logger logger = LogManager
			.getLogger(ArticleDAOImpl.class);

	@Override
	public int find(Admin admin) {
		int result = 0;
		try {
			result = adminMapper.selectByLoginIdAndPassWord(admin);
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return result;
	}

}
