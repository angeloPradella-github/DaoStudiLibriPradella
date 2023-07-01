package it.betacom.business;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.connection.Database;
import it.betacom.impl.*;
import it.betacom.model.*;

public class TestGenere {

	public static void main(String[] args) throws SQLException {
		Connection con = Database.getConnection();

		GenereImpl genereImpl = new GenereImpl(con);

		System.out.println("Genere con ID 1: " + genereImpl.get(1));

		/////////////////////

		System.out.println("Lista Generi: " + genereImpl.getAll());

		/////////////////////
		String nomeNuovoGenere = "Fumetto";
		Genere newGenere = new Genere(5, nomeNuovoGenere);
		System.out.println("Inserimento Genere " +nomeNuovoGenere+": " +
		genereImpl.insert(newGenere));

		/////////////////////
		int idEliminareGenere = 5;
		System.out.println(
				"Eliminazione Genere con id " + idEliminareGenere + ": " + genereImpl.delete(idEliminareGenere));

		/////////////////////

		String updateNuovoGenere = "Giallino";
		int updateIdGenere = 1;
		Genere updateGenereObj = new Genere(updateIdGenere, updateNuovoGenere);
		System.out.println("Updating Genere con id: " + 1 +" Nome: "+ updateNuovoGenere + ": " + genereImpl.update(updateGenereObj));
	
		///------------------------------------------------------///
		
		
	}

}
