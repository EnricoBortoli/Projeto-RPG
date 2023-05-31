package rpg.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rpg.model.vo.PersonagemVO;



public class PersonagemDAO {
	
	public PersonagemVO cadastrarPersonagemDAO(PersonagemVO personagemVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		
		String query = "INSERT INTO PERSONAGEM (NOME, DANO, VIDA, CDCLASSE, CDEQUIPAMENTO, CDPODER, EXPATUAL) VALUES ("
				+ personagemVO.getNome() + ", "
				+ personagemVO.getDano() + ", "
				+ personagemVO.getVida() + ", "
				+ personagemVO.getClasse().getCdClasse() + ", "		
				+ personagemVO.getExpAtual() + ")";
		try {
			int resultado = stmt.executeUpdate(query);
			if(resultado == 1) {
				retorno = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query do método cadastrarPersonagemDAO!");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return personagemVO;
	};	
	
	
	public boolean verificarEspacoDeSaveDAO(PersonagemVO personagemVO) {
		Connection conn= Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		boolean retorno = true;
		
		String query = "SELECT MAX CDPERSONAGEM "
				+ "FROM PERSONAGEM;";

		try {
			resultado = stmt.executeQuery(query);
			if (resultado.equals(3)) {
				retorno = false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query do método verificarExistenciaProdutoPorNomeDAO");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
}



