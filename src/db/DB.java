package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	// 1 - Operação para ler e carregar as propriedades de conexão com o banco de
	// dados
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} 
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	// 2 - Operação para iniciar uma conexão com o banco de dados
	public static Connection getConnection() {
		if (conn == null) {
			try {
				// Pegou as propriedades
				Properties props = loadProperties();
				String url = props.getProperty("dburl");

				// Conexão com o banco de dados passando a url e a propriedades
				conn = DriverManager.getConnection(url, props);
			} 
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	// 3 - Operação para fechar uma conexão
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} 
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
