package com.aaa.pagetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private Connection conn = null;

	public BaseDao(Connection conn) {
		this.conn = conn;
	}

	protected int executeUpdate(String sql, Object... params) throws SQLException {
		int result = 0;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i + 1, params[i]);
		}
		result = pstmt.executeUpdate();
		return result;
	}

	protected ResultSet executeQuery(String sql, Object... params) throws SQLException {
		ResultSet rs = null;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i + 1, params[i]);
		}
		rs = pstmt.executeQuery();
		return rs;
	}
}