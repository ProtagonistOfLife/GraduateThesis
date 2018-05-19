package com.pcw.filter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.pcw.bean.BTable;
import com.pcw.bean.QueryPaper;
import com.pcw.bean.Question;
import com.pcw.common.Connection;
import com.pcw.dao.BTableDao;
import com.pcw.dao.QueryPageDao;
import com.pcw.dao.QuestionDao;

/**
 * Servlet Filter implementation class GetQueryFilter
 */
@WebFilter("/GetQueryFilter")
public class GetQueryFilter implements Filter {
	private SqlSession session;
	private QueryPageDao qpd;
	private QuestionDao qd;
	private BTableDao btd;
	private ServletContext context;
	private Map<String, QueryPaper> qpmap;
	private Map<String, Question> qmap;
	private Map<String, Map<Character,Integer>> qresult;
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hr = (HttpServletRequest)request;
		String qpid = hr.getParameter("queryid");
		Map<Character,Integer> rmap = null;
		if(!qpmap.containsKey(qpid)){
			String id = qpid.split("_")[1];
			QueryPaper qp = qpd.findById(Long.parseLong(id));
			List<Question> questions = qd.findByQuery(qp.getPaperid());
			List<Question> list = new LinkedList<>();
			for(Question q : questions){
				if(qmap.containsKey("q_"+ q.getQuestionid())){
					list.add(qmap.get("q_"+ q.getQuestionid()));
				}else{
					list.add(q);
					qmap.put("q_"+ q.getQuestionid(), q);
					rmap = new TreeMap<>();
					for(String str : q.getResult().split(";")){
						rmap.put(str.charAt(0), Integer.parseInt(str.split(":")[1].split("?")[0]));
					}
				}
			}
			qp.setQuestions(list);
			qpmap.put("qp_"+qp.getPaperid(), qp);
		}
		
		chain.doFilter(request, response);
	}

	@SuppressWarnings("unchecked")
	public void init(FilterConfig fConfig) throws ServletException {
		context = fConfig.getServletContext();
		session = Connection.getSession();
		qpd = session.getMapper(QueryPageDao.class);
		qd = session.getMapper(QuestionDao.class);
		btd = session.getMapper(BTableDao.class);
		qpmap = (Map<String, QueryPaper>) context.getAttribute("qpmap");
		qmap = (Map<String, Question>) context.getAttribute("qmap");
		qresult = (Map<String, Map<Character, Integer>>) context.getAttribute("qresult");
		
	}

}
