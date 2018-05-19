package com.pcw.service.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
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

import com.pcw.bean.Question;
import com.pcw.common.Connection;
import com.pcw.dao.QuestionDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/al/searchquestion")
public class SearchQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSession qsession;
	private QuestionDao qd;
	private Map<String, Map<Character,Integer>> qresult;
	private Map<String, Question> qmap;
	private ServletContext context;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pattern = URLDecoder.decode(request.getParameter("pattern"),"UTF-8");
		List<Question> questions = qd.findByPattern(pattern);
		System.out.println(pattern);
		
		char c ='A';
		Map<Character, Integer> rmap = null;
		JSONArray ja = new JSONArray();
		JSONArray chooses = null;
		JSONObject jo = new JSONObject();
		
		for(Question q : questions){
			chooses = new JSONArray();
			jo.put("questionid", "q_"+q.getQuestionid());
			if(qresult.containsKey("q_"+q.getQuestionid())){
				jo.put("question", q.getQuestion());
				jo.put("choose", JSONArray.fromObject(q.getChoose().split(";")));
				for(Map.Entry<Character, Integer> entry : qresult.get("q_"+q.getQuestionid()).entrySet()){
					chooses.add(entry.getKey() + ":" + entry.getValue());
				}
				jo.put("result", chooses);
				ja.add(jo);
				continue;
			}
			c = 'A';
			rmap = new TreeMap<>();
			if(!qmap.containsKey("q_"+q.getQuestionid())){
				qmap.put("q_"+q.getQuestionid(), q);
			}
			if(q.getResult() == null || q.getResult().equals("") )
				for(String srt : q.getChoose().split(";")){
					rmap.put(c, 0);
					c++;
				}
			else
				for(String str : q.getResult().split(";")){
					rmap.put(str.charAt(0), Integer.parseInt(str.split(":")[1].split("?")[0]));
				}
			qresult.put("q_"+q.getQuestionid(), rmap);
			jo.put("question", q.getQuestion());
			jo.put("choose", JSONArray.fromObject(q.getChoose().split(";")));
			for(Map.Entry<Character, Integer> entry : qresult.get("q_"+q.getQuestionid()).entrySet()){
				chooses.add(entry.getKey() + ":" + entry.getValue());
			}
			jo.put("result", chooses);
			ja.add(jo);
		}
		System.out.println(ja);
		response.getWriter().println(URLEncoder.encode(ja.toString(), "utf-8"));
	}


	@SuppressWarnings("unchecked")
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		qsession = Connection.getSession();
		qd = qsession.getMapper(QuestionDao.class);
		context = config.getServletContext();
		qresult = (Map<String, Map<Character, Integer>>) context.getAttribute("qresult");
		qmap = (Map<String, Question>) context.getAttribute("qmap");
	}

	
	
}
