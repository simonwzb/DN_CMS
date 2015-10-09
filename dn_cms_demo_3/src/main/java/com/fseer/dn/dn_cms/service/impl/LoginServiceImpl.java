package com.fseer.dn.dn_cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fseer.dn.dn_cms.dao.AdminDAO;
import com.fseer.dn.dn_cms.entity.Admin;
import com.fseer.dn.dn_cms.service.LoginService;

/**
 * @Title: LoginService
 * @Description: TODO
 * @author simonw
 * @version 2014年7月3日 上午11:34:23
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource
	private AdminDAO adminDAO;

	public int checkAdmin(Admin admin) {
		
		return adminDAO.find(admin);
	}
}
