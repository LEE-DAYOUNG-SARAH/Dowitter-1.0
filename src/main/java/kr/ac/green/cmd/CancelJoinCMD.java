package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class CancelJoinCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "가입이 취소되었습니다.");
		return "login.jsp";
	}

}
