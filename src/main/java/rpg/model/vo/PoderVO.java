package rpg.model.vo;

public class PoderVO {
	private int cdPoder;
	private String nome;
	private String descricao;
	private int bonus;
	
	public PoderVO(int cdPoder, String nome, String descricao, int bonus) {
		super();
		this.cdPoder = cdPoder;
		this.nome = nome;
		this.descricao = descricao;
		this.bonus = bonus;
	}

	public PoderVO() {
		super();
	}

	public int getCdPoder() {
		return cdPoder;
	}

	public void setCdPoder(int cdPoder) {
		this.cdPoder = cdPoder;
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

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Poder: " + nome + "\nDescrição: " + descricao;
	}
	
}
