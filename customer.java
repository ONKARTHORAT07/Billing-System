import java.sql.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.*;
public class customer extends JFrame implements ActionListener
{
	
	JLabel l0,l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3,b4,b5;
	Container c;
	Font f=new Font("Serif", Font.BOLD, 30);
	Font f1=new Font("Italic", Font.BOLD, 20);
	JPanel p=new JPanel();
	
	Connection con;
	Statement st;
	
	public customer()
	{		
	try 
	{
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://localhost/BillingSystem","postgres","Onkar@123");
		st=con.createStatement();
	}
	catch(Exception e)
	{
		System.out.println("error"+e);
	}
	
		
		//setUndecorated(true);
		setSize(1000,700);
		setLocation(600,200);
		setVisible(true);
		
		c=getContentPane();
		c.setLayout(null);
		//cus detail
		c.setBackground(new Color(219,180,216));
		l0=new JLabel("CUSTOMER DETAILS");
		l0.setBounds(290,9, 600, 50);
		l0.setFont(f);
		c.add(l0);
		//id
		l1=new JLabel("Id");
		l1.setBounds(250, 100, 300, 30);
		l1.setFont(f1);
		t1=new JTextField(20);
		t1.setBounds(350,100,300,30);
		c.add(l1);
		c.add(t1);
		//name
		l2=new JLabel("Name");
		l2.setBounds(250,150, 300, 30);
		l2.setFont(f1);
		t2=new JTextField(20);
		t2.setBounds(350,150,300,30);
		c.add (l2);
		c.add(t2);
		//contact
		l3=new JLabel("Contact");
		l3.setBounds(250,200,300,30);
		l3.setFont(f1);
		t3=new JTextField(20);
		t3.setBounds(350,200,300,30);
		c.add (l3);
		c.add(t3);
		//address
		l4=new JLabel("Address");
		l4.setBounds(250,250,300,30);
		l4.setFont(f1);
		t4=new JTextField(20);
		t4.setBounds(350,250,300,30);
		c.add (l4);
		c.add(t4);
		//save
		b1=new JButton("SAVE");
		b1.setBounds(100,350,100,30);
		c.add(b1);
		//uodate
		b2=new JButton("MODIFY");
		b2.setBounds(250,350,100,30);
		c.add(b2);
		b3=new JButton("DELETE");
		b3.setBounds(400,350,100,30);
		c.add(b3);
		b4=new JButton("SHOW");
		b4.setBounds(550,350,100,30);
		c.add(b4);
		b5=new JButton("CLOSE");
		b5.setBounds(700,350,100,30);
		c.add(b5);
	    
		t1.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	
		
	}

	public static void main(String[] args) {
		
		new customer();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b5)
		{
			dispose();
		}
		if(e.getSource()==b4)
		{
			report r=new report();
			r.setVisible(true);
		}
		int id;
		String name,contact,address,q;
		id=Integer.parseInt(t1.getText());
		name=t2.getText();
		contact=t3.getText();
		address=t4.getText();	
		try 
		{
		if(e.getSource()==b1)
		{
			q="insert into customer values('"+id+"','"+name+"','"+contact+"','"+address+"')";
			st.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "Record Inserted");
		}
		if(e.getSource()==b2)
		{
			q="update customer set name='"+name+"',contact='"+contact+"',address='"+address+"' where id='"+id+"'";
			st.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "Record Updated");
		}
		if(e.getSource()==b3)
		{
		    q="delete from customer where id='"+id+"'";
			st.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "Record Deleted");
		}
		if(e.getSource()==t1)
		{
			q="select * from customer where id="+id;
			ResultSet rs=st.executeQuery(q);
			if(rs.next())
			{
				t2.setText(""+rs.getString(2));
				t3.setText(""+rs.getString(3));
				t4.setText(""+rs.getString(4));
			}
		}
	}
		catch (Exception e1)
		{
			System.out.println("error"+e1.getMessage());
		}
		}
}
