package com.fseer.dn.dn_cms.dao;


import com.fseer.dn.dn_cms.entity.Admin;

/**
 * @Title: AdminDAO
 * @Description: TODO
 * @author simonw
 * @version 2014年7月3日 上午11:53:11
 */
public interface AdminDAO {

	/**
	 * @Title: find
	 * @Description: 查找某一Admin 
	 * @param admin
	 * @return type: int 
	 * @throws Exception 
	 */
	public int find(Admin admin);
}
