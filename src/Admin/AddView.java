package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddView extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField name;
	private JDateChooser dob;
	private JTextField contact;
	private JTextField address;
	private JTextField email;
	private JTable table;
	private JTextField searchtable;
	public static boolean totalStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddView frame = new AddView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fillTable(JTable table,String searchval) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/studentmanagement","root","");   
			
			String fillTable = "SELECT * FROM addstudent WHERE concat(ID,Name,Email,Gender,DateOfBirth,Contact,Address,Status) like ?";
			PreparedStatement pre2 = con.prepareStatement(fillTable);
			pre2.setString(1, "%"+searchval+"%");
			ResultSet result = pre2.executeQuery();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			Object[] row;
			while(result.next()) {
				row = new Object [8];
				row[0] = result.getString(1);
				row[1] = result.getString(2);
				row[2] = result.getString(3);
				row[3] = result.getString(4);
				row[4] = result.getString(5);
				row[5] = result.getString(6);
				row[6] = result.getString(7);
				row[7] = result.getString(8);
				model.addRow(row);
			}
			//ResultSet rs=stmt.executeQuery(sql);  
//			if(rs.next())  {
//				JOptionPane.showMessageDialog(null, "Log in successfully");
//				dispose();
//				Menu menu = new Menu();
//				menu.setVisible(true);
//			}
//			else
//				JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
			con.close();
//			System.out.println("Data successfully deposited");
		}catch(Exception e1){ System.out.println(e1);}   
	}
	
	
	//Check info
	
//	public boolean checkInput() {
//		if(ID.getText().equals("")||name.getText().equals("")||dob.getDate() == null) {
//			JOptionPane.showMessageDialog(null, "There are blank");
//			return false;
//		}
//		return true;
//	}
//	
	/**
	 * Create the frame.
	 */
	public AddView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddANew = new JLabel("Manage Student\r\n");
		lblAddANew.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		ID = new JTextField();
		ID.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		name = new JTextField();
		name.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JDateChooser dob = new JDateChooser();
		dob.setDateFormatString("YYYY-MM-dd");
		
		contact = new JTextField();
		contact.setColumns(10);
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.BLUE);
		btnAdd.setBackground(Color.CYAN);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{  
//					Class.forName("com.mysql.jdbc.Driver");  
//					Connection con=DriverManager.getConnection(  
//					"jdbc:mysql://localhost:3306/studentmanagement","root","");   
//					//Statement stmt=con.createStatement();  
//					String gen = "Male";
//					if(rdbtnFemale.isSelected()) {
//						gen = "Female";
//					}
////					System.out.println(gen);
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//					String dat = sdf.format(dob.getDate());
//					String status = "Enable";
//					
//					String query = "insert into AddStudent(ID,Name,Email,Gender,DateOfBirth,Contact,Address,Status)"+"values (?,?,?,?,?,?,?,?)";
//					PreparedStatement pre = con.prepareStatement(query);
//					pre.setString(1, ID.getText());
//					pre.setString(2, name.getText());
//					pre.setString(3, email.getText());
//					pre.setString(4, gen);
//					pre.setString(5, dat);
//					pre.setString(6, contact.getText());
//					pre.setString(7, address.getText());
//					pre.setString(8, status);
//					pre.execute();
//					pre.close();
//					
//
//					con.close();
//					JOptionPane.showMessageDialog(null, "The new student has been created");
//					dispose();
					AddStudent addStu = new AddStudent();
					addStu.setVisible(true);
					dispose();
//					AddView view = new AddView();
//					view.setVisible(true);
//					Menu menu = new Menu();
//					menu.setVisible(true);
//					System.out.println("Data successfully deposited");
				}catch(Exception e1){ System.out.println(e1);}  
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu();
				menu.setVisible(true);
			}
		});
		
		
		address = new JTextField();
		address.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		email = new JTextField();
		email.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//			}
//		});
		
		JButton btnUpdate = new JButton("Edit");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					String idup = ID.getText();
//					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentmanagement","root","");   
					String up = "update addstudent set Name=?, Email=?, Contact=?, Address=? where ID = ?";
					PreparedStatement pre = con.prepareStatement(up);
					pre.setString(1, name.getText());
					pre.setString(2, email.getText());
