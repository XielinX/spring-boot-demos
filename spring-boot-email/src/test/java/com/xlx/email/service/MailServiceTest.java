package com.xlx.email.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

/**
 * 邮件测试类
 *
 * @author xielx on 2019/7/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {


  @Resource
  private MailService mailService;

  @Autowired
  private TemplateEngine templateEngine;
  @Test
  public void simpleMailTest() throws Exception {
    //20238?第二次:2192,第三次:3661
    mailService.sendSimpleMail("420923119@qq.com","MJ社区","尊敬的先生/女士:\n您好,恭喜您中奖500W");
  }

  @Test
  public void htmlMailTest(){
    //2616?第二次:2577
    String content = "<html>\n"
            + "<body>\n"
            + "  <h3>您好,这是一份html邮件</h3>\n"
            + "</body>\n"
            + "</html>";
    mailService.sendHtmlMail("420923119@qq.com","MJ社区",content);


  }
  @Test
  public void attachmentsMailTest(){
    //2265
    String fileName = "D:\\hello.txt";
    mailService.sendAttachmentsMail("420923119@qq.com","MJ社区,附件","附件,请查收",fileName);
  }
  @Test
  public void inlineResourceMailTest(){
    //2499
    long reId = System.currentTimeMillis();
    String content = "<html><body>这是有图片的邮件:<img src='cid:" + reId + "'/></body></html>";
    String imgPath = "E:\\panda.jpg";//30kb
    mailService.sendInlineResourceMail("420923119@qq.com","MJ社区,这是有图片的邮件",content,imgPath, Long.toString(reId));
  }


  @Test
  public void sendTemplateMail() {//运行不了,报错
    //创建邮件正文
    Context context = new Context();
    context.setVariable("id", "006");
    String emailContent = templateEngine.process("emailTemplate", context);
    mailService.sendHtmlMail("420923119@qq.com","主题：这是模板邮件",emailContent);
  }

}
