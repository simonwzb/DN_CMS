package com.fseer.dn.dn_cms.entity;

import java.util.List;

/**
 * @author simonw
 * @version 2014年6月28日 下午8:44:37
 * @Description 分页BO类
 */
public class ArticlePgn {
	
	/**
	 * 当前页（前端的“第n页”）
	 */
	private int pageNum = 1;
	
	/**
	 * 每页的记录数
	 */
	private int numPerPage= 25;
	
	/**
	 * 记录总数
	 */
	private int totalCount;
	
	/**
	 * 排序字段（分页前的总排序，区别于前端分页后的排序）
	 * 默认值：最近更新时间
	 */
	private String orderField = "upd_timestamp";
	
	/**
	 * 升序降序
	 * 默认值：降序
	 */
	private String orderDirection = "DESC";
	
	/**
	 * 用于存储搜索条件
	 */
	private Article searchItem;
	
	/**
	 * 用于“栏目文章分页”前端传递的GET值
	 */
	private int channel_id;
	
	/**
	 * 查询后的结果集（Article的集合）
	 */
	private List<Article> articles;

	
	
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public Article getSearchItem() {
		return searchItem;
	}

	public void setSearchItem(Article searchItem) {
		this.searchItem = searchItem;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public int getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	
	
	
	
}
