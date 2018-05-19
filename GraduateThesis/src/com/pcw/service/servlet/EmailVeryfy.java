package com.pcw.service.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 彭慈文
 * 处理邮箱验证的
 */
@WebServlet("/emailveryfy")
public class EmailVeryfy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String myEmailSMTPHost = "smtp.qq.com";
		String user = "2421684498@qq.com";
		/*由pop3提供的授权码tavlixpnppchebjh*/
		/*由impa提供的授权码xumlbphtbjwedjhi*/
		String password = "xumlbphtbjwedjhi";
		String email = request.getParameter("email");
		HttpSession httpsession = request.getSession();
		
		httpsession.setAttribute("email", email);
		Random random = new Random();
		StringBuilder emailcode = new StringBuilder();
		for(int i = 0;i < 6;i++){
			emailcode.append(random.nextInt(9));
		}
		httpsession.setAttribute("emailcode", emailcode.toString());
		emailcode.append(",打死也不要告诉别人哦");
		
        // 1. 创建一封邮件
        Properties props = new Properties();                // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");//是否验证
        props.put("mail.smtp.starttls.enable", "true");
        
        Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				PasswordAuthentication pa = new PasswordAuthentication(user, password);
				return pa;
			}
		};
        
        Session session= Session.getInstance(props,auth);        // 根据参数配置，创建会话对象（为了发送邮件准备的）
        session.setDebug(true); 
        MimeMessage message = new MimeMessage(session);     // 创建邮件对象

        try {
        // 2. From: 发件人
        //    其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        //    真正要发送时, 邮箱必须是真实有效的邮箱。
			message.setFrom(new InternetAddress("2421684498@qq.com", "个人问卷调查", "UTF-8"));
			// 3. To: 收件人
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email, "USER_CC", "UTF-8"));
			// 4. Subject: 邮件主题
			message.setSubject("验证码", "UTF-8");
			// 5. Content: 邮件正文（可以使用html标签）
			message.setContent("您的pcw问卷调查验证码为"+emailcode.toString(), "text/html;charset=UTF-8");
			// 6. 设置显示的发件时间
			message.setSentDate(new Date());
			// 7. 保存前面的设置
			message.saveChanges();
			
			Transport transport = session.getTransport();
			transport.connect(user, password);
			transport.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
