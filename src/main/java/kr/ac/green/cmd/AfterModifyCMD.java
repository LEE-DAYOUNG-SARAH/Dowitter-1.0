package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public class AfterModifyCMD implements ICMD {

	@Override
	public String action(HttpServletRequest request) {
		request.setAttribute("msg", "ȸ�� ������ �����Ǿ����ϴ�.");
		return "GoMyFeed.do";
	}
	
}
