package rpg.model.vo;

public class EquipamentoVO {
	private int cdEquipamento;
	private String nome;
	private String tpEquipamento;
	private String descricao;
	private int bonus;
	private String flEquipado;

	public EquipamentoVO(int cdEquipamento, String nome, String tpEquipamento, String descricao, int bonus,
			String flEquipado) {
		super();
		this.cdEquipamento = cdEquipamento;
		this.nome = nome;
		this.tpEquipamento = tpEquipamento;
		this.descricao = descricao;
		this.bonus = bonus;
		this.flEquipado = flEquipado;
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

	public String getFlEquipado() {
		return flEquipado;
	}

	public void setFlEquipado(String flEquipado) {
		this.flEquipado = flEquipado;
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
		return "Equipamento:\nNome: " + nome + "\nTipo: " + tpEquipamento
				+ "\nDescrição: " + descricao + "\nBonús:" + bonus + "\nEquipado: " + flEquipado;
	}

//	public static void listarEquips() {
//		for(int i = 0; i < listaEquip.length; i++) {
//			listaEquip[i].toString();
//		}
//	}
//	
//	public static EquipamentoVO escolheItem() {
//		Scanner sc = new Scanner(System.in);
//		EquipamentoVO item = new EquipamentoVO();
//		int auxiliar = 0;
//		listarEquips();
//		auxiliar = sc.nextInt();
//		switch(auxiliar) {
//		case 1: 
//			item = listaEquip[1];
//			break;
//		case 2:
//			item = listaEquip[2];
//			break;
//		case 3:
//			item = listaEquip[3];
//			break;
//		default:
//			System.out.println("Opção de classe n�o existe");
//			escolheItem();
//			break;
//		
//		}
//		return item;
//	}
}







