package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import bao.BaoEmp_info;
import bao.BaoEmployee;
import bao.BaoLogin;
import entity.CurrentUser;
import entity.Emp_info;
import modal.EmployeeView;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPasswordField;

public class UserPersonalDetails extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTabbedPane tabbedPane;
	private JPanel panelProfile;
	private JPanel panelChangePassword;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblPosition;
	private JLabel lblDepartment;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblEmail;
	private JLabel lblAddress;
	private JLabel lblEducation;
	private JLabel lblSpecialize;
	private JLabel lblPhone;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnChangePassword;
	private JLabel lblNewLabel_8;
	private JLabel lblDatejoin;
	private JPasswordField txtPassword;
	private JPasswordField txtNewPassword;
	private JPasswordField txtReNewPassword;
	private JButton btnEdit;
	private CurrentUser cuser;
	
	public UserPersonalDetails(){}
	public UserPersonalDetails(CurrentUser cuser) {
		this.cuser = cuser;
		setBounds(0, 0, 900, 430);
		lblNewLabel = new JLabel("Personal Details");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 871, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
						.addContainerGap()));

		panelProfile = new JPanel();
		panelProfile.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				panelProfileComponentShown(e);
			}
		});
		tabbedPane.addTab("    Profile    ", null, panelProfile, null);

		lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_3 = new JLabel("Department:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_4 = new JLabel("Position:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblID = new JLabel("New label");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblName = new JLabel("New label");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblPosition = new JLabel("New label");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblDepartment = new JLabel("New label");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_9 = new JLabel("Address:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_10 = new JLabel("Education:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_11 = new JLabel("Specialize:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_12 = new JLabel("Email:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_13 = new JLabel("Phone:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblEmail = new JLabel("New label");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblAddress = new JLabel("New label");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblEducation = new JLabel("New label");
		lblEducation.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblSpecialize = new JLabel("New label");
		lblSpecialize.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblPhone = new JLabel("New label");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_8 = new JLabel("Date Join:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblDatejoin = new JLabel("New label");
		lblDatejoin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnEdit = new JButton("Edit Profile Details");
		btnEdit.setVisible(false);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		GroupLayout gl_panelProfile = new GroupLayout(panelProfile);
		gl_panelProfile.setHorizontalGroup(
			gl_panelProfile.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProfile.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panelProfile.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelProfile.createSequentialGroup()
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panelProfile.createSequentialGroup()
							.addGroup(gl_panelProfile.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelProfile.createSequentialGroup()
									.addGroup(gl_panelProfile.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addGroup(gl_panelProfile.createSequentialGroup()
											.addGroup(gl_panelProfile.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1)
												.addComponent(lblNewLabel_2)
												.addComponent(lblNewLabel_4))
											.addGap(45)
											.addGroup(gl_panelProfile.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPosition, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
												.addGroup(gl_panelProfile.createParallelGroup(Alignment.LEADING, false)
													.addComponent(lblDepartment, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
													.addComponent(lblID, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addComponent(lblDatejoin, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))))
									.addGap(15))
								.addGroup(gl_panelProfile.createSequentialGroup()
									.addComponent(lblNewLabel_8)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panelProfile.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panelProfile.createSequentialGroup()
									.addComponent(lblNewLabel_9)
									.addGap(32)
									.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelProfile.createSequentialGroup()
									.addGroup(gl_panelProfile.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_10)
										.addComponent(lblNewLabel_11)
										.addComponent(lblNewLabel_13)
										.addComponent(lblNewLabel_12))
									.addGap(18)
									.addGroup(gl_panelProfile.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPhone, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
										.addComponent(lblSpecialize, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
										.addComponent(lblEducation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))))
							.addGap(76))))
		);
		gl_panelProfile.setVerticalGroup(
			gl_panelProfile.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProfile.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panelProfile.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblID)
						.addComponent(lblNewLabel_9)
						.addComponent(lblAddress))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelProfile.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblName)
						.addComponent(lblNewLabel_10)
						.addComponent(lblEducation))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelProfile.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblDepartment)
						.addComponent(lblNewLabel_11)
						.addComponent(lblSpecialize))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelProfile.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblPosition)
						.addComponent(lblNewLabel_13)
						.addComponent(lblPhone))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelProfile.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(lblNewLabel_12)
						.addComponent(lblNewLabel_8)
						.addComponent(lblDatejoin))
					.addGap(42)
					.addComponent(btnEdit)
					.addContainerGap(81, Short.MAX_VALUE))
		);
		panelProfile.setLayout(gl_panelProfile);

		panelChangePassword = new JPanel();
		tabbedPane.addTab("Change Password", null, panelChangePassword, null);

		lblNewLabel_5 = new JLabel("Current password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_6 = new JLabel("Enter your new password");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_7 = new JLabel("Re-enter your new password");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnChangePassword = new JButton("Comfirm");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChangePasswordActionPerformed(e);
			}
		});
		
		txtPassword = new JPasswordField();
		
		txtNewPassword = new JPasswordField();
		
		txtReNewPassword = new JPasswordField();
		GroupLayout gl_panelChangePassword = new GroupLayout(panelChangePassword);
		gl_panelChangePassword.setHorizontalGroup(
			gl_panelChangePassword.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChangePassword.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panelChangePassword.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChangePassword.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtReNewPassword, Alignment.LEADING)
							.addComponent(txtNewPassword, Alignment.LEADING)
							.addComponent(lblNewLabel_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_6, Alignment.LEADING)
							.addComponent(lblNewLabel_5, Alignment.LEADING)
							.addComponent(txtPassword, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(621, Short.MAX_VALUE))
		);
		gl_panelChangePassword.setVerticalGroup(
			gl_panelChangePassword.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChangePassword.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtReNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addComponent(btnChangePassword)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panelChangePassword.setLayout(gl_panelChangePassword);
		getContentPane().setLayout(groupLayout);
//		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
//		for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
//			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
//		}
	}

	private void LoadListProfile(String id) {
		EmployeeView emp = new BaoEmployee().getFromId(id);
		lblAddress.setText(emp.getAddress());
		lblName.setText(emp.getName());
		lblID.setText(emp.getId());
		lblDepartment.setText(emp.getDepartment_id());
		lblPosition.setText(emp.getPosition_id());
		lblEducation.setText(emp.getEducation());
		lblSpecialize.setText(emp.getSpecialize());
		lblPhone.setText(emp.getPhone());
		lblEmail.setText(emp.getEmail());
		lblDatejoin.setText(emp.getDatejoin().toString());
	}

	protected void panelProfileComponentShown(ComponentEvent e) {
		LoadListProfile(cuser.getUsername());
	}
	
	protected void ResetTxt() {
		txtPassword.setText("");
		txtNewPassword.setText("");
		txtReNewPassword.setText("");
	}

	protected void btnChangePasswordActionPerformed(ActionEvent e) {
		
		String oldPassword = new String(txtPassword.getPassword());
		String newPassword = new String(txtNewPassword.getPassword());
		String ReNewPassword = new String(txtReNewPassword.getPassword());
		if (!oldPassword.equals("") && !newPassword.equals("") && !ReNewPassword.equals("")) {
			if(newPassword.equals(ReNewPassword)) {
				new BaoLogin().changePassword(cuser.getUsername(), oldPassword, newPassword).showMessage(null);
			
			}else {
				JOptionPane.showMessageDialog(null, "Fail: Re-enter password mismatch.", "Error",
						JOptionPane.ERROR_MESSAGE);
				ResetTxt();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Fail: You must fill out all information.", "Error",
					JOptionPane.ERROR_MESSAGE);
			ResetTxt();
		}
		
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		new AddEmployee(4, cuser.getUsername(), null, 0, cuser).setVisible(true);
	}
}
