package com.pcw.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcw.bean.User;

/**
 * 用于处理邮箱验证码的
 * @author asus-1
 *
 */
@WebServlet("/emailmatch")
public class EmailMatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String scode = (String) session.getAttribute("emailcode");
		String icode = request.getParameter("verifycode");
		if(scode.equalsIgnoreCase(icode)){
			User user = new User();
			user.setEmail((String) session.getAttribute("email"));
			session.setAttribute("user", user);
			response.getWriter().println("1");
		}
	}

}
