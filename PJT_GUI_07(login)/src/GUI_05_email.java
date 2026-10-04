import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GUI_05_email {
	int a;
	public GUI_05_email() {
		String host = "smtp.gmail.com";
        String username = "hgygee25@gmail.com";
        String password = "hxhc swzu avtw vjnv\r\n";
        String toEmail = "wlgusrud060605@naver.com";
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // TLS 사용
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587"); // TLS 포트

        // 3. 세션 생성 및 인증
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // 4. 메시지 객체 생성
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("메일 인증번호 발송");
            message.setText("안녕하세요. 인증번호는 아래와 같습니다.");
            Random rand = new Random();
            a = rand.nextInt(10000);
            message.setText(String.valueOf(a));

            // 5. 이메일 전송
            Transport.send(message);
            System.out.println("이메일이 성공적으로 전송되었습니다.");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("이메일 전송 실패: " + e.getMessage());
        }
	}
	public int getA() {
        return this.a;
    }
}
