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
		        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "@");
		        }
		        catch(SQLException e) {
		        	 e.printStackTrace();
		        } catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
		          try {
		        	 state= DatabaseConnection.getConnection().createStatement();
		        	 System.out.println(connection);
					state.executeUpdate("CREATE DATABASE IF NOT EXISTS cinema");
				} catch (NullPointerException e) {
					
					e.printStackTrace();
				}
		          catch (SQLException e) {
						
						e.printStackTrace();
					}
			        try {
			        	Class.forName("com.mysql.cj.jdbc.Driver");
			        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "@");
			        
			        	
			        }
			        catch(SQLException e) {
			        	 e.printStackTrace();
			        } catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
		
		 }
		 public static Connection getConnection() {
			 
   			 return connection;
   			 }
			 
		 
		 
	      
		 
}
