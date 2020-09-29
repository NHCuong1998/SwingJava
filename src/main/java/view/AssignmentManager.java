package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import bao.BaoAssignment;
import bao.BaoTransfer;
import entity.Assignment;
import entity.Assignment1;
import entity.AssignmentUser;
import entity.CurrentUser;
import entity.Transfer1;
import modal.ResultsMessage;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignmentManager extends JInternalFrame {
	private JLabel lblNewLabel;
	private JButton btnAdd;
	private JButton btnDelete;
	private JTextField txtSearch;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private List<Assignment> list;
	private CurrentUser cuser = new CurrentUser();
	private int i = 0;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AssignmentManager frame = new AssignmentManager();
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
	public AssignmentManager(CurrentUser cuser) {
		this.cuser = cuser;
		setBounds(0, 0, 1000, 475);

		lblNewLabel = new JLabel("Assignment Manager");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});

		txtSearch = new JTextField();
		txtSearch.setColumns(10);

		lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnDelete))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		loadListToTable();
		scrollPane.setViewportView(table);

		getContentPane().setLayout(groupLayout);

	}

	void loadListToTable() {
		list = new BaoAssignment().getAssignmentDepartment(cuser.getBranchId());
		DefaultTableModel defaultTable = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setModel(defaultTable);
		
		defaultTable.addColumn("#");
		defaultTable.addColumn("id");
		defaultTable.addColumn("Name Project");
		defaultTable.addColumn("Name Employee");
		defaultTable.addColumn("Done");
		defaultTable.addColumn("Date Join");
		i = 0;
		for (Assignment ls : list) {
			if (ls.isStatus()) {
				defaultTable.addRow(new Object[] { ++i,ls.getId(), ls.getProject_id(), ls.getEmployee_id(),
						(ls.getDone() > 0) ? "Complete" : "Executing", ls.getDatejoin() });
			}

		}

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(230);
		table.getColumnModel().getColumn(3).setPreferredWidth(230);
		table.getColumnModel().getColumn(4).setPreferredWidth(220);
		table.getColumnModel().getColumn(5).setPreferredWidth(193);
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		new AddAssignment(1, null, cuser).setVisible(true);
	}
	
	

	protected void btnDeleteActionPerformed(ActionEvent e) {

		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Select Row on table", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			ResultsMessage rm = new BaoAssignment().delete((String) table.getValueAt(row, 1));
			if(rm.getNum() > 0) {
				loadListToTable();
			 }
			 rm.showMessage(null);
		}
	}
}
