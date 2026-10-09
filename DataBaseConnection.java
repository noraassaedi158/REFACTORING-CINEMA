package Model.database;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseConnection {
	static Connection connection;
	Statement state;
	
		 {
		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
		        	
		        	
		        }
		        catch(Exception e) {
		        	System.out.println(e);
		        }
		          try {
		        	 state= this.getConnection().createStatement();
					state.executeUpdate("CREATE DATABASE IF NOT EXISTS cinema");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			        try {
			        	Class.forName("com.mysql.cj.jdbc.Driver");
			        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
			        
			        	
			        }
			        catch(Exception e) {
			        	System.out.println(e);
			        }
		
		 }
		 public static Connection getConnection() {
			 
   			 return connection;
   			 }
			 
		 
		 
	      
		 
}
