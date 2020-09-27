package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;

import bao.BaoEmployee;
import bao.BaoGetComboBox;
import bao.BaoPosition;
import bao.BaoProject;
import bao.BaoTransfer;
import entity.CurrentUser;
import entity.GetProject;
import entity.Position;
import entity.Project;
import helper.GetIndexComboID;
import modal.ComboItem;
import modal.EmployeeView;
import modal.ListComboItem;
import modal.ResultsMessage;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddDepartmentTransfer extends JFrame {

	private JPanel contentPane;
	private JButton btnload;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtDes;
	private JComboBox cbDepartment;
	private JComboBox cbEmployee;
	private JLabel lblId;
	private List<ComboItem> listCB2;
	private List<ComboItem> listCB1;
	private String id;
	private CurrentUser cuser;
	private JLabel lblNewLabel_3;
	private JTextField txtDepartmentOld;
	private JLabel lblDepartmentOld;
	private int index;
	private TransferDepartment frameTFD;
	private EmployeeManager frameEM;
	private int type;
	private int indexlist;

//	public AddDepartmentTransfer() {}
	public AddDepartmentTransfer(int type, String id, CurrentUser cuser, int index, TransferDepartment frameTFD, EmployeeManager frameEM) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.type=type;
		this.id=id;
		this.cuser=cuser;
		this.index = index;
		this.frameTFD = frameTFD;
		this.id=id;
		this.frameEM=frameEM;
		
		btnload = new JButton("Save");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		
		btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		
		lblNewLabel = new JLabel("Description");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel_1 = new JLabel("Department new");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtDepartmentOld = new JTextField();
		txtDepartmentOld.setColumns(10);
		
		lblDepartmentOld = new JLabel("Department Old");
		lblDepartmentOld.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtDes = new JTextField();
		txtDes.setColumns(10);
		
		cbDepartment = new JComboBox();
		comboBoxSetValue2();
		
		cbEmployee = new JComboBox();
		cbEmployee.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbEmployeeItemStateChanged(e);
			}
		});
		comboBoxSetValue1();
		
		lblId = new JLabel("Emp id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel_3 = new JLabel("Transfer Department");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDepartmentOld)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(6)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(cbDepartment, Alignment.LEADING, 0, 429, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addComponent(cbEmployee, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addComponent(txtDes, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
						.addComponent(txtDepartmentOld, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
					.addGap(84))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(172)
					.addComponent(btnload, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(231, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbEmployee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDepartmentOld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDepartmentOld))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnload)
						.addComponent(btnNewButton_1))
					.addGap(139))
		);
		contentPane.setLayout(gl_contentPane);
		getFirtLoad();
	}

	
	private void getFirtLoad() {
		if(type==2) {
			EmployeeView obj = new BaoEmployee().getFromId(id);
			if(obj.getId() != null) {
				cbEmployee.setSelectedIndex(indexlist);
				txtDepartmentOld.setText(obj.getDepartment_id());
			}
		}
		txtDepartmentOld.setEditable(false);
	}
	
	private void comboBoxSetValue1() {
		listCB1= new BaoGetComboBox().getList("Employee", cuser.getUsername());
		int i=0;
		for (ComboItem item :listCB1) {
			if(item.getId().equals(id))
				indexlist = i;
			cbEmployee.addItem(new ComboItem(item.getId(), item.getValue()));
			i++;
		}
	}
	
	private void comboBoxSetValue2() {
		listCB2 = new BaoGetComboBox().getList("Department", cuser.getUsername());
		for (ComboItem item :listCB2) {
			cbDepartment.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}

	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		if(
				((ComboItem) cbDepartment.getSelectedItem()).getId().equals(txtDepartmentOld.getText())
			)
				JOptionPane.showMessageDialog(this, "old value = new value");
		else {
			ResultsMessage rs =	new BaoTransfer().insertDepartmentT(id, txtDepartmentOld.getText(), ((ComboItem) cbDepartment.getSelectedItem()).getId(), txtDes.getText(), cuser.getUsername());
			if(rs.getNum() > 0 && type==2)
				frameEM.updateListFromID(index, id);
			rs.showMessage(this);
		}
	}
	protected void cbEmployeeItemStateChanged(ItemEvent e) {
		EmployeeView obj = new BaoEmployee().getFromId(((ComboItem) cbEmployee.getSelectedItem()).getId());
		txtDepartmentOld.setText(obj.getDepartment_id());
	}
}
