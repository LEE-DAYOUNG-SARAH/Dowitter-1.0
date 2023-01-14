package kr.ac.green.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.ac.green.dto.User;

public class MySqlUserDao implements IUserDao {
	//field
	private static final MySqlUserDao INSTANCE = new MySqlUserDao();
	
	//constructor
	private MySqlUserDao() {}
	
	//getInstance
	public static IUserDao getInstance() {
		return INSTANCE;
	}

	//insertUser
	@Override
	public int insertUser(Connection con, User user) {
		int result = 0;
		String sql = "INSERT INTO users VALUES (?,?)";
		PreparedStatement pStmt = null;
		
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, toEn(user.getU_id()));
			pStmt.setString(2, toEn(user.getU_pw()));
			
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		return result;
	}

	//deleteUser
	@Override
	public int deleteUser(Connection con, String u_id) {
		int result = 0;
		String sql = "DELETE FROM users WHERE u_id=?";
		PreparedStatement pStmt = null;
		
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, toEn(u_id));
			
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		return result;
	}

	//updateUser
	@Override
	public int updateUser(Connection con, User user) {
		int result = 0;
		String sql = "UPDATE users SET u_pw=? WHERE u_id=?";
		PreparedStatement pStmt = null;
		
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, toEn(user.getU_pw()));
			pStmt.setString(2, toEn(user.getU_id()));
			
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		return result;
	}

	//getById
	@Override
	public User getById(Connection con, String u_id) {
		User user = null;
		String sql = "SELECT * FROM users WHERE u_id=?";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, toEn(u_id));
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				user = new User(
						toKor(rs.getString(1)),
						toKor(rs.getString(2))
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pStmt);
		}
		return user;
	}

	//toEn
	private String toEn(String str) {
		String en = null;
		try {
			en = new String(str.getBytes("euc-kr"),"8859_1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return en;
	}
	//toKor
	private String toKor(String str) {
		String kor = null;
		try {
			kor = new String(str.getBytes("8859_1"),"euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return kor;
	}
	
	//close
	private void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {}
	}
	private void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {}
	}
}
