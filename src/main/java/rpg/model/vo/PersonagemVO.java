package rpg.model.vo;

import rpg.util.ModeloPersonagem;

public class PersonagemVO extends ModeloPersonagem {
	
	private int cdPersonagem;
	private ClasseVO classe;
	private int expAtual;
	
	public PersonagemVO(String nome, int dano, int vida, int cdPersonagem, ClasseVO classe, int expAtual) {
		super(nome, dano, vida);
		this.cdPersonagem = cdPersonagem;
		this.classe = classe;
		this.expAtual = expAtual;
	}

	public PersonagemVO() {
		super();
	}

	public int getCdPersonagem() {
		return cdPersonagem;
	}

	public void setCdPersonagem(int cdPersonagem) {
		this.cdPersonagem = cdPersonagem;
	}

	public ClasseVO getClasse() {
		return classe;
	}

	public void setClasse(ClasseVO classe) {
		this.classe = classe;
	}

	public int getExpAtual() {
		return expAtual;
	}

	public void setExpAtual(int expAtual) {
		this.expAtual = expAtual;
	}

	@Override
	public String toString() {
		return "Classe: " + classe + "\nXP Total: " + expAtual;
	}
	
	
	
	
	
	

	
}
