package it.betacom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import it.betacom.dao.LibroDAO;
import it.betacom.model.Autore;
import it.betacom.model.Editore;
import it.betacom.model.Genere;
import it.betacom.model.Libro;

public class LibroImpl implements LibroDAO {
	private Connection con;

	/**
	 * @param con
	 */
	public LibroImpl(Connection con) {
		this.con = con;
	}

	@Override
	public Libro get(int id) throws SQLException {
		String sql = "SELECT * from libri WHERE codiceR = ?";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		int codiceR = 0;
		int codiceA = 0;
		String titolo;
		int numPag;
		int anno;
		int codiceG;
		int codiceE;
		Libro obj = null; // ritorna null se non lo trova

		while (rs.next()) {
			codiceR = rs.getInt("codiceR");
			codiceA = rs.getInt("codiceA");
			numPag = rs.getInt("numPag");
			anno = rs.getInt("anno");
			codiceG = rs.getInt("codiceG");
			codiceE = rs.getInt("codiceE");
			titolo = rs.getString("titolo");

			obj = new Libro(codiceR, codiceA, titolo, numPag, anno, codiceG, codiceE);
		}

		return obj;
	}

	@Override
	public List<Libro> getAll() throws SQLException {
		String sql = "SELECT * from libri";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		int codiceR = 0;
		int codiceA = 0;
		String titolo;
		int numPag;
		int anno;
		int codiceG;
		int codiceE;
		Libro obj = null; // ritorna null se non lo trova
		List<Libro> arrList = new ArrayList<>();

		while (rs.next()) {
			codiceR = rs.getInt("codiceR");
			codiceA = rs.getInt("codiceA");
			numPag = rs.getInt("numPag");
			anno = rs.getInt("anno");
			codiceG = rs.getInt("codiceG");
			codiceE = rs.getInt("codiceE");
			titolo = rs.getString("titolo");

			obj = new Libro(codiceR, codiceA, titolo, numPag, anno, codiceG, codiceE);
			arrList.add(obj);
		}

		return arrList;
	}

