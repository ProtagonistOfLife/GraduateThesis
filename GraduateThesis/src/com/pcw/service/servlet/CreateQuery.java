package com.pcw.service.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.pcw.bean.QueryPaper;
import com.pcw.bean.User;
import com.pcw.common.Connection;
import com.pcw.dao.QueryPageDao;

@WebServlet("/al/createquery.do")
public class CreateQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SqlSession session; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryPageDao qpd = session.getMapper(QueryPageDao.class);
		User user = (User) request.getSession().getAttribute("user");
		List<QueryPaper> queries = qpd.findByUser(user.getUserid());
		QueryPaper qp = new QueryPaper();
		qp.setPaperid(System.currentTimeMillis());
		qp.setUserid(user.getUserid());
		String papername = URLDecoder.decode(request.getParameter("title"), "UTF-8");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date enddate = format.parse((String)request.getParameter("enddate"));
			qp.setPapername(papername);
			qp.setEnddate(enddate);
			qpd.addQueryPage(qp);
			session.commit();
			Map<String, QueryPaper> map = (Map<String, QueryPaper>) request.getServletContext().getAttribute("qpmap");
			String mapid = "qp_" + qp.getPaperid();
			map.put(mapid, qp);
			request.getSession().setAttribute("qp", qp);
			response.getWriter().println("1");
		} catch (ParseException e) {
			request.setAttribute("etitle", "创建失败");
			request.setAttribute("msg", "时间填写错误，问卷创建失败!!");
			request.getRequestDispatcher("pages/errorpages.jsp").forward(request, response);
			response.getWriter().println("1");
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		super.init();
		session = Connection.getSession();
	}

}
