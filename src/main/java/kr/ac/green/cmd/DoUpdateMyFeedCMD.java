package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.DaoFactory;
import kr.ac.green.dao.IDocDao;
import kr.ac.green.dto.Doc;

public class DoUpdateMyFeedCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		int d_num = Integer.parseInt(request.getParameter("d_num"));
		String d_content = request.getParameter("d_content");
		
		IDocDao dao = DaoFactory.getDocDao();
		Connection con = DaoFactory.connect();
		Doc doc = dao.getByNum(con, d_num);
		doc.setD_content(d_content);
		dao.updateDoc(con, doc);
		DaoFactory.disconnect(con);
		
		request.setAttribute("isRedirect", true);
		return "myFeed.jsp";
	}

}
