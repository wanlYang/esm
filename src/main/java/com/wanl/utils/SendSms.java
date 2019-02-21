package com.wanl.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.alibaba.fastjson.JSONObject;
import com.sun.mail.util.MailSSLSocketFactory;
import com.wanl.entity.Result;

/**
 * 
 * @Title:SendSms
 * @Description：关于验证码
 * @author:Yang
 */
public class SendSms{

	private static final long serialVersionUID = 1L;

	private static final String QUERY_PATH = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
	private static final String ACCOUNT_SID = "5d03f1f5291045c19927459f2a4dd665";
	private static final String AUTH_TOKEN = "673bdea1b8f94dc5b0116fb59fce545a";

	public static String getSMSCode() {
		Random rand = new Random();
		String code = "";
		for (int i = 0; i < 6; i++) {
			code += rand.nextInt(10);
		}
		return code;
	}

	public static Result sendMessageCode(String code, String phone) {
		String timestamp = getTimestamp();
		String sig = getMD5(ACCOUNT_SID, AUTH_TOKEN, timestamp);
		String tamp = "【婉碧网络】您的验证码为" + code + "，请于" + 5 + "分钟内正确输入，如非本人操作，请忽略此短信。";
		OutputStreamWriter out = null;
		BufferedReader br = null;
		StringBuilder result = new StringBuilder();
		try {
			URL url = new URL(QUERY_PATH);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoInput(true);
			// 设置是否允许数据写入
			connection.setDoOutput(true);
			// 设置是否允许参数数据输出
			connection.setConnectTimeout(5000);
			// 设置链接响应时间
			connection.setReadTimeout(10000);
			// 设置参数读取时间
			connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			// 提交请求
			out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			String args = getQueryArgs(ACCOUNT_SID, tamp, phone, timestamp, sig, "JSON");
			out.write(args);
			out.flush();
			// 读取返回参数
			br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String temp = "";
			while ((temp = br.readLine()) != null) {
				result.append(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonObject = JSONObject.parseObject(result.toString());
		String respCode = jsonObject.getString("respCode");
		String respDesc = jsonObject.getString("respDesc");
		return new Result(0,respDesc,0,respCode);
	}

	/**
	 * 定义一个请求参数拼接方法
	 * @Author YangBin
	 * @Date 15:54 2019/2/21
	 * @Param [accountSid, smsContent, to, timestamp, sig, respDataType]
	 * @version v1.0
	 * @return java.lang.String
	 **/
	public static String getQueryArgs(String accountSid, String smsContent, String to, String timestamp, String sig, String respDataType) {
		return "accountSid=" + accountSid + "&smsContent=" + smsContent + "&to=" + to + "&timestamp=" + timestamp
				+ "&sig=" + sig + "&respDataType=" + respDataType;
	}

	/**
	 * 获取时间戳
	 * @Author YangBin
	 * @Date 15:54 2019/2/21
	 * @Param []
	 * @version v1.0
	 * @return java.lang.String
	 **/
	public static String getTimestamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	/**
	 * sing签名
	 * @Author YangBin
	 * @Date 15:54 2019/2/21
	 * @Param [sid, token, timestamp]
	 * @version v1.0
	 * @return java.lang.String
	 **/
	public static String getMD5(String sid, String token, String timestamp) {
		StringBuilder result = new StringBuilder();
		String source = sid + token + timestamp;
		// 获取某个类的实例
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			// 要进行加密的东西
			byte[] bytes = digest.digest(source.getBytes());
			for (byte b : bytes) {
				String hex = Integer.toHexString(b & 0xff);
				if (hex.length() == 1) {
					result.append("0" + hex);
				} else {
					result.append(hex);
				}
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result.toString();
	}
	/**
	 * 发送邮箱验证码
	 * @Author YangBin
	 * @Date 15:54 2019/2/21
	 * @Param [email, emailMsg]
	 * @version v1.0
	 * @return boolean
	 **/
	public static boolean sendMail(String email, String emailMsg){
		try {
			// 1.创建一个程序与邮件服务器会话对象 Session
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "SMTP");
			props.setProperty("mail.host", "smtp.sina.com");
			// 指定验证为true
			props.setProperty("mail.smtp.auth", "true");
	        MailSSLSocketFactory sf;
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
	        props.put("mail.smtp.ssl.enable", "true");
	        props.put("mail.smtp.ssl.socketFactory", sf);

			// 创建验证器
			Authenticator auth = new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("yang_bin_0619@sina.com", "THEA2018###");
				}
			};
			Session session = Session.getInstance(props, auth);

			// 2.创建一个Message，它相当于是邮件内容
			Message message = new MimeMessage(session);
			// 设置发送者
			message.setFrom(new InternetAddress("yang_bin_0619@sina.com"));
			// 设置发送方式与接收者
			message.setRecipient(RecipientType.TO, new InternetAddress(email));
			message.setSubject("玄煞网络科技");

			message.setContent(emailMsg, "text/html;charset=utf-8");
			// 3.创建 Transport用于将邮件发送
			Transport.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
