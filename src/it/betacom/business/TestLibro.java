package it.betacom.business;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.connection.Database;
import it.betacom.impl.*;
import it.betacom.model.*;

public class TestLibro {

	public static void main(String[] args) throws SQLException {
		Connection con = Database.getConnection();
		
		LibroImpl libroImpl = new LibroImpl(con);
		
		/////////////////////
		
		System.out.println("\nLibro con ID 1: " + libroImpl.get(1));
		
		/////////////////////
		
		System.out.println("\nLista Libri: " + libroImpl.getAll());

		/////////////////////
		
		Libro newLibro = new Libro(9999, 1, "Il nuovo libro", 200, 2023, 1, 1);
		System.out.println("\nInserimento Libro: " + libroImpl.insert(newLibro));

		/////////////////////
		
		int idEliminareLibro = 9999;
		System.out.println("\nEliminazione Libro con id " + idEliminareLibro + ": " + libroImpl.delete(idEliminareLibro));
		
		/////////////////////
		
		Libro updateLibroObj = new Libro(1, 1, "Il libro aggiornato", 300, 2023, 1, 1);
		System.out.println("\nAggiornamento Libro con id: " + 1 + ": " + libroImpl.update(updateLibroObj));
		
		/////////////////////
		
		System.out.println("\nInfo complete Libro con ID 1: \n" + libroImpl.getCompleteInfo(1));
		
		/////////////////////
		
		System.out.println("\nInfo complete su tutti i libri: \n" + libroImpl.getCompleteInfoAll());
	}
}
