import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
public class report extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6;
	
	Container c;
	
	report()
	{
		setUndecorated(true);
		setSize(1000,700);
		setLocation(600,200);
		setVisible(true);
	
	
	c=getContentPane();
	c.setLayout(null);
	c.setBackground(new Color(219,180,216));
	b1=new JButton("Customer Data");
	b1.setBounds(250,250,190,90);
	b2=new JButton("Product Data");
	b2.setBounds(550,250,190,90);
	
	c.add(b1);
	c.add(b2);
	//c.add(b3);
	//c.add(b4);

	b1.addActionListener(this);
	b2.addActionListener(this);
	
	
	}

	public static void main(String[] args) 
	{
		new report();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	if(e.getSource()==b1)
	{
	CustomerData cd=new CustomerData();
	cd.setVisible(true);
	}
	if(e.getSource()==b2)
	{
		ProductData pd=new ProductData();
		pd.setVisible(true);
	}
	}

}
