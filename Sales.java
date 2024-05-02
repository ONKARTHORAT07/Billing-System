import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Sales extends JFrame implements ActionListener
{
	JPanel p,p1,p2,p3;
	//JFrame f;
	Container c;
	
	Font f1=new Font("Serif",Font.BOLD,25);
	Font f2=new Font("Serif",Font.ITALIC,20);
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
	JTextField t1,t2,t3,t4,t5,t6,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19;
	JButton b1,b2,b3,b4,b5;
	JTable j;
	Connection con;
	Statement st;
	JComboBox c1;
	      
	public Sales()
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
		setSize(1100,820);
		setLocation(480,200);
		setVisible(true);
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		String currentDate=dateFormat.format(new Date());
		
		
		c=getContentPane();
		c.setLayout(null);
	    c.setBackground(new Color(219,180,216));
		Border b=BorderFactory.createLineBorder(Color.BLACK, 1);
		
		//panel2
	    p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(200,50,700,50);
		p2.setBorder(b);
		p2.setBackground(Color.white);
		c.add(p2);
		l18=new JLabel("Rangoli Paints & Hardware");
		l18.setBounds(80,9,500,50);
		Font f3=new Font("Serif",Font.ITALIC,20);
		l18.setFont(f3);
		p2.add(l18);
		
		//panel1
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(200,100,700,250);
		p.setBorder(b);
		p.setBackground(Color.white);
		c.add(p);
		//order no
		l1=new JLabel("Order No");
		l1.setBounds(10,9,200,50);
		l1.setFont(f1);
		t1=new JTextField(20);
		t1.setBounds(160,20,100,30);
		p.add(l1);
		p.add(t1);
		//date
		l2=new JLabel("Date");
		l2.setBounds(410,9,200,50);
		l2.setFont(f1);
		t2=new JTextField(20);
		t2.setBounds(500,20,100,30);
		
		  
		p.add(l2);
		p.add(t2);
		//customer id
		l3=new JLabel("Customer Id");
		l3.setBounds(10,50,200,50);
		l3.setFont(f1);
		t3=new JTextField(20);
		t3.setBounds(250,60,350,30);
		p.add(l3);
		p.add(t3);
		//customer name
		l4=new JLabel("Customer Name");
		l4.setBounds(10,100,300,50);
		l4.setFont(f1);
		t4=new JTextField(20);
		t4.setBounds(250,110,350,30);
		p.add(l4);
		p.add(t4);
		//Address
		l5=new JLabel("Address");
		l5.setBounds(20,145,200,50);
		l5.setFont(f1);
		t5=new JTextField(20);
		t5.setBounds(250,155,350,30);
		p.add(l5);
		p.add(t5);
		//mobile no
		l6=new JLabel("Mobile NO.");
		l6.setBounds(20,190,200,50);
		l6.setFont(f1);
		t6=new JTextField(20);
		t6.setBounds(250,200,350,30);
		p.add(l6);
		p.add(t6);
		
		
		//panel2
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(200,350,700,220);
		p1.setBorder(b);
		p1.setBackground(Color.white);
		c.add(p1);
		
		
		//product details
		l7=new JLabel("Product Details");
		l7.setBounds(200,1,400,50);
		l7.setFont(f1);
		p1.add(l7);
		//line	
		//l8=new JLabel("--------------------------------------------------------------");
		//l8.setBounds(0,200,500,50);
		//l8.setFont(f1);
		//p1.add(l8);
		//category
		l9=new JLabel("Company");
		l9.setBounds(20,35,200,50);
		l9.setFont(f1);
		p1.add(l9);
		//combo box
		String[] values= {"Nerolac","Asian Paints"};
		c1=new JComboBox(values);
		c1.setBounds(250,50,320,25);
		c1.setFont(f2);
		p1.add(c1);	
		//product name
		l10=new JLabel("Product Name");
		l10.setBounds(20,90,270,50);
		l10.setFont(f1);
		t10=new JTextField(20);
		t10.setBounds(250,100,350,30);
		
		b1=new JButton("+");
		b1.setBounds(630,85,45,45);
		
		p1.add(l10);
	    p1.add(t10);
	    p1.add(b1);
	    b1.addActionListener(this);
		//qty
		l11=new JLabel("Qty-");
		l11.setBounds(20,150,200,50);
		l11.setFont(f1);
		t11=new JTextField(20);
		t11.setBounds(90,160,80,34);
		p1.add(l11);
		p1.add(t11);
		//rate
		l12=new JLabel("Rate-");
		l12.setBounds(200,150,200,50);
		l12.setFont(f1);
		t12=new JTextField(20);
		t12.setBounds(280,160,140,35);
		p1.add(l12);
		p1.add(t12);
		//rate
		l13=new JLabel("Total-");
		l13.setBounds(440,150,200,50);
		l13.setFont(f1);
		t13=new JTextField(20);
		t13.setBounds(530,160,140,35);
		p1.add(l13);
		p1.add(t13);
		
		
		//panel3
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBounds(200,570,700,200);
		p3.setBorder(b);
		p3.setBackground(Color.white);
		c.add(p3);
		//gst summry
		/*l18=new JLabel("GST Summary");
		l18.setBounds(200,1,400,50);
		l18.setFont(f1);
		p3.add(l18);
		
		//gst
		l14=new JLabel("GST-");
		l14.setBounds(20,40,200,50);
		l14.setFont(f1);
		t14=new JTextField(20);
		t14.setBounds(90,50,80,34);
		p3.add(l14);
		p3.add(t14);
		//CGST
		l15=new JLabel("CGST-");
		l15.setBounds(200,40,200,50);
		l15.setFont(f1);
		t15=new JTextField(20);
		t15.setBounds(300,50,80,35);
		p3.add(l15);
		p3.add(t15);
		//SGST
		l16=new JLabel("SGST-");
		l16.setBounds(440,40,200,50);
		l16.setFont(f1);
		t16=new JTextField(20);
		t16.setBounds(540,50,80,35);
		       
		p3.add(l16);
		p3.add(t16);
		//ftotal
		l17=new JLabel("Final Total-");
		l17.setBounds(20,95,200,50);
		l17.setFont(f1);
		t17=new JTextField(20);
		t17.setBounds(180,105,140,35);
		p3.add(l17);
		p3.add(t17);*/
		b5=new JButton("PRINT");
		b5.setBounds(570,70,100,60);
		p3.add(b5);
		b4=new JButton("CLOSE");
		b4.setBounds(450,70,100,60);
		p3.add(b4);
		b3=new JButton("SAVE");
		b3.setBounds(330,70,100,60);
		p3.add(b3);
		l19=new JLabel("Thank You...Visit again");
		l19.setBounds(20,150,500,50);
		l19.setFont(f3);
		p3.add(l19);
		b5.addActionListener(this);
		b4.addActionListener(this);
		b3.addActionListener(this);
		t3.addActionListener(this);
		t2.setText(currentDate);
	
	}

	public static void main(String[] args) {
		new Sales();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		 int cid,pquantity,pprice;
	   	   String cname,ccont,caddr,q,pname,pcompany;
	   	   cid=Integer.parseInt(t3.getText());
	   	   double cgst=0.05;
		   double gst=0.18;
		   double sgst=0.06;
	     try
	     {
	       if(e.getSource()==b4) {
				
				dispose();
	       }
	      if(e.getSource()==b5)
	       {
	    	 BillReport br=new BillReport(Integer.parseInt(t3.getText()));
	    	   br.setVisible(true);
	    	   
	       }
	      if(e.getSource()==b3)
			{
				int pid=1;
				  cname=t4.getText();
			   	   caddr=t5.getText();
			   	   ccont=t6.getText();
			   	   pcompany=c1.getSelectedItem().toString();
			   	   pname=t10.getText();
			   	   pquantity=Integer.parseInt(t11.getText());
			       pprice=Integer.parseInt(t12.getText());
			     System.out.println(cname+"\t"+caddr+"\t"+ccont+"\t"+pcompany+"\t"+pname+"\t"+pquantity+"\t"+pprice);
			    q="insert into salesorder values("+cid+",'"+cname+"','"+ccont+"','"+caddr+"','"+pcompany+"','"+pname+"',"+pquantity+","+pprice+")";
				st.executeUpdate(q);
				JOptionPane.showMessageDialog(null, "Record Inserted");
			}
			if(e.getSource()==t3)
			{
				
				q="select * from customer where id="+cid;
				ResultSet rs=st.executeQuery(q);
				if(rs.next())
				{
					t4.setText(""+rs.getString(2));
					t5.setText(""+rs.getString(4));
					t6.setText(""+rs.getString(3));
				}
			}
			/*if(e.getSource()==t13)
			{
				int quantity=Integer.parseInt(t11.getText());
				double price=Double.parseDouble(t12.getText());
				double total=quantity*price;
				t13.setText(String.valueOf(total));
			}
			//double productCost=pquantity*pprice;
			//double total=productCost+(productCost*(gst+cgst+sgst));
			//t17.setText(String.valueOf(total));*/
			}
			catch(Exception e1)
			{
				System.out.println("Error"+e1);
			}
	}
}
