package rpg.model.bo;

import rpg.model.vo.PersonagemVO;

import javax.swing.JOptionPane;

import rpg.model.dao.PersonagemDAO;

public class PersonagemBO {

	public PersonagemVO cadastrarPersonagemBO(PersonagemVO personagemVO) {
		PersonagemDAO personagemDAO = new PersonagemDAO();
		if(personagemDAO.verificarEspacoDeSaveDAO(personagemVO)) {
			personagemVO = personagemDAO.cadastrarPersonagemDAO(personagemVO);
		} else {
			JOptionPane.showMessageDialog(null, "Não existem slots de save livres.");
		}
		return personagemVO;
	};
	
}


/*
	public ProdutoVO cadastrarProdutoBO(ProdutoVO produtoVO) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		if (produtoDAO.verificarExistenciaProdutoPorNomeDAO(produtoVO)) {
			System.out.println("Produto ja esta )cadastrado!");
		} else {
			produtoVO = produtoDAO.cadastrarProdutoDAO(produtoVO);
		}
		return produtoVO;
	}
*/