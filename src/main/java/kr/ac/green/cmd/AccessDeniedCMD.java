package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class AccessDeniedCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "��ȿ���� ���� �����Դϴ�.");
		return "login.jsp";
	}

}
