package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class AccessDeniedCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "유효하지 않은 접근입니다.");
		return "login.jsp";
	}

}
