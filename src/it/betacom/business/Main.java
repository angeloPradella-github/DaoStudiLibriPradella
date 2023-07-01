package it.betacom.business;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.connection.Database;
import it.betacom.impl.*;
import it.betacom.service.impl.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection conn = Database.getConnection();
		
		if (conn != null) {
			System.out.print("Database connection done");
		}
		// ------------------------- AUTORI------------------------------------
		AutoreImpl autoreImpl = new AutoreImpl(conn);
		AutoreServiceImpl autoreService = new AutoreServiceImpl(autoreImpl);
		
		//Salvataggio PDF
		System.out.println("\n=====================  TEST SALVATAGGIO AUTORI...  =====================");
		System.out.println("=== [ TEST PDF ] ===");
		autoreService.saveListAsPdf();
		autoreService.saveAsPdf(autoreImpl.get(1));
		//Salvataggio TXT
		System.out.println("\n=== [ TEST TXT ] ===");
		autoreService.saveListAsTxt();
		autoreService.saveAsTxt(autoreImpl.get(1));
		//Salvataggio CSV
		autoreService.saveListAsCsv();
		autoreService.saveAsCsv(autoreImpl.get(1));
		// -----------------------------LIBRI ---------------------------------------
		System.out.println("\n===================== TEST SALVATAGGIO LIBRI... =====================");
		LibroImpl libroImpl = new LibroImpl(conn);
		LibroServiceImpl libroService = new LibroServiceImpl(libroImpl);
		//Salvataggio PDF
		System.out.println("=== [ TEST PDF ] ===");
		libroService.saveListAsPdf();
		libroService.saveAsPdf(libroImpl.get(8));
		//Salvataggio TXT
		System.out.println("\n=== [ TEST TXT ] ===");
		libroService.saveListAsTxt();
		libroService.saveAsTxt(libroImpl.get(8));
		//Salvataggio CSV
		System.out.println("\n=== [ TEST CSV ] ===");
		libroService.saveListAsCsv();
		libroService.saveAsCsv(libroImpl.get(8));


	}

}
