package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.table.DefaultTableModel;

import bao.BaoGetComboBox;
import bao.BaoPosition;
import bao.BaoProject;
import bao.BaoTransfer;
import entity.CurrentUser;
import entity.GetProject;
import entity.Position;
import entity.Project;
import entity.TransferLog;
import entity.TransferView;
import helper.GetIndexComboID;
import modal.ComboItem;
import modal.ListComboItem;
import modal.ResultsMessage;

import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.FocusAdapter;

public class ViewLogTransfer extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_1;
	private List<ComboItem> listCB2;
	private CurrentUser cuser;
	private JLabel lblNewLabel_3;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtFilter;
	private JLabel lblNewLabel;

	public ViewLogTransfer(CurrentUser cuser) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 866, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.cuser=cuser;

		
		btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		
		Date now = new Date();
		Date now1 = new Date();
		now1.setDate(1);

		
		lblNewLabel_3 = new JLabel("View Log Transfer");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		scrollPane = new JScrollPane();
		
		txtFilter = new JTextField();
		txtFilter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtKeyFilter(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				txtKeyFilter(e);
			}
		});
		txtFilter.setText("");
		txtFilter.setColumns(10);
		
		lblNewLabel = new JLabel("Search");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(txtFilter, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(txtFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
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
		defaultTable.addColumn("Description");
		defaultTable.addColumn("Department old");
		defaultTable.addColumn("Department new");
		defaultTable.addColumn("Date");
		defaultTable.addColumn("UserCheck");
		defaultTable.addColumn("Check");
		defaultTable.addColumn("Part");
		
		int i = 0;
		
		List<TransferLog> listTF = new BaoTransfer().getTransferLog(cuser.getUsername());
		
		for (TransferLog obj : listTF) {
				defaultTable.addRow(new Object[] { ++i, obj.getEmployee_id(), obj.getDescription(), obj.getOld(), obj.getNewname(), obj.getDate(),
						obj.getUserCheck(),obj.getCheck() ? "Accept" : "Don't Accept", obj.getPart()
				});
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(50);
	}
	
	protected void do_txtFind(KeyEvent e, String find) {
		DefaultRowSorter sorter = (DefaultRowSorter) table.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}

	protected void txtKeyFilter(KeyEvent e) {
		do_txtFind(e, txtFilter.getText());
	}
	
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		this.dispose();
	}
}
