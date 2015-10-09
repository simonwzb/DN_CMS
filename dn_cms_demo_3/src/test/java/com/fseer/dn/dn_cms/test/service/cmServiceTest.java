package com.fseer.dn.dn_cms.test.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fseer.dn.dn_cms.service.CmsService;

/**
 * @author simonw
 * @version 2014年6月29日 下午8:11:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-base.xml",
		"classpath:applicationContext-mybatis.xml" })
public class cmServiceTest {

	@Resource
	private CmsService cmsService;

	@Test
	public void testFindNewid() {
		int newid = cmsService.getNewid();
		/*System.out.println(newid);*/
		assertNotEquals(newid, 1);
	}

}
