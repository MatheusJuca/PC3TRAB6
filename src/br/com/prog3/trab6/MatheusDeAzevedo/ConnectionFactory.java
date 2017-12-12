package br.com.prog3.trab6.MatheusDeAzevedo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String pass = "12345678";
		String url = "jdbc:postgresql://127.0.0.1:5432/trabalho6";
		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, pass);
			System.out.println("Conexão realizada com sucesso");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Exceção: " + e.getMessage());
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			System.err.println("Exceção: " + e.getMessage());
		}
	}
}