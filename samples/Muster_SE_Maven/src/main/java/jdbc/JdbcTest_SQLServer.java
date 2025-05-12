package jdbc;

import java.io.PrintWriter;
import java.sql.*;


//import oracle.jdbc.*;


public class JdbcTest_SQLServer {

	public static void main(String[] args) {
		
		Connection myconnect = null;
		
		DriverManager.setLogWriter(new PrintWriter(System.out));
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						
			myconnect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks;integratedSecurity=true");
			
			
			Statement st = myconnect.createStatement();
			String query = "SELECT * from HumanResources.Employee";
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()){
				System.out.println(rs.getString(1) + " | " + rs.getString(2)+ " | "+rs.getString(3));
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
