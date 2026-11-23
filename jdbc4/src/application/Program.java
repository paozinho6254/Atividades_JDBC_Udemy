package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		PreparedStatement ps = null;
		
		// Nada muito a ser comentado, apenas update de dados de um atributo
		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement("Update seller set BaseSalary = BaseSalary + 1000 where (DepartmentId = 1)");
			
			int rowsAffected = ps.executeUpdate();
			
			System.out.println("Rows affected: "+rowsAffected);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(ps);
			DB.closeConnection();
		}
		
		
	}

}
