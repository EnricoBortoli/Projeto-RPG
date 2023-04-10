package rpg.util;

	public abstract class ModeloPersonagem {
	
	private String nome;
	private int dano;
	private int vida;
	private int id;
	
	
	public ModeloPersonagem(String nome, int dano, int vida) {
		super();
		this.nome = nome;
		this.dano = dano;
		this.vida = vida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nDano: " + dano + "\nVida: " + vida;
	}

	public ModeloPersonagem() {
		super();
	}
	
	
	
}
