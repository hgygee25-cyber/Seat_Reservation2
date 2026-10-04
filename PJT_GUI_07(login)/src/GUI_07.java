import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUI_07 {
	public GUI_07(JTextField textfield1, String email) {
		String filePath = "C:\\Users\\user\\OneDrive\\Desktop\\학원과제\\login.txt";
    	int a = 0;
    	String email_cor = textfield1.getText() + "@" +email;
    	try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
    		
    		int count = 0;
    		while(count < GUI_04.array.size()) {
    			Object A = GUI_04.array.get(count);
    			String[] array2 = ((String) A).split("/");
    			count++;
    			
    			if( (array2[2]).equals(email_cor)) {
    				JOptionPane.showMessageDialog(null, array2[0]);
    				break;
    			}
    		}
       	} catch (FileNotFoundException e1) {
    	    System.out.println("파일을 찾을 수 없습니다: " + filePath);
    	} catch (IOException e1) {
    	    e1.printStackTrace();
    	}
	}
}
