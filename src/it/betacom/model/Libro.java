package it.betacom.model;

public class Libro {

	private int codiceR;
	private int codiceA;
	private String titolo;
	private int numPag;
	private int anno;
	private int codiceG;
	private int codiceE;

	public Libro() {
	}
	/**
	 * Versione senza il codice Libro (Primary Key)
	 * @param codiceA
	 * @param titolo
	 * @param numPag
	 * @param anno
	 * @param codiceG
	 * @param codiceE
	 */
	public Libro(int codiceA, String titolo, int numPag, int anno, int codiceG, int codiceE) {
		this.codiceA = codiceA;
		this.titolo = titolo;
		this.numPag = numPag;
		this.anno = anno;
		this.codiceG = codiceG;
		this.codiceE = codiceE;
	}

	/**
	 * Versione con il codice Libro (Primary Key)
	 * @param codiceR Primary Key
	 * @param codiceA
	 * @param titolo
	 * @param numPag
	 * @param anno
	 * @param codiceG
	 * @param codiceE
	 */
	public Libro(int codiceR, int codiceA, String titolo, int numPag, int anno, int codiceG, int codiceE) {
		this.codiceR = codiceR;
		this.codiceA = codiceA;
		this.titolo = titolo;
		this.numPag = numPag;
		this.anno = anno;
		this.codiceG = codiceG;
		this.codiceE = codiceE;
	}

	public int getCodiceR() {
		return codiceR;
	}

	public void setCodiceR(int codiceR) {
		this.codiceR = codiceR;
	}

	public int getCodiceA() {
		return codiceA;
	}

	public void setCodiceA(int codiceA) {
		this.codiceA = codiceA;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getCodiceG() {
		return codiceG;
	}

	public void setCodiceG(int codiceG) {
		this.codiceG = codiceG;
	}

	public int getCodiceE() {
		return codiceE;
	}

	public void setCodiceE(int codiceE) {
		this.codiceE = codiceE;
	}

	@Override
	public String toString() {
		return "Libro{" + "codiceR=" + codiceR + ", codiceA=" + codiceA + ", titolo='" + titolo + '\'' + ", numPag="
				+ numPag + ", anno=" + anno + ", codiceG=" + codiceG + ", codiceE=" + codiceE + '}';
	}
}
