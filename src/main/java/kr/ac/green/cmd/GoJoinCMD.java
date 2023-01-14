package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class GoJoinCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "모든 항목은 필수입력입니다.");
		return "join.jsp";
	}

}
