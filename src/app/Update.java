package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Update {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			//conecta ao banco
			conn = DB.getConnection();
			
			//prepara para alterar um dado ja existente
			st = conn.prepareStatement(
					"UPDATE `times`"+
					"SET `nome` = ?, "+
					"`posicao` = ? "+
					"WHERE (`idtimes` = '4');"
					);
			//valores para alteracao ==> logica primeira interrogacao, numero 1
			st.setString(1, "chocolate");
			st.setInt(2, 5);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Linhas afetadas: " + rowsAffected);
		
		}catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			DB.closeConnection();
		}

	}

}
