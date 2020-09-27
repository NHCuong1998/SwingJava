package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import bao.BaoEmployee;
import bao.BaoGetComboBox;
import bao.BaoTransfer;
import entity.CurrentUser;
import entity.Emp_project;
import entity.Project_branch;
import entity.Transfer1;
import entity.Transfer;
import modal.ComboItem;
import modal.EmployeeView;
import modal.ResultsMessage;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;

public class UserTransfer extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_1;
	private List<Transfer> list;
	private int i = 0;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox cbbNewProject;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane_1;
	private JTextPane txtPane;
	private JButton btnComfirm;
	private List<ComboItem> listCB;
	private List<ComboItem> listCB1;
	private List<ComboItem> listCB2;
	private JComboBox cbbOldProject;
	private CurrentUser cuser;
	private JLabel lblNewLabel_5;
	private JTextField txtSearch;
	private JButton btnDelete;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JTextField txtDepatment;
	private JLabel lblNewLabel_6;
	private JComboBox cbbDepartment;
	private JLabel lblNewLabel_7;
	private JScrollPane scrollPane_2;
	private JTextPane txtReasonDepartment;
	private JButton btnNewButton;
	
	
	
	public UserTransfer(CurrentUser cuser) {
		this.cuser = cuser;
		setBounds(0, 0, 900, 462);
		
		lblNewLabel = new JLabel("Transfer");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 864, Short.MAX_VALUE)
							.addGap(10))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		
		panel = new JPanel();
		tabbedPane.addTab("   History   ", null, panel, null);
		
		scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtSearchKeyReleased(e);
			}
		});
		txtSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldFocusGained(e);
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtSearchFocusLost(e);
			}
		});
		txtSearch.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Search");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(396, Short.MAX_VALUE))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		//Load table transfer
		loadListToTable();
		
		panel_1 = new JPanel();
		tabbedPane.addTab("   Transfer Project    ", null, panel_1, null);
		
		lblNewLabel_2 = new JLabel("Curren Project");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNewLabel_3 = new JLabel("Select the project you want to transfer");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbbNewProject = new JComboBox();
		comboBoxSetValue();
		
		lblNewLabel_4 = new JLabel("Reason for transfer");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		scrollPane_1 = new JScrollPane();
		
		btnComfirm = new JButton("Comfirm");
		btnComfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnComfirmActionPerformed(e);
			}
		});
		
		cbbOldProject = new JComboBox();
		comboBoxSetValue1();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnComfirm, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(cbbOldProject, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cbbNewProject, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
							.addComponent(lblNewLabel_4, Alignment.LEADING)
							.addComponent(lblNewLabel_3, Alignment.LEADING)
							.addComponent(lblNewLabel_2, Alignment.LEADING)))
					.addContainerGap(495, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbOldProject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbNewProject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnComfirm)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		
		txtPane = new JTextPane();
		scrollPane_1.setViewportView(txtPane);
		panel_1.setLayout(gl_panel_1);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("   Transfer Department   ", null, panel_2, null);
		
		lblNewLabel_1 = new JLabel("Curren Department");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtDepatment = new JTextField();
		txtDepatment.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDepatment.setHorizontalAlignment(SwingConstants.CENTER);
		txtDepatment.setFocusable(false);
		txtDepatment.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Select the department you want to transfer");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbbDepartment = new JComboBox();
		comboBoxSetValue2();
		
		lblNewLabel_7 = new JLabel("Reason for transfer");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		scrollPane_2 = new JScrollPane();
		
		btnNewButton = new JButton("Comfirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(cbbDepartment, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtDepatment, Alignment.LEADING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
						.addComponent(lblNewLabel_7, Alignment.LEADING)
						.addComponent(lblNewLabel_6, Alignment.LEADING)
						.addComponent(lblNewLabel_1, Alignment.LEADING))
					.addContainerGap(497, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDepatment, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbbDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		txtReasonDepartment = new JTextPane();
		scrollPane_2.setViewportView(txtReasonDepartment);
		EmployeeView emp = new BaoEmployee().getFromId(cuser.getUsername());
		txtDepatment.setText(emp.getDepartment_id());
		panel_2.setLayout(gl_panel_2);
		getContentPane().setLayout(groupLayout);
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
		for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
		    basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
		}
		
	}
	
	private void loadListToTable() {
		list = new BaoTransfer().getTranfer(cuser.getUsername(),null);
		DefaultTableModel defaultTable = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setModel(defaultTable);
		defaultTable.addColumn("Id");
		defaultTable.addColumn("Name User");
		defaultTable.addColumn("Old Project");
		defaultTable.addColumn("New Project");
		defaultTable.addColumn("Description");
		defaultTable.addColumn("Date");
		defaultTable.addColumn("Censorship");
		i = 0;
		for (Transfer ls : list) {
			if (ls.isStatus()) {
				if (ls.getPart() > 0) {
					defaultTable
							.addRow(new Object[] { ls.getId(), ls.getEmp_id(), ls.getProject_old(), ls.getProject_new(),
									ls.getDescription(), ls.getDate(), ls.isCheck() ? "Accept" : "Refuse" });
				} else if(ls.getPart() == 0 && ls.isCheck() == false){
					defaultTable.addRow(new Object[] { ls.getId(), ls.getEmp_id(), ls.getProject_old(),
							ls.getProject_new(), ls.getDescription(), ls.getDate(), "Waiting for approval" });
				}
			}
		}

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(160);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(123);
	}
	
	private void comboBoxSetValue() {
		listCB = new BaoGetComboBox().getList("Project Of Department", cuser.getUsername());
		for (ComboItem item :listCB) {
			cbbNewProject.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}
	private void comboBoxSetValue1() {
		listCB1 = new BaoGetComboBox().getList("Project Of Employee", cuser.getUsername());
		for (ComboItem item :listCB1) {
			if(item.getId().equals("") && item.getValue().equals("")) {
				cbbOldProject.addItem(new ComboItem("", ""));
			}
			cbbOldProject.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}
	
	private void comboBoxSetValue2() {
		EmployeeView emp = new BaoEmployee().getFromId(cuser.getUsername());
		listCB2 = new BaoGetComboBox().getList("Department Of Branch", cuser.getUsername());
		for (ComboItem item :listCB2) {
			if(!item.getId().equals(emp.getDepartment_id())) {
			cbbDepartment.addItem(new ComboItem(item.getId(), item.getValue()));
			}
		}
	}
	protected void btnComfirmActionPerformed(ActionEvent e) {
		String newProject = ((ComboItem) cbbNewProject.getSelectedItem()).getId();
		String oldProject = ((ComboItem) cbbOldProject.getSelectedItem()).getId();
		String description = txtPane.getText();
		
		if(description.equals("")) {
			JOptionPane.showMessageDialog(this, "Fail: You must fill out all information.", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			ResultsMessage rm =  new BaoTransfer().insert(cuser.getUsername(), oldProject, newProject, description );
			txtPane.setText("");
			if(rm.getNum() > 0) {
				loadListToTable();
			 }
			 rm.showMessage(null);
		}
		
		
	}
	protected void btnDeleteActionPerformed(ActionEvent e) {
		
		int row = table.getSelectedRow();
		ResultsMessage rm = new BaoTransfer().delete_project((String) table.getValueAt(row, 0));
		
		if(rm.getNum() > 0) {
			loadListToTable();
		 }
		 rm.showMessage(null);
	}
	protected void textFieldFocusGained(FocusEvent e) {
		if (txtSearch.getText().equals("Search")) {
			txtSearch.setText("");
			txtSearch.setForeground(Color.BLACK);
		}
	}
	protected void txtSearchFocusLost(FocusEvent e) {
		if (txtSearch.getText().equals("")) {
			txtSearch.setText("Search");
			txtSearch.setForeground(Color.GRAY);
		}
	}
	protected void do_txtFind(KeyEvent e, String find) {
		DefaultRowSorter sorter = (DefaultRowSorter) table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	protected void txtSearchKeyReleased(KeyEvent e) {
		do_txtFind(e, txtSearch.getText());
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		EmployeeView emp = new BaoEmployee().getFromId(cuser.getUsername());
		String newDepartment = ((ComboItem) cbbDepartment.getSelectedItem()).getId();
		String description = txtReasonDepartment.getText();
		
		if(description.equals("")) {
			JOptionPane.showMessageDialog(this, "Fail: You must fill out all information.", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			ResultsMessage rm =  new BaoTransfer().insertDepartmentT(cuser.getUsername(), emp.getDepartment_id() , newDepartment, description);
			if(rm.getNum() > 0) {
				loadListToTable();
				txtReasonDepartment.setText("");
			 }
			 rm.showMessage(null);
		}
	}
}
