package dao;

public class Pracownik {

	private int id = 0;
	private String login = "";
	private String haslo = "";
	private String stanowisko = "";
	private int doswiadczenie = 0;
	
	
	
	public Pracownik() {
		
	}
	
	
	
	public Pracownik(int id, String login, String haslo, String stanowisko, int exp) {
		super();
		this.id = id;
		this.login = login;
		this.haslo = haslo;
		this.stanowisko = stanowisko;
		this.doswiadczenie = exp;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	public String getStanowisko() {
		return stanowisko;
	}
	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}
	public int getExp() {
		return doswiadczenie;
	}
	public void setExp(int exp) {
		this.doswiadczenie = exp;
	}
	
	@Override
	public String toString() {
		return "Pracownik [id=" + id + ", login=" + login + ", haslo=" + haslo + ", stanowisko=" + stanowisko + ", exp="
				+ doswiadczenie + "]";
	}
	
	
	
}
