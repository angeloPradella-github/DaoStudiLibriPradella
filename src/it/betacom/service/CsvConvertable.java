package it.betacom.service;

import java.sql.SQLException;

public interface CsvConvertable<T> {
	String convertToCSV(T t) throws SQLException;
}
