package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class AfterWithdrawCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "�׵��� �̿����ּż� ����帳�ϴ�.");
		return "login.jsp";
	}

}
