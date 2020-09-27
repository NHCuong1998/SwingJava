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
import bao.BaoTransfer;
import entity.AssignmentUser;
import entity.CurrentUser;
import entity.Transfer1;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserMyJob extends JInternalFrame {
	private JLabel lblNewLabel;
	private List<AssignmentUser> list;
	private int i = 0;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private CurrentUser cuser;

	public UserMyJob(CurrentUser cuser) {
		this.cuser=cuser;
		setBounds(0, 0, 900, 430);

		lblNewLabel = new JLabel("My Job");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));

		panel = new JPanel();

		lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				textFieldKeyReleased(e);
			}
		});
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldFocusGained(e);
			}
			@Override
			public void focusLost(FocusEvent e) {
				textFieldFocusLost(e);
			}
		});
		textField.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addGap(10)
												.addComponent(lblNewLabel_1)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 230,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(panel, GroupLayout.DEFAULT_SIZE, 864,
																Short.MAX_VALUE)
														.addGap(10))
												.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 874,
														Short.MAX_VALUE)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(17).addComponent(panel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));

		scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		// Load table tranfer
		loadListTable();

		getContentPane().setLayout(groupLayout);
		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
//		for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
//			basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
//		}
	}

	private void loadListTable() {
		list = new BaoAssignment().getAssignmentUser(cuser.getUsername());
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
		defaultTable.addColumn("Date Join");
		defaultTable.addColumn("Done");
		i = 0;
		for (AssignmentUser ls : list) {
			String str = "";
			int check = ls.getDone();
			if (check <= 0) {
				str = "Complete";
			}else if(check > 0) {
				str = "Executing";
			}

			defaultTable.addRow(new Object[] { ++i, ls.getId(), ls.getName_project(), ls.getDatejoin(),str
			});

		}

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(225);
	}
	protected void textFieldFocusGained(FocusEvent e) {
		if (textField.getText().equals("Search")) {
			textField.setText("");
			textField.setForeground(Color.BLACK);
        }
	}
	protected void textFieldFocusLost(FocusEvent e) {
		if (textField.getText().equals("")) {
			textField.setText("Search");
			textField.setForeground(Color.GRAY);
        }
	}
	
	protected void do_txtFind(KeyEvent e, String find) {
		DefaultRowSorter sorter =(DefaultRowSorter) table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	protected void textFieldKeyReleased(KeyEvent e) {
		do_txtFind(e, textField.getText());
	}
}
