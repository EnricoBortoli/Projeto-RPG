package rpg.model.bo;

import rpg.model.vo.PersonagemVO;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import rpg.model.dao.PersonagemDAO;
import rpg.model.exception.personagemMaximosException;

public class PersonagemBO {

	PersonagemDAO personagemDAO = new PersonagemDAO();
	public PersonagemVO cadastrarPersonagemBO(PersonagemVO personagemVO) throws personagemMaximosException {
		if(personagemDAO.verificarEspacoDeSaveDAO(personagemVO)) {
			personagemVO = personagemDAO.cadastrarPersonagemDAO(personagemVO);
		} else {
			String mensagemNumeroPersonagens = "Já existem 3 personagens caradastrados";
			throw new personagemMaximosException(mensagemNumeroPersonagens);
		}
		return personagemVO;
	}

	public ArrayList<PersonagemVO> consultarTodosPersonagens() {
		ArrayList<PersonagemVO> listaPersonagens = new ArrayList<PersonagemVO>();
		listaPersonagens = personagemDAO.consultarTodosPersonagens();
		return listaPersonagens;
	};
	
}
