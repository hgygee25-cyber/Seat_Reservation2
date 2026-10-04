import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI_01_set extends JPanel{
	JLabel[] seatLabel = new JLabel[45];
	JPanel[] seatpanel = new JPanel[45];
	public void updateSeatImage(int index) {
		System.out.println("seat: "+seat.seat_label);
		System.out.println("seat: "+seat.seat.get(index));
		if(seat.seat.get(index) == 0) {
	        seat.seat_label.set(index,"C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\초록.png");
	    }
	    else if(seat.seat.get(index) == 1) {
	        seat.seat_label.set(index,"C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\빨강.png");
	    }
	    else if(seat.seat.get(index) == 2) {
	        seatpanel[index].setVisible(true);
   			seat.seat_label.set(index, "C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\회색.png");
	    }
		System.out.println("seat_l1: "+seatLabel[index]);
	    	seatLabel[index].setIcon(new ImageIcon(seat.seat_label.get(index)));
	    	System.out.println("seat_l2: "+seat.seat_label.get(index));
	    	System.out.println("seat_l2: "+seatLabel[index]);
	    	
	    	if(seat.seat.get(index) == 0) {
	    		seatpanel[index].setVisible(false);
	    	}
	    	if(seat.seat.get(index) == 1) {
	    		seatpanel[index].setBackground(new Color(246, 111, 105, 200));
	        seatpanel[index].setOpaque(true);
	        seatpanel[index].setVisible(true);	    	
	    }
	    	else if(seat.seat.get(index) == 2) {
	    		seatpanel[index].setBackground(new Color(197, 191, 179, 200));
	        seatpanel[index].setOpaque(true);
	        seatpanel[index].setVisible(true);
	    	}
	}
	
	public GUI_01_set() {
		setBounds(0, 0, 600, 750);
		setLayout(null);
		setBackground(Color.pink);

		new seat(); 
			    
		//panel
		int[] x1 = {0, 99,149,198,250,304,354,406,460, 524,524,524,524,524,524,524,524, 480,432,386,338,235,186,140,93, 47,47,47,47,47,47,47,47, 280,312,334,340,334,312,280,248,220,215,220,248};
		int[] y1 = {0, 92,92,92,92,92,92,92,92, 128,170,212,254,295,336,376,416, 445,445,445,445,445,445,445,445, 420,374,334,294,253,211,172,132, 205,215,245,280,320,345,350,345,320,280,245,215};

		for(int i = 1; i <= 44; i++) {
			seatpanel[i] = new JPanel();
			seatpanel[i].setBounds(x1[i], y1[i], 30, 33);
			seatpanel[i].setOpaque(true);

		    // 현재 좌석 상태에 따라 색 지정
		    if(seat.seat.get(i) == 0) {
		    		seatpanel[i].setVisible(false);
		    }
		    else if(seat.seat.get(i) == 1) {
		    		seatpanel[i].setOpaque(true);
		        seatpanel[i].setBackground(new Color(246, 111, 105, 200));
		    }
		    else if(seat.seat.get(i) == 2) {
		    		seatpanel[i].setOpaque(true);
		        seatpanel[i].setBackground(new Color(197, 191, 179, 200));
		    }

		}
		
		for(int i = 1; i <= 44; i++) {
		    add(seatpanel[i]);
		}
		//글씨
		JLabel label1 = new JLabel("현재 실습실 좌석 현황");
        label1.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 10));
        label1.setBounds(250,30,500,20);
        add(label1);
		
        JLabel label2 = new JLabel("좌석 상태");
        label2.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label2.setBounds(63,530,500,20);
        add(label2);
        
        JLabel label3 = new JLabel("전체 좌석 확인");
        label3.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 27));
        label3.setBounds(63,26,500,27);
        add(label3);
        
        JLabel label4 = new JLabel("사용가능");
        label4.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 15));
        label4.setBounds(410,535,100,15);
        add(label4);
		
        JLabel label5 = new JLabel("사용중");
        label5.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 15));
        label5.setBounds(480,535,100,15);
        add(label5);
        
        JLabel label6 = new JLabel("고장");
        label6.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 15));
        label6.setBounds(540,535,100,15);
        add(label6);
        
        JLabel label7 = new JLabel("<< 뒤로가기");
        label7.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label7.setBounds(260,690,100,40);
        add(label7);
		//버튼 이름붙이기
		JLabel t1 = new JLabel("PC01        PC02       PC03        PC04        PC05        PC06        PC07        PC08");
		t1.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
		t1.setBounds(105,95,800,10);
        add(t1);
		
        JLabel t2 = new JLabel("<html>PC09<br><br><br>PC10<br><br><br>PC11<br><br><br>PC12<br><br><br><br>PC13<br><br><br>PC14<br><br><br>PC15<br><br><br>PC16</html>");
        t2.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t2.setBounds(530,76,50,400);
        add(t2);
        
        JLabel t3 = new JLabel("PC24       PC23       PC22       PC21                      PC20       PC19       PC18       PC17");
        t3.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t3.setBounds(100,445,800,10);
        add(t3);
        
        JLabel t4 = new JLabel("<html>PC32<br><br><br>PC31<br><br><br>PC30<br><br><br>PC29<br><br><br><br>PC28<br><br><br>PC27<br><br><br>PC26<br><br><br>PC25</html>");
        t4.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t4.setBounds(50,75,50,400);
        add(t4);
		
        JLabel t5 = new JLabel("PC01         PC02         PC03         PC04         PC05         PC06         PC07         PC08         PC09         PC10");
        t5.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t5.setBounds(45,570,800,10);
        add(t5);
		
        JLabel t6 = new JLabel("PC11          PC12         PC13         PC14          PC15         PC16          PC17          PC18         PC19         PC20");
        t6.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t6.setBounds(45,600,800,10);
        add(t6);
        
        JLabel t7 = new JLabel("PC21         PC22        PC23         PC24         PC25         PC26        PC27         PC28         PC29        PC30");
        t7.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t7.setBounds(45,630,800,10);
        add(t7);
        
        JLabel t8 = new JLabel("PC31         PC32         PC33        PC34         PC35         PC36         PC37         PC38         PC39        PC40");
        t8.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t8.setBounds(45,660,800,10);
        add(t8);
        
        JLabel t9 = new JLabel("PC41         PC42        PC43         PC44");
        t9.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t9.setBounds(45,690,4200,10);
        add(t9);
        
        JLabel t10 = new JLabel("PC33");
        t10.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t10.setBounds(280,210,50,10);
        add(t10);
        
        JLabel t11 = new JLabel("PC44           PC34");
        t11.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t11.setBounds(250,230,200,10);
        add(t11);
        
        JLabel t12 = new JLabel("PC43                         PC35");
        t12.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t12.setBounds(225,250,200,10);
        add(t12);
        
        JLabel t13 = new JLabel("PC42                              PC36");
        t13.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t13.setBounds(220,290,200,10);
        add(t13);
        
        JLabel t14 = new JLabel("PC41                        PC37");
        t14.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t14.setBounds(230,330,300,10);
        add(t14);
        
        JLabel t15 = new JLabel("PC40           PC38");
        t15.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t15.setBounds(250,350,200,10);
        add(t15);
        
        JLabel t16 = new JLabel("PC39");
        t16.setFont(new Font("그리운 체리 한스푼", Font.PLAIN, 10));
        t16.setBounds(280,370,50,10);
        add(t16);
		//버튼44개


		int[] x = { 0, 32, 86, 140, 195, 250, 305, 360, 415, 470, 525, 32, 86, 140, 195, 250, 305, 360, 415, 470, 525, 32, 86, 140, 195, 250, 305, 360, 415, 470, 525, 32, 86, 140, 195, 250, 305, 360, 415, 470, 525, 32, 86, 140, 195 };
		int[] y = { 0, 565, 565, 565, 565, 565, 565, 565, 565, 565, 565, 595, 595,  595, 595, 595, 595,  595, 595, 595, 595, 625, 625, 625, 625, 625, 625, 625, 625, 625, 625, 655, 655, 655, 655, 655, 655, 655, 655, 655, 655, 685, 685, 685, 685};
		
		for(int i = 1; i <= 44; i++) {
			seatLabel[i] = new JLabel(new ImageIcon(seat.seat_label.get(i)));
		    seatLabel[i].setBounds(x[i], y[i], 50, 25);
		    add(seatLabel[i]);
		
		    
		}
		
		//
		ImageIcon icon00 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\01\\화면0.png");
		Image image00 = icon00.getImage();
		Image scaledimage00 = image00.getScaledInstance(540, 440, Image.SCALE_SMOOTH);
		ImageIcon scaledicon00 = new ImageIcon(scaledimage00);
		JLabel label_image00 = new JLabel(scaledicon00);
		label_image00.setBounds(30,70, 540, 440);
		add(label_image00);
			
		
		ImageIcon icon0 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\01\\화면1_버튼1_화면_버튼.png");
		Image image0 = icon0.getImage();
		Image scaledimage0 = image0.getScaledInstance(100, 40, Image.SCALE_SMOOTH);
		ImageIcon scaledicon0 = new ImageIcon(scaledimage0);
		JLabel label_image0 = new JLabel(scaledicon0);
		label_image0.setBounds(250,690,100, 40);
		add(label_image0);
		
		// 현재 좌석 보여주기
		ImageIcon icon1 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\01\\화면1_버튼1_화면.png");
		Image image1 = icon1.getImage();
		Image scaledimage1 = image1.getScaledInstance(600, 750, Image.SCALE_SMOOTH);
		ImageIcon scaledicon1 = new ImageIcon(scaledimage1);
		JLabel label_image1 = new JLabel(scaledicon1);
		label_image1.setBounds(0,0,600,750);
		add(label_image1);
		
		label_image1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    		int result = JOptionPane.showConfirmDialog( GUI_01_set.this, "좌석 예약은 '좌석 신청'란에서 할 수 있습니다.\n좌석 예약을 원하십니까?", null, JOptionPane.YES_NO_OPTION );

		    	    if (result == JOptionPane.YES_OPTION) {
		    	    		JOptionPane.showMessageDialog( GUI_01_set.this, "좌석 예약은 로그인이 필수입니다. \n로그인 화면으로 넘어갑니다.");
		    	    		GUI_00.g1_0.setVisible(false);
		    	    		new GUI_01_login();
		    	    }else if (result == JOptionPane.NO_OPTION) {
		    	            
		    	    }
		    }
		});
		
		label_image0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            		GUI_00.g1_0.setVisible(false);
            		GUI_00.g1.setVisible(true);
            }
        });
	}
}
