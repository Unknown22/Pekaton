package model;

public class Sprint {

	private int id;
	private String poczatek;
	private String koniec;
	
	public Sprint(int _id, String _poczatek, String _koniec){
		this.id = _id;
		this.poczatek = _poczatek;
		this.koniec = _koniec;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPoczatek() {
		return poczatek;
	}
	public void setPoczatek(String poczatek) {
		this.poczatek = poczatek;
	}
	public String getKoniec() {
		return koniec;
	}
	public void setKoniec(String koniec) {
		this.koniec = koniec;
	}
	
	
}
