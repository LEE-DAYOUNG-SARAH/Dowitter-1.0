package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class GoJoinCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "��� �׸��� �ʼ��Է��Դϴ�.");
		return "join.jsp";
	}

}
