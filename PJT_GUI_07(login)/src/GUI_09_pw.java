import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI_09_pw extends JFrame{
	JPasswordField textfield1;
	int count_eye=1;
	int pw=-1;
	String id = GUI_03_2.textfield_id.getText();
	public GUI_09_pw(String al) {
		setSize(500,400);
		
		Container contentpane = getContentPane();
		contentpane.setLayout(null);
		
		JLabel label1 = new JLabel("pw");
		label1.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		label1.setBounds(50, 100, 50, 30);
		contentpane.add(label1);
		
		JLabel label2 = new JLabel("pw");
		label2.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		label2.setBounds(50, 200, 50, 30);
		contentpane.add(label2);
		
		JLabel label3 = new JLabel("8~16자의 영문 대소문자, 숫자, 특수문자를 모두 포함한 pw만 가능");
		label3.setBounds(50, 130, 500, 30);
		contentpane.add(label3);
		
		JLabel label4 = new JLabel();
		label4.setBounds(50, 230, 500, 30);
		contentpane.add(label4);
		
		textfield1 = new JPasswordField();
		textfield1.setBounds(100, 100, 150, 40);
		contentpane.add(textfield1);
		
		JPasswordField textfield2 = new JPasswordField();
		textfield2.setBounds(100, 200, 150, 40);
		contentpane.add(textfield2);
		
		
		KeyListener password = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				/////////////////////////////////////////////////////////////////////
				String A = textfield1.getText();
				String[] a = A.split("");
				ArrayList<String> array = new ArrayList<String>();
				for (int i = 0; i<a.length; i++) {
					array.add(a[i]);
				}
				if(array.size() >=8) {
					String string_1 = "[!\"#$%&'()*+,-./:;<=>?@[₩]^_`{|}~]";
					Pattern pattern = Pattern.compile(string_1);
					Matcher matcher = pattern.matcher(A);
					
					if(matcher.find()) {
						System.out.println("조건만족");
						int count1=0;
						int count2=0;
						int count3=0;
						for(int i= 0;i<a.length;i++) {
							if (Character.isLowerCase(A.charAt(i))) {
								count1+=1;
							}
							else if (Character.isUpperCase(A.charAt(i))) {
								count2+=1;
							}
							else if (Character.isDigit(A.charAt(i))) {
								count3+=1;
							}
						}
						if(count1!=0 && count2!=0 && count3!=0) {
							label3.setForeground(Color.green);
						}else {
							label3.setForeground(Color.red);
						}
					}else {
						System.out.println("조건실패: 특수문자");
						label3.setForeground(Color.red);
					}
				}else {
					System.out.println("조건실패: 8자 미만");
					label3.setForeground(Color.red);
				}
			}
		};
		textfield1.addKeyListener(password);
		
		KeyListener password2 = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(!textfield2.getPassword().equals("")) {
					if((textfield1.getText()).equals(textfield2.getText())) {
						label4.setText("비밀번호와 일치합니다.");
						label4.setForeground(Color.green);
					}else {
						label4.setText("비밀번호와 일치하지 않습니다.");
						label4.setForeground(Color.red);
					}
				}
			}
		};
		textfield2.addKeyListener(password2);
		
		ImageIcon icon1 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\스크린샷 2026-07-18 160342.png");
		ImageIcon icon2 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\눈뜬거.png");		
		
		Image image1 = icon1.getImage();
		Image image2 = icon2.getImage();
		
		Image changeImg1 = image1.getScaledInstance(20,20,Image.SCALE_SMOOTH);
		Image changeImg2 = image2.getScaledInstance(20,20,Image.SCALE_SMOOTH);

		ImageIcon changeIcon1 = new ImageIcon(changeImg1);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);

		JLabel label_image1 = new JLabel(changeIcon1);
		
		label_image1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	count_eye++;
            	if(label_image1.getIcon() == changeIcon1) {
                	label_image1.setIcon(changeIcon2);
                	pw = 1;
                	textfield1.setEchoChar((char) 0);
            	}else {
            		label_image1.setIcon(changeIcon1);
            		pw = -1;
            		textfield1.setEchoChar((char) '*'); 
            	}
            	
            }
        });
		
		label_image1.setBounds(255, 110, 20, 20);
		add(label_image1);
		
		JButton button = new JButton("변경 완료");
		button.setBounds(100, 250, 100, 40);
		contentpane.add(button);
		
		button.addMouseListener(new MouseAdapter() {
            @SuppressWarnings("unlikely-arg-type")
			@Override
            public void mouseClicked(MouseEvent e) {
            	if(label3.getForeground()==Color.green && label4.getForeground()==Color.green) {
	            	String pw_n = new String(textfield1.getPassword());
					String hashedPassword = "";
			        try {
			            MessageDigest md5 = MessageDigest.getInstance("MD5");
			            byte[] messageDigest = md5.digest(pw_n.getBytes());
			            StringBuilder sb = new StringBuilder();
			            for(byte b : messageDigest) {
			                sb.append(String.format("%02x", b));
			            }
			            hashedPassword = sb.toString();
			        } catch(NoSuchAlgorithmException e1) {
			            throw new RuntimeException(e1);
			        }
			        
					String[] array2 = al.split("/");
					
					if(!array2[1].equals(textfield1.getPassword())){
						System.out.println("삭제 열:"+al);
						System.out.println("해시된 new pw:"+hashedPassword);
						System.out.println("전 내용:"+GUI_04.array);
						GUI_04.array.remove(al);
						GUI_04.array.add(array2[0]+"/"+hashedPassword+"/"+array2[2]);
						
						System.out.println("___");
						System.out.println("바뀐 내용:"+GUI_04.array);
						String filepath = "C:\\Users\\user\\OneDrive\\Desktop\\학원과제\\login.txt";
						try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(filepath))) {
				        	for (String str : GUI_04.array) {
				                writer.write(str);
				                writer.newLine();
				            }
				            System.out.println("회원가입 정보가 파일에 저장되었습니다.");
				        } catch (java.io.IOException e1) {
				            System.out.println("파일 저장 중 오류가 발생했습니다: " + e1.getMessage());
				        }
						
						JOptionPane.showMessageDialog(null, "비밀번호 변경이 완료되었습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "비밀번호가 예전것과 같습니다. 다시 변경해주세요");
					}
				}else {
            		JOptionPane.showMessageDialog(null, "다시 시도해주세요");
            	}
		   }
		});
		
		setVisible(true);
	}
}
