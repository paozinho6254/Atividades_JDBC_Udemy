package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		// Declaração dos objetos
		Connection conn = null;
		// Responsável pelos comandos SQL
		Statement st = null;
		// Carrega os dados da tabela
		ResultSet rs = null;

		try {
			// Abre conexão
			conn = DB.getConnection();
			// Carrega o estado resposável por mandar os comandos sem parâmetro
			st = conn.createStatement();
			// Carrega os dados da Requisição no banco
			rs = st.executeQuery("Select * from department");
			// Faz a leitura de cada Linha 
			while (rs.next()) {
					System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Padrão, sempre feche as conexões no finally
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
			
	}

}
