package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class AfterWithdrawCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "그동안 이용해주셔서 감사드립니다.");
		return "login.jsp";
	}

}
