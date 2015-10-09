package com.fseer.dn.dn_cms.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fseer.dn.dn_cms.dao.ChannelDAO;
import com.fseer.dn.dn_cms.entity.Channel;

/**
 * @Title: ChannelDAOTest
 * @Description: TODO
 * @author simonw
 * @version 2014年6月30日 下午12:08:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-base.xml",
		"classpath:applicationContext-mybatis.xml" })
public class ChannelDAOTest {

	@Resource
	private ChannelDAO channelDAO;

	@Test
	public void testFindAll() {
		List<Channel> channels = channelDAO.findAll();
		/*System.out.println("channel.size():" + channels.size());
		for (Channel c : channels) {
			System.out.println(c.getName());
		}*/
		assertNotEquals(channels.size(), 0);
	}
	
	@Test
	public void testFindById() {
		Channel channel = channelDAO.findById(9);
		assertNotNull(channel);
	}

}
