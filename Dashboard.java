import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener
{
	JPanel p,p1,p2;
	JButton b1,b2,b3,b4,b5,b6,b7;
	JLabel l1,l2;
	Dashboard()
	{
		   
		Font f=new Font("Times New Roman",Font.BOLD,30);
		Font f2=new Font("Times New Roman",Font.BOLD,20);	
		Border b=BorderFactory.createLineBorder(Color.black);
		setSize(2000,1500);
		setLocation(0,0);
		setBackground(new Color(219,180,216));
		setVisible(true);
		setLayout(null);
		Font f1=new Font("Serif",Font.BOLD,80);	
		l1=new JLabel("WEL-COME.....");
		l1.setBounds(700,400,700,100);
		l1.setFont(f1);
		add(l1);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(0, 0, 2000, 100);
		//p.setBackground(new Color(255,255,255,0.25);
		p.setBorder(b);
		p.setBackground(new Color(219,180,216));
		add(p);
		l1=new JLabel("Rangoli Paints & Hardware");
		l1.setBounds(700,30,900,50);
		l1.setFont(f);
		p.add(l1);
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 300, 1900);
		p1.setBackground(new Color(219,180,216));
		p1.setBorder(b);
		add(p1);	
		b1=new JButton("HOME");
		b1.setBounds(0, 100, 300, 50);
		p1.add(b1);
		b1.addActionListener(this);
		b1.setFont(f2);
		Icon i=new ImageIcon("/home/tanu/PROJECT/BillingSys/src/home.gif");	
		b1.setIcon(i);
		
		b2=new JButton("CUSTOMERS");
		b2.setBounds(0, 200, 300, 50);
		p1.add(b2);
		b2.addActionListener(this);
		b2.setFont(f2);
		Icon i1=new ImageIcon("/home/tanu/PROJECT/BillingSys/src/icons8-customers.gif");	
		b2.setIcon(i1);
		
		b3=new JButton("PRODUCTS");
		b3.setBounds(0, 300, 300, 50);
		p1.add(b3);
		b3.addActionListener(this);
		b3.setFont(f2);
		Icon i2=new ImageIcon("/home/tanu/PROJECT/BillingSys/src/product.gif");	
		b3.setIcon(i2);
		
		b4=new JButton("SALES");
		b4.setBounds(0, 400,300, 50);
		p1.add(b4);
		b4.addActionListener(this);
		b4.setFont(f2);
		Icon i3=new ImageIcon("/home/tanu/PROJECT/BillingSys/src/sales.gif");	
		b4.setIcon(i3);
		
		
		b5=new JButton("REPORT");
		b5.setBounds(0, 500, 300, 50);
		p1.add(b5);
		b5.addActionListener(this);
		b5.setFont(f2);
		Icon i4=new ImageIcon("/home/tanu/PROJECT/BillingSys/src/report.gif");
		b5.setIcon(i4);
		
		b6=new JButton("LOGOUT");
		b6.setBounds(0, 600, 300, 50);
		p1.add(b6);
		Icon i5=new ImageIcon("/home/tanu/PROJECT/BillingSys/src/logout.gif");
		b6.setIcon(i5);
		b6.addActionListener(this);
		b6.setFont(f2);
		/*b7=new JButton("LOGOUT");
		b7.setBounds(0, 970, 300, 120);
		p1.add(b7);
		b7.addActionListener(this);
		Icon i6=new ImageIcon("/home/tanu/PROJECT/BillingSys/src/logout.gif");
		b7.setIcon(i6);*/
		
		//panel2
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(299, 99, 2000, 1100);
		p2.setBorder(b);
		
		
		
		//p2.setBackground(new Color(219,180,216));
		add(p2);
		
	}
	public static void main(String[] args) {
		
			new Dashboard();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		
		
         if(e.getSource()==b6) {
			
			dispose();
		}
		
		if(e.getSource()==b2)
		{
			customer c=new customer();
		    c.setVisible(true);
		    
		   
		}
		if(e.getSource()==b3)
		{
			Product p=new Product();
			p.setVisible(true);
		}
		if(e.getSource()==b4)
		{
			Sales s=new Sales();
			s.setVisible(true);
		}
		if(e.getSource()==b5)
		{
			report r=new report();
			r.setVisible(true);
		}
		
		  
	}

}
