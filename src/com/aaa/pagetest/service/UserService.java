package com.aaa.pagetest.service;

import java.sql.SQLException;
import java.util.List;

import com.aaa.pagetest.entity.User;
import com.aaa.pagetest.util.PageBean;

public interface UserService {
	List<User> getAllUsers() throws SQLException;
	PageBean getPageUsers(int pageCur,int pageSize) throws SQLException;
}
