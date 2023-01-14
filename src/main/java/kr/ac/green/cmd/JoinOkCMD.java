package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class JoinOkCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "가입이 성공하였습니다.");
		return "login.jsp";
	}

}
