package com.pcw.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class Connection {
	private static Logger log = Logger.getLogger(Connection.class);
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try {
			Reader reader = Resources.getResourceAsReader("mybatisconfig.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
			
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession(){
		return sqlSessionFactory.openSession();
	}
}
