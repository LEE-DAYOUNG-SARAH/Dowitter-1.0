package kr.ac.green.dao;

import java.sql.Connection;

import kr.ac.green.dto.Doc;

public interface IDocDao {
	int insertDoc(Connection con, Doc doc);
	int deleteDoc(Connection con, int d_num);
	int updateDoc(Connection con, Doc doc);
	Doc[] getAll(Connection con);
	Doc[] getById(Connection con, String u_id);
	Doc getByNum(Connection con, int d_num);
}
