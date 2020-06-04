package DBTool;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;


import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import Entity.MyAuthenticator;

public class EmailSend {

	public EmailSend() {
	}
	
	public void sendEmail(String e) throws MessagingException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		// �ʼ�����
	    String subject = "��ӭע��־Ը����ϵͳ��";
	   
	    //1. ���ڴ�� SMTP ��������ַ�Ȳ���
	    Properties properties = new Properties();
	    // ������ַ
	    properties.setProperty("mail.smtp.host", "mail.bjtu.edu.cn");
	    // �ʼ�Э��
	    properties.setProperty("mail.transport.protocol", "smtp");
	    // ��֤
	    properties.setProperty("mail.smtp.auth", "true");
	    // �˿�
	    properties.setProperty("mail.smtp.port", "25");
	 
	    // ʹ��JavaMail�����ʼ���5������
	    // 2. ����session
	    Session session = Session.getDefaultInstance(properties, new MyAuthenticator("17321096@bjtu.edu.cn", "chc@1999118"));
	    // ����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
	    session.setDebug(true);
	 
	    // 3. �����ʼ�
	    // �����ʼ�����
	    MimeMessage message = new MimeMessage(session);
	 
	    // �ʼ��ı���
	    message.setSubject(subject);
	    // �ʼ���������
	    message.setSentDate(new Date());
	    // ָ���ʼ��ķ�����
	    message.setFrom(new InternetAddress("17301144@bjtu.edu.cn","��ͬ����Ա"));
	 
	    // ָ���ʼ����ռ���
	    message.setRecipient(Message.RecipientType.TO, new InternetAddress(e, " "));
	 
	    // ָ���ʼ��ĳ�����
	    //message.setRecipient(Message.RecipientType.CC, new InternetAddress("17301160@bjtu.edu.cn", "����"));
	 
	    // ��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���
	    Multipart multipart = new MimeMultipart();
	 
	    // ����ʼ�����
	    BodyPart contentBodyPart = new MimeBodyPart();
	    // �ʼ�����
	    String introduce = "���������������֤�������Ҳ��������ע�ᣡ\n";
	    String result = introduce + "<a href='http://localhost:8080/Contract/register.jsp'>����˴����ע��</a>";
	    contentBodyPart.setContent(result,"text/html;charset=GBK");
	    multipart.addBodyPart(contentBodyPart);

	    // �ʼ����ı�����
	    message.setContent(multipart);
	 
	    // 4. �����ʼ�,Transportÿ�η��ͳɹ������æ�ر�
	    Transport.send(message, message.getAllRecipients());
	
	}

}
