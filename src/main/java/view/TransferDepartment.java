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

import bao.BaoBranch;
import bao.BaoPosition;
import bao.BaoProject;
import bao.BaoTransfer;
import entity.Branch;
import entity.CurrentUser;
import entity.GetProject;
import entity.Position;
import entity.Transfer;
import entity.TransferView;
import modal.ResultsMessage;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.FocusAdapter;

public class TransferDepartment extends JInternalFrame {
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnLoad;
	private JTextField txtFilter;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JMenuItem mntmAdd;
	private JMenuItem mntmEdit;
	private JMenuItem mntmDelete;
	private JMenuItem mntmReload;
	private int i;
	private List<TransferView> list;
	private JButton btnLoadAll;
	private CurrentUser cuser = new CurrentUser();
	private JButton btnNewButton;

	public TransferDepartment(CurrentUser cuser) {
		this.cuser = cuser;
		setBounds(-15, -27, 1030, 505);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});

		btnEdit = new JButton("Accept");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditActionPerformed(e);
			}
		});

		btnDelete = new JButton("Don't accpet");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});

		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadActionPerformed(e);
			}
		});

		txtFilter = new JTextField("Search");
		txtFilter.setForeground(Color.GRAY);
		txtFilter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtFilterKeyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				txtFilterKeyReleased(e);
			}
		});
		txtFilter.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtFilterFocusGained(e);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtFilterFocusLost(e);
			}
		});
		txtFilter.setColumns(10);

		scrollPane = new JScrollPane();

		lblNewLabel = new JLabel("Tranfer Department");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		btnLoadAll = new JButton("Load All");
		btnLoadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadAllActionPerformed(e);
			}
		});
		
		btnNewButton = new JButton("ViewLog");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLoadAll, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(txtFilter, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
					.addGap(6))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLoad)
						.addComponent(btnLoadAll)
						.addComponent(btnAdd)
						.addComponent(btnEdit)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDelete)
							.addComponent(txtFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
		);

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

		
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
		for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
		    basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
		}
	}

	protected void btnLoadActionPerformed(ActionEvent e) {
		new Sys_FrameLoadTFD(this, cuser).setVisible(true);
	}

	protected void btnLoadAllActionPerformed(ActionEvent e) {
		list = new BaoTransfer().getTranferView(null, null, false, cuser.getUsername());
		loadListToTable();
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		new AddDepartmentTransfer(1, null, cuser, 0,this, null).setVisible(true);
	}

	protected void btnEditActionPerformed(ActionEvent e) {

		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Select Row on table", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int index = (Integer) table.getValueAt(row, 0) - 1;
			TransferView obj = list.get(index);
			if (obj.isStatus() == false || obj.isCheck() == true)
				JOptionPane.showMessageDialog(this, "Job transfer is checked or status id fasle!", "Error",
						JOptionPane.ERROR_MESSAGE);
			else {
				int confirm = JOptionPane
						.showConfirmDialog(this,
								"? Accept: " + list.get(index).getEmployee_name() + "\n" + obj.getDepartment_name_old()
										+ " [Go to] " + obj.getDepartment_name_new(),
								"Confirm", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					new BaoTransfer().dpTransferAccectp(list.get(index).getId(), cuser.getUsername(), true)
							.showMessage(null);
				}
			}
		}
	}

	protected void btnDeleteActionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Select Row on table", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int index = (Integer) table.getValueAt(row, 0) - 1;
			TransferView obj = list.get(index);
			if (obj.isStatus() == false || obj.isCheck() == true)
				JOptionPane.showMessageDialog(this, "Job transfer is checked or status id fasle!", "Error",
						JOptionPane.ERROR_MESSAGE);
			else {
				int confirm = JOptionPane.showConfirmDialog(
						this, "? Don't Accept: " + list.get(index).getEmployee_name() + "\n"
								+ obj.getDepartment_name_old() + " [Go to] " + obj.getDepartment_name_new(),
						"Confirm", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					new BaoTransfer().dpTransferAccectp(list.get(index).getId(), cuser.getUsername(), false)
							.showMessage(null);
				}
			}
		}
	}

	public void loadListToTable(List<TransferView> list) {
		this.list = list;
		loadListToTable();
	}

	private void loadListToTable() {
		DefaultTableModel defaultTable = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setModel(defaultTable);

		defaultTable.addColumn("#");
		defaultTable.addColumn("Employee Name");
		defaultTable.addColumn("Date");
		defaultTable.addColumn("Description");
		defaultTable.addColumn("Department old");
		defaultTable.addColumn("Department new");
		defaultTable.addColumn("Check");
		i = 0;
		
		for (TransferView obj : list) {
			if (obj.getProject_old() == null && obj.getProject_new() == null || obj.getProject_old().equals("") && obj.getProject_new().equals("")) {
				String v_Check;
				if(!obj.isStatus()==true)
					v_Check = obj.isCheck() ? "Accept" : "Don't Aceept";
				else
					v_Check = obj.isCheck() ? "Waiting" : "Don't Aceept";
				
				defaultTable.addRow(new Object[] { ++i, obj.getEmployee_name(), obj.getDate(),
						obj.getDescription(), obj.getDepartment_name_old(), obj.getDepartment_name_new(), v_Check
				});
			}
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);

	}

	public void addNewToTable(String id) {
		Position po = new BaoPosition().getFromId(id);
//    	list.add(po);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { ++i, po.getId(), po.getName(), po.getBranch_id(), po.isStatus() });
	}

	public void updateListFromID(int index, String id) {
		Position po = new BaoPosition().getFromId(id);
//		list.set(index, po);
		loadListToTable();
	}

	protected void do_txtFind(KeyEvent e, String find) {
		DefaultRowSorter sorter = (DefaultRowSorter) table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}

	protected void do_txtFind(KeyEvent e, String find, int index) {
		DefaultRowSorter sorter = (DefaultRowSorter) table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find, index));
		sorter.setSortKeys(null);
	}

	protected void txtFilterKeyReleased(KeyEvent e) {
		do_txtFind(e, txtFilter.getText());
	}

	protected void txtFilterFocusGained(FocusEvent e) {
		if (txtFilter.getText().equals("Search")) {
			txtFilter.setText("");
			txtFilter.setForeground(Color.BLACK);
			
		}
	}

	protected void txtFilterFocusLost(FocusEvent e) {
		if (txtFilter.getText().equals("")) {
			txtFilter.setText("Search");
			txtFilter.setForeground(Color.GRAY);
		}
	}

	protected void txtFilterKeyPressed(KeyEvent e) {
		do_txtFind(e, txtFilter.getText());
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		new ViewLogTransfer(cuser).setVisible(true);
	}
}
