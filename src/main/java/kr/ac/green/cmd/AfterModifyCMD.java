package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class AfterModifyCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "회원 정보가 수정되었습니다.");
		return "GoMyFeed.do";
	}
	
}
