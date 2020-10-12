package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import db.DB;

public class Create {
 public static void main(String[] args) throws ParseException {
	 //abrir conexão
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
//a virgula é o que será substituido por informações
//logo esse é um codigo generico para a minha tabala só com duas colunas.
		 	st.setString(1, "uniCarioca");
			st.setInt(2, 4);
//não precisa de aspas se for numeros
//caso precise de data ==> 
//st.setDate(posicaoColuna, new java.sql.Date(sdf.parse("dd/mm/aaaa").getTime()));
			
			// o cara que faz as coisas acontecerem é esse ai hó
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
