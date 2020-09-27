package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.DefaultRowSorter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import bao.BaoBranch;
import bao.BaoPosition;
import bao.BaoProject;
import dao.DaoProject;
import entity.CurrentUser;
import entity.GetProject;
import entity.Position;
import entity.Project;
import helper.ShowResults;
import modal.ResultsMessage;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.FocusAdapter;
import javax.swing.JLabel;



public class ProjectManager extends JInternalFrame {
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnLoad;
	private JTextField txtFilter;
	private JScrollPane scrollPane;
	private JTable tblProject;
	private JMenuItem mmtmView;
	private JMenuItem mntmAdd;
	private JMenuItem mntmEdit;
	private JMenuItem mntmDelete;
	private JMenuItem mntmReload;
	private List<GetProject> list;
	private int i=0;
	private JLabel lblNewLabel;
	
	private CurrentUser cuser;

	public ProjectManager(CurrentUser cuser) {
		setBounds(-15, -27, 1030, 505);
		this.cuser=cuser;
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		
		btnUpdate = new JButton("Edit");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		
		btnLoad = new JButton("Filter");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadActionPerformed(e);
			}
		});
		
		txtFilter = new JTextField("Search");
		txtFilter.setForeground(Color.GRAY);
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
		txtFilter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtFilterKeyReleased(e);
			}
		});
		txtFilter.setColumns(10);
		
		scrollPane = new JScrollPane();
		
		lblNewLabel = new JLabel("Project Manager");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
							.addComponent(txtFilter, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
							.addGap(62))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnLoad)
						.addComponent(btnDelete)
						.addComponent(btnUpdate)
						.addComponent(txtFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE))
		);
		
		tblProject = new JTable();
		tblProject.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(tblProject);
		getContentPane().setLayout(groupLayout);
		tblProject.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		        doubleClickRowOnTable(e);
		    }
		});
		
//		BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
//		for (MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()) {
//		    basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
//		}
		
