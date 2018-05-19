package com.pcw.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("usermsg");
		Cookie[] cooks = request.getCookies();
		Cookie cook = null;
		for(Cookie c : cooks){
			if(c.getName().equals("user")){
				cook = c;
				break;
			}
		}
		if(cook != null){
			cook.setMaxAge(0);
			response.addCookie(cook);
			response.sendRedirect("/GraduateThesis/login");
		}
	}

}
