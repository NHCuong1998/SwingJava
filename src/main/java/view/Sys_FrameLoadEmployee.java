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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;

public class Sys_FrameLoadEmployee extends JFrame {

	private JPanel contentPane;
	private JButton btnload;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtName;
	private JComboBox cbDepartment;
	private JLabel lblNewLabel_4;
	private JComboBox cbPosition;
	private JTextField txtId;
	private JLabel lblId;
	private List<ComboItem> listCB;
	private List<ComboItem> listCB2;
	private List<ComboItem> listCB3;
	private JDateChooser calDate1;
	private JLabel txt;
	private JCheckBox chkStatus;
	private EmployeeManager em;
	private JLabel lblDate;
	private JDateChooser calDate2;
	private JLabel lblNewLabel_2;
	private JComboBox cbBranch;
	private JTextField txtEducation;
	private JLabel lblEducation;
	private JLabel lblSpeciallize;
	private JTextField txtSpecial;
	private CurrentUser cuser;
	private JLabel lblNewLabel_3;

	public Sys_FrameLoadEmployee(){}
	public Sys_FrameLoadEmployee(EmployeeManager em, CurrentUser cuser) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.em=em;
		this.cuser=cuser;
		btnload = new JButton("Load");
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
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		cbDepartment = new JComboBox();
		comboBoxSetValue2();
		
		lblNewLabel_4 = new JLabel("Position");
		
		cbPosition = new JComboBox();
		comboBoxSetValue();
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		Date now = new Date();
		Date now1 = new Date();
		now1.setDate(1);
		
		calDate1 = new JDateChooser();
		calDate1.setDateFormatString("yyyy-MM-dd");
		calDate1.setDate(now1);
		
		txt = new JLabel("Date 1");
		txt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		chkStatus = new JCheckBox("Get status is false");
//		chkStatus.setVisible(false);
		
		lblDate = new JLabel("Date 2");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		calDate2 = new JDateChooser();
		calDate2.setDateFormatString("yyyy-MM-dd");
		calDate2.setDate(now);
		
		lblNewLabel_2 = new JLabel("Branch");
		
		cbBranch = new JComboBox();
		comboBoxSetValue3();
		
		txtEducation = new JTextField();
		txtEducation.setColumns(10);
		
		lblEducation = new JLabel("Education");
		lblEducation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblSpeciallize = new JLabel("Speciallize");
		lblSpeciallize.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtSpecial = new JTextField();
		txtSpecial.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Filter Employee");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(90)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4)
								.addComponent(lblEducation, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSpeciallize, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnload, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
									.addGap(69)
									.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
									.addGap(82))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(chkStatus, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
									.addGap(161))
								.addComponent(txtSpecial, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
								.addComponent(txtEducation, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
								.addComponent(cbBranch, 0, 338, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(calDate2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
										.addComponent(calDate1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
									.addGap(28))
								.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
								.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
								.addComponent(cbDepartment, 0, 338, Short.MAX_VALUE)
								.addComponent(cbPosition, 0, 338, Short.MAX_VALUE))))
					.addGap(54))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_3)
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cbBranch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbPosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4))
							.addGap(23)
							.addComponent(calDate1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(calDate2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtEducation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEducation)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addComponent(lblNewLabel_1)))
							.addGap(68)
							.addComponent(txt, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDate)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtSpecial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chkStatus))
						.addComponent(lblSpeciallize))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnload)
						.addComponent(btnNewButton_1))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	private void comboBoxSetValue() {
		listCB = new BaoGetComboBox().getList("ProjectType", cuser.getUsername());
		cbPosition.addItem(new ComboItem(null, "Empty"));
		for (ComboItem item :listCB) {
			cbPosition.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}
	
	private void comboBoxSetValue2() {
		listCB2 = new BaoGetComboBox().getList("Department", cuser.getUsername());
		cbDepartment.addItem(new ComboItem(null, "Empty"));
		for (ComboItem item :listCB2) {
			cbDepartment.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}
	
	private void comboBoxSetValue3() {
		listCB3 = new BaoGetComboBox().getList("Branch", cuser.getUsername());
		cbBranch.addItem(new ComboItem(null, "Empty"));
		for (ComboItem item :listCB3) {
			cbBranch.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}
	
	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		LocalDate date1 = calDate1.getDate() == null ? null : calDate1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate date2 = calDate2.getDate() == null ? null : calDate2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		List<EmployeeView> list = new BaoEmployee()
			.getFormLoad(txtId.getText(), txtName.getText(), chkStatus.isSelected(), date1, date2, txtEducation.getText(), txtSpecial.getText(), 
				((ComboItem) cbPosition.getSelectedItem()).getId() ,
				((ComboItem) cbDepartment.getSelectedItem()).getId(), 
				((ComboItem) cbBranch.getSelectedItem()).getId(),
				cuser.getUsername());
		
		if(list.isEmpty()) {
			new ResultsMessage(0,"No result!").showMessage(this);
		} else {
			em.loadListToTableFromList(list);
			this.dispose();
		}	
	}
}
