package com.aaa.pagetest.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.aaa.pagetest.entity.User;
import com.aaa.pagetest.service.UserService;
import com.aaa.pagetest.service.impl.UserServiceImpl;

public class test {
	@Test
	public void showAllUsers() {
		UserService userService=new UserServiceImpl();
		List<User> users =null;
		try {
			users=userService.getAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (User user : users) {
			System.out.println(user.getUserName()+"=="+user.getPassword());
		}
	}
}
