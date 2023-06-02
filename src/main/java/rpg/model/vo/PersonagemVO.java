package rpg.model.vo;

import java.util.ArrayList;

import rpg.util.ModeloPersonagem;

public class PersonagemVO extends ModeloPersonagem {
	
	private int cdPersonagem;
	private ClasseVO classe;
	private int expAtual;
	private ArrayList<EquipamentoVO> equipamentosDoPersonagem = new ArrayList<EquipamentoVO>();
	private ArrayList<PoderVO> poderesDoPersonagem = new ArrayList<PoderVO>();
	
	public PersonagemVO(String nome, int dano, int vida, int cdPersonagem, ClasseVO classe, int expAtual,
			ArrayList<EquipamentoVO> equipamentosDoPersonagem, ArrayList<PoderVO> poderesDoPersonagem) {
		super(nome, dano, vida);
		this.cdPersonagem = cdPersonagem;
		this.classe = classe;
		this.expAtual = expAtual;
		this.equipamentosDoPersonagem = equipamentosDoPersonagem;
		this.poderesDoPersonagem = poderesDoPersonagem;
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

	public ArrayList<EquipamentoVO> getEquipamentosDoPersonagem() {
		return equipamentosDoPersonagem;
	}

	public void setEquipamentosDoPersonagem(ArrayList<EquipamentoVO> equipamentosDoPersonagem) {
		this.equipamentosDoPersonagem = equipamentosDoPersonagem;
	}

	public ArrayList<PoderVO> getPoderesDoPersonagem() {
		return poderesDoPersonagem;
	}

	public void setPoderesDoPersonagem(ArrayList<PoderVO> poderesDoPersonagem) {
		this.poderesDoPersonagem = poderesDoPersonagem;
	}
	
}
