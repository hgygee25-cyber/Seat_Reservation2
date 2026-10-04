import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.*;
import login.GUI_04;

public class GUI_03_1 extends JPanel {
	static int selectedSeat;
	int index_s = 0;
	String username= "1";
	static JLabel label11;
	static JLabel label12;
	public void index(int i_s) {
		index_s = i_s;
		label12.setText("PC"+String.valueOf(index_s));
	}
	public void usernamee(String name) {
		username = name;
		label11.setText(username);
	}
	public GUI_03_1() {
		setBounds(0, 0, 600, 750);
		setLayout(null);
		setBackground(Color.pink);
		//
		JLabel label1 = new JLabel("예약할 좌석의 시간을 입력해주세요");
        label1.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 10));
        label1.setBounds(250,40,600,20);
        add(label1);
		
        JLabel label2 = new JLabel("예약 정보");
        label2.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label2.setBounds(110,390,500,20);
        add(label2);
        
        JLabel label3 = new JLabel("좌석 예약하기");
        label3.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 27));
        label3.setBounds(70,30,500,27);
        add(label3);
        
        JLabel label4 = new JLabel("사용자명");
        label4.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        label4.setBounds(110,450,100,15);
        add(label4);
		
        JLabel label5 = new JLabel("좌석 번호");
        label5.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        label5.setBounds(110,510,100,15);
        add(label5);
        
        JLabel label6 = new JLabel("예약 설정 시간");
        label6.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        label6.setBounds(110,570,100,15);
        add(label6);
        
        JLabel label7 = new JLabel("<< 뒤로가기");
        label7.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label7.setBounds(60,685,100,40);
        add(label7);
        
        JLabel label8 = new JLabel("예약하기  >>");
        label8.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label8.setBounds(480,685,100,40);
        add(label8);
        
        JLabel label9 = new JLabel("좌석 예약을 진행하고 있습니다");
        label9.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 27));
        label9.setBounds(150,280,500,40);
        add(label9);
        
        JLabel label10 = new JLabel("잠시만 기다려주세요");
        label10.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        label10.setBounds(250,320,200,40);
        add(label10);
		//
		JTextField timeField = new JTextField();
		timeField.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
		timeField.setForeground(Color.black);
		timeField.setBackground(new Color(252, 247, 240));
		timeField.setBounds(200,565,100,25);
		add(timeField);
		
		label11 = new JLabel(username);
		label11.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 20));
		label11.setBounds(200,450,100,20);
        add(label11);
        
        label12 = new JLabel("PC");
        label12.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label12.setBounds(200,510,100,20);
        add(label12);
		
		ImageIcon icon2 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\03\\화면2_버튼.png");
		Image image2 = icon2.getImage();
		Image scaledimage2 = image2.getScaledInstance(100,40, Image.SCALE_SMOOTH);
		ImageIcon scaledicon2 = new ImageIcon(scaledimage2);
		JLabel label_image2 = new JLabel(scaledicon2);
		label_image2.setBounds(60,685,100,40);
		add(label_image2);
		
		ImageIcon icon3 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\03\\화면2_버튼.png");
		Image image3 = icon3.getImage();
		Image scaledimage3 = image3.getScaledInstance(100,40, Image.SCALE_SMOOTH);
		ImageIcon scaledicon3 = new ImageIcon(scaledimage3);
		JLabel label_image3 = new JLabel(scaledicon3);
		label_image3.setBounds(480,685,100,40);
		add(label_image3);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\03\\화면1-2.png");
		Image image = icon.getImage();
		Image scaledimage = image.getScaledInstance(600,750, Image.SCALE_SMOOTH);
		ImageIcon scaledicon = new ImageIcon(scaledimage);
		JLabel label_image = new JLabel(scaledicon);
		label_image.setBounds(0,0,600,750);
		add(label_image);
		
		label_image2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    		GUI_00.g3_1.setVisible(false);
		        GUI_00.g3.setVisible(true);
		    }
		});
		
		label_image3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int minutes;
		        
		        try {
		            minutes = Integer.parseInt(timeField.getText());
		        } catch(NumberFormatException ex) {
		            JOptionPane.showMessageDialog(GUI_03_1.this, "예약 시간을 숫자로 입력해주세요.");
		            return;
		        }

		        if(minutes < 1 || minutes > 90) {
		            JOptionPane.showMessageDialog(GUI_03_1.this, "예약 시간은 1분 이상 90분 이하로 입력해주세요.");
		            return;
		        }
		        
		        boolean alreadyReserved = false;
		        for(int i = 1; i <= 44; i++) {
		            if(username.equals(seat.userName[i]) && seat.seat.get(i) == 1) {
		                alreadyReserved = true;
		                break;
		            }
		        }
		        
		        if (alreadyReserved) {
		            JOptionPane.showMessageDialog(GUI_03_1.this, "아직 예약된 좌석이 있습니다.");
		            GUI_00.g3_1.setVisible(false);
			        GUI_00.g3.setVisible(false);
			        GUI_00.g2.setVisible(true);
		        } else {
			        	try {
			        		seat.reserve(username, selectedSeat, minutes);
		                JOptionPane.showMessageDialog( GUI_03_1.this, username + "님, PC" + selectedSeat+ " 좌석을 " + minutes + "분 예약했습니다.");
			            
		                GUI_00.g3_1.setVisible(false);
			            GUI_00.g3.setVisible(false);
			            GUI_00.g2_1.setVisible(true);
		            } catch (IllegalArgumentException ex) {
		                JOptionPane.showMessageDialog( GUI_03_1.this, ex.getMessage());
		            }
		        }

		       System.out.println(username + "/" + index_s + "/" + minutes);

		        
		    }
		});
	}
}
