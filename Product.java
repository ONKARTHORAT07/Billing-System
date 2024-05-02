import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class Product extends JFrame implements ActionListener 
{
	Container c;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4,b5,b6;
	Connection con;
	Statement st;
	JComboBox c2;
	
	
	public Product()
	{
		
		
      try {
	       Class.forName("org.postgresql.Driver");
	       con=DriverManager.getConnection("jdbc:postgresql://localhost/BillingSystem","postgres","Onkar@123");
	       st=con.createStatement();
          }
      catch(Exception e)
          {
	       System.out.println("error"+e);
          }
		
		setUndecorated(true);
		setSize(1000,700);
		setLocation(600,200);
		setVisible(true);
		
		
	    Font f=new Font("Serif",Font.BOLD,25);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(219,180,216));
		l1=new JLabel("PRODUCT DETAILS");
		l1.setBounds(310,80, 600, 50);
		l1.setFont(f);
		
		l2=new JLabel("Product ID");
		l2.setBounds(200, 150, 300, 30);
		t1=new JTextField(20);
		t1.setBounds(450,150,300,30);
		
		
		l4=new JLabel("Company");
		l4.setBounds(200,200,300,30);
		String[] values1={"Nerolac","Asian Paints"};
		c2=new JComboBox(values1);
		c2.setBounds(450,200,300,30);
		
		l5=new JLabel("Product Name");
		l5.setBounds(200,250,900,30);
		t2=new JTextField(20);
		t2.setBounds(450,250,300,30);
		
		l6=new JLabel("Quantity");
		l6.setBounds(200,300,900,40);
		t3=new JTextField(20);
		t3.setBounds(450,300,160,30);
		
		l7=new JLabel("Price");
		l7.setBounds(200,350,900,40);
		t4=new JTextField(20);
		t4.setBounds(450,350,160,30);
		
		b1=new JButton("SAVE");
		b1.setBounds(150,450,90,40);
		b2=new JButton("MODIFY");
		b2.setBounds(300,450,90,40);
		b3=new JButton("SHOW");
		b3.setBounds(450,450,90,40);
		b4=new JButton("DELETE");
		b4.setBounds(600,450,100,40);
		b5=new JButton("CLOSE");
		b5.setBounds(750,450,100,40);
		
		
		
		l2.setFont(f);
		
		l4.setFont(f);
		l5.setFont(f);
		l6.setFont(f);
		l7.setFont(f);
		
		c.add(l1);
		c.add(l2); 
		c.add(t1);
		
		
		c.add(l4);
		c.add(c2);
		c.add(l5);
		c.add(t2);
		c.add(l6);
		c.add(t3);
		c.add(l7);
		c.add(t4);
		
		c.add(b1); 
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b5);
		
		t1.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	
	

		    
		       
		    
	}
	public static void main(String[] args) 
	{
		new Product();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		

	       if(e.getSource()==b5) {
				
				dispose();
			}
	       if(e.getSource()==b3)
			{
				report r=new report();
				r.setVisible(true);
			}
			
		
		
		int pid;
		String pname,pquantity,q,pprice,pcompany;
		pid=Integer.parseInt(t1.getText());
		pcompany=c2.getSelectedItem().toString();
		pname=t2.getText();
		pquantity=t3.getText();
		pprice=t4.getText();
		
		try {
		if(e.getSource()==b1)
		{
			
					q="insert into product values('"+pid+"','"+c2.getSelectedItem().toString()+"','"+pname+"','"+pquantity+"','"+pprice+"')";
			st.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "Record Inserted");
		}
		if(e.getSource()==b2)
		{
					q="update product set name='"+pname+"',quantity='"+pquantity+"',price='"+pprice+"' where pid='"+pid+"'";
			st.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "Record Updated");
		}
		if(e.getSource()==b4)
		{
					q="delete from product where pid='"+pid+"'";
			st.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "Record Deleted");
		}
		if(e.getSource()==t1)
		{
			q="select * from product where pid="+pid;
			ResultSet rs=st.executeQuery(q);
			if(rs.next())
			{
				t2.setText(""+rs.getString(3));
				t3.setText(""+rs.getString(4));
				t4.setText(""+rs.getString(5));
			}
		}
		
		}
		
		
		
	
		catch (Exception e1)
		{
			System.out.println("error"+e1);
		}
	}
	
	}
