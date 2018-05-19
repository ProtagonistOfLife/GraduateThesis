package com.pcw.service.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.pcw.bean.User;
import com.pcw.common.Connection;
import com.pcw.dao.UserDao;
import com.pcw.enumeration.Gender;

public class Regist extends HttpServlet {
	private static Logger log = Logger.getLogger(Regist.class);
	private static final long serialVersionUID = 1L;
	private UserDao userdao;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession session= Connection.getSession();  
		 userdao = session.getMapper(UserDao.class);
		log.debug("正在注册");
		//获取注册信息
		String name = request.getParameter("nickname");
		String password = request.getParameter("password");
		String birthyear = request.getParameter("year");
		String birthmonth = request.getParameter("month");
		String birthday = request.getParameter("day");
		String gender = request.getParameter("sex");
		//创建对象
		log.debug("正在创建用户对象");
		User user = (User) request.getSession().getAttribute("user");
		try {
			password = User.encodeByMD5(password);
			if(user == null)
				user = new User(name, password);
			else{
				user.setUsername(name);
				user.setPassword(password);
			}
			if(gender.equals("女"))
				user.setGender(Gender.female);
			else
				user.setGender(Gender.male);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date birth = format.parse(birthyear+"-"+birthmonth+"-"+birthday);
			user.setBirth(birth);
			userdao.addUser(user);
			System.out.println("运行中");
			log.error("注册成功");
			response.setHeader("refresh","3;url='login'");
			request.setAttribute("etitle", "注册成功");
			request.setAttribute("relink", "login");
			request.setAttribute("msg", "注册成功！！3秒后跳转至登录页面");
			request.setAttribute("rename", "回到登录界面");
			request.getRequestDispatcher("pages/errorpages.jsp").forward(request, response);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("创建用户对象异常");
			request.setAttribute("etitle", "注册失败");
			request.setAttribute("msg", "注册失败!!");
			request.setAttribute("relink", "http://www.baidu.com");
			request.setAttribute("rename", "浏览其他网页");
			request.getRequestDispatcher("pages/errorpages.jsp").forward(request, response);
		}
		
	}

}
/*由于暂时未决定使用mybatis还是jdbc，暂不是用dao*/
