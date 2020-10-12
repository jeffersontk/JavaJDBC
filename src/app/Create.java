package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import db.DB;

public class Create {
 public static void main(String[] args) throws ParseException {
	 //abrir conex�o
	 Connection conn = null;
	 //prepara o statemente
	 PreparedStatement st = null;
	 
	 try {
		 conn = DB.getConnection();
// inserir cod sql aqui na tabela desejada
// lembrando dos nomes das colunas
		 st = conn.prepareStatement(
				 "INSERT INTO times" +
				 "(nome, posicao)" +
				 
				 "VALUES " +
				 "(?,?)"
				 );
//a virgula � o que ser� substituido por informa��es
//logo esse � um codigo generico para a minha tabala s� com duas colunas.
		 	st.setString(1, "uniCarioca");
			st.setInt(2, 4);
//n�o precisa de aspas se for numeros
//caso precise de data ==> 
//st.setDate(posicaoColuna, new java.sql.Date(sdf.parse("dd/mm/aaaa").getTime()));
			
			// o cara que faz as coisas acontecerem � esse ai h�
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Linhas afetadas: "+ rowsAffected);
	 }
	 catch (SQLException e) {
		e.printStackTrace();
	}
	 finally {
			DB.closeConnection();
		}
}
}
