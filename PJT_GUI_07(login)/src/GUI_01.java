import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GUI_01 extends JFrame{
	public GUI_01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);
		
		Container contentpane = getContentPane();
		contentpane.setLayout(null);
		
		//기본틀
		String a = "ID";
		JLabel label1 = new JLabel(a);
		label1.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		label1.setBounds(50, 50, 50, 30);
		contentpane.add(label1);
		
		String b = "password";
		JLabel label2 = new JLabel(b);
		label2.setFont(new Font("맑은고딕", Font.PLAIN, 30));
		label2.setBounds(50, 105, 150, 30);
		contentpane.add(label2);
		
		JTextField textfield1 = new JTextField();
		textfield1.setBounds(200, 50, 150, 40);
		contentpane.add(textfield1);
		
		JPasswordField textfield2 = new JPasswordField();
		textfield2.setBounds(200, 105, 150, 40);
		contentpane.add(textfield2);
		
		JButton button = new JButton("로그인");
		button.setBounds(390, 75, 70, 50);
		button.setBackground(Color.white);
		contentpane.add(button);
/*		
		JButton button2 = new JButton("회원가입");
		button2.setFont(new Font("맑은고딕", Font.PLAIN, 10));
		button2.setBounds(240, 230, 75, 30);
		contentpane.add(button2);
		
		JButton button3 = new JButton("ID찾기");
		button3.setFont(new Font("맑은고딕", Font.PLAIN, 10));
		button3.setBounds(320, 230, 75, 30);
		contentpane.add(button3);
		
		JButton button4 = new JButton("PW변경");
		button4.setFont(new Font("맑은고딕", Font.PLAIN, 10));
		button4.setBounds(400, 230, 75, 30);
		contentpane.add(button4);
*/ 	  // 라벨로 변경하기 
		JLabel button2 = new JLabel("회원가입");
		button2.setFont(new Font("맑은고딕", Font.PLAIN, 10));
		button2.setBounds(240, 230, 75, 30);
		contentpane.add(button2);
		
		JLabel button3 = new JLabel("ID찾기");
		button3.setFont(new Font("맑은고딕", Font.PLAIN, 10));
		button3.setBounds(320, 230, 75, 30);
		contentpane.add(button3);
		
		JLabel button4 = new JLabel("PW변경");
		button4.setFont(new Font("맑은고딕", Font.PLAIN, 10));
		button4.setBounds(400, 230, 75, 30);
		contentpane.add(button4);
	
		//회원가입 버튼 눌렀다면
		button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		    	new GUI_02();
            }
        });
		// ID찾기 버튼 눌렀다면
		button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		    	new GUI_03();
            }
        });
		// pw찾기 버튼 눌렀다면
		button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
		    	new GUI_03_2();
            }
        });
	
		
		//로그인 버튼 눌렀다면
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 메모장에 있는지 확인&비교하기
				String filePath = "C:\\Users\\user\\OneDrive\\Desktop\\학원과제\\login.txt";
            	int a = 0;
            	try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            		int count = 0;
            		while(count < GUI_04.array.size()) {
            			Object A = GUI_04.array.get(count);
            			String[] array2 = ((String) A).split("/");
            			count++;
            			
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
            	        } catch(NoSuchAlgorithmException e1) {
            	            throw new RuntimeException(e1);
            	        }
            	        
            			if( (array2[0]).equals(textfield1.getText()) && (array2[1]).equals(hashedPassword)) {
            				a=1;
            				break;
            			}
            		}
            	} catch (FileNotFoundException e1) {
            	    System.out.println("파일을 찾을 수 없습니다: " + filePath);
            	} catch (IOException e1) {
            	    e1.printStackTrace();
            	}
            	
            	
              	if(a==1) {
              		JOptionPane.showMessageDialog(null, "로그인이 완료되었습니다!");
              	}else  {
              		JOptionPane.showMessageDialog(null, "로그인에 실패하셨습니다.");
              	}
			}
		});
    	
		setVisible(true);
	}
	
	public static void readtxt() {
		String filepath = "C:\\Users\\user\\OneDrive\\Desktop\\학원과제\\login.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
        		GUI_04.array.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		readtxt();
		new GUI_01();
	}
}

