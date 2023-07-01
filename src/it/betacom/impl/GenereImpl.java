package it.betacom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import it.betacom.dao.GenereDAO;
import it.betacom.model.Genere;
import it.betacom.util.CustomSQLException;

public class GenereImpl implements GenereDAO {

	private Connection con;

	/**
	 * @param con
	 */
	public GenereImpl(Connection con) {
		this.con = con;
	}

	@Override
	public Genere get(int id) throws SQLException {

		String sql = "SELECT * from generi WHERE codiceG = ?";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		String descrizione = "";
		int codiceG = -1;
		Genere obj = null; // ritorna null se non lo trova

		while (rs.next()) {
			codiceG = rs.getInt("codiceG");
			descrizione = rs.getString("descrizione");
			obj = new Genere(codiceG, descrizione);
		}

		return obj;
	}

	@Override
	public List<Genere> getAll() throws SQLException {
		String sql = "SELECT * from generi";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		String descrizione = "";
		int codiceG = -1;
		Genere obj = null;
		List<Genere> arrList = new ArrayList<>();

		while (rs.next()) {
			codiceG = rs.getInt("codiceG");
			descrizione = rs.getString("descrizione");
			obj = new Genere(codiceG, descrizione);
			arrList.add(obj);
		}

		return arrList;
	}

	@Override
	public int insert(Genere g) throws SQLException {
		String sql = "INSERT into generi(descrizione) values (?)";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setString(1, g.getDescrizione());

		int status = ps.executeUpdate();

		return status;
	}

	@Override
	public int update(Genere g) throws SQLException {
		String newDescrizione = g.getDescrizione();
		int newId = g.getCodiceG();
		String sql = "UPDATE generi SET descrizione = ? WHERE codiceG = ?";
		PreparedStatement ps = null;
		int rowsUpdated = 0;

		try {
			ps = this.con.prepareStatement(sql);
			ps.setInt(2, newId);
			ps.setString(1, newDescrizione);

			rowsUpdated = ps.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();;
		}

		return rowsUpdated;
	}

	@Override
	public int delete(Genere g) throws SQLException {
		String sql = "DELETE FROM generi WHERE codiceG = ?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, g.getCodiceG());

		int status = ps.executeUpdate();

		return status;

	}

	@Override
	public int delete(int id) throws SQLException {
		String sql = "DELETE FROM generi WHERE codiceG = ?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, id);

		int status = ps.executeUpdate();

		return status;

	}

}
