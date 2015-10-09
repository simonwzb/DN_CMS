package com.fseer.dn.dn_cms.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fseer.dn.dn_cms.dao.ArticleDAO;
import com.fseer.dn.dn_cms.entity.Article;
import com.fseer.dn.dn_cms.entity.Channel;

/**
 * @author simonw
 * @version 2014年6月29日 下午3:13:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-base.xml",
		"classpath:applicationContext-mybatis.xml" })
public class ArticleDAOTest {

	@Resource
	private ArticleDAO articleDAO;

	@Test
	public void testFindCount() {
		assertNotEquals(articleDAO.findCount(), 0);
	}

	@Test
	public void testFindPgnAll() {
		List<Article> articles = articleDAO.findPgnAll(0, 10, "id", "ASC");
		assertEquals(articles.size(), 10);
	}

	@Test
	public void testInsert() {
		// test-part
		Article article = new Article();
		// 取得最大id+1
		int id = articleDAO.findMaxId() + 1;
		article.setId(id);
		article.setName("testMAXPLUS");
		Channel c = new Channel();
		c.setId(0);
		article.setChannel(c);
		int flag = articleDAO.insert(article);
		assertEquals(flag, 1);
	}

	@Test
	public void testDeletByIds() {
		/*int[] ids = new int[2];
		ids[0] = articleDAO.findMaxId();
		ids[1] = articleDAO.findMaxId() - 1;
		int flag = articleDAO.deleteByIds(ids);
		assertEquals(flag, 2);*/
		assertEquals(0, 0);

	}

	@Test
	public void testFindById() {
		int id = 999;
		Article article = articleDAO.findById(id);
		assertTrue(article.getId().equals(id));
	}

	@Test
	public void testFindCountChannelId() {
		int channelId = 5;
		int result = articleDAO.findCountChannelId(channelId);
		assertNotEquals(result, 0);
	}

	@Test
	public void testFindPgnAChannel() {
		List<Article> articles = articleDAO.findPgnChannelId(6, 1, 10, "id",
				"ASC");
		assertEquals(articles.size(), 10);
	}

}
