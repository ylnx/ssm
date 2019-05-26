package com.lx.edu.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * 描述:
 *
 * @author liaox
 * @create 2019-05-18 17:56
 */
@Component
public class EmailTask {

//    @Scheduled(cron = "0/5 * * * * ?")
//    public void test(){
//        java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyyMMdd");
//        String format = format1.format(new Date());
//        System.out.println(format);
//    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void sendEmail() throws MessagingException, UnsupportedEncodingException {
        // 0.1 服务器的设置
        System.out.println("sendEmail");
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
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("981307875@qq.com"));
        // 2.3 主题
        message.setSubject("数据库备份文件");
        // 2.4 内容
//        message.setContent("哈哈，您到我的商城注册了。", "text/html;charset=UTF-8");
        // 创建多重消息
        Multipart mp = new MimeMultipart();
        // 创建文本消息部分
        MimeBodyPart mbpContent = new MimeBodyPart();
        mbpContent.setContent("数据库备份文件", "text/html;charset=UTF-8");
        mp.addBodyPart(mbpContent);

        // 附件部分
        MimeBodyPart mbpFile = new MimeBodyPart();
        // 设置要发送附件的文件路径
        java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyyMMdd");
        String date = format1.format(new Date());
        String filename = "D:\\db_backup\\ssh_"+date+".sql";
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
