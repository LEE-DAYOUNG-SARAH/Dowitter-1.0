package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.DaoFactory;
import kr.ac.green.dao.IDocDao;
import kr.ac.green.dto.Doc;

public class GoTimelineCMD implements ICMD{

	@Override
	public String action(HttpServletRequest request) {
		IDocDao dao = DaoFactory.getDocDao();
		Connection con = DaoFactory.connect();
		Doc[] list = dao.getAll(con);
		DaoFactory.disconnect(con);
		
		request.setAttribute("list", list);
		return "timeline.jsp";
	}
	
}
