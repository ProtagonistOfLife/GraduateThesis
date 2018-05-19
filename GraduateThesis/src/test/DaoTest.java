package test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcw.bean.BTable;
import com.pcw.bean.Question;
import com.pcw.common.Connection;
import com.pcw.dao.BTableDao;
import com.pcw.dao.QueryPageDao;
import com.pcw.dao.QuestionDao;

public class DaoTest {
	private SqlSession session;
	private QuestionDao qd;
	private QueryPageDao qpd;
	private BTableDao btd;
	
	@Before
	public void doBefore(){
		session = Connection.getSession();
		qd = session.getMapper(QuestionDao.class);
		qpd = session.getMapper(QueryPageDao.class);
		btd = session.getMapper(BTableDao.class);
	}
	
	@Test
	public void doSearch(){
		List<Question> list = qd.findByPattern("");
		for(Question q : list){
			System.out.println(q.getQuestion());
		}
	}
	
	@Test
	public void doUpdate(){
		Question q = new Question();
		q.setQuestionid(1525858456804l);
		q.setCreate_date(new Date());
		q.setResult("test");
		qd.update(q);
		session.commit();
	}
	
	@Test
	public void doPageHelper(){
		PageHelper.startPage(1, 2);
		List<Question> list = qd.findByPattern("Ò»°ã");
		PageInfo<Question> pi = new PageInfo<>(list);
		System.out.println(pi.getPages());
	}
	
	public void deleteQuery(){
		String sql = "select qp.* from ques_paper qp,ques_question_paper qqp where qo.paperid = qqp.paperid";
		
	}
}
