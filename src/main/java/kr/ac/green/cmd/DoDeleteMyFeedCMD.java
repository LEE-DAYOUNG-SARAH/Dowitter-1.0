package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.DaoFactory;
import kr.ac.green.dao.IDocDao;

public class DoDeleteMyFeedCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		int d_num = Integer.parseInt(request.getParameter("d_num"));
		
		IDocDao dao = DaoFactory.getDocDao();
		Connection con = DaoFactory.connect();
		dao.deleteDoc(con, d_num);
		DaoFactory.disconnect(con);
		
		request.setAttribute("isRedirect", true);
		return "myFeed.jsp";
	}

}