	@Override
	public int insert(Libro l) throws SQLException {
		if (!existsInTable("autori", "codiceA", l.getCodiceA(), con)) {
			System.out.println("L'autore con ID " + l.getCodiceA() + " non esiste.");
			return 0;
		}
		if (!existsInTable("generi", "codiceG", l.getCodiceG(), con)) {
			System.out.println("Il genere con ID " + l.getCodiceG() + " non esiste.");
			return 0;
		}
		if (!existsInTable("editori", "codiceE", l.getCodiceE(), con)) {
			System.out.println("L'editore con ID " + l.getCodiceE() + " non esiste.");
			return 0;
		}

		String sql = "INSERT INTO libri (codiceR, codiceA, titolo, numPag, anno, codiceG, codiceE) VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = this.con.prepareStatement(sql);
		int rowsInserted = 0;

		ps.setInt(1, l.getCodiceR());
		ps.setInt(2, l.getCodiceA());
		ps.setString(3, l.getTitolo());
		ps.setInt(4, l.getNumPag());
		ps.setInt(5, l.getAnno());
		ps.setInt(6, l.getCodiceG());
		ps.setInt(7, l.getCodiceE());

		try {
			rowsInserted = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsInserted;
	}

	@Override
	public int update(Libro l) throws SQLException {
		if (!existsInTable("autori", "codiceA", l.getCodiceA(), con)) {
			System.out.println("L'autore con ID " + l.getCodiceA() + " non esiste.");
			return 0;
		}
		if (!existsInTable("generi", "codiceG", l.getCodiceG(), con)) {
			System.out.println("Il genere con ID " + l.getCodiceG() + " non esiste.");
			return 0;
		}
		if (!existsInTable("editori", "codiceE", l.getCodiceE(), con)) {
			System.out.println("L'editore con ID " + l.getCodiceE() + " non esiste.");
			return 0;
		}
		if (!existsInTable("libri", "codiceR", l.getCodiceR(), con)) {
			System.out.println("Il libro con ID: " + l.getCodiceE()
					+ " passato non esiste sulla tab, quondi non è possibile modificare.");
			return 0;
		}

		String sql = "UPDATE libri SET codiceA = ?, titolo = ?, numPag = ?, anno = ?, codiceG = ?, codiceE = ? WHERE codiceR = ?";

		PreparedStatement ps = this.con.prepareStatement(sql);
		int rowsUpdated = 0;

		ps.setInt(1, l.getCodiceA());
		ps.setString(2, l.getTitolo());
		ps.setInt(3, l.getNumPag());
		ps.setInt(4, l.getAnno());
		ps.setInt(5, l.getCodiceG());
		ps.setInt(6, l.getCodiceE());
		ps.setInt(7, l.getCodiceR());

		try {
			rowsUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsUpdated;
	}

	@Override
	public int delete(Libro l) throws SQLException {
		if (!existsInTable("libri", "codiceR", l.getCodiceR(), con)) {
			System.out.println("Il libro con ID: " + l.getCodiceR()
					+ " non esiste nel database, quindi non può essere eliminato.");
			return 0;
		}

		String sql = "DELETE FROM libri WHERE codiceR = ?";

		PreparedStatement ps = this.con.prepareStatement(sql);

		ps.setInt(1, l.getCodiceR());

		int rowsDeleted = ps.executeUpdate();

		return rowsDeleted;
	}

	@Override
	public int delete(int id) throws SQLException {
		if (!existsInTable("libri", "codiceR", id, con)) {
			System.out.println("Il libro con ID: " + id + " non esiste nel database, quindi non può essere eliminato.");
			return 0;
		}

		String sql = "DELETE FROM libri WHERE codiceR = ?";

		PreparedStatement ps = this.con.prepareStatement(sql);

		ps.setInt(1, id);

		int rowsDeleted = ps.executeUpdate();

		return rowsDeleted;
	}

	@Override
	public String getCompleteInfo(int id) {
		String sql = "SELECT libri.titolo, libri.anno, autori.nomeA, autori.cognomeA, generi.descrizione, editori.nome FROM libri JOIN autori ON libri.codiceA = autori.codiceA JOIN generi ON libri.codiceG = generi.codiceG JOIN editori ON libri.codiceE = editori.codiceE WHERE libri.codiceR = ?";

		PreparedStatement ps;
		String result = "";

		try {
			ps = this.con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String titolo = rs.getString(1);
				int anno = rs.getInt(2);
				String nomeAutore = rs.getString(3);
				String cognomeAutore = rs.getString(4);
				String genere = rs.getString(5);
				String editore = rs.getString(6);

				result += "Titolo: " + titolo + "\n";
				result += "Anno: " + anno + "\n";
				result += "Autore: " + nomeAutore + " " + cognomeAutore + "\n";
				result += "Genere: " + genere + "\n";
				result += "Editore: " + editore + "\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	///////////////////////////
	public List<String> getCompleteInfoAll() {
		String sql = "SELECT libri.codiceR, libri.titolo, libri.anno, autori.nomeA, autori.cognomeA, generi.descrizione, editori.nome FROM libri JOIN autori ON libri.codiceA = autori.codiceA JOIN generi ON libri.codiceG = generi.codiceG JOIN editori ON libri.codiceE = editori.codiceE";

		PreparedStatement ps;
		List<String> results = new ArrayList<>();

		try {
			ps = this.con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int codiceR = rs.getInt(1);
				String titolo = rs.getString(2);
				int anno = rs.getInt(3);
				String nomeAutore = rs.getString(4);
				String cognomeAutore = rs.getString(5);
				String genere = rs.getString(6);
				String editore = rs.getString(7);

				String result = "";
				result += " CodiceR: " + codiceR + "\n";
				result += "   Titolo: " + titolo + "\n";
				result += "   Anno: " + anno + "\n";
				result += "   Autore: " + nomeAutore + " " + cognomeAutore + "\n";
				result += "   Genere: " + genere + "\n";
				result += "   Editore: " + editore + "\n";
				result += "===========================\n";

				results.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	// ------------------ METODI LAZY LOADING PER RICAVARE GLI OGGETTI TRAMITE ID DI GENERE AUTORE ED EDITORE
	@Override
	public Autore getAutore(int id) throws SQLException {
		String sql = "SELECT * FROM autori WHERE codiceA = ?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return new Autore(rs.getInt("codiceA"), rs.getString("nomeA"), rs.getString("cognomeA"), rs.getInt("annoN"),
					rs.getInt("annoM"), rs.getString("sesso").charAt(0), rs.getString("nazione"));
		}

		return null;
	}

	@Override
	public Genere getGenere(int id) throws SQLException {
		String sql = "SELECT * from generi WHERE codiceG = ?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return new Genere(rs.getInt("codiceG"), rs.getString("descrizione"));
		}

		return null;
	}

	@Override
	public Editore getEditore(int id) throws SQLException {
		String sql = "SELECT * from editori WHERE codiceE = ?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return new Editore(rs.getInt("codiceE"), rs.getString("nome"), rs.getString("sede"));
		}

		return null;
	}

}
