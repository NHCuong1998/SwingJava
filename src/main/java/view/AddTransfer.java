package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bao.BaoAssignment;
import bao.BaoGetComboBox;
import bao.BaoTransfer;
import entity.CurrentUser;
import modal.ComboItem;
import modal.ResultsMessage;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AddTransfer extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox cbbEmployee;
	private JLabel lblNewLabel_2;
	private JComboBox cbbNewProject;
	private JButton btnAddTransfer;
	private JButton btnExitAddTransfer;
	private JLabel lblNewLabel_3;
	private JComboBox cbbOldProject;
	private List<ComboItem> listCB1;
	private List<ComboItem> listCB2;
	private List<ComboItem> listCB3;
	private CurrentUser cuser;
	private JButton btnChoose;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane;
	private JTextPane txtDescription;
	private TransferManager supper;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddTransfer frame = new AddTransfer();
//					frame.setUndecorated(true);
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
	public AddTransfer(CurrentUser cuser) {
		this.cuser = cuser;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 515, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblNewLabel = new JLabel("Add Transfer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		lblNewLabel_1 = new JLabel("Select Employee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cbbEmployee = new JComboBox();
		comboBoxSetValue1();

		lblNewLabel_2 = new JLabel("Select Project");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cbbNewProject = new JComboBox();

		btnAddTransfer = new JButton("Add Transfer");
		btnAddTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddTransferActionPerformed(e);
			}
		});

		btnExitAddTransfer = new JButton("Exit");
		btnExitAddTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExitAddTransferActionPerformed(e);
			}
		});

		lblNewLabel_3 = new JLabel("Select Old Project");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		cbbOldProject = new JComboBox();

		btnChoose = new JButton("Choose");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChooseActionPerformed(e);
			}
		});

		lblNewLabel_4 = new JLabel("Description");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));

		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(177)
					.addComponent(lblNewLabel)
					.addGap(191))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(95, Short.MAX_VALUE)
					.addComponent(btnAddTransfer)
					.addGap(32)
					.addComponent(btnExitAddTransfer, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(176))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
								.addComponent(cbbNewProject, 0, 358, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3)
										.addComponent(cbbEmployee, 0, 283, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnChoose))
								.addComponent(cbbOldProject, 0, 358, Short.MAX_VALUE))
							.addGap(66))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbbEmployee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChoose))
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbbOldProject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbbNewProject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExitAddTransfer)
						.addComponent(btnAddTransfer))
					.addGap(20))
		);

		txtDescription = new JTextPane();
		scrollPane.setViewportView(txtDescription);
		contentPane.setLayout(gl_contentPane);
	}

	protected void btnExitAddTransferActionPerformed(ActionEvent e) {
		this.dispose();
	}

	private void comboBoxSetValue1() {
		listCB1 = new BaoGetComboBox().getList("Employee Of Branch", cuser.getUsername());
		for (ComboItem item : listCB1) {
			cbbEmployee.addItem(new ComboItem(item.getId(), item.getValue()));
		}

	}

	protected void btnChooseActionPerformed(ActionEvent e) {
		cbbOldProject.removeAllItems();
		cbbNewProject.removeAllItems();
		String emp = ((ComboItem) cbbEmployee.getSelectedItem()).getId();
		listCB2 = new BaoGetComboBox().getList("Project Of Employee", emp);
		for (ComboItem item : listCB2) {
			if (item.getId().equals("") && item.getValue().equals("")) {
				cbbOldProject.addItem(new ComboItem("", ""));
			}
			cbbOldProject.addItem(new ComboItem(item.getId(), item.getValue()));
		}

		listCB3 = new BaoGetComboBox().getList("Project Of Department", emp);
		for (ComboItem item : listCB3) {
//				cbbNewProject.addItem("Currently the department has no project.");			
				cbbNewProject.addItem(new ComboItem(item.getId(), item.getValue()));
			
		}

	}

	protected void btnAddTransferActionPerformed(ActionEvent e) {
		String emp = ((ComboItem) cbbEmployee.getSelectedItem()).getId();
		String Description = txtDescription.getText();
		if (cbbOldProject.getSelectedIndex() < 0 || cbbNewProject.getSelectedIndex() < 0 || Description.equals("")) {
			JOptionPane.showMessageDialog(this, "You must fill out all information");
		} else if (cbbOldProject.getSelectedIndex() < 0) {
			JOptionPane.showMessageDialog(this, "Currently, the staff has not participated in the project");
		} else {
			String oldProject = ((ComboItem) cbbOldProject.getSelectedItem()).getId();
			String newProject = ((ComboItem) cbbNewProject.getSelectedItem()).getId();
			ResultsMessage rm = new BaoTransfer().insert(emp, oldProject, newProject, Description, cuser.getUsername());
			if (rm.getNum() > 0) {
				this.dispose();
//				supper.addNewToTable(emp, oldProject, newProject);
//				supper.reLoadTable();
				new BaoAssignment().insert(emp, newProject);
				new BaoAssignment().setDone(null, oldProject, emp);
			}
			rm.showMessage(null);
		}
	}
}
