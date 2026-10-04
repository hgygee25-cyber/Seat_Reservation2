import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_01 extends JPanel{
	static JLabel label_image01;
	public GUI_01() {
		setBounds(0, 0, 600, 750);
		setLayout(null);
		setBackground(Color.black);
		
		//글씨
		JLabel label1 = new JLabel("잔여 좌석");
        label1.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 30));
        label1.setBounds(145,220,500,30);
        add(label1);
		
        JLabel label = new JLabel("   "+seat.availableCount()+"/44                              "+seat.waitingCount()+"명");
        label.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 30));
        label.setBounds(150,260,500,30);
        add(label);
        
        JLabel label2 = new JLabel("대기 인원");
        label2.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 30));
        label2.setBounds(400,220,500,30);
        add(label2);
        
        JLabel label3 = new JLabel("컴퓨터 좌석 예약");
        label3.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 25));
        label3.setBounds(70,40,500,25);
        add(label3);
        
        JLabel label4 = new JLabel("전체 좌석 확인 >>");
        label4.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 28));
        label4.setBounds(250,393,500,28);
        add(label4);
		
        JLabel label5 = new JLabel("로그인         >>");
        label5.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 30));
        label5.setBounds(250,477,500,40);
        add(label5);
        
        JLabel label6 = new JLabel("종료하기");
        label6.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 30));
        label6.setBounds(250,565,500,40);
        add(label6);
    		//
		ImageIcon icon0 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\01\\화면1_버튼1.png");
		JLabel label_image0 = new JLabel(icon0);
		label_image0.setBounds(170,370,260, 71);
		add(label_image0);
		
		ImageIcon icon01 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\01\\화면1_버튼2.png");
		label_image01 = new JLabel(icon01);
		label_image01.setBounds(170,460,260, 71);
		add(label_image01);
		
		ImageIcon icon02 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\01\\버튼.png");
		Image image2 = icon02.getImage();
		Image scaledimage2 = image2.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon scaledicon2 = new ImageIcon(scaledimage2);
		JLabel label_image02 = new JLabel(scaledicon2);
		label_image02.setBounds(200,565,35, 35);
		add(label_image02);
		
		ImageIcon icon03 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\01\\1.png");
		JLabel label_image03 = new JLabel(icon03);
		label_image03.setBounds(170,550,260, 71);
		add(label_image03);
		
		//첫화면
		ImageIcon icon1 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\01\\화면1.png");
		Image image1 = icon1.getImage();
		Image scaledimage1 = image1.getScaledInstance(600, 750, Image.SCALE_SMOOTH);
		ImageIcon scaledicon1 = new ImageIcon(scaledimage1);
		JLabel label_image1 = new JLabel(scaledicon1);
		label_image1.setBounds(0,0,600,750);
		add(label_image1);
		
		label_image0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            		GUI_00.g1_0.setVisible(true);
    				GUI_00.g1.setVisible(false);
            }
        });
		
		label_image01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GUI_01_login();
				GUI_00.g1.setVisible(false);
			}
		});
		
		label_image03.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
