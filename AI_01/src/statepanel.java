import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public class statepanel extends JPanel {

    JLabel summary = new JLabel();
    JTextArea result = new JTextArea();

    JComboBox<String> standard = new JComboBox<>( new String[]{"누적 사용 시간", "사용 횟수"});
    DefaultTableModel model = new DefaultTableModel( new String[]{"컴퓨터 번호", "누적 사용(분)", "사용 횟수", "사용률(%)"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int column) {
            return column == 0 || column == 2 ? Integer.class : Double.class;
        }
    };

    // 사용률 그래프
    JPanel graph = new JPanel() {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            Graphics2D g = (Graphics2D)graphics.create();
            g.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));

            long now = System.currentTimeMillis();

            ArrayList<Integer> order = new ArrayList<>();

            for (int i = 1; i <= 44; i++) {
                order.add(i);
            }

            // 사용률이 높은 PC부터 표시
            order.sort((a, b) -> Double.compare( seat.utilization(b, now),seat.utilization(a, now)));

            // 0~100% 축
            for (int value = 0; value <= 100; value += 25) {
                int x = 65 + value * 370 / 100;

                g.setColor(new Color(0xE2E6F0));
                g.drawLine(x, 25, x, 1000);

                g.setColor(new Color(0x505A74));
                g.drawString(value + "%", x - 10, 17);
            }

            for (int row = 0; row < order.size(); row++) {
                int pc = order.get(row);
                int y = 32 + row * 22;

                int width = (int)Math.round(seat.utilization(pc, now) * 370 / 100);

                g.setColor(new Color(0x1E2433));
                g.drawString("PC" + pc, 10, y + 12);

                g.setColor(new Color(0x1751D0));
                g.fillRect(65, y, width, 14);
            }

            g.dispose();
        }
    };

    public statepanel() {
        setBounds(0, 0, 600, 750);
        setLayout(null);
        setBackground(Color.white);
		
        JLabel title = new JLabel("좌석 통계");
        title.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 27));
        title.setBounds(63, 25, 550, 27);
        add(title);

        summary.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 17));
        summary.setBounds(25, 80, 550, 17);
        add(summary);

        JTable table = new JTable(model);
        table.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 13));
        table.setRowHeight(25);
        table.setAutoCreateRowSorter(true);

        DefaultTableCellRenderer decimal =new DefaultTableCellRenderer() {
        		@Override
            protected void setValue(Object value) {
        			if (value instanceof Number) {
        				setText(String.format("%.2f", ((Number)value).doubleValue()));
        			} else {
        				setText("");
        			}
        		}
        };

        table.getColumnModel().getColumn(1).setCellRenderer(decimal);
        table.getColumnModel().getColumn(3).setCellRenderer(decimal);

        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setBounds(25, 105, 550, 220);
        add(tableScroll);
        
        standard.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        standard.setBounds(300, 340, 275, 30);
        add(standard);
        
        JLabel label = new JLabel("최다·최소 사용 기준");
        label.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 10));
        label.setBounds(340,220,30,20);
        add(label);
        
        result.setEditable(false);
        result.setLineWrap(true);
        result.setWrapStyleWord(true);
        result.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 13));
        JScrollPane label0 = new JScrollPane(result);
        label0.setBounds(25, 380, 550, 60);
        add(label0);
        
        
        JLabel label1 = new JLabel("컴퓨터별 사용률(%) — 높은 순");
        label1.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label1.setBounds(25, 470, 550, 20);
        add(label1);
        
        graph.setBackground(new Color(0xFDFDFF));
        graph.setPreferredSize(new Dimension(510, 1010));

        JScrollPane graphScroll = new JScrollPane(graph);
        graphScroll.getVerticalScrollBar().setUnitIncrement(22);
        graphScroll.setBounds(25, 500, 550, 140);
        add(graphScroll);
        
        JLabel label2 = new JLabel("사용률 = 실제 누적 사용 시간 ÷ 집계 경과 시간 × 100");
        label2.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        label2.setBounds(25, 643, 550, 15);
        add(label2);
        
        JLabel label3 = new JLabel("집계 경과 시간에는 프로그램 종료 시간과 고장 시간도 포함됩니다.");
        label3.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 15));
        label3.setBounds(25, 663, 550, 15);
        add(label3);
        
        JLabel label4 = new JLabel("<< 뒤로가기");
        label4.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label4.setBounds(25, 695, 160, 20);
        add(label4);

        ImageIcon icon = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\04\\배경.png");
		Image image = icon.getImage();
		Image scaledimage = image.getScaledInstance(600,750, Image.SCALE_SMOOTH);
		ImageIcon scaledicon = new ImageIcon(scaledimage);
		JLabel label_image = new JLabel(scaledicon);
		label_image.setBounds(0,0,600,750);
		add(label_image);
		
		label4.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {

		        setVisible(false);
		        GUI_00.g2.setVisible(true);
		    }
		});

        standard.addActionListener(e -> refresh());
        refresh();
    }

    public void refresh() {
        long now = System.currentTimeMillis();

        model.setRowCount(0);

        int occupied = 0;
        boolean hasHistory = false;

        for (int i = 1; i <= 44; i++) {
            int count = seat.useCount(i);
            double minute = seat.usedMillis(i, now) / 60000.0;
            double rate = seat.utilization(i, now);

            model.addRow(new Object[]{
                    i, minute, count, rate
            });

            if (seat.seat.get(i) == seat.u) {
                occupied++;
            }

            if (count > 0) {
                hasHistory = true;
            }
        }

        summary.setText(String.format("현재 사용 중: "+ seat.availableCount()+ "/44             현재 점유율: %.1f%%             대기: %d명",occupied * 100.0 / 44, seat.waitingCount()));

        if (!hasHistory) {
            result.setText( "사용 기록이 없습니다. 모든 컴퓨터가 0입니다.");
            graph.repaint();
            return;
        }

        boolean byCount = standard.getSelectedIndex() == 1;
        int[] most = seat.mostUsed(byCount);
        int[] least = seat.leastUsed(byCount);

        String standardText = byCount ? "사용 횟수" : "누적 사용 시간";
        
        String mostText = "";
        for (int i : most) {
            mostText += "PC" + String.format("%02d", i) + " ";
        }

        String leastText = "";
        for (int i : least) {
            leastText += "PC" + String.format("%02d", i) + " ";
        }

        result.setText("가장 많이 사용: " + mostText + "\n\n" + "가장 적게 사용: " + leastText);
        graph.repaint();
    }
}
