package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bao.BaoEmp_info;
import bao.BaoEmployee;
import entity.CurrentUser;
import entity.Emp_info;
import modal.EmployeeView;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class User extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JLabel lblNewLabel_1;
	private JLabel lblImageAccount;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblName;
	private JLabel lblGender;
	private JLabel lblDateJoin;
	private JLabel lblBranch;
	private JLabel lblPosition;
	private JLabel lblDepartment;
	private JDesktopPane desktopPane_1;
	private JLabel lblNewLabel_6;
	private JButton btnMyJob;
	private JButton btnPersonalDetails;
	private JButton btnProject;
	private JButton btnTransfer;
	private JLabel lblBg1;
	private JLabel lblNewLabel_13;
	private JPanel panel;
	private int x = 0;
	private JDesktopPane desktopPane_2;
	private JButton btnSignOut;
	private CurrentUser cuser;

	public User(CurrentUser cuser) {
		this.cuser = cuser ;		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();		
		desktopPane_1 = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desktopPane_1, GroupLayout.PREFERRED_SIZE, 978, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(desktopPane_1, Alignment.LEADING)
						.addComponent(desktopPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 661, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		lblNewLabel_6 = new JLabel("Company");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_6.setBounds(22, 11, 130, 42);
		desktopPane_1.add(lblNewLabel_6);
		
// JButton JFrame User
		btnMyJob = new JButton("My Job");
		btnMyJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMyJobActionPerformed(e);
			}
		});
		btnMyJob.setBounds(74, 112, 170, 50);
		desktopPane_1.add(btnMyJob);
		
		btnPersonalDetails = new JButton("Personal details");
		btnPersonalDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPersonalDetailsActionPerformed(e);
			}
		});
		btnPersonalDetails.setBounds(297, 112, 170, 50);
		desktopPane_1.add(btnPersonalDetails);
		
		btnProject = new JButton("Project");
		btnProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnProjectActionPerformed(e);
			}
		});
		btnProject.setBounds(509, 112, 170, 50);
		desktopPane_1.add(btnProject);
		
		btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTransferActionPerformed(e);
			}
		});
		btnTransfer.setBounds(745, 112, 170, 50);
		desktopPane_1.add(btnTransfer);
		
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(47, 205, 900, 430);
		desktopPane_1.add(panel);
		
		desktopPane_2 = new JDesktopPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane_2, GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane_2, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		lblNewLabel_13 = new JLabel("New label");
		Image img2 = new ImageIcon(this.getClass().getResource("../img/bg2.jpg")).getImage().getScaledInstance(978, 661, Image.SCALE_DEFAULT);
		lblNewLabel_13.setIcon(new ImageIcon(img2));
		lblNewLabel_13.setBounds(0, 0, 978, 661);
		desktopPane_1.add(lblNewLabel_13);
		
	

//End Panel Transfer
		
		lblImageAccount = new JLabel("New label");
		lblImageAccount.setBounds(30, 11, 208, 178);
		Image img = new ImageIcon(this.getClass().getResource("../img/user.png")).getImage().getScaledInstance(208, 178, Image.SCALE_DEFAULT);
		lblImageAccount.setIcon(new ImageIcon(img));
		desktopPane.add(lblImageAccount);
		
		lblNewLabel_1 = new JLabel("Full Name:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 213, 70, 24);
		desktopPane.setLayout(null);
		desktopPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("Gender:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 248, 70, 24);
		desktopPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Date Join:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 283, 70, 24);
		desktopPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Branch:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 318, 70, 24);
		desktopPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Position:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 353, 70, 24);
		desktopPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Department:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 388, 86, 24);
		desktopPane.add(lblNewLabel_5);
		
		lblName = new JLabel("Ngô Hùng Cường");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(106, 214, 157, 24);
		desktopPane.add(lblName);
		
		lblGender = new JLabel("Male");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setBounds(106, 249, 157, 24);
		desktopPane.add(lblGender);
		
		lblDateJoin = new JLabel("2020/12/12");
		lblDateJoin.setForeground(Color.WHITE);
		lblDateJoin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateJoin.setBounds(106, 284, 157, 24);
		desktopPane.add(lblDateJoin);
		
		lblBranch = new JLabel("Sài Gòn, Việt Nam");
		lblBranch.setForeground(Color.WHITE);
		lblBranch.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBranch.setBounds(106, 319, 157, 24);
		desktopPane.add(lblBranch);
		
		lblPosition = new JLabel("Staff");
		lblPosition.setForeground(Color.WHITE);
		lblPosition.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPosition.setBounds(106, 354, 157, 24);
		desktopPane.add(lblPosition);
		
		lblDepartment = new JLabel("IT");
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDepartment.setBounds(106, 388, 157, 24);
		desktopPane.add(lblDepartment);
		
		btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignOutActionPerformed(e);
			}
		});
		btnSignOut.setBounds(10, 429, 253, 30);
		desktopPane.add(btnSignOut);
		
		lblBg1 = new JLabel("New label");
		lblBg1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBg1.setBounds(0, 1, 273, 660);
		Image img1 = new ImageIcon(this.getClass().getResource("../img/bg1.jpg")).getImage().getScaledInstance(373, 660, Image.SCALE_DEFAULT);
		lblBg1.setIcon(new ImageIcon(img1));
		desktopPane.add(lblBg1);
		
		EmployeeView emp = new BaoEmployee().getFromId(cuser.getUsername());
		lblName.setText(emp.getName());
		lblPosition.setText(emp.getPosition_id());
		lblDepartment.setText(emp.getDepartment_id());
		
		contentPane.setLayout(gl_contentPane);
	}
	protected void btnMyJobActionPerformed(ActionEvent e) {
		if(x != 1) {
			panel.setVisible(true);
			desktopPane_2.removeAll();
			UserMyJob sub = new UserMyJob(cuser);
			sub.setVisible(true);
			desktopPane_2.add(sub);
			x = 1;
		}
	}
	protected void btnPersonalDetailsActionPerformed(ActionEvent e) {
		if(x != 2) {
			panel.setVisible(true);
			desktopPane_2.removeAll();
			UserPersonalDetails sub = new UserPersonalDetails(cuser);
			sub.setVisible(true);
			desktopPane_2.add(sub);
			x = 2;
		}
	}
	protected void btnProjectActionPerformed(ActionEvent e) {
		if(x != 3) {
			panel.setVisible(true);
			desktopPane_2.removeAll();
			UserProject sub = new UserProject(cuser);
			sub.setVisible(true);
			desktopPane_2.add(sub);
			x = 3;
		}
	}
	protected void btnTransferActionPerformed(ActionEvent e) {
		if(x != 4) {
			panel.setVisible(true);
			desktopPane_2.removeAll();
			UserTransfer sub = new UserTransfer(cuser);
			sub.setVisible(true);
			desktopPane_2.add(sub);
			x = 4;
		}
	}
	protected void btnSignOutActionPerformed(ActionEvent e) {
		Login login = new Login();
		login.setExtendedState(JFrame.MAXIMIZED_BOTH);
		login.setVisible(true);
		this.dispose();
		
		
	}
	
}
