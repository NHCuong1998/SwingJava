package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bao.BaoBranch;
import bao.BaoDepartment;
import bao.BaoGetComboBox;
import bao.BaoPosition;
import bao.BaoSystemInfo;
import entity.Branch;
import entity.CurrentUser;
import entity.Department;
import entity.Position;
import helper.GetArrayIndexJList;
import helper.GetIndexComboID;
import helper.SetTileFrame;
import modal.ComboItem;
import modal.ResultsMessage;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AddTransferDepartment extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtId;
	private JLabel lblBranchName;
	private JTextField txtName;
	private JButton btnSave;
	private JButton btnCancel;
	private int type;
	private JLabel lblTitle;
	private String id;
	private JCheckBox chckStatus;
	private JScrollPane scrlDepartment;
	private JList listDM;
	private List<ComboItem> listCB;
	private List<Department> listDepartment; 
	private JComboBox cbBranch;
	private JCheckBox chkBranchAdmin;
	private JCheckBox chkDepartmentAdmin;
	private JLabel lblBranchId;
	private JLabel lblListDepartment;
	private boolean userIsAdmin;
	private CurrentUser cuser;
	private int index;
	PositionManager framePm;
	private int maxDepartment;
	
//	public AddPosition(int type, String id, CurrentUser cuser, int index, PositionManager framePm) {}
	public AddTransferDepartment(int type, String id, CurrentUser cuser, int index, PositionManager framePm) {
		this.type =type;
		this.id = id;
		this.cuser = cuser;
		this.index=index;
		this.framePm = framePm;
		this.maxDepartment = BaoSystemInfo.get("max_department");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 559, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("Position ID");
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		lblBranchName = new JLabel("Position Name");
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSave_actionPerformed(e);
			}
		});
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		
		lblTitle = new JLabel(SetTileFrame.getTitle(this.type, "Position"));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setForeground(Color.BLUE);
		
		chckStatus = new JCheckBox("Status");
		chckStatus.setVisible(false);
		
		
		listDM = new JList(new DefaultListModel());
	
		scrlDepartment = new JScrollPane(listDM);
		scrlDepartment.setEnabled(false);
		
		cbBranch = new JComboBox();
		cbBranch.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbBranchItemStateChanged(e);
			}
		});

		
		chkBranchAdmin = new JCheckBox("Admin Branch");

		chkDepartmentAdmin = new JCheckBox("Admin Department");
		chkDepartmentAdmin.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				chkDepartmentAdminItemStateChanged(e);
			}
		});
		
		lblBranchId = new JLabel("Branch ID");
		
		lblListDepartment = new JLabel("List  Department");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(114)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
					.addGap(17))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBranchName)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblBranchId)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cbBranch, 0, 417, Short.MAX_VALUE)
								.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
								.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(119)
							.addComponent(btnSave)
							.addGap(95)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblListDepartment, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addComponent(chkBranchAdmin)
							.addGap(18)
							.addComponent(chkDepartmentAdmin)
							.addGap(49)
							.addComponent(chckStatus, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(scrlDepartment, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(lblTitle)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBranchName))
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbBranch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblBranchId)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(chkDepartmentAdmin)
							.addComponent(chckStatus))
						.addComponent(chkBranchAdmin))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblListDepartment)
					.addGap(3)
					.addComponent(scrlDepartment, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnCancel))
					.addGap(16))
		);
		
		contentPane.setLayout(gl_contentPane);
		firstLoad();
	}
	
	
	protected void firstLoad() {
		comboBoxSetValue();
		
		if(this.type==2) {
			loadFrameWhenEdit();
		}else {
			this.setVisible(true);
		}
		
		if(!cuser.isAdmin())
			hideBranch();
	}
	
	protected void loadFrameWhenEdit() {
		Position pos = new BaoPosition().getFromId(id);
		if(pos.getId() != null) {
			txtId.setText(pos.getId());
			txtName.setText(pos.getName());
			comboBoxSetSelectItem(pos.getBranch_id());
			chckStatus.setSelected(pos.isStatus());
			chkBranchAdmin.setSelected(pos.getListBranch() != null ? true : false);
			chkDepartmentAdmin.setSelected(pos.getListDepartment() != null ? true : false);
			chckStatus.setVisible(true);
			txtId.setEditable(false);
			
			if(pos.getListDepartment() != null) {
				listDM.setSelectedIndices(GetArrayIndexJList.get(pos.getListDepartment(), listDepartment));
			}
			
			this.setVisible(true);
		}else 
			new ResultsMessage(-1, "["+id+"] - is not exits!").showMessage(this);
	}
	
	@SuppressWarnings("unchecked")
	public void comboBoxSetValue() {
		listCB = new BaoGetComboBox().getList("Branch", cuser.getUsername());
		for (ComboItem item :listCB) {
			cbBranch.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}
	
	public void comboBoxSetSelectItem(String id) {
		int index = GetIndexComboID.getIndex(listCB, id);
		if(index > -1) {
			cbBranch.setSelectedIndex(index);
		}
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setListDMLoad(String branch_id) {
		listDepartment = new BaoDepartment().getFromBranch(branch_id);
		DefaultListModel defaultDM = new DefaultListModel();
		
		for (Department department : listDepartment) {
			defaultDM.addElement(department);
		}
		listDM = new JList(defaultDM);
		scrlDepartment.setViewportView(listDM);
	}
	
	protected void cbBranchItemStateChanged(ItemEvent e) {
		if(!chkDepartmentAdmin.isSelected()) return;
		setListDMLoad(((ComboItem)cbBranch.getSelectedItem()).getId());
	}
	
	private String getSelectListToId() {
		String strID ="";
		if(listDM.getSelectedIndex() != -1) {
			int[] selectedIx = listDM.getSelectedIndices();
			System.out.println(selectedIx.length +"="+ maxDepartment);
			if(selectedIx.length <= maxDepartment && selectedIx.length >= 1) {
				for (int i = 0; i < selectedIx.length; i++) {
					strID += "," + listDepartment.get(selectedIx[i]).getId();
				}
			}
		}
		return strID;
	}
	
	private void hideBranch() {
		if(!userIsAdmin) {
			chkBranchAdmin.setVisible(false);
			cbBranch.setVisible(false);
			lblBranchId.setVisible(false);
		}
	}
	
	protected void do_btnSave_actionPerformed(ActionEvent e) {
		if(!checkInput())
			return;
		String branch_id = chkBranchAdmin.isSelected() ?  ((ComboItem)cbBranch.getSelectedItem()).getId() : null;
		String listDepartment = null;
		if(chkDepartmentAdmin.isSelected()) {
			String listId = getSelectListToId();
			if(!listId.equals("")) {
				listDepartment=listId;
			}else {
				JOptionPane.showMessageDialog(this, "Max list Department: " + maxDepartment + " And List > 0");;
				return;
			}
		}
		if(type == 1) {
			ResultsMessage rm = new BaoPosition().insert(new Position(txtId.getText(), txtName.getText(), true, branch_id, listDepartment,((ComboItem)cbBranch.getSelectedItem()).getId()));
			if(rm.getNum()>0)
				framePm.addNewToTable(txtId.getText());
			rm.showMessage(this);
		}else {
			ResultsMessage rm = new BaoPosition().update(new Position(txtId.getText(), txtName.getText(), chckStatus.isSelected(),branch_id, listDepartment,((ComboItem)cbBranch.getSelectedItem()).getId()));
			if(rm.getNum()>0)
				framePm.updateListFromID(index, txtId.getText());
			rm.showMessage(this);
		}
	}
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void chkDepartmentAdminItemStateChanged(ItemEvent e) {
		if(chkDepartmentAdmin.isSelected()) {
			setListDMLoad(((ComboItem)cbBranch.getSelectedItem()).getId());
		}else {
			listDepartment.clear();
			scrlDepartment.setViewportView(new JList(new DefaultListModel()));
		}
	}
	
	protected void listDMValueChanged(ListSelectionEvent e) {
		if(listDM.getSelectedIndex() != -1) {
			int[] selectedIx = listDM.getSelectedIndices();
			System.out.println(selectedIx.length);
			if(selectedIx.length > maxDepartment || selectedIx.length < 1) {
				JOptionPane.showMessageDialog(this, "List Department >= 1 and <= " + maxDepartment);
				btnSave.setVisible(false);
			} else {
				btnSave.setVisible(true);
			}
		}
	}
	
	private boolean checkInput() {
		String error ="";
		error += new BaoSystemInfo().getSysRegex("id", "Id", txtId.getText());
		error += new BaoSystemInfo().getSysRegex("name", "Name", txtName.getText());
		
		if(!error.equals(""))
			new ResultsMessage(-1,error).showMessage(this);
			
		return error.equals("") ? true : false;
		// return false -- if error
	}

}