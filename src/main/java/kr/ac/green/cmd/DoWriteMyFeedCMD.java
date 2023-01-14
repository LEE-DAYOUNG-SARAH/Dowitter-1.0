package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.DaoFactory;
import kr.ac.green.dao.IDocDao;
import kr.ac.green.dto.Doc;
import kr.ac.green.dto.User;

public class DoWriteMyFeedCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		String d_content = request.getParameter("d_content");
		User user = (User)request.getSession().getAttribute("loginUser");
		String u_id = user.getU_id();
		Doc doc = new Doc(d_content, u_id);
		
		IDocDao dao = DaoFactory.getDocDao();
		Connection con = DaoFactory.connect();
		dao.insertDoc(con, doc);
		DaoFactory.disconnect(con);
		
		request.setAttribute("isRedirect", true);
		return "goMyFeed.do";
	}

}
