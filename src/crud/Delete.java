package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Connection conn = null;
			PreparedStatement st = null;
			try {
				//conecta ao banco
				conn = DB.getConnection();
				
				//prepara para deletar um dado ja existente
				st = conn.prepareStatement(
						"DELETE FROM `times`"+
						"WHERE"+
						"`idtimes` = ?"
						);
				//valores para alteracao ==> logica primeira interrogacao, numero 1
				st.setInt(1, 5);
				
				int rowsAffected = st.executeUpdate();
				
				System.out.println("Linhas afetadas: " + rowsAffected);
			
			}catch (SQLException e) {
				e.printStackTrace();
			
			}finally {
				DB.closeConnection();
			}
		
	}

}
