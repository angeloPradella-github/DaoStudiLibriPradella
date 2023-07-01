package it.betacom.service.impl;

import it.betacom.impl.LibroImpl;
import it.betacom.model.Autore;
import it.betacom.model.Editore;
import it.betacom.model.Genere;
import it.betacom.model.Libro;
import it.betacom.service.PrintService;
import it.betacom.util.CSVFileWriter;
import it.betacom.util.PDFGenerator;
import it.betacom.util.TextFileWriter;

import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class LibroServiceImpl implements PrintService<Libro> {
	private LibroImpl dao;

	/**
	 * @param dAO
	 */
	public LibroServiceImpl(LibroImpl dao) {
		this.dao = dao;
	}

	@Override
	public void saveListAsPdf() throws SQLException {
		List<Libro> lista = new ArrayList<>();
		String res = "=============== LISTA LIBRI ===============\n\n";

		res += dao.getCompleteInfoAll();

		res += "\n\n ========================================";

		// salva su pdf
		String folderPath = "SavedFiles/PDFs/" + LocalDate.now() + "/Libri";
		String filePath = folderPath + "/listaLibri.pdf";
		File folder = new File(folderPath);
		if (!folder.exists())
			folder.mkdirs(); // crea cartella se non esiste

		PDFGenerator.create(filePath, res);
	}

	@Override
	public void saveListAsCsv() throws SQLException {
		List<Libro> lista = dao.getAll();

		String header = "CodiceR, Titolo, Anno, Autore, Genere, Editore\n";
		String csvContent = "";

		for (Libro libro : lista) {
			csvContent += convertToCSV(libro) + "\n";
		}

		String folderPath = "SavedFiles/CSVFiles/" + LocalDate.now() + "/Libri";
		String filePath = folderPath + "/listaLibri.csv";
		File folder = new File(folderPath);
		if (!folder.exists())
			folder.mkdirs(); // crea cartella se non esiste

		CSVFileWriter.write(filePath, header + csvContent);
	}

	@Override
	public void saveListAsTxt() throws SQLException {
		List<Libro> lista = new ArrayList<>();
		String res = "=============== LISTA LIBRI ===============\n\n";

		res += dao.getCompleteInfoAll() + "\n";

		res += "\n\n ========================================";

		// salva su file di testo
		String folderPath = "SavedFiles/TxtFiles/" + LocalDate.now() + "/Libri";
		String filePath = folderPath + "/listaLibri.txt";
		File folder = new File(folderPath);
		if (!folder.exists())
			folder.mkdirs(); // crea cartella se non esiste

		TextFileWriter.write(filePath, res);
	}

	@Override
	public void saveAsPdf(Libro l) {
		String res = "=============== INFO LIBRO: " + l.getTitolo() + " [" + l.getCodiceR() + "] ===============\n\n";
		res += dao.getCompleteInfo(l.getCodiceR());
		res += "\n\n ========================================";

		// salva su pdf
		String folderPath = "SavedFiles/PDFs/" + LocalDate.now() + "/Libri";
		String filePath = folderPath + "/infoLibro-" + l.getTitolo() + "-[" + l.getCodiceR() + "].pdf";
		File folder = new File(folderPath);
		if (!folder.exists())
			folder.mkdirs(); // crea cartella se non esiste

		PDFGenerator.create(filePath, res);
	}

	@Override
	public void saveAsCsv(Libro l) throws SQLException {
		String res = convertToCSV(l);

		String folderPath = "SavedFiles/CSVFiles/" + LocalDate.now() + "/Libri";
		String filePath = folderPath + "/infoLibro-" + l.getTitolo() + "-[" + l.getCodiceR() + "].csv";
		File folder = new File(folderPath);
		if (!folder.exists())
			folder.mkdirs(); // crea cartella se non esiste

		CSVFileWriter.write(filePath, "CodiceR, Titolo, Anno, Autore, Genere, Editore\n" + res);
	}

	@Override
	public void saveAsTxt(Libro l) {
		String res = "=============== INFO LIBRO: " + l.getTitolo() + " [" + l.getCodiceR() + "] ===============\n\n";
		res += dao.getCompleteInfo(l.getCodiceR());
		res += "\n\n ========================================";

		// salva su file di testo
		String folderPath = "SavedFiles/TxtFiles/" + LocalDate.now() + "/Libri";
		String filePath = folderPath + "/infoLibro-" + l.getTitolo() + "-[" + l.getCodiceR() + "].txt";
		File folder = new File(folderPath);
		if (!folder.exists())
			folder.mkdirs(); // crea cartella se non esiste

		TextFileWriter.write(filePath, res);
	}

	@Override
	public String convertToCSV(Libro l) throws SQLException {
		Autore autore = dao.getAutore(l.getCodiceA());
		Genere genere = dao.getGenere(l.getCodiceG());
		Editore editore = dao.getEditore(l.getCodiceE());

		return l.getCodiceR() + ", " + l.getTitolo() + ", " + l.getAnno() + ", " + autore.getNomeA() + " "
				+ autore.getCognomeA() + ", " + genere.getDescrizione() + ", " + editore.getNome();
	}
}
