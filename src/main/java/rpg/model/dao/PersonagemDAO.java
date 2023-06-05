package rpg.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import rpg.model.vo.EquipamentoVO;
import rpg.model.vo.PoderVO;
import rpg.model.vo.ClasseVO;
import rpg.model.vo.PersonagemVO;
import rpg.model.dao.Banco;



public class PersonagemDAO {
	
	public PersonagemVO cadastrarPersonagemDAO(PersonagemVO personagemVO) {
	    Connection conn = Banco.getConnection();
	    Statement stmt = Banco.getStatement(conn);

	    String query = "INSERT INTO PERSONAGEM (NOME, DANO, VIDA, CDCLASSE) VALUES ('"
	            + personagemVO.getNome() + "', "
	            + personagemVO.getClasse().getDanoMod()+ ", "
	            + personagemVO.getClasse().getVidaMod()+ ", "
	            + personagemVO.getClasse().getCdClasse() + ")";
	    try {
	        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
	        ResultSet generatedKeys = stmt.getGeneratedKeys();
	        if (generatedKeys.next()) {
	        	personagemVO.setCdPersonagem(generatedKeys.getInt(1));
	        }
	        CaracteristicasDAO caracteristicasDAO = new CaracteristicasDAO();
	        ArrayList<EquipamentoVO> equipamentos = personagemVO.getEquipamentosDoPersonagem();
	        ArrayList<PoderVO> poderes = personagemVO.getPoderesDoPersonagem();
	        for (EquipamentoVO equipamento : equipamentos) {
	            caracteristicasDAO.cadastroItensPersonagem(equipamento, personagemVO.getCdPersonagem());
	        }
	        for (PoderVO poder : poderes) {
	            caracteristicasDAO.cadastroPoderesPersonagem(poder, personagemVO.getCdPersonagem());
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a query do método cadastrarPersonagemDAO!");
	        System.out.println("Erro: " + e.getMessage());
	    } finally {
	        Banco.closeStatement(stmt);
	        Banco.closeConnection(conn);
	    }
	    return personagemVO;
	}


	public boolean verificarEspacoDeSaveDAO(PersonagemVO personagemVO) {
	    Connection conn = Banco.getConnection();
	    Statement stmt = Banco.getStatement(conn);
	    ResultSet resultado = null;
	    boolean retorno = false;
	    
	    String query = "SELECT MAX(CDPERSONAGEM) FROM PERSONAGEM";

	    try {
	        resultado = stmt.executeQuery(query);
	        if (resultado.next()) {
	            int maxCdPersonagem = resultado.getInt(1);
	            if (maxCdPersonagem <= 3) {
	                retorno = true;
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a query do método verificarExistenciaProdutoPorNomeDAO");
	        System.out.println("Erro: " + e.getMessage());
	    } finally {
	        Banco.closeResultSet(resultado);
	        Banco.closeStatement(stmt);
	        Banco.closeConnection(conn);
	    }
	    return retorno;
	}


	public ArrayList<PersonagemVO> consultarTodosPersonagens() {
		String sql = " SELECT * FROM PERSONAGEM ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<PersonagemVO> listaPersonagens = new ArrayList<PersonagemVO>();
		
		try {
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				PersonagemVO personagens = new PersonagemVO();
				CaracteristicasDAO classeDAO = new CaracteristicasDAO();
				ClasseVO classe = new ClasseVO();
				
				personagens.setCdPersonagem(result.getInt("CDPERSONAGEM"));
				personagens.setNome(result.getString("NOME"));
				personagens.setDano(result.getInt("DANO"));
				personagens.setVida(result.getInt("VIDA"));
				personagens.setExpAtual(result.getInt("EXPATUAL"));
				classe = classeDAO.classePorPersonagem(result.getInt("CDCLASSE"));
				personagens.setClasse(classe);
				
				listaPersonagens.add(personagens);
			}
		} catch (SQLException e) {
			System.out.println("Erro listar todos os personagens. Causa: \n:" + e.getCause());
		}
		return listaPersonagens;
	}
}



