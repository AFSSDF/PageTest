package com.aaa.pagetest.dao;

import java.sql.SQLException;
import java.util.List;

import com.aaa.pagetest.entity.User;

public interface UserDao {
	
	List<User> getAllUsers() throws SQLException;
	
	List<User> getPageUsers(int pageCur,int pageSize) throws SQLException;
	
	int getUserCount() throws SQLException;
}
