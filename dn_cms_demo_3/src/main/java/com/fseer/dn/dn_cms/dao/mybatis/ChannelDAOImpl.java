package com.fseer.dn.dn_cms.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.fseer.dn.dn_cms.dao.ChannelDAO;
import com.fseer.dn.dn_cms.dao.mybatis.mapper.ChannelMapper;
import com.fseer.dn.dn_cms.entity.Channel;

/**
 * @author simonw
 * @version 2014年7月29日 下午8:25:22
 */
@Repository("channelDAO")
public class ChannelDAOImpl implements ChannelDAO {
	
	@Resource
	private ChannelMapper channelMapper;
	
	private final static Logger logger = LogManager
			.getLogger(ArticleDAOImpl.class);
	
	@Override
	public Channel findById(int id) {
		Channel channel = null;
		try {
			channel = channelMapper.selectById(id);
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return channel;
	}

	@Override
	public List<Channel> findAll() {
		List<Channel> channels = null;
		try {
			channels = channelMapper.selectAll();
		} catch (DataAccessException e) {
			logger.error(e);
		}
		return channels;
	}

}
