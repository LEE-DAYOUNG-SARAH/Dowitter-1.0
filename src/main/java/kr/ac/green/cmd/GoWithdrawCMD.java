package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class GoWithdrawCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "�� ������ ����� �� �����ϴ�.");
		return "withdraw.jsp";
	}

}
