package Model.database;

import java.sql.Statement;

public class DatabaseSetUp {
	public static void makeTables() {
		Statement state= DatabaseConnection.getConnection().createStatement();
		state.executeUpdate("CREATE TABLE account (username VARCHAR PRIMARY KEY, password VARCHAR NOT NULL UNIQUE)" );
		
	}

}
