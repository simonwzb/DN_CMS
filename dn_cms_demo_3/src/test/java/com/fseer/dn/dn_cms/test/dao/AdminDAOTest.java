package com.fseer.dn.dn_cms.test.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fseer.dn.dn_cms.dao.AdminDAO;
import com.fseer.dn.dn_cms.entity.Admin;

/**
 * @Title: AdminDAOTest
 * @Description: TODO
 * @author simonw
 * @version 2014年7月3日 下午12:06:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-base.xml",
		"classpath:applicationContext-mybatis.xml" })
public class AdminDAOTest {

	@Resource
	private AdminDAO adminDAO;

	@Test
	public void testFind() {
		Admin admin = new Admin("dn_cms_db", "dn_cms_db");
		int result = adminDAO.find(admin);
		/* System.out.println(result); */
		assertNotEquals(result, 0);
	}

}
