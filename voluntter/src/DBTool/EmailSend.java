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
		// 邮件主题
	    String subject = "欢迎注册志愿服务系统！";
	   
	    //1. 用于存放 SMTP 服务器地址等参数
	    Properties properties = new Properties();
	    // 主机地址
	    properties.setProperty("mail.smtp.host", "mail.bjtu.edu.cn");
	    // 邮件协议
	    properties.setProperty("mail.transport.protocol", "smtp");
	    // 认证
	    properties.setProperty("mail.smtp.auth", "true");
	    // 端口
	    properties.setProperty("mail.smtp.port", "25");
	 
	    // 使用JavaMail发送邮件的5个步骤
	    // 2. 创建session
	    Session session = Session.getDefaultInstance(properties, new MyAuthenticator("17321096@bjtu.edu.cn", "chc@1999118"));
	    // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	    session.setDebug(true);
	 
	    // 3. 创建邮件
	    // 创建邮件对象
	    MimeMessage message = new MimeMessage(session);
	 
	    // 邮件的标题
	    message.setSubject(subject);
	    // 邮件发送日期
	    message.setSentDate(new Date());
	    // 指明邮件的发件人
	    message.setFrom(new InternetAddress("17301144@bjtu.edu.cn","合同管理员"));
	 
	    // 指明邮件的收件人
	    message.setRecipient(Message.RecipientType.TO, new InternetAddress(e, " "));
	 
	    // 指明邮件的抄送人
	    //message.setRecipient(Message.RecipientType.CC, new InternetAddress("17301160@bjtu.edu.cn", "哈哈"));
	 
	    // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
	    Multipart multipart = new MimeMultipart();
	 
	    // 添加邮件正文
	    BodyPart contentBodyPart = new MimeBodyPart();
	    // 邮件内容
	    String introduce = "您的邮箱已完成验证，请点击右侧链接完成注册！\n";
	    String result = introduce + "<a href='http://localhost:8080/Contract/register.jsp'>点击此处完成注册</a>";
	    contentBodyPart.setContent(result,"text/html;charset=GBK");
	    multipart.addBodyPart(contentBodyPart);

	    // 邮件的文本内容
	    message.setContent(multipart);
	 
	    // 4. 发送邮件,Transport每次发送成功程序帮忙关闭
	    Transport.send(message, message.getAllRecipients());
	
	}

}
