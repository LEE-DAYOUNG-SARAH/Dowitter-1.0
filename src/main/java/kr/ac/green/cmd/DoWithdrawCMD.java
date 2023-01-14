package kr.ac.green.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.green.dao.DaoFactory;
import kr.ac.green.dao.IUserDao;
import kr.ac.green.dto.User;

public class DoWithdrawCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		
		IUserDao dao = DaoFactory.getUserDao();
		Connection con = DaoFactory.connect();
		dao.deleteUser(con, user.getU_id());
		DaoFactory.disconnect(con);
		
		session.invalidate();
		return "afterWithdraw.do";
	}

}
