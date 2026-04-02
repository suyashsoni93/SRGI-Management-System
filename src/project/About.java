package project;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
	
	About() {
		
		setSize(700, 500);
		setLocation(400, 150);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/suyash.jpg"));
		Image i2 = i1.getImage().getScaledInstance(360,400,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(430, 10, 230, 400);
		add(image);
		
		JLabel heading = new JLabel ("<html>SRGI<br/>Student and Faculty Management System</html>");
		heading.setBounds(70, 20, 500, 130);
		heading.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(heading);
		
		JLabel name = new JLabel ("Developed By: Suyash Soni");
		name.setBounds(70, 220, 550, 40);
		name.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(name);
		
		JLabel rollno = new JLabel ("B.C.A 3rd Year 215901007033");
		rollno.setBounds(70, 260, 550, 40);
		rollno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(rollno);
		
		JLabel contact = new JLabel ("Contact: suyashsoni93@gmail.com");
		contact.setBounds(70, 290, 550, 40);
		contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(contact);
		
		JLabel phone = new JLabel ("Mob No: 8299664281");
		phone.setBounds(70, 320, 550, 40);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(phone);
		
		setLayout(null);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new About();

	}

}
