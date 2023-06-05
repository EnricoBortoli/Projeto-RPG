package rpg.controller;

import java.util.ArrayList;

import rpg.model.bo.PersonagemBO;
import rpg.model.exception.CampoInvalidoException;
import rpg.model.exception.personagemMaximosException;
import rpg.model.vo.PersonagemVO;

public class PersonagemController {
	
	PersonagemBO personagemBO = new PersonagemBO();
	
	public PersonagemVO cadastraPersonagem(PersonagemVO personagemMain) throws CampoInvalidoException, personagemMaximosException {
		
		String mensagemInvalido = "";
		
		if(personagemMain.getNome().trim().isEmpty()) {
			mensagemInvalido += "Insira o nome do personagem! \n";
		}
		
		if(personagemMain.getClasse() == null) {
			mensagemInvalido += "Selecone uma classe ao personagem! \n";
		}
		
		if(personagemMain.getEquipamentosDoPersonagem() == null) {
			mensagemInvalido += "Selecone um equipamento ao personagem! \n";
		}
		
		if(personagemMain.getPoderesDoPersonagem() == null) {
			mensagemInvalido += "Selecone um poder ao personagem! \n";
		}
		
		if(!mensagemInvalido.isEmpty()) {
			throw new CampoInvalidoException(mensagemInvalido);
		}
		
		return personagemBO.cadastrarPersonagemBO(personagemMain);
	}

	public ArrayList<PersonagemVO> consultarTodosPersonagens() {
		ArrayList<PersonagemVO> listaPersonagens = new ArrayList<PersonagemVO>();
		listaPersonagens = personagemBO.consultarTodosPersonagens();
		return listaPersonagens;
	}
	
}
