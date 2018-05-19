package com.pcw.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;

import com.github.pagehelper.PageHelper;
import com.pcw.bean.QueryPaper;
import com.pcw.bean.Question;
import com.pcw.bean.User;
import com.pcw.common.Connection;
import com.pcw.dao.QueryPageDao;
import com.pcw.dao.QuestionDao;
import com.pcw.dao.UserDao;

public class JudgeLogin implements Filter {
	private Map<String, QueryPaper> qpmap;
	private Map<String, Question> qmap;
	private Map<String, Map<Character,Integer>> qresult;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hr = (HttpServletRequest)request;
		HttpSession session = hr.getSession();
		Cookie[] cooks = hr.getCookies();
//		usermsg为存储用户信息的属性，用于判断用户是否登录
		if(session.getAttribute("usermsg")!= null){
			chain.doFilter(request, response);
			return ;
		}
//		判断是否存在登录的cookie，用于判断用户近段时间是否登录
		for(Cookie c : cooks){
			if(c.getName().equals("user")){
				System.out.println("zhixingzhong");
//				暂时看作字符串的形式存在，后续更改
				String username = URLDecoder.decode(c.getValue(), "GBK");
				session.setAttribute("usermsg", username);
				UserDao userdao = Connection.getSession().getMapper(UserDao.class);
				User user = userdao.findByName(username);
				session.setAttribute("user", user);
				chain.doFilter(request, response);
				return ;
			}
		}
		
//		保存请求url并跳转至登录界面
		HttpServletResponse hsr = (HttpServletResponse)response;
		hsr.sendRedirect(hr.getContextPath() + "/login");
	}

	@Override
	public void destroy() {
		System.out.println("destroy执行中");
		SqlSession session = Connection.getSession();
		QuestionDao qd = session.getMapper(QuestionDao.class);
		int sum = 0;
		double percent = 0;
		StringBuilder sb = null;
		System.out.println(qmap.size());
		for(Map.Entry<String, Question> map : qmap.entrySet()){
			sb = new StringBuilder();
			 Map<Character, Integer> rmap = qresult.get("q_"+map.getKey());
			 sum = 0;
			 if(rmap == null){
				 System.out.println("rmap为空");
				 continue;
			 }
			 for(int n : rmap.values()){
				 sum += n;
			 }
			 if(sum == 0){
				 System.out.println("sum为0");
				 continue;
			 }
			 for(char key : rmap.keySet()){
				 sb.append(key).append(":").append(rmap.get(key)).append("?");
				 percent = rmap.get(key) * 100 / sum /100.0;
				 sb.append(percent).append(";");
			 }
			 map.getValue().setResult(sb.toString());
			 System.out.println(map.getValue());
			 qd.update(map.getValue());
		}
		session.commit();
		System.out.println("over");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		filterConfig.getServletContext().setAttribute("usermsg", "未登录");
		ServletContext config = filterConfig.getServletContext();
		qpmap = new HashMap<>();
		qmap = new HashMap<>();
		qresult = new HashMap<>();
		config.setAttribute("qpmap", qpmap);
		config.setAttribute("qmap", qmap);
		config.setAttribute("qresult", qresult);
	}
}
