package com.xlx.email.service;

/**
 * @author: xielx on 2019/7/6
 */
public interface MailService {


  /**
   * 发送简单文本邮件
   * @param to 收件人
   * @param subject 邮件主题
   * @param content 邮件内容
   */
  void sendSimpleMail(String to,String subject,String content) throws Exception;

  /**
   * 发送html格式的邮件
   * @param to 收件人
   * @param subject 邮件主题
   * @param content 邮件内容
   */
  void sendHtmlMail(String to, String subject, String content);

  void sendAttachmentsMail(String to, String subject, String content, String filePath);

  void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
