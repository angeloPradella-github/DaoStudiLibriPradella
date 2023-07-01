package it.betacom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import it.betacom.dao.EditoreDAO;
import it.betacom.model.Editore;
import it.betacom.util.CustomSQLException;

public class EditoreImpl implements EditoreDAO {
	private Connection con;

	/**
	 * @param con
	 */
	public EditoreImpl(Connection con) {
		this.con = con;
	}

	@Override
	public Editore get(int id) throws SQLException {
		String sql = "SELECT * from editori WHERE codiceE = ?";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		String nome = "";
		String sede = "";
		int codiceE = -1;
		Editore obj = null;

		while (rs.next()) {
			codiceE = rs.getInt("codiceE");
			nome = rs.getString("nome");
			sede = rs.getString("sede");
			obj = new Editore(codiceE, nome, sede);
		}

		return obj;
	}

	@Override
	public List<Editore> getAll() throws SQLException {
		String sql = "SELECT * from editori";

		PreparedStatement ps = this.con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		String nome = "";
		String sede = "";
		int codiceE = -1;
		Editore obj = null;
		List<Editore> arrList = new ArrayList<>();

		while (rs.next()) {
			codiceE = rs.getInt("codiceE");
			nome = rs.getString("nome");
			sede = rs.getString("sede");
			obj = new Editore(codiceE, nome, sede);
			arrList.add(obj);
		}

		return arrList;
	}

	@Override
	public int insert(Editore e) throws SQLException {
		String sql = "INSERT into editori(nome, sede) values (?, ?)";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setString(1, e.getNome());
		ps.setString(2, e.getSede());

		int status = ps.executeUpdate();

		return status;
	}

	@Override
	public int update(Editore e) throws SQLException {
		String newNome = e.getNome();
		String newSede = e.getSede();
		int newId = e.getCodiceE();
		String sql = "UPDATE editori SET nome = ?, sede = ? WHERE codiceE = ?";
		PreparedStatement ps = null;
		int rowsUpdated = 0;

		try {
			ps = this.con.prepareStatement(sql);
			ps.setString(1, newNome);
			ps.setString(2, newSede);
			ps.setInt(3, newId);

			rowsUpdated = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rowsUpdated;
	}

	@Override
	public int delete(Editore e) throws SQLException {
		String sql = "DELETE FROM editori WHERE codiceE = ?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, e.getCodiceE());

		int status = ps.executeUpdate();

		return status;
	}

	@Override
	public int delete(int id) throws SQLException {
		String sql = "DELETE FROM editori WHERE codiceE = ?";
		PreparedStatement ps = this.con.prepareStatement(sql);
		ps.setInt(1, id);

		int status = ps.executeUpdate();

		return status;
	}
}
