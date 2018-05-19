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
 * 自己写的log4j配置文件初始化servlet，暂未使用，目前使用的springMVC中的监听器进行
 */
@Deprecated
public class Log4jInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String log4jpath = config.getInitParameter("log4jpath");
		if(log4jpath == null || "".equals(log4jpath)){
			System.out.println("未配置相应的log4j的路径参数");
			BasicConfigurator.configure();
		}
		String realpath = config.getServletContext().getRealPath("/") + log4jpath;
		File logfile = new File(realpath);
		if(!logfile.exists()){
			System.out.println("配置文件不存在");
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
