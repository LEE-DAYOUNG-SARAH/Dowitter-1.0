package kr.ac.green.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ac.green.dto.Doc;

public class MySqlDocDao implements IDocDao {
	//field
	private static final MySqlDocDao INSTANCE = new MySqlDocDao();
	
	//constructor
	private MySqlDocDao() {}
	
	//getInstance
	public static IDocDao getInstance() {
		return INSTANCE;
	}

	//insertDoc
	@Override
	public int insertDoc(Connection con, Doc doc) {
		int result = 0;
		String sql = "INSERT INTO docs (d_content, u_id, d_date) VALUES (?,?,?)";
		PreparedStatement pStmt = null;
		
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, toEn(doc.getD_content()));
			pStmt.setString(2, toEn(doc.getU_id()));
			pStmt.setString(3, toEn(doc.getD_date()));
			
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		return result;
	}

	@Override
	public int deleteDoc(Connection con, int d_num) {
		int result = 0;
		String sql = "DELETE FROM docs WHERE d_num=?";
		PreparedStatement pStmt = null;
		
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setInt(1, d_num);
			
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		return result;
	}

	@Override
	public int updateDoc(Connection con, Doc doc) {
		int result = 0;
		String sql = "UPDATE docs SET d_content=? WHERE d_num=?";
		PreparedStatement pStmt = null;
		
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, toEn(doc.getD_content()));
			pStmt.setInt(2, doc.getD_num());
			
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		return result;
	}

	@Override
	public Doc[] getAll(Connection con) {
		Doc[] list = null;
		String sql = "SELECT * FROM docs ORDER BY d_date DESC";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			pStmt = con.prepareStatement(sql);
			rs = pStmt.executeQuery();
			
			list = rowMapping(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pStmt);
		}
		return list;
	}

	//getById
	@Override
	public Doc[] getById(Connection con, String u_id) {
		Doc[] list = null;
		String sql = "SELECT * FROM docs WHERE u_id=?";
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, toEn(u_id));
			rs = pStmt.executeQuery();
		
			list = rowMapping(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pStmt);
		}
		return list;
	}
	
	//rowMapping
	private Doc[] rowMapping(ResultSet rs) throws SQLException {
		ArrayList<Doc> arr = new ArrayList<Doc>();
		while(rs.next()) {
			arr.add(new Doc(
					rs.getInt(1),
					toKor(rs.getString(2)),
					toKor(rs.getString(3)),
					toKor(rs.getString(4))
			));
		}
		return arr.toArray(new Doc[0]);
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
		//getByNum
		   @Override
		   public Doc getByNum(Connection con, int d_num) {
		      Doc doc = null;
		      String sql = "SELECT * FROM docs WHERE d_num=?";
		      PreparedStatement pStmt = null;
		      ResultSet rs = null;
		      
		      try {
		         pStmt = con.prepareStatement(sql);
		         pStmt.setInt(1, d_num);
		         rs = pStmt.executeQuery();
		      
		         doc = rowMapping(rs)[0];
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(rs);
		         close(pStmt);
		      }
		      return doc;
		   }
}
