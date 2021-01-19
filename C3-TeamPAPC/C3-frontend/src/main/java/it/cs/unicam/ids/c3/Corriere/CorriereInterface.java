package it.cs.unicam.ids.c3.Corriere;

public interface CorriereInterface{
	String getPassword();

	void setPassword(String password);

	public String getNome();
	public String getCognome();
	public String getEmail();
	public long getCellulare();
	public Boolean getDisposizione();
	public void setNome(String nome);
	public void setCognome(String cognome);
	public void setEmail(String email);
	void setCellulare(long cellulare);
	public void setDisposizione();
}
    

