package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class StartCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "�������");
		return "login.jsp";
	}

}
