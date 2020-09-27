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

import bao.BaoEmp_project;
import bao.BaoProject;
import entity.CurrentUser;
import entity.Emp_project;
import entity.GetProject;
import entity.Project_branch;

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
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;

public class UserProject extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTextField txtFilter;
	private JTabbedPane tabbedPane;
	private JPanel panelMyProject;
	private JPanel panelProject;
	private List<Emp_project> list;
	private List<Project_branch> listProBranch;
	private int i=0;
	private JScrollPane scrollPane;
	private JTable tableMyProject;
	private JScrollPane scrollPane_1;
	private JTable tableProjectBranch;
	private JLabel lblNewLabel_1;
	private int x=0;
	private CurrentUser cuser;
	
	public UserProject(CurrentUser cuser) {
		this.cuser = cuser;
		setBounds(0, 0, 900, 430);
		
		lblNewLabel = new JLabel("Project");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtFilter = new JTextField();
		txtFilter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtFilterKeyReleased(e);
			}
		});
		txtFilter.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtFilterFocusGained(e);
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtFilterFocusLost(e);
			}
		});
		txtFilter.setColumns(10);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 864, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtFilter, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 312, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		panelMyProject = new JPanel();
		tabbedPane.addTab("   My Project   ", null, panelMyProject, null);
		
		scrollPane = new JScrollPane();
		GroupLayout gl_panelMyProject = new GroupLayout(panelMyProject);
		gl_panelMyProject.setHorizontalGroup(
			gl_panelMyProject.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
		);
		gl_panelMyProject.setVerticalGroup(
			gl_panelMyProject.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMyProject.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tableMyProject = new JTable();
		tableMyProject.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(tableMyProject);
		panelMyProject.setLayout(gl_panelMyProject);
	// Load table my project	
		loadListMyProject();		
		panelProject = new JPanel();
		tabbedPane.addTab("The project is going on", null, panelProject, null);
		
		scrollPane_1 = new JScrollPane();
		GroupLayout gl_panelProject = new GroupLayout(panelProject);
		gl_panelProject.setHorizontalGroup(
			gl_panelProject.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
		);
		gl_panelProject.setVerticalGroup(
			gl_panelProject.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelProject.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tableProjectBranch = new JTable();
		tableProjectBranch.setAutoCreateRowSorter(true);
		scrollPane_1.setViewportView(tableProjectBranch);
		panelProject.setLayout(gl_panelProject);
		// Load table project branch
		loadListProjectBranch();
		
		getContentPane().setLayout(groupLayout);
//		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
//		for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
//		    basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
//		}
	}
	
	private void loadListMyProject() {
		list = new BaoEmp_project().getMyProject(cuser.getUsername());
		DefaultTableModel defaultTable = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		tableMyProject.setModel(defaultTable);
		
		defaultTable.addColumn("#");
		defaultTable.addColumn("Name Project");
		defaultTable.addColumn("Name Type Project");
		defaultTable.addColumn("Date Join");
		defaultTable.addColumn("Date New");
		defaultTable.addColumn("Done");
		i=0;
		for(Emp_project empPro : list) {
			defaultTable.addRow(new Object[] {
				++i, empPro.getNameProject(), empPro.getNameProject_type(), empPro.getDatejoin(),empPro.getDatenew(), 
				(empPro.getDont()>0)?"Complete":"Executing"
			});
		}
	}
	
	protected void do_txtFind(KeyEvent e, String find) {
		DefaultRowSorter sorter =(DefaultRowSorter) tableMyProject.getRowSorter();
		DefaultRowSorter sorter1 =(DefaultRowSorter) tableProjectBranch.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
		sorter1.setRowFilter(RowFilter.regexFilter(find));
		sorter1.setSortKeys(null);
	}
	
	protected void txtFilterKeyReleased(KeyEvent e) {
		do_txtFind(e, txtFilter.getText());
	}
	
	protected void txtFilterFocusGained(FocusEvent e) {
		if (txtFilter.getText().equals("Search")) {
			txtFilter.setText("");
			txtFilter.setForeground(Color.BLACK);
        }
	}
	
	protected void txtFilterFocusLost(FocusEvent e) {
		if (txtFilter.getText().equals("")) {
			txtFilter.setText("Search");
			txtFilter.setForeground(Color.GRAY);
        }
	}
	
	protected void loadListProjectBranch() {
		listProBranch = new BaoProject().getProjectBrand(cuser.getBranchId());
		DefaultTableModel defaultTable = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		tableProjectBranch.setModel(defaultTable);
		
		defaultTable.addColumn("#");
		defaultTable.addColumn("id");
		defaultTable.addColumn("Name Project");
		defaultTable.addColumn("Name Type Project");
		defaultTable.addColumn("Description");
		defaultTable.addColumn("Date New");
		x=0;
		
		for(Project_branch pro : listProBranch) {
			defaultTable.addRow(new Object[] {
				++x, pro.getId(), pro.getName_project(), pro.getName_project_type(), pro.getDescription(),pro.getDatenew()
			
			});
		}
	}
}
