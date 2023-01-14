package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class GoWithdrawCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "이 동작은 취소할 수 없습니다.");
		return "withdraw.jsp";
	}

}
