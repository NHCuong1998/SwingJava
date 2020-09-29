package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.net.httpserver.Authenticator.Result;

import bao.BaoEmployee;
import bao.BaoLogin;
import entity.CurrentUser;
import entity.Employee;
import modal.ResultsMessage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JButton btnLogin;
	private JButton btnExitLogin;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtUser;
	private JPanel panel;
	private JPasswordField txtPassword;
	private JLabel lblBg;
	private JCheckBox chbShowPass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1317, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255), new Color(0, 0, 255)));
		panel.setForeground(new Color(128, 128, 128));
		panel.setBounds(475, 203, 422, 267);
		desktopPane.add(panel);
		
		btnExitLogin = new JButton("Exit");
		btnExitLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExitLoginActionPerformed(e);
			}
		});
		
				
				btnLogin = new JButton("Login");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnLoginActionPerformed(e);
					}
				});
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		
		lblNewLabel_3 = new JLabel("PassWord");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		
		lblNewLabel_2 = new JLabel("User");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		
		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		txtPassword = new JPasswordField();
		
		chbShowPass = new JCheckBox("Show Password");
		chbShowPass.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				do_chkShowPass_itemStateChanged(e);
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(92)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(btnExitLogin, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(91, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(chbShowPass)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtPassword)
							.addComponent(txtUser, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chbShowPass)
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnExitLogin))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		lblBg = new JLabel("New label");
		Image imgBg = new ImageIcon(this.getClass().getResource("../img/background.jpg")).getImage().getScaledInstance(1317, 704,
				Image.SCALE_DEFAULT);
		lblBg.setIcon(new ImageIcon(imgBg));
		lblBg.setBounds(0, 0, 1317, 704);
		desktopPane.add(lblBg);
		Image img = new ImageIcon(this.getClass().getResource("../img/background.jpg")).getImage();
		
		contentPane.setLayout(gl_contentPane);
		
		
		txtUser.setText("cuong");
		txtPassword.setText("123456");
		txtPassword.setEchoChar('*');
	}
	protected void btnExitLoginActionPerformed(ActionEvent e) {
		System.exit(0);
	}
	protected void btnLoginActionPerformed(ActionEvent e) {	
		String id = txtUser.getText();
		String password = new String(txtPassword.getPassword());
		if(id.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(this, "Input User and Password", "ERROR", JOptionPane.ERROR_MESSAGE);
			txtPassword.setText("");
		}else {
			CurrentUser cuser = new BaoLogin().getLogin(id, password);
			if(cuser.getUsername()!=null) {
				getJFrame(cuser);
			}else {
				JOptionPane.showMessageDialog(this, "Id or password is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
				txtPassword.setText("");
			}
		}
	}
	
	private void getJFrame(CurrentUser cuser) {
		if(!cuser.isAdmin() && cuser.getListBranch()==null && cuser.getListDepartment()==null) {
			User frameuser = new User(cuser);
			frameuser.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frameuser.setVisible(true);
			this.setVisible(false);
		}else {
			Admin frameAdmin = new Admin(cuser);
			frameAdmin.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frameAdmin.setVisible(true);
			this.setVisible(false);
		}
		
	}

	protected void do_chkShowPass_itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==1) {
			txtPassword.setEchoChar((char)0);
		}else {
			txtPassword.setEchoChar('*');
		}
	}
}
