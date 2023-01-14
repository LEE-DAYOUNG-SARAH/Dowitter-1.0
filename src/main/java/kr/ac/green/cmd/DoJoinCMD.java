package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.DaoFactory;
import kr.ac.green.dao.IUserDao;
import kr.ac.green.dto.User;

public class DoJoinCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		String nextPage = null;
		
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		User user = new User(u_id, u_pw);
		
		IUserDao dao = DaoFactory.getUserDao();
		Connection con = DaoFactory.connect();
		User savedUser = dao.getById(con, u_id);
		
		if(savedUser == null) {
			dao.insertUser(con, user);
			nextPage = "joinOk.do";
			request.setAttribute("isRedirect", true);
		} else {
			nextPage = "join.jsp";
			request.setAttribute("msg", "중복된 아이디 입니다.");
			request.setAttribute("user", user);
		}
		DaoFactory.disconnect(con);
		return nextPage;
	}

}
