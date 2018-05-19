package com.pcw.service.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.pcw.bean.User;
import com.pcw.common.Connection;
import com.pcw.dao.UserDao;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(Regist.class);
	private UserDao userdao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession session= Connection.getSession();  
		 userdao = session.getMapper(UserDao.class);
		 User user = null;
		log.debug("正在登录");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Pattern p = Pattern.compile("1\\d{10}");
		Matcher m = p.matcher(id);
		try {
//			判断是否为邮箱登录
			if(id.contains("@")){
				user = userdao.findByEmail(id);
			}
//		判断是否为手机号登录
			else if(m.matches()){
				user = userdao.findByPhone(id);
			}
//			用户名登录
			else{
				user = userdao.findByName(id);
			}
			if(!request.getParameter("verify").equalsIgnoreCase((String)request.getSession().getAttribute("verified"))){
				response.sendRedirect("login");
			}
			else if(user != null && user.getPassword().equals(User.encodeByMD5(password))){
				Cookie cook = new Cookie("user", URLEncoder.encode(user.getUsername(), "GBK"));
//				cook.setDomain("GraduateThesis.com.cn");
				cook.setMaxAge(30*24*60*60);
				request.getSession().setAttribute("usermsg", user.getUsername());
				response.addCookie(cook);
				response.sendRedirect("al/index");
			}
		} catch (NoSuchAlgorithmException e) {
			log.error(e);
			e.printStackTrace();
		}
	}
   /*    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("id");
		User user = null;
		String password = request.getParameter("password");
		UserDao userdao = null;
		try {
			userdao = new UserDaoImpl();
			if(username.contains("@")){
				user = userdao.findByEmail(username);
			}else if(username.length() == 11){
				user = userdao.findByPhone(username);
			}else{
				user = userdao.findByName(username);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user == null || !user.getPassword().equals(password)){
//			处理验证失败的结果
			
			return ;
		}
		
//		处理验证成功的结果	
	}
*/
}
