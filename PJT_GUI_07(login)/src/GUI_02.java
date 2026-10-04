 import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GUI_02 extends JFrame{
	int pw=-1;
	Timer timer;
	int t = 181;
	int count_eye = 1;
	JPasswordField textfield2;
	int number;
	public GUI_02() {
		setSize(500,400);
		Container contentpane = getContentPane();
		contentpane.setLayout(null);
		
		//기본 틀
		JLabel label1 = new JLabel("ID");
		label1.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		label1.setBounds(50, 50, 50, 30);
		contentpane.add(label1);
		
		JLabel label2 = new JLabel("PW");
		label2.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		label2.setBounds(50, 100, 50, 30);
		contentpane.add(label2);
		
		JLabel label3 = new JLabel("PW");
		label3.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		label3.setBounds(50, 150, 50, 30);
		contentpane.add(label3);
		//비번가능여부문구
		JLabel label4 = new JLabel("8~16자의 영문 대소문자, 숫자, 특수문자를 모두 포함한 pw만 가능");
		label4.setBounds(100, 130, 500, 20);
		contentpane.add(label4);
		//비번일치여부띄우는문구
		JLabel label5 = new JLabel("");
		label5.setBounds(100, 180, 200, 20);
		contentpane.add(label5);
		//중복확인여부띄우는문구
		JLabel label6 = new JLabel("중복확인여부띄우기");
		label6.setBounds(100, 30, 500, 20);
		contentpane.add(label6);
		// id가능여부문구
		JLabel label7 = new JLabel("5~20자의 영문소문자, 숫자, 특수기호(_, -)만 사용가능");
		label7.setBounds(100, 77, 500, 20);
		contentpane.add(label7);
		
		JTextField textfield1 = new JTextField();
		textfield1.setBounds(100, 50, 150, 30);
		contentpane.add(textfield1);
		
		textfield2 = new JPasswordField();
		textfield2.setBounds(100, 100, 150, 30);
		contentpane.add(textfield2);
		
		JPasswordField textfield3 = new JPasswordField();
		textfield3.setBounds(100, 150, 150, 30);
		contentpane.add(textfield3);
		
		JButton button1 = new JButton("중복확인");
		button1.setBounds(270,50,90,30);
		button1.setBackground(Color.white);
		contentpane.add(button1);
		
		JButton button2 = new JButton("가입");
		button2.setBounds(340,330,60,30);
		button2.setBackground(Color.white);
		contentpane.add(button2);

		JButton button3 = new JButton("취소");
		button3.setBounds(410,330,60,30);
		button3.setBackground(Color.white);
		contentpane.add(button3);
		
		// email & 인증
		JLabel label_email = new JLabel("email");
		label_email.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		label_email.setBounds(50, 200, 50, 30);
		label_email.setBackground(Color.white);
		contentpane.add(label_email);
		
		JTextField textfield_email1 = new JTextField();
		textfield_email1.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		textfield_email1.setBounds(100,200,110,30);
		contentpane.add(textfield_email1);
		
		JTextField textfield_email2 = new JTextField();
		textfield_email2.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		textfield_email2.setBounds(100,250,110,30);
		contentpane.add(textfield_email2);
		
		JLabel label_g = new JLabel("@");
		label_g.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		label_g.setBounds(210,200,20,30);
		contentpane.add(label_g);

		JLabel label_i = new JLabel("인증번호");
		label_i.setBounds(50, 250, 70, 30);
		contentpane.add(label_i);
		
		String[] a1 = {"naver.com", "gmail.com", "daum.net", "hotmail.com"};
		JComboBox<String> combobox = new JComboBox<String>(a1);
		combobox.setSelectedItem(null);
		combobox.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		combobox.setBounds(230,200,110,30);
		combobox.setBackground(Color.white);
		contentpane.add(combobox);
		
		JButton button_1 = new JButton("발송");
		button_1.setBounds(350,200,58,30);
		button_1.setBackground(Color.white);
		contentpane.add(button_1);
		
		JButton button_1_1 = new JButton("확인");
		button_1_1.setBounds(220,250,58,30);
		button_1_1.setBackground(Color.white);
		contentpane.add(button_1_1);
		
		JLabel label_email2 = new JLabel("인증번호를 입력해주세요");
		label_email2.setBounds(100, 277, 500, 20);
		contentpane.add(label_email2);
		//눈알사진
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
                	textfield2.setEchoChar((char) 0);
            	}else {
            		label_image1.setIcon(changeIcon1);
            		pw = -1;
            		textfield2.setEchoChar((char) '*'); 
            	}
            	
            }
        });
		
		label_image1.setBounds(252,105,20,20);
		add(label_image1);
		
		//id 입력 시 조건성립 확인
		KeyListener password1 = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String A = textfield1.getText();
				String[] a = A.split("");;
				ArrayList<String> array = new ArrayList<String>();
				for (int i = 0; i<a.length; i++) {
					array.add(a[i]);
				}
				int count1=0, count2=0, count3=0;
				ArrayList array_1 = new ArrayList();
				if(array.size() >=5 && array.size()<=20) {
					for(int i=0;i<a.length;i++) {
						if(Character.isLowerCase(A.charAt(i))){
							count1+=1;
						}else if(Character.isUpperCase(A.charAt(i))){
							count2+=1;
						}else if(Character.isDigit(A.charAt(i))) {
							count3+=1;
						}else {
							array_1.add(i);
						}
					}
					
					if(count1!=0 && count2==0 && count3!=0) {
						String string_1 = "[!\\\"#$%&'()*+,./:;<=>?@[₩]^`{|}~]";
						Pattern pattern = Pattern.compile(string_1);
						Matcher matcher = pattern.matcher(A);
								
						if(array_1.size()==0) {
							label7.setForeground(Color.green);
						}else if(matcher.find()) {
							label7.setForeground(Color.red);
						}else {
							label7.setForeground(Color.green);
						}
					}
					else {
						label7.setForeground(Color.red);
					}
				}else {
					label7.setForeground(Color.red);
				}
			}
		};
		textfield1.addKeyListener(password1);
		//pw 조건
		ArrayList<String> array1 = new ArrayList<String>();
		KeyListener password2 = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				/*char keyChar = e.getKeyChar();
				if(count_eye%2==1) {
					e.consume();
				    array1.add(String.valueOf(keyChar));
				    textfield2.setText(textfield2.setText() + "*");
				}
				if(count_eye%2==0){
					for(int i=0;i<array1.size();i++) {
						textfield2.setText(String.join("", array1));
					}
				}*/
			}
			
			
			@Override
			public void keyPressed(KeyEvent e) {				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				/////////////////////////////////////////////////////////////////////
				String A = textfield2.getText();
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
							label4.setForeground(Color.green);
						}else {
							label4.setForeground(Color.red);
						}
					}else {
						System.out.println("조건실패: 특수문자");
						label4.setForeground(Color.red);
					}
				}else {
					System.out.println("조건실패: 8자 미만");
					label4.setForeground(Color.red);
				}
			}
		};
		textfield2.addKeyListener(password2);
		
		//중복 버튼 클릭/////////////////////////////////////////////////////////////////////////////////////////////////////
		button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	String a = textfield1.getText();
		    	//메모장에 있는 id와 같은지 비교
		    	String filePath = "C:\\Users\\user\\OneDrive\\Desktop\\학원과제\\login.txt";
            	int aa = 0;
            	try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            		int count = 0;
            		while(count < GUI_04.array.size()) {
            			Object A = GUI_04.array.get(count);
            			String[] array2 = ((String) A).split("/");
            			count++;
            			
            			if( (array2[0]).equals(textfield1.getText())) {
            				System.out.println("아이디 중복");
            				aa=1;
            				break;
            			}
            		}
            	} catch (FileNotFoundException e1) {
            	    System.out.println("파일을 찾을 수 없습니다: " + filePath);
            	} catch (IOException e1) {
            	    e1.printStackTrace();
            	}
            	
            	
              	if(aa==1) {
					label6.setText("존재하는 아이디로, 사용할 수 없는 아이디입니다.");
					label6.setForeground(Color.red);
				}else {
					label6.setText("사용 가능한 아이디입니다.");
    				System.out.println(GUI_04.array.size());
					label6.setForeground(Color.green);
				}
            }
        });
		// pw 키패드 맞는지 아닌지
		KeyListener password3 = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(!textfield3.getText().equals("")) {
					if((textfield3.getText()).equals(textfield2.getText())) {
						label5.setText("비밀번호와 일치합니다.");
						label5.setForeground(Color.green);
					}else {
						label5.setText("비밀번호와 일치하지 않습니다.");
						label5.setForeground(Color.red);
					}
				}
			}
		};
		textfield2.addKeyListener(password3);
		textfield3.addKeyListener(password3);
		
		//발송버튼
		button_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	JLabel time = new JLabel("03:00");
            	time.setBounds(360,220,50,30);
            	time.setForeground(Color.blue);
            	contentpane.add(time);
            	
            	GUI_05_email a = new GUI_05_email();
            	number = a.getA();
            	
            	if(t>0) {
					timer = new Timer(1000, new ActionListener() {
		            	@Override
						public void actionPerformed(ActionEvent e) {
		            		int i = 1;
		            		t -= i;
		            		++i;
							int m = t/60;
		            		int s = t%60;
		            		time.setText(String.format("%02d:%02d", m, s));
		            		if(m<=1) {
		            			time.setForeground(Color.red);
		            		}
		            		if(m==0 && s==0) {
		            			timer.stop();
		            		}	
		           		}
					});timer.start();
				}
            	button_1.setEnabled(false);
            }
		});
		
		//확인버튼 클릭 시
		button_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if((textfield_email2.getText()).equals(String.valueOf(number))) {
            		label_email2.setText("인증번호가 일치합니다.");
            		label_email2.setForeground(Color.green);
            		timer.stop();
            		button_1_1.setEnabled(false);
            	}
            	else {
            		label_email2.setText("인증번호가 일치하지 않습니다.");
            		label_email2.setForeground(Color.red);
            	}
            }
		});
		
		//가입 버튼 클릭 시
		button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	String email = combobox.getSelectedItem().toString();
            	if( label_email2.getForeground() == Color.green && label5.getForeground() == Color.green && label4.getForeground() == Color.green && label6.getForeground() == Color.green &&label7.getForeground() == Color.green) {
            		new GUI_04(textfield1, textfield2, textfield_email1, email);
            		new GUI_06();
            	}
            	
            }
		});
		setVisible(true);
	}
}
