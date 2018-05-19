package com.pcw.service.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

/**
 * �Լ�д��log4j�����ļ���ʼ��servlet����δʹ�ã�Ŀǰʹ�õ�springMVC�еļ���������
 */
@Deprecated
public class Log4jInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String log4jpath = config.getInitParameter("log4jpath");
		if(log4jpath == null || "".equals(log4jpath)){
			System.out.println("δ������Ӧ��log4j��·������");
			BasicConfigurator.configure();
		}
		String realpath = config.getServletContext().getRealPath("/") + log4jpath;
		File logfile = new File(realpath);
		if(!logfile.exists()){
			System.out.println("�����ļ�������");
			BasicConfigurator.configure();
		}
		try {
			PropertyConfigurator.configure(new FileInputStream(logfile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			BasicConfigurator.configure();
		}
		super.init(config);
	}

	
}
