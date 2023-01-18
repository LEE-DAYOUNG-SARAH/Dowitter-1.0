package kr.ac.green.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.green.cmd.CMDFactory;
import kr.ac.green.dao.DaoFactory;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//init
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		CMDFactory.init();
		
		Map<String, String> dbInfo = new Hashtable<String, String>();
		Enumeration<?> names = config.getInitParameterNames();
		while(names.hasMoreElements()) {
			String key = names.nextElement().toString();
			String value = config.getInitParameter(key);
			dbInfo.put(key, value);
		}
		DaoFactory.init(dbInfo);
	}

	//doGet
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	//doPost
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	//process
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI().substring(request.getContextPath().length());
		String nextPage = CMDFactory.doAction(request, cmd);
		if(request.getAttribute("isRedirect") == null) {
			request.getRequestDispatcher(nextPage).forward(request, response);
		} else {
			response.sendRedirect(nextPage);
		}
	}
}
