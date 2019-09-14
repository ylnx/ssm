package com.lx.edu;

import com.lx.edu.dao.StudentDao;
import com.lx.edu.service.ClassService;
import com.lx.edu.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTest 
{
    @Resource(name = "studentService")
    private StudentService service;
    @Resource(name = "classService")
    private ClassService classService;
    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Test
    public void test() throws MessagingException, UnsupportedEncodingException {
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");
        // 0.2 账号和密码
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 账号和授权码（是授权码不是密码，）
                return new PasswordAuthentication("lxyn2123@163.com", "a123456789");
            }
        };

        // 1 与126服务器建立连接：Session
        Session session = Session.getDefaultInstance(props, authenticator);

        // 2 编写邮件：Message
        Message message = new MimeMessage(session);
        // 2.1 发件人（模拟账号）
        message.setFrom(new InternetAddress("lxyn2123@163.com"));
        // 2.2 收件人 , to:收件人 ， cc ：抄送，bcc：暗送（密送）。（模拟账号）
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("wmdtzbiyuexiuhua@163.com"));
        // 2.3 主题
        message.setSubject("数据库备份");
        // 2.4 内容
//        message.setContent("哈哈，您到我的商城注册了。", "text/html;charset=UTF-8");
        // 创建多重消息
        Multipart mp = new MimeMultipart();
        // 创建文本消息部分
        MimeBodyPart mbpContent = new MimeBodyPart();
        mbpContent.setContent("数据库备份文件查收", "text/html;charset=UTF-8");
        mp.addBodyPart(mbpContent);

        // 附件部分
        MimeBodyPart mbpFile = new MimeBodyPart();
        // 设置要发送附件的文件路径
        String filename = "C:\\Users\\liaox\\Desktop\\入户资料密码.txt";
        DataSource source = new FileDataSource(filename);
        mbpFile.setDataHandler(new DataHandler(source));
        // 处理附件名称中文（附带文件路径）乱码问题
        mbpFile.setFileName(MimeUtility.encodeText(filename));
        mp.addBodyPart(mbpFile);
        // 3 将消息进行发送：Transport
        message.setContent(mp);
        message.setSentDate(new Date());
        Transport.send(message);
    }
}