//					pre.setString(4, gen);
//					pre.setString(5, dat);
					pre.setString(3, contact.getText());
					pre.setString(4, address.getText());
					pre.setString(5, ID.getText());
//					pre.setString(8, status);
//					pre.execute();
					if(pre.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null, "The Student data has been updated");
					}
					con.close();
					dispose();
					AddView view = new AddView();
					view.setVisible(true);
//					JOptionPane.showMessageDialog(null, "The student has been updated");
				}catch(Exception e2) {
					System.out.println(e2);
				}
			}
		});
		
		JButton btnEnable = new JButton("Enable");
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con;
				try {
					con = DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/studentmanagement","root","");
					
					String statusEn = "Enable";
					String checkEn = "select Status from addstudent";
					PreparedStatement pre1 = con.prepareStatement(checkEn);
					if(totalStatus) {
						JOptionPane.showMessageDialog(null, "The student data is already enabled");
					}
					else {
						String up = "update addstudent set Status = ? where ID = ?";
						PreparedStatement pre2 = con.prepareStatement(up);
						pre2.setString(1, statusEn);
						pre2.setString(2, ID.getText());
						if(pre2.executeUpdate()>0) {
							JOptionPane.showMessageDialog(null, "The Student data has been enabled");
						}
						con.close();
						dispose();
						AddView view = new AddView();
						view.setVisible(true);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
			}
		});
		
		JButton btnDisable = new JButton("Disable");
		btnDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				try {
					con = DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/studentmanagement","root","");
					String up = "update addstudent set Status = ? where ID = ?";
					String status = "Disable";
					PreparedStatement pre = con.prepareStatement(up);
					pre.setString(1, status);
					pre.setString(2, ID.getText());
					if(pre.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null, "The Student data has been disabled");
					}
					con.close();
					dispose();
					AddView view = new AddView();
					view.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
				
				
			}
		});
		
		JLabel TotalStudent = new JLabel("Total Number of Students :");
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowInd = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				if(model.getValueAt(rowInd, 3).toString().equals("Male")) {
					rdbtnMale.setSelected(true);
					rdbtnFemale.setSelected(false);
				}
				else {
					rdbtnFemale.setSelected(true);
					rdbtnMale.setSelected(false);
				}
				if(model.getValueAt(rowInd, 7).toString().equals("Enable")) {
					totalStatus = true;
				}
				else {
					totalStatus = false;
				}
				ID.setText(model.getValueAt(rowInd, 0).toString());
				name.setText(model.getValueAt(rowInd, 1).toString());
				email.setText(model.getValueAt(rowInd, 2).toString());
				contact.setText(model.getValueAt(rowInd, 5).toString());
				address.setText(model.getValueAt(rowInd, 6).toString());
				Date bdate;
				try {
					bdate = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowInd, 4).toString());
					dob.setDate(bdate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Gender", "Date Of Birth", "Contact", "Address", "Status"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		table.getColumnModel().getColumn(3).setPreferredWidth(67);
		fillTable(table,"");
		scrollPane.setViewportView(table);
		
		searchtable = new JTextField();
		searchtable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				table.setModel(new DefaultTableModel(null,new Object[] {"ID","Name","Email","Gender","DateOfBirth","Contact","Address","Status"}));
				fillTable(table,searchtable.getText());
			}
		});
		searchtable.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search :");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGender)
										.addComponent(lblDateOfBirth)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblName)
										.addComponent(lblId))
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblContact, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
									.addGap(38)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(contact, 149, 149, 149)
									.addComponent(address, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(name)
									.addComponent(ID, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
									.addComponent(email)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(rdbtnMale)
										.addGap(18)
										.addComponent(rdbtnFemale))
									.addComponent(dob, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnCancel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnEnable, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnDisable, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(570, Short.MAX_VALUE)
					.addComponent(lblAddANew, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSearch)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchtable, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(1060, Short.MAX_VALUE)
					.addComponent(TotalStudent)
					.addGap(64))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddANew, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchtable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSearch, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblId)
								.addComponent(ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGender)
								.addComponent(rdbtnMale)
								.addComponent(rdbtnFemale))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dob, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
								.addComponent(lblDateOfBirth))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblContact)
									.addGap(29)
									.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(contact, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(address, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnEnable, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnDisable, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addGap(88))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 588, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TotalStudent)
							.addContainerGap())))
		);
		
		
		contentPane.setLayout(gl_contentPane);
	}
}
