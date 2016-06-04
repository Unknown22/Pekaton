package model;

public class Zadanie {

	private int id = 0;
	private String opis;
	private int doswiadczenie = 0;
	private String zleceniodawca;
	private int ipPracownika = 0;
	private int status = 0;
	/*
	 * status
	 * 1 - zakonczone
	 */
	
	
	
	public String getOpis() {
		return opis;
	}
	
	
	
	
	public Zadanie() {
	}




	public Zadanie(int id, String opis, int doswiadczenie, String zleceniodawca, int ipPracownika, int status) {
		super();
		this.id = id;
		this.opis = opis;
		this.doswiadczenie = doswiadczenie;
		this.zleceniodawca = zleceniodawca;
		this.ipPracownika = ipPracownika;
		this.status = status;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public int getDoswiadczenie() {
		return doswiadczenie;
	}
	public void setDoswiadczenie(int doswiadczenie) {
		this.doswiadczenie = doswiadczenie;
	}
	public String getZleceniodawca() {
		return zleceniodawca;
	}
	public void setZleceniodawca(String zleceniodawca) {
		this.zleceniodawca = zleceniodawca;
	}
	public int getIpPracownika() {
		return ipPracownika;
	}
	public void setIpPracownika(int ipPracownika) {
		this.ipPracownika = ipPracownika;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Zadanie [opis=" + opis + ", doswiadczenie=" + doswiadczenie + ", zleceniodawca=" + zleceniodawca
				+ ", ipPracownika=" + ipPracownika + ", status=" + status + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
}
