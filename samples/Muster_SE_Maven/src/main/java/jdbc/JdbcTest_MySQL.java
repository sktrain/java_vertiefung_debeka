package jdbc;

import java.io.PrintWriter;
import java.sql.*;


public class JdbcTest_MySQL {

	public static void main(String[] args) {
		
		Connection myconnect = null;
		
		DriverManager.setLogWriter(new PrintWriter(System.out));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
						
			myconnect = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/classicmodels", "root", "");
			
			
			Statement st = myconnect.createStatement();
			String query = "SELECT * from employees";
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmeta = rs.getMetaData();
			System.out.println(rsmeta.getColumnName(1)+ " : " +
					rsmeta.getColumnName(2)+ " : " +rsmeta.getColumnName(3));
			while (rs.next()){
				System.out.println(rs.getString(1) + " | " + rs.getString(2)+
						" | "+rs.getString(3));
			}
						
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if (myconnect != null){
				try {
					myconnect.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}
		}
		

	}

}