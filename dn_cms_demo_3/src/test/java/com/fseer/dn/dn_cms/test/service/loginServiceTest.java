package com.fseer.dn.dn_cms.test.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fseer.dn.dn_cms.entity.Admin;
import com.fseer.dn.dn_cms.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-base.xml",
		"classpath:applicationContext-mybatis.xml" })
public class loginServiceTest {
	
	@Resource
	private LoginService loginService;

	@Test
	public void testFind() {
		Admin admin = new Admin();
		admin.setLoginId("dn_cms_db");
		admin.setPassword("dn_cms_db");
		int result = loginService.checkAdmin(admin);
		/*System.out.println("result:"+result);*/
		assertEquals(result,1);
	}

}
