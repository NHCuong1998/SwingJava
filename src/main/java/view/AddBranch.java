package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bao.BaoBranch;
import bao.BaoSystemInfo;
import entity.Branch;
import entity.SystemRegex;
import helper.SetTileFrame;
import modal.ResultsMessage;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.zip.CheckedInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class AddBranch extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtId;
	private JLabel lblBranchName;
	private JTextField txtName;
	private JButton btnSave;
	private JButton btnCancel;
	private BranchManager bm;
	private AddDepartment frameDepa;
	private int type;
	private JCheckBox chkStatus;
	private JLabel lblTitle;
	private String id;
	private int index;

	public AddBranch(int type, String id, AddDepartment fm, BranchManager bm, int index) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.frameDepa=fm;
		this.type = type;
		this.id=id;
		this.bm=bm;
		this.index=index;
		
		lblNewLabel = new JLabel("Branch ID");
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		lblBranchName = new JLabel("Branch Name");
		
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
		
		chkStatus = new JCheckBox("Status");
		chkStatus.setVisible(false);
		
		lblTitle = new JLabel(SetTileFrame.getTitle(this.type, "Branch"));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setForeground(Color.BLUE);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBranchName)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
									.addGap(42)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE)
									.addGap(120))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(chkStatus)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(txtId)
											.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))
									.addGap(36))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBranchName))
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chkStatus)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnSave))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		firstLoad();
		
	}
	
	protected void firstLoad() {
		if(this.type==2) {
			Branch branch = new BaoBranch().getFromId(id);
			if(branch.getId() != null) {
				txtId.setText(branch.getId());
				txtName.setText(branch.getName());
				chkStatus.setSelected(branch.getStatus());
				chkStatus.setVisible(true);
				txtId.setEditable(false);
				this.setVisible(true);
			}
		}else
			this.setVisible(true);
	}
	
	private boolean checkInput() {
		String error ="";
		
		error += new BaoSystemInfo().getSysRegex("id", "Id ", txtId.getText());
		error += new BaoSystemInfo().getSysRegex("name", "Name ", txtName.getText());
	
		if(!error.equals(""))
			new ResultsMessage(-1,error).showMessage(this);
			
		return error.equals("") ? true : false;
		// return false -- if error
	}
	
	protected void do_btnSave_actionPerformed(ActionEvent e) {
		if(!checkInput())
			return;
		
		if(type==1 && frameDepa != null) {
			Branch branch = new Branch(txtId.getText(),txtName.getText(), true);
			ResultsMessage rs = new BaoBranch().insert(branch);
			if(rs.getNum() > 0 ) {
				frameDepa.comboBoxRemoveItem();
				frameDepa.comboBoxSetValue();
				frameDepa.comboBoxSelectItem(txtId.getText());
			}
			rs.showMessage(this);
		} else if(type==1 && frameDepa == null) {
			Branch branch = new Branch(txtId.getText(),txtName.getText(), true);
			ResultsMessage rsm =  new BaoBranch().insert(branch);
			if(rsm.getNum() > 0)
				bm.addBranchToTable(branch.getId());
			rsm.showMessage(this);
		} else {
			Branch branch = new Branch(txtId.getText(),txtName.getText(), chkStatus.isSelected());
			ResultsMessage rsm =  new BaoBranch().update(branch);
			if(rsm.getNum() > 0)
				bm.updateListNonDB(index, id);
			rsm.showMessage(this);
		}
		
	}
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
