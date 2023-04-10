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
				classe.setCdClasse(Integer.parseInt(resultado.getString(0)));
				classe.setNome(resultado.getString(1));
				classe.setDescricao(resultado.getString(2));
				classe.setDanoMod(Integer.parseInt(resultado.getString(3)));
				classe.setVidaMod(Integer.parseInt(resultado.getString(4)));
				listaClasses.add(classe);
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar a query do método consultarTodosProdutosVigentesDAO!");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaClasses;
	}

	public ArrayList<EquipamentoVO> consultarEquipamentosDaClasseDAO(ClasseVO classeVO){
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<EquipamentoVO> listaEquipamento = new ArrayList<EquipamentoVO>();
		
		String query = "SELECT  E.* FROM EQUIPAMENTO E JOIN CLASSE C ON E.CDCLASSE = C.CDCLASSE "
				+ "WHERE C.CDCLASSE = " + classeVO.getCdClasse();
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				EquipamentoVO equipamento = new EquipamentoVO();
				equipamento.setCdEquipamento(Integer.parseInt(resultado.getString(0)));
				equipamento.setNome(resultado.getString(1));
				equipamento.setTpEquipamento(resultado.getString(2));
				equipamento.setDescricao(resultado.getString(3));
				equipamento.setBonus(Integer.parseInt(resultado.getString(4)));
				equipamento.setFlEquipado(resultado.getString(5));
				listaEquipamento.add(equipamento);
			}
		} catch (Exception e) {
			System.out.println("Erro ao executar a query do método consultarTodosProdutosVigentesDAO!");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaEquipamento;
	}
	
	public ArrayList<PoderVO> consultarPoderesDaClasseDAO(ClasseVO classeVO){
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<PoderVO> listaPoder = new ArrayList<PoderVO>();
		
		String query = "SELECT  P.* FROM PODER P JOIN CLASSE C ON P.CDCLASSE = C.CDCLASSE "
				+ "WHERE C.CDCLASSE = " + classeVO.getCdClasse();
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				PoderVO poder = new PoderVO();
				poder.cdPoder(Integer.parseInt(resultado.getString(0)));
				poder.setNome(resultado.getString(1));
				poder.setDescricao(resultado.getString(3));
				poder.setBonus(Integer.parseInt(resultado.getString(4)));
				poder.setFlEquipado(resultado.getString(5));
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
}
