//이 페이지는 로그인 완료 후 button 많이 있는 목록
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GUI_02 extends JPanel {
	JLabel name;
	JLabel r_value;
	JLabel w_value;
	
	private static String currentUsername = "";
	String u_n = "";
	public static String us_n() {
		//System.out.println("경고문 띄우기1: "+currentUsername);
		return currentUsername;
	}
	public void user_name(String username) {
		currentUsername = username == null ? "" : username.trim();

		System.out.println("사용자 이름 띄우기: " + currentUsername);
		name.setText(username + "님");
		GUI_00.g3.usernamee(currentUsername);
		GUI_00.g3_1.usernamee(currentUsername);
	}
	public void logout() {
		System.out.println("로그아웃 전: "+currentUsername+","+name.getText());
	    currentUsername = "";
	    name.setText("");
	    GUI_00.g3_1.usernamee("");
	    GUI_00.g2.setVisible(false);
	    GUI_00.g1.setVisible(true);
		System.out.println("로그아웃 후: "+currentUsername+","+name.getText());
	    System.out.println("로그아웃 완료");
	}
	public void recount() {
		r_value.setText(seat.availableCount() + "/44");
	    w_value.setText(String.valueOf(seat.waitingCount()));
	}

	public GUI_02() {
		setBounds(0, 0, 600, 750);
		setLayout(null);
		setBackground(Color.pink);
		
		System.out.println("사용자 이름 띄우기: "+login.GUI_01.result);
		//user_name();
		name = new JLabel();
		name.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
		name.setBounds(150,115,100,30);
		add(name);
		//
		JLabel label3 = new JLabel("컴퓨터 좌석 예약 시스템");
        label3.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 27));
        label3.setBounds(100,40,500,27);
        add(label3);
        
        JLabel label1 = new JLabel("안녕하세요,");
        label1.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 23));
        label1.setBounds(48,120,150,20);
        add(label1);
		
        JLabel label2 = new JLabel("잔여 좌석");
        label2.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label2.setBounds(150,190,500,20);
        add(label2);
        
        JLabel label4 = new JLabel("대기자");
        label4.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label4.setBounds(420,195,100,20);
        add(label4);
		
        r_value = new JLabel();
        r_value.setFont(new Font("Dialog", Font.BOLD, 28));
        r_value.setBounds(150, 225, 150, 40);
        add(r_value);

        w_value = new JLabel();
        w_value.setFont(new Font("Dialog", Font.BOLD, 28));
        w_value.setBounds(420, 225, 100, 40);
        add(w_value);

        recount();

        
        JLabel label5 = new JLabel("전체 좌석");
        label5.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label5.setBounds(150,320,100,20);
        add(label5);
        
        JLabel label6 = new JLabel("좌석 신청");
        label6.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label6.setBounds(420,320,100,20);
        add(label6);
        
        JLabel label7 = new JLabel("<html>컴퓨터 좌석<br>이용 종료</html>");
        label7.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label7.setBounds(150,400,200,100);
        add(label7);
        
        JLabel label8 = new JLabel("좌석 통계");
        label8.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label8.setBounds(420,435,500,20);
        add(label8);
        
        JLabel label9 = new JLabel("사용자 검색");
        label9.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label9.setBounds(150,535,100,20);
        add(label9);
		
        JLabel label10 = new JLabel("대기 신청");
        label10.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label10.setBounds(420,535,100,20);
        add(label10);
        
        JLabel label11 = new JLabel("로그아웃");
        label11.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label11.setBounds(150,640,100,20);
        add(label11);
        
        JLabel label12 = new JLabel("고장/문의");
        label12.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label12.setBounds(420,640,100,20);
        add(label12);

		//
		ImageIcon icon3 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\버튼3.png");
		Image image3 = icon3.getImage();
		Image scaledimage3 = image3.getScaledInstance(250, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledicon3 = new ImageIcon(scaledimage3);
		JLabel label_image3 = new JLabel(scaledicon3);
		label_image3.setBounds(42,280, 250, 100);
		add(label_image3);
		
		ImageIcon icon4 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\버튼4.png");
		Image image4 = icon4.getImage();
		Image scaledimage4 = image4.getScaledInstance(250, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledicon4 = new ImageIcon(scaledimage4);
		JLabel label_image4 = new JLabel(scaledicon4);
		label_image4.setBounds(305,280, 250, 100);
		add(label_image4);
		
		ImageIcon icon00 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\버튼.png");
		Image image00 = icon00.getImage();
		Image scaledimage00 = image00.getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		ImageIcon scaledicon00 = new ImageIcon(scaledimage00);
		JLabel label_image00 = new JLabel(scaledicon00);
		label_image00.setBounds(65,420, 55, 55);
		add(label_image00);
		
		ImageIcon icon5 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\버튼5.png");
		Image image5 = icon5.getImage();
		Image scaledimage5 = image5.getScaledInstance(250, 90, Image.SCALE_SMOOTH);
		ImageIcon scaledicon5 = new ImageIcon(scaledimage5);
		JLabel label_image5 = new JLabel(scaledicon5);
		label_image5.setBounds(42,400, 250, 90);
		add(label_image5);
		
		
		ImageIcon icon6 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\버튼10.png");
		Image image6 = icon6.getImage();
		Image scaledimage6 = image6.getScaledInstance(250, 90, Image.SCALE_SMOOTH);
		ImageIcon scaledicon6 = new ImageIcon(scaledimage6);
		JLabel label_image6 = new JLabel(scaledicon6);
		label_image6.setBounds(305,400, 250, 90);
		add(label_image6);
		
		ImageIcon icon7 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\버튼7.png");
		Image image7 = icon7.getImage();
		Image scaledimage7 = image7.getScaledInstance(250, 90, Image.SCALE_SMOOTH);
		ImageIcon scaledicon7 = new ImageIcon(scaledimage7);
		JLabel label_image7 = new JLabel(scaledicon7);
		label_image7.setBounds(42,500, 250, 90);
		add(label_image7);
		
		ImageIcon icon8 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\버튼6.png");
		Image image8 = icon8.getImage();
		Image scaledimage8 = image8.getScaledInstance(250, 90, Image.SCALE_SMOOTH);
		ImageIcon scaledicon8 = new ImageIcon(scaledimage8);
		JLabel label_image8 = new JLabel(scaledicon8);
		label_image8.setBounds(305,500, 250, 90);
		add(label_image8);
		
		ImageIcon icon9 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\버튼8.png");
		Image image9 = icon9.getImage();
		Image scaledimage9 = image9.getScaledInstance(250, 90, Image.SCALE_SMOOTH);
		ImageIcon scaledicon9 = new ImageIcon(scaledimage9);
		JLabel label_image9 = new JLabel(scaledicon9);
		label_image9.setBounds(45,605, 250, 90);
		add(label_image9);
		
		ImageIcon icon000 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\버튼0.png");
		Image image000 = icon000.getImage();
		Image scaledimage000 = image000.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledicon000 = new ImageIcon(scaledimage000);
		JLabel label_image000 = new JLabel(scaledicon000);
		label_image000.setBounds(330,625, 50, 50);
		add(label_image000);
		
		ImageIcon icon10 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\버튼5.png");
		Image image10 = icon10.getImage();
		Image scaledimage10 = image10.getScaledInstance(250, 90, Image.SCALE_SMOOTH);
		ImageIcon scaledicon10 = new ImageIcon(scaledimage10);
		JLabel label_image10 = new JLabel(scaledicon10);
		label_image10.setBounds(305,605, 250, 90);
		add(label_image10);
		
		//
		ImageIcon icon = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\02\\화면1.png");
		Image image = icon.getImage();
		Image scaledimage = image.getScaledInstance(600,750, Image.SCALE_SMOOTH);
		ImageIcon scaledicon = new ImageIcon(scaledimage);
		JLabel label_image = new JLabel(scaledicon);
		label_image.setBounds(0,0,600,750);
		add(label_image);
		//
		
		//
		label_image3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            		System.out.println("버튼3 눌림");
            		GUI_00.g2_1.setVisible(true);
        			GUI_00.g2.setVisible(false);
            }
        });
		label_image4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
        			System.out.println("버튼4 눌림");
        			GUI_00.g3.setVisible(true);
        			GUI_00.g2.setVisible(false);
            }
        });

		label_image5.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        System.out.println("사용 종료 버튼 눌림");
		        // 로그인 여부 확인
		        if (currentUsername.isEmpty()) {
		            JOptionPane.showMessageDialog(GUI_02.this, "먼저 로그인해주세요.", "사용 종료", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        int endedSeat = seat.endCurrentUser(currentUsername);
		        if (endedSeat == -1) {
		        		JOptionPane.showMessageDialog(GUI_02.this, currentUsername + "님은 현재 사용 중인 컴퓨터가 없습니다.", "사용 종료", JOptionPane.INFORMATION_MESSAGE);
		            return;
		        }
		        JOptionPane.showMessageDialog(GUI_02.this, currentUsername + "님, PC" + endedSeat + " 사용을 종료했습니다.", "사용 종료", JOptionPane.INFORMATION_MESSAGE);
		    	}
		});
		label_image6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
    				System.out.println("버튼6 눌림");
    				GUI_00.state.refresh();
        			GUI_00.g2.setVisible(false);
        			GUI_00.state.setVisible(true);
            }
        });
		label_image7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
    				System.out.println("버튼7 눌림");
    				GUI_00.finduser.showTable();
        			GUI_00.g2.setVisible(false);
        			GUI_00.finduser.setVisible(true);
            }
        });
		label_image8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
    				System.out.println("버튼8 눌림");
    				GUI_00.wait.refresh();
        			GUI_00.g2.setVisible(false);
        			GUI_00.wait.setVisible(true);
            }
        });
		label_image9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
    				System.out.println("버튼9 눌림");
    				logout();
        			GUI_00.g2.setVisible(false);
        			GUI_00.g1.setVisible(true);
            }
        });
		label_image10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            		System.out.println("버튼10 눌림");
            		new fix();
            }
        });
	}
	
}
