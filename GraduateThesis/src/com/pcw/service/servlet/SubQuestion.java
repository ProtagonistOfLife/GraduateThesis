package com.pcw.service.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.pcw.bean.BTable;
import com.pcw.bean.QueryPaper;
import com.pcw.bean.Question;
import com.pcw.common.Connection;
import com.pcw.dao.BTableDao;
import com.pcw.dao.QuestionDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class SubQuestion
 */
@WebServlet("/subquestion")
public class SubQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSession session;
	private QuestionDao qdao;
	private BTableDao bt;
	private ServletContext context;
	private Map<String, Map<Character,Integer>> qresult;
	private Map<String, Question> qmap;
	
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		qdao = session.getMapper(QuestionDao.class);
		bt = session.getMapper(BTableDao.class);
		QueryPaper qp = (QueryPaper) request.getSession().getAttribute("qp");
//		问卷创建完成后返回链接
		if("ok".equals(request.getParameter("geturl"))){
			String uri = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ request.getContextPath() + "/querypage.do?queryid=qp_" + qp.getPaperid();
			response.getWriter().println(uri);
			return;
		}
		String questionid =request.getParameter("questionid");
//		添加问题
		if(questionid != null && !questionid.equals("")){
			Question ques = null;
			JSONObject jo = new JSONObject();
			JSONArray ja = new JSONArray();
			if(qmap.containsKey(questionid)){
				ques = qmap.get(questionid);
				qp.getQuestions().add(ques);
				
			}else{
				ques = qdao.findById(Long.parseLong(questionid.split("_")[1]));
				System.out.println("找到了");
				qmap.put("q_"+ques.getQuestionid(), ques);
				qp.getQuestions().add(ques);
				Map<Character, Integer> m = new TreeMap<>();
				String result = ques.getResult();
				if(result == null || result.equals("")){
					char c = 'A';
					for(String str : ques.getChoose().split(";")){
						m.put(c, 0);
						c++;
					}
				}else{
					for(String str : ques.getChoose().split(";")){
						m.put(str.charAt(0), Integer.parseInt(str.split(":")[1].split("?")[0]));
					}
				}
				qresult.put("q_"+ques.getQuestion(), m);
			}
			jo.put("question", ques.getQuestion());
			for(String str : ques.getChoose().split(";")){
				ja.add(str);
			}
			jo.put("choose", ja);
			BTable b = new BTable();
			b.setPaperid(qp.getPaperid());
			b.setQuestionid(ques.getQuestionid());
			bt.addBTable(b);
			session.commit();
			response.getWriter().println(URLEncoder.encode(jo.toString(), "UTF-8"));
			return ;
		}
//		问题创建
		Question ques = new Question();
		ques.setCreate_date(new Date());
		String question = URLDecoder.decode(request.getParameter("question"), "UTF-8");
		ques.setQuestion(question);
		String choose = URLDecoder.decode(request.getParameter("chooses"), "UTF-8");
		ques.setChoose(choose);
		System.out.println(choose);
		ques.setQuestionid(System.currentTimeMillis());
		if(qp.getQuestions() == null)
			qp.setQuestions(new LinkedList<>());
		qp.getQuestions().add(ques);
		qdao.addQuestion(ques);
		BTable btable = new BTable();
		btable.setPaperid(qp.getPaperid());
		btable.setQuestionid(ques.getQuestionid());
		bt.addBTable(btable);
		@SuppressWarnings("unchecked")
		Map<String, Question> map = (Map<String,Question>) context.getAttribute("qmap");
		String mapid = "q_" + ques.getQuestionid();
		map.put(mapid, ques);
		session.commit();
		Map<Character, Integer> rmap = new TreeMap<>();
		char c = 'A';
		for(String srt : ques.getChoose().split(";")){
			rmap.put(c, 0);
			c++;
		}
		qresult.put("q_"+ques.getQuestionid(), rmap);
		response.getWriter().println("1");
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		session = Connection.getSession();
		context = config.getServletContext();
		qresult = (Map<String, Map<Character,Integer>>)context.getAttribute("qresult");
		qmap = (Map<String, Question>) context.getAttribute("qmap");
	}

}
