package it.betacom.dao;

import java.sql.SQLException;
import java.util.List;

import it.betacom.model.Autore;
import it.betacom.model.Editore;
import it.betacom.model.Genere;
import it.betacom.model.Libro;

public interface LibroDAO extends DAO<Libro>{
	String getCompleteInfo(int id);
	
	List<String> getCompleteInfoAll();
	
	Autore getAutore(int autoreId) throws SQLException ;
	Genere getGenere(int genereId) throws SQLException ;
	Editore getEditore(int editoreId) throws SQLException ;
}
