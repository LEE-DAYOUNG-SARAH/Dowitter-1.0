package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class CancelModifyCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "ȸ������ ������ ��ҵǾ����ϴ�.");
		return "myFeed.jsp";
	}

}
