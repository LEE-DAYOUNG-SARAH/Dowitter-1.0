package kr.ac.green.dao;

import java.sql.Connection;

import kr.ac.green.dto.User;

public interface IUserDao {
	int insertUser(Connection con, User user);
	int deleteUser(Connection con, String u_id);
	int updateUser(Connection con, User user);
	User getById(Connection con, String u_id);
}
