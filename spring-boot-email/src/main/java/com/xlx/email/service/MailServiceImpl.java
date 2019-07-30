package com.xlx.email.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * MailService的实现类
 *
 * @author xielx on 2019/7/6
 */
@Component
public class MailServiceImpl implements MailService{

  private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

  @Autowired
  private JavaMailSender javaMailSender;

  @Value("${mail.fromMail.addr}")
  private String from;


  @Override
  public void sendSimpleMail(String to, String subject, String content) {
    long start = System.currentTimeMillis();
    SimpleMailMessage  message = new SimpleMailMessage();

    message.setFrom(from);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(content);

    try{
      javaMailSender.send(message);
      long end = System.currentTimeMillis();
      logger.info("简单邮件耗时:[{}]",(end - start));
    }catch (MailException e){
      logger.error("邮件发送异常:[{}]",e.getMessage());
    }

  }

  @Override
  public void sendHtmlMail(String to, String subject, String content) {
    long start = System.currentTimeMillis();
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
      messageHelper.setFrom(from);
      messageHelper.setTo(to);
      messageHelper.setSubject(subject);
      messageHelper.setText(content,true);
      javaMailSender.send(mimeMessage);
      long end = System.currentTimeMillis();
      logger.info("html邮件耗时:[{}]",(end - start));
    } catch (MessagingException e) {
      logger.error("发送html邮件时发生异常:[{}]",e.getMessage());
    }

  }

  /**
   * 附件邮件
   * @param to 邮箱接收人
   * @param subject 邮件主题
   * @param content 邮件内容
   * @param filePath 附件路径
   */
  @Override
  public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
    long start = System.currentTimeMillis();
    MimeMessage message = javaMailSender.createMimeMessage();
    //true表示需要创建一个multipart message
    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
      messageHelper.setFrom(from);
      messageHelper.setTo(to);
      messageHelper.setSubject(subject);
      messageHelper.setText(content,true);

      // 添加附件
      FileSystemResource resource = new FileSystemResource(new File(filePath));
      //文件名
      String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
      messageHelper.addAttachment(fileName,resource);


      javaMailSender.send(message);
      long end = System.currentTimeMillis();
      logger.info("附件邮件耗时:[{}]",(end - start));
    } catch (MessagingException e) {
      logger.error("发送附件邮件异常:[{}]",e.getMessage());
    }

  }

  /**
   * 发送正文中有静态资源（图片）的邮件
   * @param to 邮箱接收人
   * @param subject 邮件主题
   * @param content 邮件内容
   * @param rscPath 附件路径
   * @param rscId ?
   */
  @Override
  public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
    long start = System.currentTimeMillis();
    MimeMessage message = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
      messageHelper.setFrom(from);
      messageHelper.setTo(to);
      messageHelper.setSubject(subject);
      messageHelper.setText(content,true);

      //添加图片
      FileSystemResource resource = new FileSystemResource(new File(rscPath));
      messageHelper.addInline(rscId,resource);

      javaMailSender.send(message);
      long end = System.currentTimeMillis();
      logger.info("图片邮件耗时:[{}]",(end - start));
    } catch (MessagingException e) {
      logger.error("发送图片邮件异常:[{}]",e.getMessage());
    }
  }
}
