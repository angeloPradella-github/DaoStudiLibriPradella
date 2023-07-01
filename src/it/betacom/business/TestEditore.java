package it.betacom.business;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.connection.Database;
import it.betacom.impl.*;
import it.betacom.model.*;

public class TestEditore {

	public static void main(String[] args) throws SQLException {
		Connection con = Database.getConnection();

		EditoreImpl editoreImpl = new EditoreImpl(con);

		System.out.println("Editore con ID 1: " + editoreImpl.get(1));

		/////////////////////

		System.out.println("Lista Editori: " + editoreImpl.getAll());

		/////////////////////
		String nomeNuovoEditore = "Einaudi";
		String sedeNuovoEditore = "Torino";
		Editore newEditore = new Editore(nomeNuovoEditore, sedeNuovoEditore);
		System.out.println("Inserimento Editore " + nomeNuovoEditore + ": " + editoreImpl.insert(newEditore));

		/////////////////////
		int idEliminareEditore = 6;
		System.out.println(
				"Eliminazione Editore con id " + idEliminareEditore + ": " + editoreImpl.delete(idEliminareEditore));

		/////////////////////

		String updateNomeEditore = "Mondadori - Nuovo";
		String updateSedeEditore = "Milano";
		int updateIdEditore = 999;
		Editore updateEditoreObj = new Editore(updateIdEditore, updateNomeEditore, updateSedeEditore);
		System.out.println("Updating Editore con id: " + 1 + ", Nome: " + updateNomeEditore + ", Sede: "
				+ updateSedeEditore + ": " + editoreImpl.update(updateEditoreObj));

		/// ------------------------------------------------------///

	}
}
