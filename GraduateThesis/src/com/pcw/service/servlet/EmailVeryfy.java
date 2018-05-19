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
 * @author �����
 * ����������֤��
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
		/*��pop3�ṩ����Ȩ��tavlixpnppchebjh*/
		/*��impa�ṩ����Ȩ��xumlbphtbjwedjhi*/
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
		emailcode.append(",����Ҳ��Ҫ���߱���Ŷ");
		
        // 1. ����һ���ʼ�
        Properties props = new Properties();                // ���������ʼ��������Ĳ������ã������ʼ�ʱ����Ҫ�õ���
        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true");//�Ƿ���֤
        props.put("mail.smtp.starttls.enable", "true");
        
        Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				PasswordAuthentication pa = new PasswordAuthentication(user, password);
				return pa;
			}
		};
        
        Session session= Session.getInstance(props,auth);        // ���ݲ������ã������Ự����Ϊ�˷����ʼ�׼���ģ�
        session.setDebug(true); 
        MimeMessage message = new MimeMessage(session);     // �����ʼ�����

        try {
        // 2. From: ������
        //    ���� InternetAddress �����������ֱ�Ϊ: ����, ��ʾ���ǳ�(ֻ������ʾ, û���ر��Ҫ��), �ǳƵ��ַ�������
        //    ����Ҫ����ʱ, �����������ʵ��Ч�����䡣
			message.setFrom(new InternetAddress("2421684498@qq.com", "�����ʾ����", "UTF-8"));
			// 3. To: �ռ���
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email, "USER_CC", "UTF-8"));
			// 4. Subject: �ʼ�����
			message.setSubject("��֤��", "UTF-8");
			// 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
			message.setContent("����pcw�ʾ������֤��Ϊ"+emailcode.toString(), "text/html;charset=UTF-8");
			// 6. ������ʾ�ķ���ʱ��
			message.setSentDate(new Date());
			// 7. ����ǰ�������
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
