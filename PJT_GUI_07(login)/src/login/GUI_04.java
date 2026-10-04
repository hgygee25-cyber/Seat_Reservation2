package login;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.*;

public class GUI_04 {
	static ArrayList<String> array = new ArrayList<>();
	public GUI_04(JTextField textfield0, JTextField textfield1, JTextField textfield2, JTextField textfield_email1, String email) {
        String text1 = textfield1.getText();
        String text3 = textfield_email1.getText();
        String filePath = "C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\login.txt";
        String text0 = textfield0.getText();
        String text2 = textfield2.getText();
        String hashedPassword = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md5.digest(text2.getBytes());
            StringBuilder sb = new StringBuilder();
            for(byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            hashedPassword = sb.toString(); // return 대신 변수에 저장
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        array.add(text1 + "/" + hashedPassword + "/" + text3+"@"+email + "/" + text0);
        
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(filePath, true))) {
        	for (String str : array) {
                writer.write(str);
                writer.newLine();
            }
            System.out.println("회원가입 정보가 파일에 저장되었습니다.");
        } catch (java.io.IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
        
	}
}
