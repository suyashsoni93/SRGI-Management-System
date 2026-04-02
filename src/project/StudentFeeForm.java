package project;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class StudentFeeForm extends JFrame implements ActionListener{
	
	Choice crollno;
	JComboBox<String> cbcourse, cbyear;
	JLabel labeltotal;
	JButton update, pay, back;
	
	StudentFeeForm() {
		
		setSize(900,500);
		setLocation(300,100);
		setLayout(null);
		
        getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 50, 500, 300);
		add(image);
		
		JLabel lblrollumber = new JLabel("Select Roll No.");
		lblrollumber.setBounds(40, 60, 150, 20);
		lblrollumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblrollumber);
		
		crollno = new Choice();
		crollno.setBounds(200, 60 , 150, 20);
		add(crollno);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select*from student");
			while(rs.next()) {
				crollno.add(rs.getString("rollno"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(40, 100, 150, 20);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblname);
		
		JLabel labelname = new JLabel();
		labelname.setBounds(200, 100, 150, 20);
		labelname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(labelname);
		
		JLabel lblfname = new JLabel("Father's Name");
		lblfname.setBounds(40, 140, 150, 20);
		lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblfname);
		
		JLabel labelfname = new JLabel();
		labelfname.setBounds(200, 140, 150, 20);
		labelfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(labelfname);
		
		
		try {
			Conn c = new Conn();
			String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				labelname.setText(rs.getString("name"));
				labelfname.setText(rs.getString("fname"));
				
			}
		}catch (Exception ae){
			ae.printStackTrace();
		}
		
		crollno.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					Conn c = new Conn();
					String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(query);
					while(rs.next()) {
						labelname.setText(rs.getString("name"));
						labelfname.setText(rs.getString("fname"));
						
					}
				}catch (Exception ae){
					ae.printStackTrace();
				}
				
			}
		});
		
		JLabel lblcourse = new JLabel("Course");
		lblcourse.setBounds(40, 180, 150, 20);
		lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblcourse);
		
		String course[] = {"B.Tech", "M.Tech", "B.Pharm", "D.Pharm", "M.B.A", "M.C.A", "B.B.A", "B.C.A", "B.S.C.Agc", "B.S.C.BioTech", "Polytechnic", "L.L.B/B.A.L.L.B"};
		cbcourse = new JComboBox<String>(course);
		cbcourse.setBounds(200, 180, 150, 20);
		cbcourse.setBackground(Color.WHITE);
		add(cbcourse);
		
		JLabel lblsemester = new JLabel("Year");
		lblsemester.setBounds(40, 220, 150, 20);
		lblsemester.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblsemester);
		
		String year[] = {"year1", "year2", "year3", "year4"};
		cbyear = new JComboBox<String>(year);
		cbyear.setBounds(200, 220, 150, 20);
		cbyear.setBackground(Color.WHITE);
		add(cbyear);
		
		JLabel lbltotal = new JLabel("Total Payable");
		lbltotal.setBounds(40, 300, 150, 20);
		lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lbltotal);
		
		labeltotal = new JLabel();
		labeltotal.setBounds(200, 300, 150, 20);
		labeltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(labeltotal);
		
		update= new JButton("Update");
		update.setBounds(30, 380, 100, 25);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		update.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(update);
		
		pay= new JButton("Pay Fee");
		pay.setBounds(150, 380, 100, 25);
		pay.setBackground(Color.BLACK);
		pay.setForeground(Color.WHITE);
		pay.addActionListener(this);
		pay.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(pay);
		
		back= new JButton("back");
		back.setBounds(270, 380, 100, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(back);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == update) {
			String course = (String) cbcourse.getSelectedItem();
			String year = (String) cbyear.getSelectedItem();
			try {
				Conn c = new Conn();
				ResultSet rs =c.s.executeQuery("select * from fee where course = '"+course+"'");
				while (rs.next()) {
					labeltotal.setText(rs.getString(year));
				}
			}catch (Exception ae) {
				ae.printStackTrace();
			}
		}else if (e.getSource() == pay) {
			String rollno = crollno.getSelectedItem();
			String course = (String) cbcourse.getSelectedItem();
			String year = (String) cbyear.getSelectedItem();
			String total = labeltotal.getText();
			
			try {
				Conn c = new Conn();
				String query = "insert into collegefee values('"+rollno+"', '"+course+"', '"+year+"', '"+total+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "College Fee Submitted Successfully");
				setVisible(false);
			}catch (Exception ae) {
				ae.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new StudentFeeForm();

	}


}
