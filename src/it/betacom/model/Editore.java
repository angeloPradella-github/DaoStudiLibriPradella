package it.betacom.model;

public class Editore {
	private int codiceE; 
    private String nome, sede;
    
	/**
	 * @param codiceE
	 * @param nome
	 * @param sede
	 */
    // Costruttore per creare un Editore esistente (con codiceE)
    public Editore(int codiceE, String nome, String sede) {
        this.codiceE = codiceE;
        this.nome = nome;
        this.sede = sede;
    }

    // Costruttore per creare un nuovo Editore (senza codiceE)
    public Editore(String nome, String sede) {
        this.nome = nome;
        this.sede = sede;
    }

	public int getCodiceE() {
		return codiceE;
	}

	public void setCodiceE(int codiceE) {
		this.codiceE = codiceE;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	@Override
	public String toString() {
		return "Editore [codiceE=" + codiceE + ", nome=" + nome + ", sede=" + sede + "]";
	}
	
	
    
    
	
}
