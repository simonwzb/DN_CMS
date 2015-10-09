package com.fseer.dn.dn_cms.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.fseer.dn.dn_cms.dao.ArticleDAO;
import com.fseer.dn.dn_cms.entity.Article;
import com.fseer.dn.dn_cms.entity.Channel;

/**
 * @Title: ArticleDAOImpl
 * @Description: TODO
 * @author simonw
 * @version 2014年6月29日 上午10:25:23
 */
@Repository("articleDAO")
public class ArticleDAOImpl implements ArticleDAO {

	@Resource
	private DataSource dataSource;

	private final static Logger logger = LogManager.getLogger(ArticleDAOImpl.class);

	/**
	 * 用于格式化
	 */
	private SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd hh:mm:ss");

	@Override
	public Article findById(int id) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		Article article = new Article();
		try {
			conn = dataSource.getConnection();
			String sql = "" + "SELECT id, " + "       name, "
					+ "       author, " + "       overview, "
					+ "       main_body, " + "       channel_id, "
					+ "       crt_datetime, " + "       upd_timestamp "
					+ "FROM   article " + "WHERE  id = ? ";
			state = conn.prepareStatement(sql);
			state.setInt(1, id);
			rs = state.executeQuery();
			while (rs.next()) {
				article.setId(rs.getInt(1));
				article.setName(rs.getString(2));
				article.setAuthor(rs.getString(3));
				article.setOverview(rs.getString(4));
				article.setMainBody(rs.getString(5));
				Channel c = new Channel();
				c.setId(rs.getInt(6));
				article.setChannel(c);
				article.setCrtDatetime(format.format(rs.getTimestamp(7)));
				article.setUpdTimestamp(format.format(rs.getTimestamp(8)));
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
		return article;
	}

	@Override
	public int findMaxId() {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		int max = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT MAX(id) FROM article";
			state = conn.prepareStatement(sql);
			rs = state.executeQuery();
			while (rs.next()) {
				max = rs.getInt(1);
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
				e1.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("Connection关闭异常", e);
			}
		}
		return max;
	}

	@Override
	public int insert(Article article) {
		Connection conn = null;
		PreparedStatement state = null;
		int flag = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO article(id,name,author,main_body,channel_id,crt_datetime) values(?,?,?,?,?,?)";
			state = conn.prepareStatement(sql);
			state.setInt(1, article.getId());
			state.setString(2, article.getName());
			state.setString(3, article.getAuthor());
			state.setString(4, article.getMainBody());
			state.setInt(5, article.getChannel().getId());
			Timestamp t = new Timestamp(new Date().getTime());
			state.setTimestamp(6, t);

			flag = state.executeUpdate();
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

	@Override
	public int update(Article article) {
		Connection conn = null;
		PreparedStatement state = null;
		int flag = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "" + "UPDATE article " + "SET    name = ?, "
					+ "       author = ?, " + "       overview = ?, "
					+ "       main_body = ?, " + "       channel_id = ?, "
					+ "       crt_datetime = ? " + "WHERE  id =? ";
			state = conn.prepareStatement(sql);
			state.setInt(7, article.getId());
			state.setString(1, article.getName());
			state.setString(2, article.getAuthor());
			state.setString(3, article.getOverview());
			state.setString(4, article.getMainBody());
			state.setInt(5, article.getChannel().getId());
			Timestamp t = new Timestamp(new Date().getTime());
			state.setTimestamp(6, t);

			flag = state.executeUpdate();
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

	@Override
	public int deleteByIds(int[] ids) {
		Connection conn = null;
		PreparedStatement state = null;
		int flag = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "DELETE FROM article WHERE id=?";
			state = conn.prepareStatement(sql);
			for (int id : ids) {
				state.setInt(1, id);
				flag += state.executeUpdate();
			}
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

	@Override
	public List<Article> findPgnAll(Integer first, Integer num,
			String orderField, String orderDerection) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		List<Article> articles = new ArrayList<Article>();
		try {
			conn = dataSource.getConnection();
			/**
			 * sql语句注意， 1.ORDER BY必须放在子查询中，而且LIMMIT之前；
			 * 2.用左外连接，考虑到后期可能有channel_id的null，尤其是外键约束为SET NULL时；
			 * 3.分页只需查询ovreview以提升速度
			 */
			String sql = "" + "SELECT a.id, " + "       a. name, "
					+ "       a.author, " + "       a.overview, "
					+ "       a.crt_datetime, " + "       a.upd_timestamp, "
					+ "       b. name " + "FROM   (SELECT * "
					+ "        FROM   article " + "        ORDER  BY "
					+ orderField + " " + orderDerection
					+ "        LIMIT  ?, ?) a " + "       LEFT JOIN channel b "
					+ "              ON a.channel_id = b.id";
			state = conn.prepareStatement(sql);
			state.setInt(1, first);
			state.setInt(2, num);
			rs = state.executeQuery();
			while (rs.next()) {
				Article a = new Article();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setAuthor(rs.getString(3));
				a.setOverview(rs.getString(4));
				// 两个日期字段格式化
				a.setCrtDatetime(format.format(rs.getTimestamp(5)));
				a.setUpdTimestamp(format.format(rs.getTimestamp(6)));
				// 栏目名字段
				Channel c = new Channel();
				c.setName(rs.getString(7));
				a.setChannel(c);

				articles.add(a);
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
		return articles;
	}

	@Override
	public int findCount() {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT COUNT(id) FROM article";
			state = conn.prepareStatement(sql);
			rs = state.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}

	@Override
	public List<Article> findPgnChannelId(Integer channelId, Integer first,
			Integer num, String orderField, String orderDerection) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		List<Article> articles = new ArrayList<Article>();
		try {
			conn = dataSource.getConnection();
			/**
			 * sql语句注意， 1.ORDER BY必须放在子查询中，而且LIMMIT之前；
			 * 2.用左外连接，考虑到后期可能有channel_id的null，尤其是外键约束为SET NULL时；
			 * 3.分页只需查询ovreview以提升速度
			 */
			String sql = "" + "SELECT a.id, " + "       a. name, "
					+ "       a.author, " + "       a.overview, "
					+ "       a.crt_datetime, " + "       a.upd_timestamp, "
					+ "       b. name " + "FROM   (SELECT * "
					+ "        FROM   article "
					/**
					 * 与总分页findPgnAll()就差在这， 两个分页不能用if判断一个实现，
					 * 就因为PrepareStatement按？顺序赋值。
					 */
					+ "        WHERE  channel_id = ?" + "        ORDER  BY "
					+ orderField + " " + orderDerection
					+ "        LIMIT  ?, ?) a " + "       LEFT JOIN channel b "
					+ "              ON a.channel_id = b.id";
			state = conn.prepareStatement(sql);
			state.setInt(1, channelId);
			state.setInt(2, first);
			state.setInt(3, num);
			rs = state.executeQuery();
			while (rs.next()) {
				Article a = new Article();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setAuthor(rs.getString(3));
				a.setOverview(rs.getString(4));
				// 两个日期字段格式化
				a.setCrtDatetime(format.format(rs.getTimestamp(5)));
				a.setUpdTimestamp(format.format(rs.getTimestamp(6)));
				// 栏目名字段
				Channel c = new Channel();
				c.setName(rs.getString(7));
				a.setChannel(c);

				articles.add(a);
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
		return articles;
	}

	@Override
	public int findCountChannelId(int channelId) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT COUNT(id) FROM article where channel_id=?";
			state = conn.prepareStatement(sql);
			state.setInt(1, channelId);
			rs = state.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}

}
