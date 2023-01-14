package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.DaoFactory;
import kr.ac.green.dao.IUserDao;
import kr.ac.green.dto.User;

public class DoModifyCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		
		String u_pw = request.getParameter("u_pw");
		User user = (User)request.getSession().getAttribute("loginUser");
		user.setU_pw(u_pw);
		
		IUserDao dao = DaoFactory.getUserDao();
		Connection con = DaoFactory.connect();
		dao.updateUser(con, user);
		DaoFactory.disconnect(con);
		
		request.setAttribute("isRedirect", true);
		return "afterModify.do";
	}

}
