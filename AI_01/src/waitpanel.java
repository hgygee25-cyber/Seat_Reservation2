import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.*;

public class waitpanel extends JPanel {

    JLabel info = new JLabel();
    JLabel myInfo = new JLabel();

    JComboBox<String> type = new JComboBox<>(new String[]{"일반 사용자", "수업 참여자"});
    JSpinner minutes = new JSpinner(new SpinnerNumberModel(30, 1, 90, 1));

    DefaultTableModel waitModel = new DefaultTableModel(new String[]{"배정 순서", "사용자", "유형", "신청 시간(분)"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    DefaultTableModel pcModel = new DefaultTableModel(new String[]{"컴퓨터 번호", "상태", "누적 사용(분)"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int column) {
            if (column == 0) return Integer.class;
            if (column == 2) return Double.class;
            return String.class;
        }
    };

    public waitpanel() {
        setBounds(0, 0, 600, 750);
        setLayout(null);
        setBackground(new Color(252, 247, 240));

        JLabel title = new JLabel("대기 신청");
        title.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 27));
        title.setBounds(63, 25, 550, 27);
        add(title);

        info.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        info.setBounds(25, 90, 550, 20);
        add(info);
        
        JLabel label1 = new JLabel("수업 참여자 우선 / 같은 유형은 먼저 신청한 순서");
        label1.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 17));
        label1.setBounds(25, 120, 550, 17);
        add(label1);
        
        JLabel label0 = new JLabel("사용자 유형: ");
        label0.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 17));
        label0.setBounds(25, 160, 100, 17);
        add(label0);
        
        JLabel label2 = new JLabel("사용 시간(분): ");
        label2.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 17));
        label2.setBounds(260, 160, 100, 17);
        add(label2);
        
        type.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        type.setBounds(120, 155, 130, 30);
        add(type);
        
        minutes.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        minutes.setBounds(350, 155, 65, 30);
        add(minutes);        

        JLabel label6 = new JLabel("대기 등록");
        label6.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 17));
        label6.setBounds(450, 160, 60, 17);
        add(label6);
        
        ImageIcon icon9 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\04\\버튼.png");
		Image image9 = icon9.getImage();
		Image scaledimage9 = image9.getScaledInstance(70, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledicon9 = new ImageIcon(scaledimage9);
        JLabel label9 = new JLabel(scaledicon9);
        label9.setBounds(445, 160, 70, 20);
        label9.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 23));
        add(label9);
        
        JLabel label7 = new JLabel("대기 취소");
        label7.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 17));
        label7.setBounds(520, 160, 60, 17);
        add(label7);
            
        ImageIcon icon10 = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\04\\버튼.png");
		Image image10 = icon10.getImage();
		Image scaledimage10 = image10.getScaledInstance(70, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledicon10 = new ImageIcon(scaledimage10);
        JLabel label10 = new JLabel(scaledicon10);
        label10.setBounds(515, 160, 70, 20);
        label10.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 23));
        add(label10);
        
        JTable waitTable = new JTable(waitModel);
        waitTable.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        waitTable.setBounds(25, 200, 550, 190);
        add(waitTable); 
        
        JLabel label8 = new JLabel("컴퓨터 목록");
        label8.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 30));
        label8.setBounds(25, 470, 250, 30);
        add(label8);

        JComboBox<String> sort = new JComboBox<>(new String[]{
                "컴퓨터 번호 오름차순","컴퓨터 번호 내림차순","사용 시간 많은 순", "사용 시간 적은 순"
        });

        JScrollPane label12 = new JScrollPane(sort);
        label12.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 17));
        label12.setBounds(300, 470, 275, 30);
        add(label12);  
        
        JTable pcTable = new JTable(pcModel);
        pcTable.setRowHeight(25);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(pcModel);

        pcTable.setRowSorter(sorter);
        pcTable.getColumnModel().getColumn(2).setCellRenderer(
                new DefaultTableCellRenderer() {
                    @Override
                    protected void setValue(Object value) {
                        if (value instanceof Number) {
                            setText(String.format("%.2f",
                                    ((Number)value).doubleValue()));
                        } else {
                            setText("");
                        }
                    }
                });

        JScrollPane pcTableScroll = new JScrollPane(pcTable);
        label8.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        pcTableScroll.setBounds(25, 510, 550, 170);
        add(pcTableScroll);        

        JLabel label11 = new JLabel("목록 정렬은 실제 대기자의 배정 순서를 바꾸지 않습니다.");
        label11.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 17));
        label11.setBounds(25, 655, 550, 17);
        add(label11);
        
        JLabel label4 = new JLabel("<< 뒤로가기");
        label4.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label4.setBounds(25, 695, 160, 20);
        add(label4);
		
        label4.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    		setVisible(false);
	            GUI_00.g2.setVisible(true);
		    }
		});
        
        JLabel label5 = new JLabel("좌석 신청 >>");
        label5.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label5.setBounds(440, 695, 160, 20);
        add(label5);
        
        label5.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    		setVisible(false);
	            GUI_00.g3.setVisible(true);
		    }
		});

        //
        ImageIcon icon = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\04\\배경.png");
		Image image = icon.getImage();
		Image scaledimage = image.getScaledInstance(600,750, Image.SCALE_SMOOTH);
		ImageIcon scaledicon = new ImageIcon(scaledimage);
		JLabel label_image = new JLabel(scaledicon);
		label_image.setBounds(0,0,600,750);
		add(label_image);
        // 대기 등록
		label6.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
	            try {
	                minutes.commitEdit();
	
	                String name = GUI_02.us_n();
	                boolean lesson = type.getSelectedIndex() == 1;
	                int min = (Integer)minutes.getValue();
	                seat.joinWaiting(name, lesson, min);
	                JOptionPane.showMessageDialog(waitpanel.this,"등록되었습니다. 좌석이 비면 자동 배정됩니다.");
	
	                refresh();
	
	            } catch (java.text.ParseException ex) {
	                JOptionPane.showMessageDialog(waitpanel.this, "사용 시간을 1~90분으로 입력해주세요.");
	            } catch (IllegalArgumentException ex) {
	                JOptionPane.showMessageDialog(waitpanel.this,ex.getMessage());
	            }
		    }
        });

        // 대기 취소
        label7.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
	            String name = GUI_02.us_n();
	
	            if (!seat.isWaiting(name)) {
	                JOptionPane.showConfirmDialog(waitpanel.this,"대기 신청 내역이 없습니다.");
	                return;
	            }
	
	            int answer = JOptionPane.showConfirmDialog(waitpanel.this, "대기를 취소할까요?", "대기 취소", JOptionPane.YES_NO_OPTION);
	            if (answer == JOptionPane.YES_OPTION) {
	                seat.cancelWaiting(name);
	                refresh();
	            }
		    }
        });

        // PC 목록 정렬
        sort.addActionListener(e -> {
            int selected = sort.getSelectedIndex();
            int column = selected < 2 ? 0 : 2;
            SortOrder order = selected == 0 || selected == 3 ? SortOrder.ASCENDING : SortOrder.DESCENDING;

            sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(column, order)));
        });

        refresh();
    }

    public void refresh() {
        info.setText("잔여 좌석: " + seat.availableCount() + "/44     전체 좌석: 44     대기: " + seat.waitingCount() + "명");

        String name = GUI_02.us_n();
        int pc = seat.findUserSeat(name);

        if (pc != -1) {
            myInfo.setText("내 좌석: PC" + pc + " 사용 중");
        } else if (seat.isWaiting(name)) {
            myInfo.setText("현재 대기 중입니다. 대기 순서: " + seat.waitingNumber(name));
        } else {
            myInfo.setText("현재 대기 신청이 없습니다.");
        }

        // 대기 목록
        waitModel.setRowCount(0);
        int order = 1;

        for (seat.wait w : seat.waitingList()) {
            waitModel.addRow(new Object[]{
                    order++, w.name, w.lesson ? "수업 참여자" : "일반 사용자", w.minutes
            });
        }

        // PC 목록
        pcModel.setRowCount(0);
        long now = System.currentTimeMillis();

        for (int i = 1; i <= 44; i++) {
            pcModel.addRow(new Object[]{
                    i,seat.status(i),seat.usedMillis(i, now) / 60000.0
            });
        }
    }
}
