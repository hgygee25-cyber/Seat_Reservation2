import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import login.GUI_01;

public class GUI_01_login extends JPanel{
    public GUI_01_login() {
    	 	GUI_01.loginSuccess = () -> {
            GUI_00.g1.setVisible(false);
            GUI_00.g2.user_name(login.GUI_01.result);
    	 		GUI_00.g2.setVisible(true);
         };
        //GUI_01말고 다른 거 띄워야 함. 사용자 이름 띄우고 신청 할 수 있는거. 여러 버튼 뜨는 화면으로
		new GUI_01();
    }
}