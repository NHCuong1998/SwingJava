package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bao.BaoGetComboBox;
import bao.BaoPosition;
import bao.BaoProject;
import bao.BaoSystemInfo;
import entity.CurrentUser;
import entity.GetProject;
import entity.Position;
import entity.Project;
import helper.GetIndexComboID;
import helper.SetTileFrame;
import modal.ComboItem;
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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import java.awt.Color;

public class AddProject extends JFrame {

	private JPanel contentPane;
	private JButton btnSave;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtName;
	private JComboBox cbDepartment;
	private JScrollPane scrollPane;
	private JTextPane txtDescription;
	private JLabel Part;
	private JLabel lblNewLabel_4;
	private JTextField txtAddPart;
	private JComboBox cbType;
	private JTextField txtId;
	private JLabel lblId;
	private List<ComboItem> listCB;
	private List<ComboItem> listCB2;
	private JDateChooser calDate;
	private JLabel txt;
	private int type;
	private String id;
	private JCheckBox chkStatus;
	private ProjectManager pm;
	private int indexParent;
	private JLabel lblTitle;
	private CurrentUser cuser;

	public AddProject(int type, String id, ProjectManager pm, int indexParent, CurrentUser cuser) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.type=type;
		this.id=id;
		this.pm=pm;
		this.indexParent=indexParent;
		this.cuser=cuser;
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
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
		
		lblNewLabel = new JLabel("Name Project");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		cbDepartment = new JComboBox();
		comboBoxSetValue2();
		
		scrollPane = new JScrollPane();
		
		Part = new JLabel("Part");
		Part.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel_4 = new JLabel("Project Type");
		
		txtAddPart = new JTextField();
		txtAddPart.setColumns(10);
		
		cbType = new JComboBox();
		comboBoxSetValue();
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		calDate = new JDateChooser();
		calDate.setDateFormatString("yyyy-MM-dd");
		calDate.setDate(new Date());
		
		txt = new JLabel("Date");
		txt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		chkStatus = new JCheckBox("Status");
		chkStatus.setVisible(false);
		
		lblTitle = new JLabel(SetTileFrame.getTitle(this.type, "Project"));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setForeground(Color.BLUE);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(210)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(172, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(144, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Part)
							.addGap(295))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(255))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(251))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel)
									.addComponent(txt, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
								.addComponent(lblNewLabel_4))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cbType, 0, 374, Short.MAX_VALUE)
								.addComponent(txtAddPart, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
								.addComponent(cbDepartment, 0, 374, Short.MAX_VALUE)
								.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
								.addComponent(calDate, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
								.addComponent(chkStatus)
								.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))))
					.addGap(68))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(cbDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Part)
						.addComponent(txtAddPart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(cbType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(calDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chkStatus)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnNewButton_1))
					.addGap(144))
		);
		
		txtDescription = new JTextPane();
		scrollPane.setViewportView(txtDescription);
		contentPane.setLayout(gl_contentPane);
		
		if(this.type!= 1) {
			loadFrameWhenEdit();
		}else {
			txtAddPart.setText("0");
			txtAddPart.setEditable(false);
			this.setVisible(true);
		}
	}
	
	private void comboBoxSetValue() {
		listCB = new BaoGetComboBox().getList("ProjectType", cuser.getUsername());
		for (ComboItem item :listCB) {
			cbType.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}
	
	private void comboBoxSetValue2() {
		listCB2 = new BaoGetComboBox().getList("Department", cuser.getUsername());
		for (ComboItem item :listCB2) {
			cbDepartment.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}
	
	protected void loadFrameWhenEdit() {
		Project pro = new BaoProject().getFromID(id);
		if(pro.getId() != null) {
			txtId.setText(pro.getId());
			txtName.setText(pro.getName());
			cbDepartment.setSelectedIndex(new ListComboItem(listCB2).findIdToIndex(pro.getDepartment_id()));
			txtDescription.setText(pro.getDescription());
			txtAddPart.setText(String.valueOf(pro.getPart()));
			cbType.setSelectedIndex(new ListComboItem(listCB).findIdToIndex(pro.getProject_type_id()));
			chkStatus.setSelected(pro.isStatus());
			txtId.setEditable(false);
			this.setVisible(true);
			
			if(type==3) {
				setVisibleFrame(false);
				btnSave.setText("Edit");
			}else {
				setVisibleFrame(true);
			}
		}
		
	}

	private void setVisibleFrame(boolean bool) {
		txtId.setEditable(false);
		txtName.setEnabled(bool);
		cbDepartment.setEnabled(bool);
		txtDescription.setEnabled(bool);
		txtAddPart.setEnabled(bool);
		cbType.setEnabled(bool);
		calDate.setEnabled(bool);
		chkStatus.setVisible(true);
		chkStatus.setEnabled(bool);
	}
	
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		LocalDate date = calDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(type==3) {
			setVisibleFrame(true);
			btnSave.setText("Save");
			type=2;
		}else if(type == 1) {
			if(!checkInput())
				return;
			ResultsMessage rm = new BaoProject().insert(new Project(txtId.getText(), txtName.getText(), ((ComboItem) cbDepartment.getSelectedItem()).getId(),
					txtDescription.getText(),Integer.parseInt(txtAddPart.getText()), ((ComboItem) cbType.getSelectedItem()).getId(), date, true));
			if(rm.getNum()>0) {
				pm.addProjectToTable(txtId.getText());
			}
			rm.showMessage(this);
		}else {
			if(!checkInput())
				return;
			ResultsMessage rm = new BaoProject().update(new Project(txtId.getText(), txtName.getText(), ((ComboItem) cbDepartment.getSelectedItem()).getId(),
					txtDescription.getText(),Integer.parseInt(txtAddPart.getText()), ((ComboItem) cbType.getSelectedItem()).getId(), date, chkStatus.isSelected()));
			if(rm.getNum()>0) {
				pm.updateListNonDB(indexParent, id);
			}
			rm.showMessage(this);
		}
	}
	
	private boolean checkInput() {
		String error ="";
		error += new BaoSystemInfo().getSysRegex("id", "Id",txtId.getText());
		error += new BaoSystemInfo().getSysRegex("name", "Name", txtName.getText());
//		error += txtDescription.getText().equals("") ? "" : new BaoSystemInfo().getSysRegex("name","Description", txtDescription.getText());
		
		if(!error.equals(""))
			new ResultsMessage(-1,error).showMessage(this);
			
		return error.equals("") ? true : false;
		// return false -- if error
	}
	
}
