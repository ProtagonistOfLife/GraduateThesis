package com.pcw.bean;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcw.common.Connection;
import com.pcw.dao.QueryPageDao;
@Deprecated
public class MD5Test {
	@Test
	public void test() throws NoSuchAlgorithmException, UnsupportedEncodingException{
		User user = new User();
		String md5code = User.encodeByMD5("pengciwen");
		System.out.println(md5code + ":" + md5code.length());
		md5code = User.encodeByMD5("0000");
		System.out.println(md5code + ":" + md5code.length());
	}

	@Test
	public void search(){
		 SqlSession sqlsession = Connection.getSession();
	    QueryPageDao qpd = sqlsession.getMapper(QueryPageDao.class);
	    PageHelper.startPage(1, 10,true);
	    List<QueryPaper> queries = qpd.findByUser(1036l);
	    PageInfo<QueryPaper> pages = new PageInfo<QueryPaper>(queries);
		   for(QueryPaper q : queries){
			   System.out.println(q.getPapername());
		   }
	}
}
