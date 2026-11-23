package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	

	// Por padrão deixar o conn como null, que ainda vai receber uma conexão
	private static Connection conn = null;

	// Método de conexão
	public static Connection getConnection() {
		// Esperando que haja inconsistências com banco, bloco try evita um crash
		try {
			// Caso conn esteja no estado esperado
			if (conn == null) {
				// Método que retorna as propriedades de acesso ao banco
				Properties props = loadProperties();
				// Url que direciona localmente o endereço do banco MySQL
				String url = props.getProperty("dburl");
				// Conn utiliza do Driver de conexão com MySQL anteriormente baixado,
				// utilzando o Url e as propriedades para ter acesso ao banco.
				conn = DriverManager.getConnection(url, props);
			}
			// Exceção para possíveis intabilidades
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		// Caso a conexão de certo é retornado o conn, reponsável pela ponte de ligação
		return conn;
	}

	// Método para fechar conexão
	public static void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	// Método responsável por ler as propriedades do arquivo que carrega as
	// informações do banco
	private static Properties loadProperties() {
		// Tentantiva de acesso ao arquivo
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			// Objeto props faz a leitura dos dados contidos
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	//Fechamento de Statement
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// Fechamento do ResultSet
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
}
