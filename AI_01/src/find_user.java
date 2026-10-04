import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class find_user extends JPanel {
    static JTable tb;
    static DefaultTableModel model;
    static JTextField search;
    
    public find_user() {
        setBounds(0, 0, 600, 750);
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel title = new JLabel("사용자 검색");
        title.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 27));
        title.setBounds(63, 25, 550, 27);
        add(title);

        JLabel label = new JLabel("검색 :");
        label.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 20));
        label.setBounds(380, 72, 70, 25);
        add(label);

        search = new JTextField();
        search.setBounds(445, 75, 120, 25);
        add(search);

        String[] col = {"컴퓨터", "상태", "사용자", "남은 시간"};

        model = new DefaultTableModel(col, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tb = new JTable(model);
        tb.setFont(new Font("메모먼트꾹꾹체", Font.PLAIN, 18));
        tb.setRowHeight(28);
        tb.getTableHeader().setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 16));

        JScrollPane scroll = new JScrollPane(tb);
        scroll.setBounds(20, 100, 560, 580);
        add(scroll);

        showTable();
        timer.start();
        search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchUser();
            }
        });
        
        JButton button = new JButton("<< 나가기");
        button.setBounds(25, 695, 160, 20);
        button.setBackground(Color.white);
        button.setForeground(Color.black);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("메모먼트꾹꾹체", Font.BOLD, 20));
        add(button);
        
        ImageIcon icon = new ImageIcon("C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\04\\배경2.png");
		Image image = icon.getImage();
		Image scaledimage = image.getScaledInstance(600,750, Image.SCALE_SMOOTH);
		ImageIcon scaledicon = new ImageIcon(scaledimage);
		JLabel label_image = new JLabel(scaledicon);
		label_image.setBounds(0,0,600,750);
		add(label_image);
		
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            		System.out.println("!되돌리기");
            		GUI_00.finduser.setVisible(false);
            		GUI_00.g2.setVisible(true);
            }
        });
    }//
    static Timer timer = new Timer(1000, e -> showTable());
    public static void showTable() {
        model.setRowCount(0);
        long now = System.currentTimeMillis();

        for (int i = 1; i <= 44; i++) {
            String pc = String.format("PC%02d", i);
            String state;
            String username;
            long min;

            if (seat.seat.get(i) == seat.a) {
                state = "사용가능";
                username = "-";
                min = 0;
            }else if (seat.seat.get(i) == seat.u) {
                state = "사용중";
                username = seat.userName[i];
                if (username == null || username.isEmpty()) {
                    username = "-";
                }
                if (seat.endTime[i] > now) {
                    min = (seat.endTime[i] - now + 59999) / 60000;
                } else {
                    min = 0;
                }
            }else {
                state = "고장";
                username = "-";
                min = 0;
            }

            model.addRow(new Object[] {
            		pc,state, username, min
            	});
        }
        searchUser();
    }

    public static void searchUser() {
        String text = search.getText().trim();
        tb.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable tb, Object value, boolean selected, boolean focus, int row, int col) {
                    Component c = super.getTableCellRendererComponent(tb,value, selected, focus,row, col );
                    String username = tb.getValueAt(row, 2).toString();

                    if (!text.isEmpty() && !username.equals("-") &&username.contains(text)) {
                        c.setBackground(Color.PINK);
                    }else {
                        c.setBackground(Color.WHITE);
                    }
                    return c;
                }
            }
        );

        tb.repaint();
    }
}