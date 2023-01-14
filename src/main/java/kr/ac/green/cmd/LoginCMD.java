package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import kr.ac.green.dao.DaoFactory;
import kr.ac.green.dao.IUserDao;
import kr.ac.green.dto.User;

public class LoginCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		String nextPage = null;
		
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		
		IUserDao dao = DaoFactory.getUserDao();
		Connection con = DaoFactory.connect();
		User savedUser = dao.getById(con, u_id);
		DaoFactory.disconnect(con);
		
		if(savedUser == null) {
			request.setAttribute("msg", "��ϵ��� ���� ���̵��Դϴ�.");
			nextPage = "login.jsp";
		} else {
			if(savedUser.getU_pw().equals(u_pw)) {
				request.getSession().setAttribute("loginUser", savedUser);
				nextPage = "goTimeline.do";
			} else {
				request.setAttribute("msg", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				nextPage = "login.jsp";
			}
		}
		return nextPage;
	}

}
