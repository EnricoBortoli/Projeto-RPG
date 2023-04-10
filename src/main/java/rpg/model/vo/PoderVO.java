package rpg.model.vo;

public class PoderVO {
	private int cdPoder;
	private String nome;
	private String descricao;
	private String flEquipado;
	private ClasseVO classe;
	
	public PoderVO(int cdPoder, String nome, String descricao, String flEquipado, ClasseVO classe) {
		super();
		this.cdPoder = cdPoder;
		this.nome = nome;
		this.descricao = descricao;
		this.flEquipado = flEquipado;
		this.classe = classe;
	}

	public PoderVO() {
		super();
	}

	public int getCdPoder() {
		return cdPoder;
	}

	public void cdPoder(int cdPoder) {
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

	public String getFlEquipado() {
		return flEquipado;
	}

	public void setFlEquipado(String flEquipado) {
		this.flEquipado = flEquipado;
	}
	
	public ClasseVO getClasse() {
		return classe;
	}

	public void setClasse(ClasseVO classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Poder: " + cdPoder + "\nNome: " + nome + "\nDescricao: " + descricao + "\nEquipado: "
				+ flEquipado;
	}
	
//	public void listarEfeitos() {
//		for(int i = 0; i < listaEfeito.length; i++) {
//			System.out.println("-------- Lista de Efeitos --------");
//			listaEfeito[i].toString();
//		}
//	}
	
}
