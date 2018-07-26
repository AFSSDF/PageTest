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

//Service��
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

	
	//����һҳ��ʾ������������ҳ��
	//���ظ�ҳ������
	@Override
	public PageBean getPageUsers(int pageCur, int pageSize) throws SQLException {
		UserDao userDao;
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConn();
			userDao = new UserDaoImpl(conn);
			//�������������
			int dataTotal = userDao.getUserCount();
			//���ø�ҳ�Ļ�����Ϣ
			PageBean<User> pageBean = new PageBean<User>(dataTotal, pageCur, pageSize);
			//���ݸ�ҳ����ϢΪ��ҳ��������
			pageBean.setList(userDao.getPageUsers(pageBean.getPageCur(), pageBean.getPageSize()));
			//���ظ�ҳ
			return pageBean;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatabaseUtil.close(conn, null, null, null);
		}

	}

}
