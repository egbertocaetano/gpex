package gpex.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String H2Driver = "org.h2.Driver";  
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {                     
	      Class.forName(H2Driver);  
	      return DriverManager.getConnection("jdbc:h2:~/extensao;AUTO_SERVER=TRUE", "sa", "");
	   }  
}
