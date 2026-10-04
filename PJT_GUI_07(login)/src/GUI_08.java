import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextField;


public class GUI_08 {
	static int aa=0;
	static String al = null;
    public GUI_08(JTextField textfield1, String email) {
		String filePath = "C:\\Users\\user\\OneDrive\\Desktop\\학원과제\\login.txt";
    	String email_cor = textfield1.getText() + "@" +email;
    	
    	try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
    		int count = 0;
    		while(count < GUI_04.array.size()) {
    			Object A = GUI_04.array.get(count);
    			String[] array2 = ((String) A).split("/");
    			if( (array2[2]).equals(email_cor) && GUI_03_2.textfield_id.getText().equals(array2[0])) {
    				 aa = 1;
    				 al = GUI_04.array.get(count);
    				 break;
    			}
    			else {
    				count++;
    			}
    		}
       	} catch (FileNotFoundException e1) {
    	    System.out.println("파일을 찾을 수 없습니다: " + filePath);
    	} catch (IOException e1) {
    	    e1.printStackTrace();
    	}
    	
		if(aa==1) {
			System.out.println("8번 성공 ");
		}
		else {
			System.out.println("실패");
		}
	}
}
