package com.fseer.dn.dn_cms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.fseer.dn.dn_cms.dao.AdminDAO;
import com.fseer.dn.dn_cms.entity.Admin;

/**
 * @Title: AdminDAOImpl
 * @Description: TODO
 * @author simonw
 * @version 2014年7月3日 上午11:57:32
 */
@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Resource
	private DataSource dataSource;

	private final static Logger logger = LogManager.getLogger(AdminDAOImpl.class);

	@Override
	public int find(Admin admin) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		int flag = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT COUNT(*) FROM admin WHERE login_id=? AND password=?";
			state = conn.prepareStatement(sql);
			state.setString(1, admin.getLoginId());
			state.setString(2, admin.getPassword());
			rs = state.executeQuery();
			while (rs.next()) {
				flag = rs.getInt(1);
			}
			rs.close();
			state.close();
			conn.close();
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
		return flag;
	}

}
