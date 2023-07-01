package it.betacom.model;

public class Autore {

	private int codiceA;
	private String nomeA;
	private String cognomeA;
	private Integer annoN;
	private Integer annoM;
	private Character sesso;
	private String nazione;

	public Autore(int codiceA, String nomeA, String cognomeA, Integer annoN, Integer annoM, Character sesso, String nazione) {
		this.codiceA = codiceA;
		this.nomeA = nomeA;
		this.cognomeA = cognomeA;
		this.annoN = annoN;
		this.annoM = annoM;
		this.sesso = sesso;
		this.nazione = nazione;
	}

	public int getCodiceA() {
		return codiceA;
	}

	public void setCodiceA(int codiceA) {
		this.codiceA = codiceA;
	}

	public String getNomeA() {
		return nomeA;
	}

	public void setNomeA(String nomeA) {
		this.nomeA = nomeA;
	}

	public String getCognomeA() {
		return cognomeA;
	}

	public void setCognomeA(String cognomeA) {
		this.cognomeA = cognomeA;
	}

	public Integer getAnnoN() {
		return annoN;
	}

	public void setAnnoN(Integer annoN) {
		this.annoN = annoN;
	}

	public Integer getAnnoM() {
		return annoM;
	}

	public void setAnnoM(Integer annoM) {
		this.annoM = annoM;
	}

	public Character getSesso() {
		return sesso;
	}

	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	@Override
	public String toString() {
		return "Autore [codiceA=" + codiceA + ", nomeA=" + nomeA + ", cognomeA=" + cognomeA + ", annoN=" + annoN
				+ ", annoM=" + annoM + ", sesso=" + sesso + ", nazione=" + nazione + "]";
	}
	
	
}
