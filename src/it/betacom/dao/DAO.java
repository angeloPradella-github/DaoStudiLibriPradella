package it.betacom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.betacom.model.Employee;

/**
 * Interfaccia DAO che definisce i metodi di base per l'accesso ai dati di un
 * oggetto di tipo generico. L'interfaccia fornisce operazioni CRUD (Create,
 * Read, Update, Delete) per l'oggetto specificato.
 *
 * @param <Type> tipo dell'oggetto da gestire
 */
public interface DAO<Type> {

	/**
	 * Restituisce l'oggetto con l'identificatore specificato.
	 *
	 * @param id identificatore dell'oggetto
	 * @return oggetto con l'identificatore specificato
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati
	 */
	Type get(int id) throws SQLException;

	/**
	 * Restituisce una lista di tutti gli oggetti presenti nel database.
	 *
	 * @return lista di tutti gli oggetti presenti nel database
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati
	 */
	List<Type> getAll() throws SQLException;

	/**
	 * Inserisce un nuovo oggetto nel database.
	 *
	 * @param t oggetto da inserire
	 * @return numero di righe modificate nel database
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati
	 */
	int insert(Type t) throws SQLException;

	/**
	 * Aggiorna l'oggetto nel database.
	 *
	 * @param t oggetto da aggiornare
	 * @return numero di righe modificate nel database
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati
	 */
	int update(Type t) throws SQLException;

	/**
	 * Elimina l'oggetto dal database.
	 *
	 * @param t oggetto da eliminare
	 * @return numero di righe modificate nel database
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati
	 */
	int delete(Type t) throws SQLException;

	/**
	 * Elimina l'oggetto con l'identificatore specificato dal database.
	 *
	 * @param id identificatore dell'oggetto da eliminare
	 * @return numero di righe modificate nel database
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati
	 */
	int delete(int id) throws SQLException;

	/**
	 * Verifica se esiste un record nella tabella specificata con il valore
	 * specificato nella colonna specificata per verificare l'integrità refrenziale dei dati nel
	 * caso un parametro non esista nella tabella specificata.
	 *
	 * @param tableName  nome della tabella in cui effettuare la verifica
	 * @param columnName nome della colonna da verificare
	 * @param id         valore da cercare nella colonna specificata
	 * @param con        connessione al database
	 * @return true se esiste un record corrispondente, false altrimenti
	 * @throws SQLException se si verifica un errore durante l'accesso ai dati
	 */
	default boolean existsInTable(String tableName, String columnName, int id, Connection con) throws SQLException {
		String sql = "SELECT * FROM " + tableName + " WHERE " + columnName + " = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
}