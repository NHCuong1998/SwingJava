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

import bao.BaoAssignment;
import bao.BaoBranch;
import bao.BaoPosition;
import bao.BaoProject;
import bao.BaoTransfer;
import entity.Branch;
import entity.CurrentUser;
import entity.GetProject;
import entity.Position;
import entity.Transfer1;
import entity.Transfer;
import modal.ResultsMessage;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransferManager extends JInternalFrame {
	private JButton btnAdd;
	private JButton btnDelete;
	private JTextField txtSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAccept;
	private JButton btnRefuse;
	private JLabel lblNewLabel;
	private List<Transfer> list;
	private int i = 0;
	private CurrentUser cuser = new CurrentUser();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TransferManager frame = new TransferManager();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			
//		});
//	}

	/**
	 * Create the frame.
	 */

	public TransferManager(CurrentUser cuser) {

		this.cuser = cuser;
		setBounds(-5, -27, 1015, 504);

		btnAdd = new JButton("Add Transfer");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});

		btnDelete = new JButton("Delete Transfer");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});

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
				txtSearchFocusGained(e);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtSearchFocusLost(e);
			}
		});
		txtSearch.setColumns(10);

		scrollPane = new JScrollPane();

		btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAcceptActionPerformed(e);
			}
		});

		btnRefuse = new JButton("Refuse");
		btnRefuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefuseActionPerformed(e);
			}
		});

		lblNewLabel = new JLabel("Transfer Manager");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnAccept, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnRefuse, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 979, GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(17)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd).addComponent(btnDelete).addComponent(btnAccept)
								.addComponent(btnRefuse))
						.addGap(15).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		loadListToTable();
		getContentPane().setLayout(groupLayout);
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
		for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
		}
		if(cuser.getUsername().equals("admin")) {
			btnAccept.setVisible(false);
			btnRefuse.setVisible(false);
		}
	}
	

	private void loadListToTable() {
		list = new BaoTransfer().getTranfer(null, cuser.getBranchId());
		DefaultTableModel defaultTable = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		table.setModel(defaultTable);

		defaultTable.addColumn("ID");
		defaultTable.addColumn("Name User");
		defaultTable.addColumn("Old Project");
		defaultTable.addColumn("New Project");
		defaultTable.addColumn("Description");
		defaultTable.addColumn("Date");
		defaultTable.addColumn("Censorship");
		i = 0;
		for (Transfer ls : list) {
			if (cuser.getListBranch() != null) {
				if (ls.getDepartment_new() == null && ls.getDepartment_old() == null
						|| ls.getDepartment_new().equals("") && ls.getDepartment_old().equals("")) {
					if (ls.isStatus()) {
						if (ls.getPart() > 0) {
							defaultTable.addRow(
									new Object[] { ++i, ls.getEmp_id(), ls.getProject_old(), ls.getProject_new(),
											ls.getDescription(), ls.getDate(), ls.isCheck() ? "Accept" : "Refuse" });
						} else if (ls.getPart() == 1 && ls.isCheck() == false) {
							defaultTable.addRow(new Object[] { ++i, ls.getEmp_id(), ls.getProject_old(),
									ls.getProject_new(), ls.getDescription(), ls.getDate(), "Waiting for approval" });
						}
					}
				}
			}else {
				if (ls.getDepartment_new() == null && ls.getDepartment_old() == null
						|| ls.getDepartment_new().equals("") && ls.getDepartment_old().equals("")) {
					if (ls.isStatus()) {
						if (ls.getPart() > 0) {
							defaultTable.addRow(
									new Object[] { ++i, ls.getEmp_id(), ls.getProject_old(), ls.getProject_new(),
											ls.getDescription(), ls.getDate(), ls.isCheck() ? "Accept" : "Refuse" });
						} else if (ls.getPart() == 0 && ls.isCheck() == false) {
							defaultTable.addRow(new Object[] { ++i, ls.getEmp_id(), ls.getProject_old(),
									ls.getProject_new(), ls.getDescription(), ls.getDate(), "Waiting for approval" });
						}
					}
				}
			}

		}

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(190);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(118);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
	}


	public void addNewToTable(String id, String oldProject, String newProject) {
		Transfer transfer = new BaoTransfer().loadTableTransfer(id, oldProject, newProject);
		list.add(transfer);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { transfer.getId(), transfer.getEmp_id(), transfer.getProject_old(),
				transfer.getProject_new(), transfer.getDescription(), transfer.getDate(),
				transfer.isCheck() ? "Accept" : "Refuse" });
		loadListToTable();
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		new AddTransfer(cuser).setVisible(true);
	}

	protected void txtSearchFocusGained(FocusEvent e) {
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

	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String str = (String) table.getValueAt(row, 6);
		if (str.equals("Waiting for approval")) {
			btnAccept.setVisible(true);
			btnRefuse.setVisible(true);
		} else {
			btnAccept.setVisible(false);
			btnRefuse.setVisible(false);
		}
	}

	protected void btnAcceptActionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Select Row on table", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (table.getValueAt(row, 6).equals("Accept") || table.getValueAt(row, 6).equals("Refuse")) {
			JOptionPane.showMessageDialog(this, "Transfer is has review", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			ResultsMessage rm = new BaoTransfer().censorship((String) table.getValueAt(row, 0), 1, cuser.getUsername(),
					(String) table.getValueAt(row, 2), (String) table.getValueAt(row, 3));
			if (rm.getNum() > 0) {
				loadListToTable();
			}
			rm.showMessage(null);
		}

	}

	protected void btnRefuseActionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Select Row on table", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (table.getValueAt(row, 6).equals("Accept") || table.getValueAt(row, 6).equals("Refuse")) {
			JOptionPane.showMessageDialog(this, "Transfer is has review", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			ResultsMessage rm = new BaoTransfer().censorship((String) table.getValueAt(row, 0), 0, cuser.getUsername(),
					(String) table.getValueAt(row, 2), (String) table.getValueAt(row, 3));
			if (rm.getNum() > 0) {
				loadListToTable();
			}
			rm.showMessage(null);
		}

	}

	protected void btnDeleteActionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (table.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(this, "Select Row on table", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			ResultsMessage rm = new BaoTransfer().delete_project((String) table.getValueAt(row, 0));
			if (rm.getNum() > 0) {
				loadListToTable();
			}
			rm.showMessage(null);
		}

	}

	public void reLoadTable() {
		table.removeAll();
		loadListToTable();
	}
}
