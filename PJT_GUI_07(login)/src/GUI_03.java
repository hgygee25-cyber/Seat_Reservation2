import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class GUI_03 extends JFrame {
	Timer timer;
	int t = 181;
	int number;
	static JTextField textfield1;
	static JTextField textfield2;
	public GUI_03() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400,300);
		Container contentpane = getContentPane();
		contentpane.setLayout(null);
		
		//기본 틀
		JLabel label1 = new JLabel("email");
		label1.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		label1.setBounds(10, 50, 50, 30);
		contentpane.add(label1);
		
		textfield1 = new JTextField();
		textfield1.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		textfield1.setBounds(70,55,110,30);
		contentpane.add(textfield1);
		
		textfield2 = new JTextField();
		textfield2.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		textfield2.setBounds(70,105,110,30);
		contentpane.add(textfield2);
		
		JLabel label1_1 = new JLabel("@");
		label1_1.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		label1_1.setBounds(180,50,20,30);
		contentpane.add(label1_1);

		JLabel label2 = new JLabel("인증번호");
		label2.setBounds(10, 100, 70, 30);
		contentpane.add(label2);
		
		String[] a1 = {"naver.com", "gmail.com", "daum.net", "hotmail.com"};
		JComboBox<String> combobox = new JComboBox<String>(a1);
		combobox.setSelectedItem(null);
		combobox.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		combobox.setBounds(200,55,110,30);
		combobox.setBackground(Color.white);
		contentpane.add(combobox);
		
		JButton button1 = new JButton("발송");
		button1.setBounds(320,55,58,30);
		button1.setBackground(Color.white);
		contentpane.add(button1);
		
		JButton button2 = new JButton("확인");
		button2.setBounds(320,105,58,30);
		button2.setBackground(Color.white);
		contentpane.add(button2);
		
		JLabel label3 = new JLabel();
		label3.setFont(new Font("맑은고딕", Font.PLAIN, 10));
		label3.setBounds(70, 130, 200, 20);
		contentpane.add(label3);
		
		
		button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	JLabel time = new JLabel("03:00");
            	time.setBounds(330, 80, 50, 30);
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
            	button1.setEnabled(false);
            }
        });
		
		button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if((textfield2.getText()).equals(String.valueOf(number))) {
            		timer.stop();
            		button2.setEnabled(false);
                	String email = combobox.getSelectedItem().toString();
            		new GUI_07(textfield1, email);
           
            	}
            	else {
            		textfield2.setText("인증번호가 일치하지 않습니다.");
            		textfield2.setForeground(Color.red);
            	}
            }
		});
		
		setVisible(true);
	}
}
