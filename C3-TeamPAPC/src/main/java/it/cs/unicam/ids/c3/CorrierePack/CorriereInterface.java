package it.cs.unicam.ids.c3.CorrierePack;

public interface CorriereInterface{
	String getPassword();
	void setPassword(String password);
	String getNome();
	String getCognome();
	String getEmail();
	long getCellulare();
	boolean getDisposizione();
	void setNome(String nome);
	void setCognome(String cognome);
	void setEmail(String email);
	void setCellulare(long cellulare);
	void setDisposizione();
}
    

