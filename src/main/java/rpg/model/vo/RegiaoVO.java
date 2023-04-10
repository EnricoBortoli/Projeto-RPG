package rpg.model.vo;

public class RegiaoVO {
	private int cdRegiao;
	private String nome;
	private String descricao;
	
	public RegiaoVO(int cdRegiao, String nome, String descricao) {
		super();
		this.cdRegiao = cdRegiao;
		this.nome = nome;
		this.descricao = descricao;
	}

	public RegiaoVO() {
		super();
	}

	public int getCdRegiao() {
		return cdRegiao;
	}

	public void setCdRegiao(int cdRegiao) {
		this.cdRegiao = cdRegiao;
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

	@Override
	public String toString() {
		return "Regiao\nNome: " + nome + "\nDescricao: " + descricao;
	}
	
	
	
}
