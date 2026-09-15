package Model.database;

import java.sql.Statement;

public class DatabaseSetUp {
	Statement state;
	public DatabaseSetUp() {{
		try {
		    state= DatabaseConnection.getConnection().createStatement();
		   state.executeUpdate("CREATE TABLE IF NOT EXISTS account (username VARCHAR(50) PRIMARY KEY, password VARCHAR(50) NOT NULL UNIQUE)" );
		   state.executeUpdate("CREATE TABLE IF NOT EXISTS cinema (cinema_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50))");
		   state.executeUpdate("CREATE TABLE IF NOT EXISTS room (id INT AUTO_INCREMENT FORIEGN KEY (cinema_id) REFERENCE cinema, )");
		
	}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
}
