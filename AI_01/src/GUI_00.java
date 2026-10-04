import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GUI_00 extends JFrame {
	static GUI_01_set g1_0;
	static GUI_01 g1;
	static GUI_02 g2;
	static waitpanel wait;
	static statepanel state;
	static GUI_03 g3;
	static GUI_03_1 g3_1;
	static GUI_02_1 g2_1;
	static find_user finduser;
	static Container contentpane;
	static JLabel label_image1;
	public GUI_00() {
		//타이틀바 삭제
	    seat.loadState();
	    setUndecorated(true);
		setBounds(550, 400, 600,750);
		setSize(600,750);
		contentpane = getContentPane();
		contentpane.setLayout(null);
		
		finduser = new find_user();
		g3_1 = new GUI_03_1();
		g3 = new GUI_03();
		g2 = new GUI_02();
		wait = new waitpanel();
		state = new statepanel();
		g1 = new GUI_01();
		g2_1 = new GUI_02_1();
		g1_0 = new GUI_01_set();
		seat.timer.start();
		
		contentpane.add(finduser);
		contentpane.add(g2_1);
		contentpane.add(g1_0);
		contentpane.add(g3_1);
		contentpane.add(g3);
		contentpane.add(g2);
		contentpane.add(wait);
		contentpane.add(state);
		contentpane.add(g1);
		
		finduser.setVisible(false);
		g3_1.setVisible(false);
		g3.setVisible(false);
		g2.setVisible(false);
		g2_1.setVisible(false);
		g1_0.setVisible(false);
		g1.setVisible(false);
		wait.setVisible(false);
		state.setVisible(false);

		//글씨
		JLabel label1 = new JLabel("컴퓨터 좌석 예약 시스템");
        label1.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 40));
        label1.setBounds(130,290,500,40);
        add(label1);
		
        JLabel label2 = new JLabel("<html>원하는 좌석을 선택하고<br>&nbsp&nbsp바로 예약해보세요!</html>");
        label2.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label2.setBounds(220,350,500,50);
        add(label2);
        
        JLabel label3 = new JLabel("컴퓨터 좌석 예약 시스템");
        label3.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        label3.setBounds(80,40,500,15);
        add(label3);
        
        JLabel label4 = new JLabel("시작하기   >>");
        label4.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 25));
        label4.setBounds(250,465,500,40);
        add(label4);
        
        //버튼
		ImageIcon icon0 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\00\\화면1_버튼1.png");
		Image image0 = icon0.getImage();
		Image scaledimage0 = image0.getScaledInstance(270, 60, Image.SCALE_SMOOTH);
		ImageIcon scaledicon0 = new ImageIcon(scaledimage0);
		JLabel label_image0 = new JLabel(scaledicon0);
		label_image0.setBounds(165,455,270, 60);
		contentpane.add(label_image0);
		
		//첫화면
		ImageIcon icon1 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\00\\화면1.png");
		Image image1 = icon1.getImage();
		Image scaledimage1 = image1.getScaledInstance(600, 750, Image.SCALE_SMOOTH);
		ImageIcon scaledicon1 = new ImageIcon(scaledimage1);
		label_image1 = new JLabel(scaledicon1);
		label_image1.setBounds(0,0,600,750);
		contentpane.add(label_image1);
		
		label_image0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	label1.setVisible(false);
            	label2.setVisible(false);
            	label3.setVisible(false);
            	label4.setVisible(false);
        		label_image0.setVisible(false);
        		label_image1.setVisible(false);
        		g1.setVisible(true);
        		System.out.println("첫화면 -> 두번쨰화면");
            }
        });
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GUI_00());
	}
}
