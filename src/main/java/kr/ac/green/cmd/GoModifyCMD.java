package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class GoModifyCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "��й�ȣ�� ���������մϴ�.");
		return "modify.jsp";
	}

}
