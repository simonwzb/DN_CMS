package com.fseer.dn.dn_cms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.fseer.dn.dn_cms.dao.ChannelDAO;
import com.fseer.dn.dn_cms.entity.Channel;

/**
 * @Title: ChannelDAOImpl
 * @Description: TODO
 * @author simonw
 * @version 2014年6月30日 下午12:02:25
 */
@Repository("channelDAO")
public class ChannelDAOImpl implements ChannelDAO {
	
	@Resource
	private DataSource dataSource;
	
	private final static Logger logger = LogManager.getLogger(ChannelDAOImpl.class);

	@Override
	public Channel findById(int id) {
		return null;
	}

	@Override
	public List<Channel> findAll() {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		List<Channel> channels = new ArrayList<Channel>();
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT id,name FROM channel";
			state = conn.prepareStatement(sql);
			rs = state.executeQuery();
			while (rs.next()) {
				Channel c = new Channel();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				channels.add(c);
			}
			rs.close();
			state.close();
		} catch (Exception e) {
			logger.error("JDBC异常", e);
		} finally {
			try {
				if (state != null)
					state.close();
			} catch (SQLException e1) {
				logger.error("PrepareStatement关闭异常", e1);
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				logger.error("Connection关闭异常", e);
			}
		}
		return channels;
	}

}
