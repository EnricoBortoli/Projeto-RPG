package rpg.model.vo;

public class EquipamentoVO {
	private int cdEquipamento;
	private String nome;
	private String tpEquipamento;
	private String descricao;
	private int bonus;


	public EquipamentoVO(int cdEquipamento, String nome, String tpEquipamento, String descricao, int bonus,
			String flEquipado) {
		super();
		this.cdEquipamento = cdEquipamento;
		this.nome = nome;
		this.tpEquipamento = tpEquipamento;
		this.descricao = descricao;
		this.bonus = bonus;
	}
	
	public EquipamentoVO() {
		super();
	}

	public int getCdEquipamento() {
		return cdEquipamento;
	}

	public void setCdEquipamento(int cdEquipamento) {
		this.cdEquipamento = cdEquipamento;
	}

	public String getTpEquipamento() {
		return tpEquipamento;
	}

	public void setTpEquipamento(String string) {
		this.tpEquipamento = string;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
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
		return "\nEquipamento: " + nome + "\nDescrição: " + descricao;
	}
}