//		loadtable
		firtLoad();
	}

	private void loadListToTable() {
		DefaultTableModel defaultTable = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		tblProject.setModel(defaultTable);
		
		defaultTable.addColumn("#");
		defaultTable.addColumn("Id");
		defaultTable.addColumn("Name");
		defaultTable.addColumn("Date");
		defaultTable.addColumn("Description");
		defaultTable.addColumn("Status");
		defaultTable.addColumn("Type");
		defaultTable.addColumn("Department");
		defaultTable.addColumn("Branch");
		
		i=0;
		
		for(GetProject pro : list) {
			defaultTable.addRow(new Object[] {
				++i, pro.getId(), pro.getName(), pro.getDate(), pro.getDescription(), pro.isStatus() ? true:false, 						
						pro.getType_name(), pro.getDepartment_name(), pro.getBranch_name()
			});
		}
		tblProject.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblProject.getColumnModel().getColumn(0).setPreferredWidth(30);
		tblProject.getColumnModel().getColumn(1).setPreferredWidth(70);
		tblProject.getColumnModel().getColumn(2).setPreferredWidth(90);
		tblProject.getColumnModel().getColumn(3).setPreferredWidth(150);
		tblProject.getColumnModel().getColumn(4).setPreferredWidth(150);
		tblProject.getColumnModel().getColumn(5).setPreferredWidth(150);
		tblProject.getColumnModel().getColumn(6).setPreferredWidth(150);
		createPopupMenu();
	}
	
	protected void updateListNonDB(GetProject getPro) {
		int index=0;
		String id=getPro.getId();
		for (int i = 0; i < list.size(); i ++) {
		    if(list.get(i).getId().equals(id)) {
		    	index=i; break;
		    }
		}
		list.set(index, getPro);
		loadListToTable();
	}
	
	public void updateListNonDB(int index, String id) {
		GetProject getPro = new BaoProject().getGProjectFromID(id, true, cuser.getUsername());
		list.set(index, getPro);
		loadListToTable();
	}
	
    public void addProjectToTable(String id) {
    	GetProject pro = new BaoProject().getGProjectFromID(id, false, cuser.getUsername());
    	list.add(pro);
    	DefaultTableModel model = (DefaultTableModel) tblProject.getModel();
    	model.addRow(new Object[] {
				++i, pro.getId(), pro.getName(), pro.getDate(), pro.getDescription(), pro.isStatus() ? true:false, 						
						pro.getType_name(), pro.getDepartment_name(), pro.getBranch_name()
		});
    }

    protected void firtLoad() {
		list = new BaoProject().getAllProjectFirt(false, cuser.getUsername());
		loadListToTable();
	}
	
    public void loadListToTable(List<GetProject> list) {
    	this.list = list;
    	loadListToTable();
    }
    
	protected void btnLoadActionPerformed(ActionEvent e) {
		new Sys_FrameLoadProject(this, cuser).setVisible(true);
	}

	private void createPopupMenu() {
		mntmReload = new JMenuItem("Load Data");
		mntmReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadActionPerformed(e);
			}
		});

		mmtmView = new JMenuItem("View");
		mmtmView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnViewActionPerformed(e);
			}
		});
		
        mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		
		mntmEdit = new JMenuItem("Edit");
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		
		mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		
		JPopupMenu popup = new JPopupMenu();
        popup.add(mntmReload);
        popup.add(mmtmView);
        popup.add(mntmAdd);
        popup.add(mntmEdit);
        popup.add(mntmDelete);
        MouseListener popupListener = new PopupListener(popup);
        tblProject.addMouseListener(popupListener);
        clearFind();
    }
    
    private class PopupListener extends MouseAdapter {

        private JPopupMenu popup;

        PopupListener(JPopupMenu popupMenu) {
            popup = popupMenu;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (tblProject.getSelectedRow() != -1) {
                maybeShowPopup(e);
            }
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }
	
	protected void doubleClickRowOnTable(MouseEvent e) {
		JTable table =(JTable) e.getSource();
        Point point = e.getPoint();
        int row = table.rowAtPoint(point);
        if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
        	new AddProject(3, (String) tblProject.getValueAt(row, 1), this, (Integer) tblProject.getValueAt(row, 0) -1, cuser);
        }
	}
    
	protected void btnAddActionPerformed(ActionEvent e) {
		new AddProject(1, null, this, 0, cuser).setVisible(true);
	}
	
	protected void btnViewActionPerformed(ActionEvent e) {
		int row = tblProject.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Select Row on table", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			new AddProject(3, (String) tblProject.getValueAt(row, 1), this, 0, cuser);
		}
	}
	
	protected void btnUpdateActionPerformed(ActionEvent e) {
		int row = tblProject.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Select Row on table", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			new AddProject(2, (String) tblProject.getValueAt(row, 1), this, (Integer) tblProject.getValueAt(row, 0) -1, cuser);
		}
	}
	
	protected void btnDeleteActionPerformed(ActionEvent e) {
		int row = tblProject.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "Select Row on table", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			String id = (String) tblProject.getValueAt(row, 1);
			int confirm = JOptionPane.showConfirmDialog(this, "Confirm delete ID: " + id, "Confirm", JOptionPane.YES_NO_OPTION);
			if(confirm == JOptionPane.YES_OPTION){
				ResultsMessage rm = new BaoProject().delete(id);
				int index = (int) tblProject.getValueAt(row, 0);
				rm.showMessage(null);
				if(rm.getNum() == 2)
					updateListNonDB(index -1, id);
				if(rm.getNum() == 1) {
					list.remove(index-1);
					loadListToTable();
				}
					
			}
		}
	}
	
	protected void do_txtFind(KeyEvent e, String find) {
		DefaultRowSorter sorter =(DefaultRowSorter) tblProject.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find));
		sorter.setSortKeys(null);
	}
	
	protected void do_txtFind(KeyEvent e, String find, int index) {
		DefaultRowSorter sorter =(DefaultRowSorter) tblProject.getRowSorter();
		sorter.setRowFilter(RowFilter.regexFilter(find, index));
		sorter.setSortKeys(null);
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
	
	private void clearFind() {
    	txtFilter.setText("Search");
		txtFilter.setForeground(Color.GRAY);
    }
}
