package com.xcy.video.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 * ���ʼ�������
 */
public final class MailUtils {

    private static final String USER = "1649692109@qq.com"; // �����˳ƺţ�ͬ�����ַ
    private static final String PASSWORD = "mpycjxemdlixddhh"; // �����qq�������ʹ������Ȩ�룬���ߵ�¼����

    /**
     *
     * @param to �ռ�������
     * @param text �ʼ�����
     * @param title ����
     */
    /* ������֤��Ϣ���ʼ� */
    public static boolean sendMail(String to, String text, String title){
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.qq.com");

            // �����˵��˺�
            props.put("mail.user", USER);
            //�����˵�����
            props.put("mail.password", PASSWORD);

            // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // �û���������
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
            Session mailSession = Session.getInstance(props, authenticator);
            // �����ʼ���Ϣ
            MimeMessage message = new MimeMessage(mailSession);
            // ���÷�����
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // �����ռ���
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // �����ʼ�����
            message.setSubject(title);

            // �����ʼ���������
            message.setContent(text, "text/html;charset=UTF-8");
            // �����ʼ�
            Transport.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static String getValidateCode(int  num){

        Random random = new Random();
        String validateCode = "";
        for (int i=0;i<num;i++){

            int result  = random.nextInt(10);
            validateCode +=result;

        }
        return validateCode;
    }

    public static void main(String[] args) throws Exception { // ��������
        MailUtils.sendMail("1959560381@qq.com","�����ʼ�������ɵ���֤���ǣ�"+getValidateCode(6),"��ã�����һ������ʼ�������ظ���");
        System.out.println("���ͳɹ�");
    }



}