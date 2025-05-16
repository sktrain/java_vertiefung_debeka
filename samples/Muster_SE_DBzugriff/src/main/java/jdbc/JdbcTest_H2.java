/* JDBC_Zugriff auf Oracle Express
 * Voraussetzung: JAR-Datei mit JDBC-Driver ist im Classpath,
 * das DBMS l�uft und die Zugangsinfos stimmen
 */

package jdbc;

import java.sql.*;


//import oracle.jdbc.*;


public class JdbcTest_H2 {

    public static void main(String[] args) {

        //DriverManager.setLogWriter(new PrintWriter(System.out));

        //Schritt 1: Laden des Treibers (passiert bei aktuellen Treibern via ServiceLoader-Mechanismus
//
//				try {
//					Class.forName("org.h2.Driver");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
        //DriverManager.registerDriver(new org.h2.Driver());

        //Schritt 2: da Connection AutoCloseable ->  try mit Ressourcen
        try (Connection myconnect =
                     DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");) {


            //Schritt 3: SQL-Anweisungen absetzen
            System.out.println(myconnect.getMetaData().getDatabaseProductName());
            Statement st = myconnect.createStatement();
            String query = "SELECT * FROM HR.EMPLOYEES WHERE rownum < 10";
            ResultSet rs = st.executeQuery(query);
            int anzahlspalten = rs.getMetaData().getColumnCount();
            System.out.println("Insgesamt Spalten verfügbar: " + anzahlspalten);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " | " + rs.getString(2));
            }

            PreparedStatement ps = myconnect
                    .prepareStatement("UPDATE HR.EMPLOYEES SET LAST_NAME = ? WHERE EMPLOYEE_ID = ?");
            ps.setString(1, "König");
            ps.setLong(2, 100);
            ps.executeUpdate();

            rs = st.executeQuery("SELECT EMPLOYEE_ID, LAST_NAME FROM HR.EMPLOYEES WHERE EMPLOYEE_ID = 100");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "\t:\t" + rsmd.getColumnName(2));
            rs.next();
            System.out.println(rs.getString("EMPLOYEE_ID") + "\t:\t" + rs.getString("LAST_NAME"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
