package it.betacom.service.impl;

import it.betacom.impl.AutoreImpl;
import it.betacom.model.Autore;
import it.betacom.service.PrintService;
import it.betacom.util.CSVFileWriter;
import it.betacom.util.PDFGenerator;
import it.betacom.util.TextFileWriter;

import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.File;



public class AutoreServiceImpl implements PrintService<Autore> {
	private AutoreImpl dao;

	/**
	 * @param dAO
	 */
	public AutoreServiceImpl(AutoreImpl dao) {
		this.dao = dao;
	}

	@Override
	public void saveListAsPdf() throws SQLException {
	    List<Autore> lista = new ArrayList<>();
	    String res = "=============== LISTA AUTORI ===============\n\n";

	    lista = dao.getAll();
	    
	    for (Autore autore: lista) 
	        res += autore.toString() + "\n";
	    
	    res+="\n\n ========================================";
	    
	    //salva su pdf
		String folderPath = "SavedFiles/PDFs/"+LocalDate.now()+"/Autori";
	    String filePath = folderPath + "/listaAutori.pdf";
	    File folder = new File(folderPath);
		if (!folder.exists()) folder.mkdirs(); //crea cartella se non esiste
		
		PDFGenerator.create(filePath, res);
	}


	@Override
	public void saveListAsCsv() throws SQLException {
	    List<Autore> lista = dao.getAll();

	    String header = "CodiceA, NomeA, CognomeA, AnnoN, AnnoM, Sesso, Nazione\n";
	    String csvContent = "";

	    for (Autore autore : lista) {
	        csvContent += convertToCSV(autore) + "\n";
	    }

	    String folderPath = "SavedFiles/CSVFiles/" + LocalDate.now() + "/Autori";
	    String filePath = folderPath + "/listaAutori.csv";
	    File folder = new File(folderPath);
	    if (!folder.exists()) folder.mkdirs(); //crea cartella se non esiste
	    
	    CSVFileWriter.write(filePath, header + csvContent);
	}

	@Override
	public void saveListAsTxt() throws SQLException {
	    List<Autore> lista = new ArrayList<>();
	    String res = "=============== LISTA AUTORI ===============\n\n";

	    lista = dao.getAll();
	    
	    for (Autore autore: lista) 
	        res += autore.toString() + "\n";
	    
	    res+="\n\n ========================================";
	    
	    //salva su file di testo
	    String folderPath = "SavedFiles/TxtFiles/"+LocalDate.now()+"/Autori";
	    String filePath = folderPath + "/listaAutori.txt";
	    File folder = new File(folderPath);
	    if (!folder.exists()) folder.mkdirs(); //crea cartella se non esiste
	    
	    TextFileWriter.write(filePath, res);
	}

	@Override
	public void saveAsPdf(Autore a) {
	    String res = "=============== INFO AUTORE: " +a.getCognomeA()+ " ["+ a.getCodiceA()+"] ===============\n\n";
	    res+= a.toString();
	    res+="\n\n ========================================";
	    
	    //salva su pdf
		String folderPath = "SavedFiles/PDFs/"+LocalDate.now()+"/Autori";
	    String filePath = folderPath + "/infoAutore-" +a.getCognomeA()+ "-["+ a.getCodiceA()+"].pdf";
	    File folder = new File(folderPath);
		if (!folder.exists()) folder.mkdirs(); //crea cartella se non esiste
		
		PDFGenerator.create(filePath, res);
	}

	@Override
	public void saveAsCsv(Autore a) throws SQLException {
	    String res = convertToCSV(a);

	    String folderPath = "SavedFiles/CSVFiles/" + LocalDate.now() + "/Autori";
	    String filePath = folderPath + "/infoAutore-" + a.getNomeA() + "-" + a.getCognomeA() + "-[" + a.getCodiceA() + "].csv";
	    File folder = new File(folderPath);
	    if (!folder.exists()) folder.mkdirs(); //crea cartella se non esiste
	    
	    CSVFileWriter.write(filePath, "CodiceA, NomeA, CognomeA, AnnoN, AnnoM, Sesso, Nazione\n" + res);
	}

	@Override
	public void saveAsTxt(Autore a) {
	    String res = "=============== INFO AUTORE: " + a.getCognomeA() + " [" + a.getCodiceA() + "] ===============\n\n";
	    res += a.toString();
	    res += "\n\n ========================================";

	    //salva su file di testo
	    String folderPath = "SavedFiles/TxtFiles/"+LocalDate.now()+"/Autori";
	    String filePath = folderPath + "/infoAutore-" + a.getCognomeA() + "-[" + a.getCodiceA() + "].txt";
	    File folder = new File(folderPath);
	    if (!folder.exists()) folder.mkdirs(); //crea cartella se non esiste
	    
	    TextFileWriter.write(filePath, res);
	}

	@Override
	public String convertToCSV(Autore a) {
	    return a.getCodiceA() + ", " + a.getNomeA() + ", " + a.getCognomeA() + ", " + a.getAnnoN() 
	        + ", " + a.getAnnoM() + ", " + a.getSesso() + ", " + a.getNazione();
	}


}
