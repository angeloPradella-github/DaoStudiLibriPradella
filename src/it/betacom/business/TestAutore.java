package it.betacom.business;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.connection.Database;
import it.betacom.impl.AutoreImpl;
import it.betacom.model.Autore;

public class TestAutore {

	public static void main(String[] args) throws SQLException {
		Connection con = Database.getConnection();

		AutoreImpl autoreImpl = new AutoreImpl(con);

//		System.out.println("Autore con ID 1: " + autoreImpl.get(1));
//
//		/////////////////////
//
//		System.out.println("Lista Autori: " + autoreImpl.getAll());

		/////////////////////
//		Autore newAutore = new Autore(0, "Mario", "Rossi", 1985, null, 'M', "Italia");
//		System.out.println("Inserimento Autore " + newAutore.getNomeA() + ": " + autoreImpl.insert(newAutore));

		/////////////////////
		int idEliminareAutore = 6;
		System.out.println(
				"Eliminazione Autore con id " + idEliminareAutore + ": " + autoreImpl.delete(idEliminareAutore));

		/////////////////////

		String updateNomeAutore = "Luigi";
		String updateCognomeAutore = "Bianchi";
		int updateAnnoNAutore = 1990;
		Integer updateAnnoMAutore = null;
		char updateSessoAutore = 'M';
		String updateNazioneAutore = "Italia";
		int updateIdAutore = 1;
		Autore updateAutoreObj = new Autore(updateIdAutore, updateNomeAutore, updateCognomeAutore, updateAnnoNAutore, updateAnnoMAutore, updateSessoAutore, updateNazioneAutore);
		System.out.println("Updating Autore con id: " + 1 + ", Nome: " + updateNomeAutore + ", Cognome: "
				+ updateCognomeAutore + ": " + autoreImpl.update(updateAutoreObj));
	}
}
