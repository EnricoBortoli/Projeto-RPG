package rpg.model.bo;

import rpg.model.vo.PersonagemVO;

import javax.swing.JOptionPane;

import rpg.model.dao.PersonagemDAO;
import rpg.model.exception.personagemMaximosException;

public class PersonagemBO {

	public PersonagemVO cadastrarPersonagemBO(PersonagemVO personagemVO) throws personagemMaximosException {
		PersonagemDAO personagemDAO = new PersonagemDAO();
		if(personagemDAO.verificarEspacoDeSaveDAO(personagemVO)) {
			personagemVO = personagemDAO.cadastrarPersonagemDAO(personagemVO);
		} else {
			String mensagemNumeroPersonagens = "Já existem 3 personagens caradastrados";
			throw new personagemMaximosException(mensagemNumeroPersonagens);
		}
		return personagemVO;
	};
	
}
