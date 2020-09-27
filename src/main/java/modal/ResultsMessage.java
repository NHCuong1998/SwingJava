package modal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ResultsMessage {
	
	private int num;
	private String message;
	
	public ResultsMessage() {}
	public ResultsMessage(int num, String message) {
		this.num = num;
		this.message = message;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void showMessage(JFrame jframe) {
		if (num > 0) {
			JOptionPane.showMessageDialog(jframe, message, "Info", JOptionPane.INFORMATION_MESSAGE);
			if(jframe != null) {
				jframe.dispose();
			}
		}else if (num == 0 || (num == -1 && message != null )){
			JOptionPane.showMessageDialog(jframe, message, "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(jframe,"There was an abnormal error during execution!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
