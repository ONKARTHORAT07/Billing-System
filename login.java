import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class login extends JFrame implements ActionListener 
{
	Container c;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2;
	JPasswordField p1;
	JButton b1,b2;
	login()
	{
		//setUndecorated(true);
		setSize(1000,700);
		setLocation(600,200);
	    Font f=new Font("Serif",Font.BOLD,30);	
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		//c.setBackground(new Color(51,204,220));
		l1=new JLabel("LOGIN");
		l1.setBounds(370,9, 600, 50);
		l1.setFont(f);
		l2=new JLabel("UserName");
		l3=new JLabel("Password");
		l2.setBounds(200, 100, 300, 40);
		l2.setFont(f);
		l3.setBounds(200,170,160,40);
		l3.setFont(f);
		t1=new JTextField(20);
		t1.setBounds(450,100,300,40);
		p1=new JPasswordField(20);
		p1.setBounds(450,170,160,40);
		l4=new JLabel("UserType");
		l4.setBounds(200,250,900,40);
		l4.setFont(f);
		String[] values= {"Admin","Worker"};
		JComboBox c1=new JComboBox(values);
		c1.setBounds(450,250,300,40);
		b1=new JButton("Login");
		b1.setBounds(300,350,90,40);
		b2=new JButton("Cancel");
		b2.setBounds(450,350,90,40);
		c.add(l1);
		c.add(l2); 
		c.add(t1);
		c.add(l3); 
		c.add(p1);
		c.add(l4);
		c.add(c1);
		c.add(b1); 
		c.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public static void main(String[] args) 
	{
		new login();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
		String un,pass;
		un=t1.getText();
		pass=p1.getText();
		if(un.equals("sai")&& pass.equals("ram"))
		{
			JOptionPane.showMessageDialog(null,"Login Successfully");
			new Dashboard();
		}
		else
			JOptionPane.showMessageDialog(null,"Incorrect Username & Password");
		}
		if(e.getSource()==b2)
			dispose();
		}
	}
