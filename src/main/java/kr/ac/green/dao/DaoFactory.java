package kr.ac.green.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DaoFactory {
	//field
	private static Map<String, String> DBINFO;
	
	//init
	public static void init(Map<String, String> dbInfo) {
		DBINFO = dbInfo;
		try {
			Class.forName(DBINFO.get("driver"));
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//connect
	public static Connection connect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					DBINFO.get("dbUrl"), DBINFO.get("uid"), DBINFO.get("upw")
			);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//disconnect
	public static void disconnect(Connection con) {
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//getDocDao
	public static IDocDao getDocDao() {
		IDocDao dao = null;
		if(DBINFO.get("dbType").equals("mysql")) {
			dao = MySqlDocDao.getInstance();
		}
		return dao;
	}
	
	//getUserDao
	public static IUserDao getUserDao() {
		IUserDao dao = null;
		if(DBINFO.get("dbType").equals("mysql")) {
			dao = MySqlUserDao.getInstance();
		}
		return dao;
	}
}
