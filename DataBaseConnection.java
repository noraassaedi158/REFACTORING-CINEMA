package Model.database;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
public class DatabaseConnection {
	
		 {
		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "@@@@");
		        	System.out.println("connected");
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
	      }
}
