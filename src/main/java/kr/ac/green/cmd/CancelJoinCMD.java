package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class CancelJoinCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "������ ��ҵǾ����ϴ�.");
		return "login.jsp";
	}

}
