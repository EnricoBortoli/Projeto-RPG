package rpg.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import rpg.model.dao.CaracteristicasDAO;
import rpg.model.vo.ClasseVO;
import rpg.model.vo.EquipamentoVO;
import rpg.model.vo.PoderVO;
import rpg.model.vo.RegiaoVO;

public class CaracteristicasController {

	private CaracteristicasDAO caracteristicasDAO = new CaracteristicasDAO();;

	public ArrayList<ClasseVO> consultarTodasClassesController() {
		caracteristicasDAO = new CaracteristicasDAO();
		ArrayList<ClasseVO> listaClasses = new ArrayList<ClasseVO>();
		listaClasses = caracteristicasDAO.consultarTodasClassesDAO();
		return listaClasses;
	}

	public ArrayList<EquipamentoVO> ConsultaEquipamentoPorClasseController(int cdClasse) {
		caracteristicasDAO = new CaracteristicasDAO();
		ArrayList<EquipamentoVO> listaEquipamentoPorClasse = new ArrayList<EquipamentoVO>();
		listaEquipamentoPorClasse = caracteristicasDAO.consultarEquipamentosDaClasseDAO(cdClasse);
		return listaEquipamentoPorClasse;		
	}

	public ArrayList<PoderVO> ConsultaPoderPorClasseController(int cdClasse) {
		caracteristicasDAO = new CaracteristicasDAO();
		ArrayList<PoderVO> listaPoderPorClasse = new ArrayList<PoderVO>();
		listaPoderPorClasse = caracteristicasDAO.consultarPoderesDaClasseDAO(cdClasse);
		return listaPoderPorClasse;
	}

	public ArrayList<RegiaoVO> consultaRegioes() {
		caracteristicasDAO = new CaracteristicasDAO();
		ArrayList<RegiaoVO> listaRegioes = new ArrayList<RegiaoVO>();
		listaRegioes = caracteristicasDAO.consultaRegioesDAO();
		return listaRegioes;
	}

}
