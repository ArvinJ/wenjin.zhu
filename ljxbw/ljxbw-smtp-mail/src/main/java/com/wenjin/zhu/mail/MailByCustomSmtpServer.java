package com.wenjin.zhu.mail;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
/**
 * 
 * 
 * @Title:  MailByCustomSmtpServer.java   
 * @Package cafeInfo   
 * @Description:    TODO(基于自定义smtp服务器发邮件)   
 * @author: wenjin.zhu    
 * @date:   2018年8月23日 上午11:43:19   
 * @version V1.0
 */
public class MailByCustomSmtpServer {
 
	/**
	 * @param args
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void main(String[] args) throws AddressException, MessagingException {
			Properties prop = new Properties();
			prop.setProperty("mail.transport.protocol", "smtp");//定义邮件发送协议
			prop.setProperty("mail.smtp.host", "172.16.53.21");//声明邮件服务器地址
			prop.setProperty("mail.smtp.auth", "true");//发送权限，为true时表示允许发送
			prop.setProperty("mail.debug", "true");//设置为true时，调试的时候可以在控制台显示信息
			//prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//ssl
			prop.setProperty("mail.smtp.starttls.enable", "true"); //tls
			
			Session session = Session.getInstance(prop);//相当于建立了一条通信路线
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("alert@nbscreen.com"));//发件者邮箱
			msg.setRecipient(RecipientType.TO, new InternetAddress("15156980156@163.com"));//收件邮箱
			msg.setSubject("Topic");
			msg.setText("context1");
			
			Transport tran = session.getTransport();
			tran.connect("alert", "!Q@W#E4r5t6y");
			tran.sendMessage(msg,msg.getAllRecipients());
			
		
		
	}
 
}