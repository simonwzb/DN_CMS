package com.fseer.dn.dn_cms.entity;

// Generated 2014-6-28 20:23:50 by Hibernate Tools 4.0.0


/**
 * Article generated by hbm2java
 */
@SuppressWarnings("serial")
public class Article implements java.io.Serializable {

	private Integer id;
	private Channel channel = new Channel();
	private String name;
	private String author;
	private String overview;
	private String mainBody;
	private String updTimestamp;
	private String crtDatetime;
	
	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMainBody() {
		return mainBody;
	}
	public void setMainBody(String mainBody) {
		this.mainBody = mainBody;
	}
	public String getUpdTimestamp() {
		return updTimestamp;
	}
	public void setUpdTimestamp(String updTimestamp) {
		this.updTimestamp = updTimestamp;
	}
	public String getCrtDatetime() {
		return crtDatetime;
	}
	public void setCrtDatetime(String crtDatetime) {
		this.crtDatetime = crtDatetime;
	}

	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	/**
	 * @Description : 重写toString()方法，主要用于单元测试
	 */
	@Override
	public String toString() {
		
			StringBuffer str = new StringBuffer("ID:[" + this.id 
					+ "].名字:[" + this.name
					+ "].作者:[" + this.author);
			
				if(this.mainBody!=null) {
					str.append("].正文长度:[" + this.mainBody.length());
				}
				if(this.channel.getName() != null) {
					str.append("].栏目号:[" + this.channel.getId());
					str.append("].栏目名:[" + this.channel.getName());
				}
				str.append("].创建时间:[" + this.crtDatetime);
				str.append("].更新时间:[" + this.updTimestamp + "]");
		return str.toString();
	}
	
	
}
