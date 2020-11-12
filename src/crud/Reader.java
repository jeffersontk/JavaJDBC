package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Reader {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//cria a conexao
			conn = DB.getConnection();
			//chama a conexao para o st
			st = conn.createStatement();
			// aqui poem o sql - nome da tabela
			rs = st.executeQuery("select * from aluno");
			
			// percorrer o vetor no banco
			while(rs.next()) {
				System.out.println(
						//para apresentar os dados do banco de acordo com o nome e tipo da coluna
						rs.getInt("idaluno") + " | "+
						rs.getString("alunoNome") + " | "+
						rs.getString("alunoCurso")+ " | "+
						rs.getString("alunoAvaliacao")+ " | "+
						rs.getInt("alunoMatricula")
						);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
