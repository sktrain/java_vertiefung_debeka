/* JDBC_Zugriff auf Oracle Express
 * Voraussetzung: JAR-Datei mit JDBC-Driver ist im Classpath,
 * das DBMS l�uft und die Zugangsinfos stimmen
 */

package jdbc;

import java.sql.*;


//import oracle.jdbc.*;


public class JdbcTest_H2 {

	public static void main(String[] args) {
		
		//Connection myconnect = null;
		
		//DriverManager.setLogWriter(new PrintWriter(System.out));
		
		
			//Schritt 1
			
				try {
					Class.forName("org.h2.Driver");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Schritt 2 : hier mal try mit Ressourcen
				try (Connection myconnect = 
						DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");){
				
					//myconnect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
				
				//Schritt 3
				System.out.println(myconnect.getMetaData().getDatabaseProductName());
				Statement st = myconnect.createStatement();
				String query = " SELECT * from hr.employees where rownum < 10";
				ResultSet rs = st.executeQuery(query);
				int  anzahlspalten = rs.getMetaData().getColumnCount();
				System.out.println("Insgesamt Spalten verfügbar: " + anzahlspalten);
				while (rs.next()){				
					System.out.println(rs.getString("last_name") + " | " + rs.getString("first_name")+ 
							" | "+rs.getString("salary"));				
				}
//
//				PreparedStatement ps = myconnect
//					.prepareStatement("UPDATE employees SET LAST_NAME = ? WHERE EMPLOYEE_ID = ?");
//				ps.setString(1, "König");
//				ps.setLong(2, 100);
//				ps.executeUpdate();
//
//				rs = st.executeQuery("SELECT EMPLOYEE_ID, LAST_NAME FROM employees WHERE EMPLOYEE_ID = 100");
//				ResultSetMetaData rsmd = rs.getMetaData();
//				System.out.println(rsmd.getColumnName(1) + "\t:\t" + rsmd.getColumnName(2));
//				rs.next();
//				System.out.println(rs.getString("EMPLOYEE_ID") + "\t:\t" + rs.getString("LAST_NAME"));
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();}
						
		/*}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();}*/
		/*finally {
			if (myconnect != null){
				try {
					myconnect.close();
				}catch (SQLException e){
					e.printStackTrace();
				}
			}*/
		}
		

	

}
