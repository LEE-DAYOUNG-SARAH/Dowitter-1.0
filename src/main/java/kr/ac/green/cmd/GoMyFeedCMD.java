package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.DaoFactory;
import kr.ac.green.dao.IDocDao;
import kr.ac.green.dto.Doc;
import kr.ac.green.dto.User;

public class GoMyFeedCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("loginUser");
		String u_id = user.getU_id();
		
		IDocDao dao = DaoFactory.getDocDao();
		Connection con = DaoFactory.connect();
		Doc[] list = dao.getById(con, u_id);
		DaoFactory.disconnect(con);
		
		request.setAttribute("list", list);
		return "myFeed.jsp";
	}

}
