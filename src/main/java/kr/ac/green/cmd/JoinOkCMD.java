package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class JoinOkCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "������ �����Ͽ����ϴ�.");
		return "login.jsp";
	}

}
