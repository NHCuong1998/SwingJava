package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bao.BaoAssignment;
import bao.BaoGetComboBox;
import entity.CurrentUser;
import helper.SetTileFrame;
import modal.ComboItem;
import modal.ResultsMessage;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class AddAssignment extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox cbbEmployee;
	private List<ComboItem> listCB1;
	private List<ComboItem> listCB2;
	private CurrentUser cuser;
	private JButton btnSelect;
	private JLabel lblNewLabel_2;
	private JComboBox cbbProject;
	private JButton btnAdd;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddAssignment frame = new AddAssignment();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddAssignment(int type, String id, CurrentUser cuser) {
		this.cuser = cuser;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 464, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("Assignment");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblNewLabel_1 = new JLabel("Select Employee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbbEmployee = new JComboBox();
		comboBoxSetValue1();
		
		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSelectActionPerformed(e);
			}
		});
		
		
		lblNewLabel_2 = new JLabel("Select Project");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbbProject = new JComboBox();
		
		btnAdd = new JButton("Save");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cbbProject, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(cbbEmployee, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(111, Short.MAX_VALUE)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(105))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(34)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbbEmployee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSelect))
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbProject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnNewButton_1))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void comboBoxSetValue1() {
		listCB1 = new BaoGetComboBox().getList("Employee Of Branch", cuser.getUsername());
		for (ComboItem item :listCB1) {
			cbbEmployee.addItem(new ComboItem(item.getId(), item.getValue()));
		}
		
	}
	
	protected void btnSelectActionPerformed(ActionEvent e) {
		cbbProject.removeAllItems();
		String emp = ((ComboItem) cbbEmployee.getSelectedItem()).getId();
		listCB2 = new BaoGetComboBox().getList("Project Of Employee", emp);
		for (ComboItem item :listCB2) {
			if(item.getId().equals("") && item.getValue().equals("")) {
				cbbProject.addItem(new ComboItem("", ""));
			}
			cbbProject.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		this.dispose();
	}
	protected void btnAddActionPerformed(ActionEvent e) {
		
		if(cbbEmployee.getSelectedIndex() < 0 || cbbProject.getSelectedIndex() < 0){
			JOptionPane.showMessageDialog(this,	 "You must fill out all information");
		}else {
			String emp = ((ComboItem) cbbEmployee.getSelectedItem()).getId();
			String project = ((ComboItem) cbbProject.getSelectedItem()).getId();
			ResultsMessage rm = new BaoAssignment().insert(emp, project);
			 rm.showMessage(null);
		}
	}
}
