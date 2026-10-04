import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class fix {
	static int seatNumber = 0;
	public fix() {
        Object[] options = new Object[44];
        for(int i=0;i<=43;i++) {
        		options[i] = i+1;
        }
        Object selected = JOptionPane.showInputDialog(null, "수리가 필요한 컴퓨터 좌석을 알려주세요 ", "고장/문의", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if (selected != null) {
            seatNumber = (int) selected;
            int answer = JOptionPane.showConfirmDialog(
                    null,
                    "PC" + seatNumber + "을 고장으로 신고할까요?\n"
                    + "사용 중인 좌석이면 현재 이용이 종료됩니다.",
                    "고장 신고",
                    JOptionPane.YES_NO_OPTION);

            if (answer == JOptionPane.YES_OPTION) {
                seat.markBroken(seatNumber);
            }


            System.out.println("선택한 좌석: " + seatNumber);
        }
	}
}
