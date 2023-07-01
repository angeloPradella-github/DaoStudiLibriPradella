package it.betacom.util;

import java.sql.SQLException;

public class CustomSQLException extends SQLException{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void printSQLException() {
		
	    System.err.println("SQLState: " + super.getSQLState());
	    System.err.println("Codice Errore: " + super.getErrorCode());
	    System.err.println("Messaggio: " + super.getMessage());
	    Throwable t = super.getCause();
	    
	    while (t != null) {
	        System.out.println("Causa: " + t);
	        t = t.getCause();
	    }
	}
//	public String getSQLState(){
//		super.getSQLState();
//		super.getErrorCode();
//		
//		return null;
//	}
}
