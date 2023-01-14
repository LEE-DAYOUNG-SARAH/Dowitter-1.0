package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class GoModifyCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "비밀번호만 수정가능합니다.");
		return "modify.jsp";
	}

}
