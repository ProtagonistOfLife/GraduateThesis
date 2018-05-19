package com.pcw.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcw.bean.QueryPaper;
import com.pcw.bean.User;
import com.pcw.common.Connection;
import com.pcw.dao.QueryPageDao;
import com.pcw.dao.UserDao;

public class DoSetRequest implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hr = (HttpServletRequest)request;
		 String param1 = request.getParameter("page");
		    int pageorder = 1;
		    if(param1 != null && !param1.equals(""))
		    	pageorder = Integer.parseInt(param1);
		    PageHelper.startPage(pageorder,10);
		    SqlSession sqlsession = Connection.getSession();
		    QueryPageDao qpd = sqlsession.getMapper(QueryPageDao.class);
		   	User user = (User) hr.getSession().getAttribute("user");
		    List<QueryPaper> queries = qpd.findByUser(user.getUserid());
		    PageInfo<QueryPaper> pages = new PageInfo<QueryPaper>(queries);
		    hr.setAttribute("page", pages);
		    hr.setAttribute("queries", queries);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
