package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class CancelModifyCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "회원정보 수정이 취소되었습니다.");
		return "myFeed.jsp";
	}

}
