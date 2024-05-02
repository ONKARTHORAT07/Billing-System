import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class ProductData extends JFrame implements ActionListener {
    private JTable table;
    //Font f=new Font("Serif", Font.BOLD, 30);

    public ProductData() {
        setTitle("Product Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
        setSize(1000,700);
        setLocation(600,200);
        //table.setFont(f);

        
        String url = "jdbc:postgresql://localhost/BillingSystem"; 
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/BillingSystem","postgres","Onkar@123");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM product";
            ResultSet resultSet = statement.executeQuery(query);
            table = new JTable(buildTableModel(resultSet));
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }
        Object[][] data = new Object[50][columnCount]; 
        int rowCount = 0;
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                data[rowCount][i - 1] = resultSet.getObject(i);
            }
            rowCount++;
        }
        return new DefaultTableModel(data, columnNames);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductData example = new ProductData();
            example.setVisible(true);
        });
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
