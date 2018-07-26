package com.aaa.pagetest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.pagetest.entity.User;
import com.aaa.pagetest.service.UserService;
import com.aaa.pagetest.service.impl.UserServiceImpl;
import com.aaa.pagetest.util.PageBean;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		UserService userService = new UserServiceImpl();
		//获得该页页码
		Integer pageCur = Integer.parseInt(request.getParameter("pageCur"));
		PageBean pageBean = null;
		try {
			//根据页码及一页显示的数据获得该页
			pageBean = userService.getPageUsers(pageCur, 2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(pageBean));
		//把页面JSON化方便前端页面解析
		out.print(JSON.toJSONString(pageBean));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
