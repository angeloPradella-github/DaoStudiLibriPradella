package it.betacom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import it.betacom.dao.AutoreDAO;
import it.betacom.model.Autore;
import it.betacom.util.CustomSQLException;

public class AutoreImpl implements AutoreDAO {

	private Connection con;

	public AutoreImpl(Connection con) {
		this.con = con;
	}

	@Override
	public Autore get(int id) throws SQLException {
		String sql = "SELECT * FROM autori WHERE codiceA = ?";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		int codiceA = -1;
		String nomeA = "";
		String cognomeA = "";
		Integer annoN = null;
		Integer annoM = null;
		Character sesso = null;
		String nazione = "";
		Autore autore = null;

		if (rs.next()) {
			codiceA = rs.getInt("codiceA");
			nomeA = rs.getString("nomeA");
			cognomeA = rs.getString("cognomeA");
			annoN = rs.getInt("annoN");
			annoM = rs.getInt("annoM");
			sesso = rs.getString("sesso").charAt(0);
			nazione = rs.getString("nazione");
			autore = new Autore(codiceA, nomeA, cognomeA, annoN, annoM, sesso, nazione);
		}

		return autore;
	}

	@Override
	public List<Autore> getAll() throws SQLException {
		String sql = "SELECT * FROM autori";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Autore> autori = new ArrayList<>();

		while (rs.next()) {
			int codiceA = rs.getInt("codiceA");
			String nomeA = rs.getString("nomeA");
			String cognomeA = rs.getString("cognomeA");
			Integer annoN = rs.getInt("annoN");
			Integer annoM = rs.getInt("annoM");
			Character sesso = rs.getString("sesso").charAt(0);
			String nazione = rs.getString("nazione");
			Autore autore = new Autore(codiceA, nomeA, cognomeA, annoN, annoM, sesso, nazione);
			autori.add(autore);
		}

		return autori;
	}

	@Override
	public int insert(Autore a) throws SQLException {
		String sql = "INSERT INTO autori(nomeA, cognomeA, annoN, annoM, sesso, nazione) VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setString(1, a.getNomeA());
		ps.setString(2, a.getCognomeA());
		ps.setInt(3, a.getAnnoN());

		if (a.getAnnoM() != null) {
			ps.setInt(4, a.getAnnoM());
		} else {
			ps.setNull(4, java.sql.Types.INTEGER);
		}

		ps.setString(5, String.valueOf(a.getSesso()));
		ps.setString(6, a.getNazione());

		int rowsInserted = ps.executeUpdate();

		return rowsInserted;
	}


	@Override
	public int update(Autore a) throws SQLException {
		String sql = "UPDATE autori SET nomeA = ?, cognomeA = ?, annoN = ?, annoM = ?, sesso = ?, nazione = ? WHERE codiceA = ?";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setString(1, a.getNomeA());
		ps.setString(2, a.getCognomeA());
		ps.setInt(3, a.getAnnoN());
		ps.setObject(4, a.getAnnoM());
		ps.setString(5, String.valueOf(a.getSesso()));
		ps.setString(6, a.getNazione());
		ps.setInt(7, a.getCodiceA());

		int rowsUpdated = ps.executeUpdate();

		return rowsUpdated;
	}

	@Override
	public int delete(Autore a) throws SQLException {
		String sql = "DELETE FROM autori WHERE codiceA = ?";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, a.getCodiceA());

		int rowsDeleted = ps.executeUpdate();

		return rowsDeleted;
	}

	@Override
	public int delete(int id) throws SQLException {
		String sql = "DELETE FROM autori WHERE codiceA = ?";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, id);

		int rowsDeleted = ps.executeUpdate();

		return rowsDeleted;
	}
}
