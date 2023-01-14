package kr.ac.green.cmd;

import javax.servlet.http.HttpServletRequest;

public interface ICMD {
	String action(HttpServletRequest request);
}
