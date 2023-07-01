package it.betacom.service;

import java.sql.SQLException;

public interface PrintService<T> extends CsvConvertable<T>{
	//Salva lista intera
	void saveListAsPdf() throws SQLException;
	void saveListAsCsv() throws SQLException;
	void saveListAsTxt() throws SQLException;
	//Salva singoli
	void saveAsPdf(T t);
	void saveAsCsv(T t) throws SQLException;
	void saveAsTxt(T t);
}
