package com.aaa.pagetest.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aaa.pagetest.dao.BaseDao;
import com.aaa.pagetest.dao.UserDao;
import com.aaa.pagetest.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	public UserDaoImpl(Connection conn) {
		super(conn);
	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		String sql = "select * from easybuy_user";
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		rs = super.executeQuery(sql);
		while (rs.next()) {
			User user = new User();
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getInt("sex"));
			users.add(user);
		}
		return users;
	}
	
	
	//根据处理后的页码和一页显示的数据书进行查询
	//返回该页的数据
	@Override
	public List<User> getPageUsers(int pageCur, int pageSize) throws SQLException {
		String sql = "select * from easybuy_user limit ?,?";
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();
		rs = super.executeQuery(sql,pageSize*(pageCur-1),pageSize);
		while (rs.next()) {
			User user = new User();
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getInt("sex"));
			users.add(user);
		}
		return users;
	}

	@Override
	public int getUserCount() throws SQLException {
		String sql = "select count(*) as count from easybuy_user";
		ResultSet rs = null;
		int count=0;
		rs = super.executeQuery(sql);
		while (rs.next()) {
			count=rs.getInt("count");
		}
		return count;
	}

}
