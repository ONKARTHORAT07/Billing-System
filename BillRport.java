import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
class BillReport extends JFrame implements ActionListener
{
	int num;
	@SuppressWarnings("deprecation")
	public BillReport(int num)
	{
		try
		{
		Class.forName("org.postgresql.Driver");
   		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/BillingSystem","postgres","Onkar@123");
    	Statement st=con.createStatement();
    	File ff=new File("D:\\report.html");
    	FileWriter fw=new FileWriter(ff);
    		BufferedWriter bw=new BufferedWriter(fw);
    		bw.write("<html>");
    		bw.write("<title>  </title>");
    		bw.write("<head>   </head>");
    		bw.write("<body>");
		ResultSet rs=st.executeQuery("select * from salesorder where cid="+num);
		
		if(rs.next())
		{	
        	bw.write("<table align=center  border=1 width=50% height=12% bgcolor=white><tr><td width=10% background=.jpeg><td><h2 align=center><font color='Red'><i>AATO.CO<i></tr></table>");
       		
		    //bw.write("<table align=center  border=1 width=50% height=5% bgcolor=white><tr><td><h4 align=center><font color='green'>AATO.CO </tr></table>");
    		
		    bw.write("<table align=center  border=1 width=50% height=5% bgcolor=white><tr><td><h4 align=center><font color='green'>A/P-Shirdi,Tal-Rahata,Dist-Ahmednagar  </tr></table>");
    		
            bw.write("<table align=center  border=1 width=50% height=5% bgcolor=white><tr><td><h4 align=left><font color='Blue'>Customer Id: "+rs.getString(1)+"<td width=35%><h4><font color='Blue'>Date:"+getCurrentDate() +"</tr></table>");
    		
			bw.write("<table align=center  border=1 width=50% height=5% bgcolor=white><tr><td><h3><font color='Blue'>Customer Name: "+rs.getString(2)+"<td width=35%><h4><font color='Blue'>Contact No:"+rs.getString(3)+"</tr></table>");
    			
            bw.write("<table align=center  border=1 width=50% height=5% bgcolor=white><tr><td><h3><font color='Blue'>Customer Address: "+rs.getString(4)+"</tr></table>");
    		}
    		
               
    		bw.write("<table border=2 cellpadding=10 align=center width=50% background=aaaa.jpg>");
    		
    		              	
		bw.write("<tr>");
		int total=0,sum=0,p;
		//bw.write("<th><font color='Blue'>Product Id");
		bw.write("<th><font color='Blue'>Product Company");
		bw.write("<th><font color='Blue'>Product Name");
		bw.write("<th><font color='Blue'>Qty");
		bw.write("<th><font color='Blue'>Price");
		bw.write("<th><font color='Blue'>Amount");
			
		bw.write("</tr>");
		//rs.close();
		ResultSet rs1=st.executeQuery("select * from salesorder where cid="+num);
		
			while(rs1.next())
			{
	       		bw.write("<tr>");
	        //bw.write("<td><font color='Blue'>"+rs.getString(5));
      		bw.write("<td><font color='Blue'>"+rs1.getString(5));
			bw.write("<td><font color='Blue'>"+rs1.getString(6));
			bw.write("<td><font color='Blue'>"+rs1.getInt(7));
			bw.write("<td><font color='Blue'>"+rs1.getInt(8));
			p=rs1.getInt(7)*rs1.getInt(8);
			sum=sum+p;
		    bw.write("<td><font color='Blue'>"+sum);
          	//total=Integer.parseInt(rs.getString(13));
			 
			bw.write("</tr>");
		
			}
			//rs1.close();
		bw.write("<tr>");

               
		bw.write("<td colspan=3><font color='Blue'>Total");
		bw.write("<td><font color='Blue'>"+sum);
 
		bw.write("</tr>");
		bw.write("<tr>");
		double gst=0;
		gst=sum+(sum*0.18);
        
bw.write("<td colspan=3><font color='Blue'>Final Bill With GST (9% SGST +9% CGST)");
bw.write("<td><font color='Blue'>"+gst);

bw.write("</tr>");
			
		bw.write("</table>");
			
		//bw.write("<table align=center  border=1 width=50% height=5% bgcolor=pink><tr><td><h4 align='left'><font color='Blue'>Customer Signature.................<h4 align='right'><font color='Blue'>Authorised Signature:-.................</tr></table>");
		bw.write("</body>");
		bw.write("</html>");	
		Runtime r=Runtime.getRuntime();
		Runtime.getRuntime().exec("cmd /c start firefox D:\\report.html");
		bw.close();
		}
		catch(Exception e)
		{
			System.out.print("\n Error="+e);
		}
	}
	private String getCurrentDate() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(new Date());
	}
	public static void main(String args[])
	{
//		new BillReport(1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
