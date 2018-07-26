package com.aaa.pagetest.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.aaa.pagetest.dao.UserDao;
import com.aaa.pagetest.dao.impl.UserDaoImpl;
import com.aaa.pagetest.entity.User;
import com.aaa.pagetest.service.UserService;
import com.aaa.pagetest.util.DatabaseUtil;
import com.aaa.pagetest.util.PageBean;

//Service层
public class UserServiceImpl implements UserService {

	@Override
	public List<User> getAllUsers() throws SQLException {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConn();
			return new UserDaoImpl(conn).getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatabaseUtil.close(conn, null, null, null);
		}
	}

	
	//根据一页显示的数据条数和页码
	//返回该页的数据
	@Override
	public PageBean getPageUsers(int pageCur, int pageSize) throws SQLException {
		UserDao userDao;
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConn();
			userDao = new UserDaoImpl(conn);
			//获得总数据条数
			int dataTotal = userDao.getUserCount();
			//设置该页的基本信息
			PageBean<User> pageBean = new PageBean<User>(dataTotal, pageCur, pageSize);
			//根据该页的信息为该页设置数据
			pageBean.setList(userDao.getPageUsers(pageBean.getPageCur(), pageBean.getPageSize()));
			//返回该页
			return pageBean;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatabaseUtil.close(conn, null, null, null);
		}

	}

}
