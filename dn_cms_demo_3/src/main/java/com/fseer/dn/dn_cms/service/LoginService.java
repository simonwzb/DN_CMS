package com.fseer.dn.dn_cms.service;

import com.fseer.dn.dn_cms.entity.Admin;

/**
 * @Title: LoginService
 * @Description: TODO
 * @author simonw
 * @version 2014年7月3日 上午11:55:51
 */
public interface LoginService {

	/**
	 * @Title: checkAdmin
	 * @Description: 根据用户名密码查看用户是否存在
	 * @param admin
	 * @return type: int 
	 */
	public int checkAdmin(Admin admin);
}
