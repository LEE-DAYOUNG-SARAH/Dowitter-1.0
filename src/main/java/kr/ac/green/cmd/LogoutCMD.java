package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.green.dto.User;

public class LogoutCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		request.setAttribute("msg", user.getU_id() + "´Ô ¾È³çÈ÷ °¡¼¼¿ä.");
		session.invalidate();
		return "login.jsp";
	}

}
