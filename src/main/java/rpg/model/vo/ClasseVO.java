package rpg.model.vo;

import java.util.Scanner;

public class ClasseVO {

	private int cdClasse;
	private String nome;
	private String descricao;
	private int danoMod;
	private int vidaMod;
	private EquipamentoVO listaEquipamentos[];
	private PoderVO listaPoder[];
	
	public ClasseVO(int cdClasse, String nome, String descricao, int danoMod, int vidaMod,
			EquipamentoVO[] listaEquipamentos, PoderVO[] listaPoder) {
		super();
		this.cdClasse = cdClasse;
		this.nome = nome;
		this.descricao = descricao;
		this.danoMod = danoMod;
		this.vidaMod = vidaMod;
		this.listaEquipamentos = listaEquipamentos;
		this.listaPoder = listaPoder;
	}

	public ClasseVO() {
		super();
	}

	public int getCdClasse() {
		return cdClasse;
	}

	public void setCdClasse(int cdClasse) {
		this.cdClasse = cdClasse;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDanoMod() {
		return danoMod;
	}

	public void setDanoMod(int danoMod) {
		this.danoMod = danoMod;
	}

	public int getVidaMod() {
		return vidaMod;
	}

	public void setVidaMod(int vidaMod) {
		this.vidaMod = vidaMod;
	}

	public EquipamentoVO[] getListaEquipamentos() {
		return listaEquipamentos;
	}

	public void setListaEquipamentos(EquipamentoVO[] listaEquipamentos) {
		this.listaEquipamentos = listaEquipamentos;
	}

	public PoderVO[] getListaPoder() {
		return listaPoder;
	}

	public void setListaPoder(PoderVO[] listaPoder) {
		this.listaPoder = listaPoder;
	}

	@Override
	public String toString() {
		return "Classe: " + nome + "\nDescricao: " + descricao + "\nDano base: " + danoMod
				+ "\nVida base: " + vidaMod;
	}
	
}
