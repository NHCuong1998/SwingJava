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
import bao.BaoTransfer;
import entity.CurrentUser;
import entity.GetProject;
import entity.Position;
import entity.Project;
import entity.TransferView;
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

public class Sys_FrameLoadTFD extends JFrame {

	private JPanel contentPane;
	private JButton btnload;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JComboBox cbDepartment;
	private JTextField txtId;
	private JLabel lblId;
	private List<ComboItem> listCB2;
	private JCheckBox chkStatus;
	private TransferDepartment tf;
	private CurrentUser cuser;
	private JLabel lblNewLabel_3;

	public Sys_FrameLoadTFD(TransferDepartment tf, CurrentUser cuser) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.tf=tf;
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
		
		lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cbDepartment = new JComboBox();
		comboBoxSetValue2();

		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		lblId = new JLabel("Id or Name Emp");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		Date now = new Date();
		Date now1 = new Date();
		now1.setDate(1);
		
		chkStatus = new JCheckBox("Get done!");

		
		lblNewLabel_3 = new JLabel("Department Transfer");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(btnload, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(299, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chkStatus)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(6)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(cbDepartment, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(cbDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chkStatus)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnload)
						.addComponent(btnNewButton_1))
					.addGap(207))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	private void comboBoxSetValue2() {
		listCB2 = new BaoGetComboBox().getList("Department", cuser.getUsername());
		cbDepartment.addItem(new ComboItem(null, "Empty"));
		for (ComboItem item :listCB2) {
			cbDepartment.addItem(new ComboItem(item.getId(), item.getValue()));
		}
	}

	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		
		List<TransferView> list = new BaoTransfer().getTranferView(txtId.getText(), 
				((ComboItem) cbDepartment.getSelectedItem()).getId(), 
				chkStatus.isSelected(), cuser.getUsername());
		if(list.isEmpty()) {
			new ResultsMessage(0,"No result!").showMessage(this);
		} else {
			tf.loadListToTable(list);
			this.dispose();
		}	
	}
}
