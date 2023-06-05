package rpg.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import rpg.model.vo.ClasseVO;
import rpg.model.vo.EquipamentoVO;
import rpg.model.vo.PoderVO;

public class CaracteristicasDAO {

		
	
	public ArrayList<ClasseVO> consultarTodasClassesDAO(){
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ClasseVO> listaClasses = new ArrayList<ClasseVO>();
		
		String query = "SELECT CDCLASSE, NOME, DESCRICAO, DANOMOD, VIDAMOD "
				+ "FROM CLASSE ";
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				ClasseVO classe = new ClasseVO();
				classe.setCdClasse(Integer.parseInt(resultado.getString(1)));
				classe.setNome(resultado.getString(2));
				classe.setDescricao(resultado.getString(3));
				classe.setDanoMod(Integer.parseInt(resultado.getString(4)));
				classe.setVidaMod(Integer.parseInt(resultado.getString(5)));
				listaClasses.add(classe);
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar a query do método consultarTodasClassesDAO!");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaClasses;
	}

	public ArrayList<EquipamentoVO> consultarEquipamentosDaClasseDAO(int cdClasse){
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<EquipamentoVO> listaEquipamento = new ArrayList<EquipamentoVO>();
		
		String query = "SELECT  E.* FROM EQUIPAMENTO E JOIN CLASSE C ON E.CDCLASSE = C.CDCLASSE "
				+ "WHERE C.CDCLASSE = " + cdClasse;
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				EquipamentoVO equipamento = new EquipamentoVO();
				equipamento.setCdEquipamento(Integer.parseInt(resultado.getString(1)));
				equipamento.setNome(resultado.getString(2));
				equipamento.setTpEquipamento(resultado.getString(3));
				equipamento.setDescricao(resultado.getString(4));
				equipamento.setBonus(Integer.parseInt(resultado.getString(5)));
				listaEquipamento.add(equipamento);
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar a query do método consultarEquipamentosDaClasseDAO!");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaEquipamento;
	}
	
	public ArrayList<PoderVO> consultarPoderesDaClasseDAO(int cdClasse){
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<PoderVO> listaPoder = new ArrayList<PoderVO>();
		
		String query = "SELECT  P.* FROM PODER P JOIN CLASSE C ON P.CDCLASSE = C.CDCLASSE "
				+ "WHERE C.CDCLASSE = " + cdClasse;
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				PoderVO poder = new PoderVO();
				poder.setCdPoder(Integer.parseInt(resultado.getString(1)));
				poder.setNome(resultado.getString(2));
				poder.setDescricao(resultado.getString(3));
				poder.setBonus(Integer.parseInt(resultado.getString(4)));
				listaPoder.add(poder);
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar a query do método consultarTodosProdutosVigentesDAO!");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaPoder;
	}

	public boolean cadastroItensPersonagem(EquipamentoVO equipamento, int cdPersonagem) {
		
		    Connection conn = Banco.getConnection();
		    Statement stmt = Banco.getStatement(conn);
		    boolean retorno = false;
		    
		    String query = "INSERT INTO EQUIPAMENTOPESONAGEM (CDPERSONAGEM, CDEQUIPAMENTO, FLEQUIPADO) VALUES ('"
		            + cdPersonagem+ "', "
		            + equipamento.getCdEquipamento() + ", "
		            + "'S')";
		    try {
		    	int resultado = stmt.executeUpdate(query);
				if(resultado == 1) {
					retorno = true;
				}
		    } catch (SQLException e) {
		        System.out.println("Erro ao executar a query do método cadastroItensPersonagem!");
		        System.out.println("Erro: " + e.getMessage());
		    }finally {
		        Banco.closeStatement(stmt);
		        Banco.closeConnection(conn);
		    }
		    return retorno;
	}
	
	public boolean cadastroPoderesPersonagem(PoderVO poder, int cdPersonagem) {
		
	    Connection conn = Banco.getConnection();
	    Statement stmt = Banco.getStatement(conn);
	    boolean retorno = false;
	    
	    String query = "INSERT INTO PODERPESONAGEM (CDPERSONAGEM, CDPODER, FLEQUIPADO) VALUES ('"
	            + cdPersonagem+ "', "
	            + poder.getCdPoder() + ", "
	            + "'S')";
	    try {
	    	int resultado = stmt.executeUpdate(query);
			if(resultado == 1) {
				retorno = true;
			}
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar a query do método cadastroPoderesPersonagem!");
	        System.out.println("Erro: " + e.getMessage());
	    }finally {
	        Banco.closeStatement(stmt);
	        Banco.closeConnection(conn);
	    }
	    return retorno;
}

	public ClasseVO classePorPersonagem(int cdclasse) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ClasseVO classe = new ClasseVO();
		
		String query = "SELECT CDCLASSE, NOME, DESCRICAO, DANOMOD, VIDAMOD "
				+ "FROM CLASSE WHERE CDCLASSE = " + cdclasse;
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				classe.setCdClasse(Integer.parseInt(resultado.getString(1)));
				classe.setNome(resultado.getString(2));
				classe.setDescricao(resultado.getString(3));
				classe.setDanoMod(Integer.parseInt(resultado.getString(4)));
				classe.setVidaMod(Integer.parseInt(resultado.getString(5)));
				
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar a query do método consultarTodasClassesDAO!");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return classe;
	}
}
