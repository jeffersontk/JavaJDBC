package crud;

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
					"UPDATE `mydb`.`aluno`"+ 
					"SET `alunoNome` = ?,"+
					"`alunoCurso` = ?,"+
					"`alunoAvaliacao` = ?,"+
					"`alunoMatricula` = ?"+ 
					" WHERE "+
					"(`idaluno` = ?)"
					);
			//valores para alteracao ==> logica primeira interrogacao, numero 1
			st.setString(1, "chocolate");
			st.setString(2, "docinho");
			st.setString(3, "reprovado");
			st.setInt(4, 2016333555);
			st.setInt(5, 3);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Linhas afetadas: " + rowsAffected);
		
		}catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			DB.closeConnection();
		}
	}
}
