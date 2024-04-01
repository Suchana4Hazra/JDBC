import java.sql.*;
public class connect {
	
	public static Connection get_con() {
		
       Connection con = null;
       try {
       	
       	  Class.forName("oracle.jdbc.driver.OracleDriver");
       	  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
       } catch(Exception e) {
       	
       	  System.out.println("Connection error"+e.getMessage());
       }
       return con;
	}
	
	public static void main(String[] args) {
		
		Connection m = connect.get_con();
		System.out.println(m);
	}
}