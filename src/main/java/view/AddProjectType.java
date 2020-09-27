package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bao.BaoBranch;
import bao.BaoProject_type;
import bao.BaoSystemInfo;
import entity.Branch;
import entity.CurrentUser;
import entity.Project_type;
import helper.SetTileFrame;
import modal.ResultsMessage;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class AddProjectType extends JFrame {

	private JPanel contentPane;
	private JLabel lblID;
	private JTextField txtId;
	private JLabel lblName;
	private JTextField txtName;
	private JButton btnSave;
	private JButton btnCancel;
	private JLabel lblTitle;
	private int type;
	private String id;
	private CurrentUser cuser;
	private ProjectTypeManager pt;
	private int index;
	private JCheckBox chkStatus;

	public AddProjectType(int type, String id, ProjectTypeManager pt, int index, CurrentUser cuser) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.id=id;
		this.type=type;
		this.cuser=cuser;
		this.pt=pt;
		this.index = index;
		lblID = new JLabel("Type ID");
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		lblName = new JLabel("Type Name");
		
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
				btnCancelActionPerformed(e);
			}
		});
		
		lblTitle = new JLabel(SetTileFrame.getTitle(this.type, "Project Type"));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setForeground(Color.BLUE);
		
		chkStatus = new JCheckBox("Status");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblID))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(chkStatus)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblTitle, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(13)
								.addComponent(btnSave)
								.addGap(33)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addComponent(txtId)
							.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblID))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblName))
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chkStatus)
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnSave))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		firstLoad();
	}
	
	protected void firstLoad() {
		if(this.type==2) {
			Project_type pType = new BaoProject_type().getfromId(id);
			if(pType.getId() != null) {
				txtId.setText(pType.getId());
				txtName.setText(pType.getName());
				chkStatus.setSelected(pType.isStatus());
				chkStatus.setVisible(true);
				txtId.setEditable(false);
				this.setVisible(true);
			}
		}else
			this.setVisible(true);
	}
		
	protected void do_btnSave_actionPerformed(ActionEvent e) {
		if(!checkInput())
			return;
		if(type == 1) {
			ResultsMessage rm = new BaoProject_type().insert(new Project_type(txtId.getText(), txtName.getText(), true));
			if(rm.getNum()>0)
				pt.addToTable(txtId.getText());
			rm.showMessage(this);
		} else {
			ResultsMessage rm = new BaoProject_type().update(new Project_type(txtId.getText(), txtName.getText(), chkStatus.isSelected()));
			if(rm.getNum()>0)
				pt.updateListNonDB(index, txtId.getText());
			rm.showMessage(this);
		}
			
	}
	
	private boolean checkInput() {
		String error ="";
		error += new BaoSystemInfo().getSysRegex("id","Id" ,txtId.getText());
		error += new BaoSystemInfo().getSysRegex("name","Name", txtName.getText());
		
		if(!error.equals(""))
			new ResultsMessage(-1,error).showMessage(this);
			
		return error.equals("") ? true : false;
		// return false -- if error
	}
	protected void btnCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}
}
