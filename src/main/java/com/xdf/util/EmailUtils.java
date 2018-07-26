package com.xdf.util;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
/*
import com.tradetuber.hiwi.web.model.Sendmaillog;
import com.tradetuber.hiwi.web.service.SendmaillogService;*/
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailUtils {
	
	/**
	 * 发送邮件工具类
	 * @param mailSender 发送邮件类对象，使用spring注入即可获取实例
	 * @param from 发件人
	 * @param to 收件人
	 * @param subject 主题
	 * @param text 内容
	 */
	public static void sendEmail(JavaMailSender mailSender, String from, String to, String subject, String text, int mailtype /*,SendmaillogService sendmaillogService*/){
		try {
			/****2017年10月16日开始，因为服务器无法直接发送这些邮件，因此更换逻辑

			//			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//			JavaMailSenderImpl mailSender =  (JavaMailSenderImpl) context.getBean("mailSender");
			MimeMessage mime = mailSender.createMimeMessage();  
			MimeMessageHelper mimehelper = new MimeMessageHelper(mime, true,"utf-8");  
			mimehelper.setFrom(from);//设置发送人  
			mimehelper.setTo(to);//设置收件人  
//	    if (mail.getCc() != null && !"".equals(mail.getCc()))  
//	        mimehelper.setCc(mail.getCc());//设置抄送人  
//	    if (mail.getAcc() != null && !"".equals(mail.getAcc()))  
//	        mimehelper.setBcc(mail.getAcc());//设置暗送人  
			mimehelper.setSentDate(new Date());//设置发送日期  
			mimehelper.setSubject(subject);//设置主题  
			mimehelper.setText(text,true);//设置邮件内容
//			mimehelper.setText("设置邮件内容为HTML超文本格式  ", true);//设置邮件内容为HTML超文本格式  
//	    FileSystemResource fsr = new FileSystemResource(attement.get(i));//设置附件内容  
//	    mimehelper.addInline(attementFileName.get(i), fsr);//添加附件  
			mailSender.send(mime);//将邮件发送

			*****/
		/*	Sendmaillog sendmaillog = new Sendmaillog();
			sendmaillog.setCreatetime(new Date());
			sendmaillog.setProcesstime(new Date());
			sendmaillog.setMailfrom(from);
			sendmaillog.setMailto(to);
			sendmaillog.setMailcontent(text);
			sendmaillog.setMailtype(mailtype);
			sendmaillog.setMailtitle(subject);
			sendmaillog.setProcessstatus(Sendmaillog.PROCESSSTATUS_DEFAULT);
			sendmaillogService.insert(sendmaillog);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}