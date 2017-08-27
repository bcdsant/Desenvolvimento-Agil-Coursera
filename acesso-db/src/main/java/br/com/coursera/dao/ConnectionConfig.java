package br.com.coursera.dao;

public class ConnectionConfig {
	private static final String db_connection = "jdbc:postgresql://localhost/usuarios";
	private static final String db_user = "postgres";
	private static final String db_password = "admin";
	
	public static String getDbConnection() {
		return db_connection;
	}
	public static String getDbUser() {
		return db_user;
	}
	public static String getDbPassword() {
		return db_password;
	}
	
	
	
}
