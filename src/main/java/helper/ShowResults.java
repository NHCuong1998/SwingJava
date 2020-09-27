package helper;

import javax.swing.JOptionPane;

public class ShowResults {
	public static void jop_Error(String message) {
		
		JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void jop_Info(String message) {
		
		JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
