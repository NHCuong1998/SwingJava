package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;

import bao.BaoGetComboBox;
import bao.BaoPosition;
import bao.BaoProject;
import entity.CurrentUser;
import entity.GetProject;
import entity.Position;
import entity.Project;
import helper.GetIndexComboID;
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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;

public class Sys_FrameLoadProject extends JFrame {

	private JPanel contentPane;
	private JButton btnload;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtProName;
	private JComboBox cbDepartment;
	private JLabel lblNewLabel_4;
	private JComboBox cbType;
	private JTextField txtId;
	private JLabel lblId;
	private List<ComboItem> listCB;
	private List<ComboItem> listCB2;
	private List<ComboItem> listCB3;
	private JDateChooser calDate1;
	private JLabel txt;
	private JCheckBox chkStatus;
	private ProjectManager pm;
	private JLabel lblDate;
	private JDateChooser calDate2;
	private JLabel lblNewLabel_2;
	private JComboBox cbBranch;
	private CurrentUser cuser;
	private JLabel lblNewLabel_3;

	public Sys_FrameLoadProject() {}
	public Sys_FrameLoadProject(ProjectManager pm, CurrentUser cuser) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.pm=pm;
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
		
		lblNewLabel = new JLabel("Project Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtProName = new JTextField();
		txtProName.setColumns(10);
		
		cbDepartment = new JComboBox();
		comboBoxSetValue2();
		
		lblNewLabel_4 = new JLabel("Project Type");
		
		cbType = new JComboBox();
		comboBoxSetValue();
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		lblId = new JLabel("Project Id");
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
		
		lblNewLabel_3 = new JLabel("Filter Project");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(90)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addComponent(lblDate, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
										.addGap(1))
									.addComponent(lblNewLabel))
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(57)
									.addComponent(btnload, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addGap(72)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(68)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
										.addComponent(txtProName, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
										.addComponent(cbDepartment, Alignment.TRAILING, 0, 319, Short.MAX_VALUE)
										.addComponent(cbType, Alignment.TRAILING, 0, 319, Short.MAX_VALUE)
										.addComponent(cbBranch, 0, 319, Short.MAX_VALUE)
										.addComponent(calDate1, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
										.addComponent(chkStatus)
										.addComponent(calDate2, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))))))
					.addGap(84))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtProName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(cbType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbBranch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(calDate1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(txt, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(lblDate))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(calDate2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chkStatus)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnload)
						.addComponent(btnNewButton_1))
					.addGap(43))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	private void comboBoxSetValue() {
		listCB = new BaoGetComboBox().getList("ProjectType", cuser.getUsername());
		cbType.addItem(new ComboItem(null, "Empty"));
		for (ComboItem item :listCB) {
			cbType.addItem(new ComboItem(item.getId(), item.getValue()));
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

		List<GetProject> list = new BaoProject().getAllProject(txtId.getText(), chkStatus.isSelected(), 
				((ComboItem) cbType.getSelectedItem()).getId() , ((ComboItem) cbDepartment.getSelectedItem()).getId(), 
				((ComboItem) cbBranch.getSelectedItem()).getId(), txtProName.getText(), date1, date2, cuser.getUsername());
		if(list.isEmpty()) {
			new ResultsMessage(0,"No result!").showMessage(this);
		} else {
			pm.loadListToTable(list);
			this.dispose();
		}	
	}
}
