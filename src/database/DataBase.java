package database;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
	
	private Connection connection;
	
	public DataBase(){
		connection = DbUtil.getConnection();
	}
	
	public Pracownik getPracownikByID(int id) {

		Pracownik pracownik = new Pracownik();
		
		try {

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from pracownik where pracownik.id =" + id);

			while (rs.next()) {

				pracownik = new Pracownik(rs.getInt("id"), 
											rs.getString("login"), 
											rs.getString("haslo"),
											rs.getString("stanowisko"),
											rs.getInt("doswiadczenie")
													);
			}

		} catch (SQLException e) {
			System.out.println("Blad przy pobieraniu pracownika o id: " + id );
//			e.printStackTrace();
			return pracownik;
		}

		return pracownik;
	}
	
	public List<Zadanie> getZadaniaByPracownikId(int id){
		List<Zadanie> zadania = new ArrayList<Zadanie>();
		
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM zadanie WHERE id_pracownika =" + id + ";");
			
			while (rs.next()) {
				Zadanie zadanie = new Zadanie(rs.getInt("id"),
												rs.getString("opis"),
												rs.getInt("doswiadczenie"),
												rs.getString("zleceniodawca"),
												rs.getInt("id_pracownika"),
												rs.getInt("status"),
												rs.getInt("id_sprint"));
				zadania.add(zadanie);
			}
			
		} catch (SQLException e){
			System.out.println("Blad przy pobieraniu zadan dla pracownika o id: " + id);
		}
		return zadania;
	}
	
	public int getIdBy(String login, String password){  
		int id=-1;
		try{  		              
		Statement s=connection.createStatement();  
		ResultSet rs = s.executeQuery("select id from pracownik where login = '" + login + "' and haslo = '" + password + "'");
		
		
		 while(rs.next())
		 {
			 id=rs.getInt("id");
		 }

		              
		}catch(Exception e){
			System.out.println("Blad przy logowaniu");
			e.printStackTrace();
		}  
		
		return id;
	}
	
	public void setZadanieStatusById(int id, int status){
		
		try{
			Statement s=connection.createStatement();  

			s.executeUpdate("UPDATE `zadanie` SET `status`='"+status+"' WHERE `id`='"+id+"';");

		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("Blad przy zmianie statusu");
		}	
	}
	
	public List<Sprint> getAllSprints(){
		List<Sprint> sprinty = new ArrayList<Sprint>();
		
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM sprint;");
			
			while (rs.next()) {
				Sprint sprint = new Sprint (rs.getInt("id"),
											rs.getString("poczatek"),
											rs.getString("koniec"));
				sprinty.add(sprint);
			}
			
		} catch (SQLException e){
			System.out.println("Blad przy pobieraniu listy sprintow");
		}
		
		return sprinty;
	}
	

	public List<Zadanie> getAllZadanieBySprintId(int id_sprint){
		List<Zadanie> zadania = new ArrayList<Zadanie>();
		
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM zadanie WHERE id_sprint ="+id_sprint+";");
			
			while (rs.next()) {
				Zadanie zadanie = new Zadanie(rs.getInt("id"),
												rs.getString("opis"),
												rs.getInt("doswiadczenie"),
												rs.getString("zleceniodawca"),
												rs.getInt("id_pracownika"),
												rs.getInt("status"),
												rs.getInt("id_sprint"));
				zadania.add(zadanie);
			}
			
		} catch (SQLException e){
			System.out.println("Blad przy pobieraniu listy zadan");
		}
		
		return zadania;
	}

	public void updatePracownikExpByZadanie(int id_pracownika, int id_zadania){
		int exp_zadanie = 0;
		int obecny_exp_pracownika = -1;
		
		try{
			Statement s=connection.createStatement();  
			ResultSet rs = s.executeQuery("SELECT doswiadczenie FROM zadanie WHERE id ="+id_zadania+";");
			while(rs.next())
			{
				exp_zadanie=rs.getInt("doswiadczenie");
			}
		} catch(SQLException e){
			System.out.println("Blad przy pobieraniu doswiadczenia za zadanie");
		}
		System.out.println(exp_zadanie);
		
		try{
			Statement s=connection.createStatement();  
			ResultSet rs = s.executeQuery("SELECT doswiadczenie FROM pracownik WHERE id ="+id_pracownika+";");
			while(rs.next())
			{
				obecny_exp_pracownika=rs.getInt("doswiadczenie");
			}
			System.out.println(obecny_exp_pracownika);
			
			if(obecny_exp_pracownika>0){
				int suma = exp_zadanie + obecny_exp_pracownika;
				s.executeUpdate("UPDATE `pracownik` SET `doswiadczenie`='"+suma+"' WHERE `id`='"+id_pracownika+"';");
			}
		} catch(SQLException e){
			System.out.println("Blad przy aktualizacji expa pracownika");
		}
		
	}
	
	public List<Zadanie> getWolneZadania(){
		List<Zadanie> zadania = new ArrayList<Zadanie>();
		
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM zadanie WHERE id_pracownika is null;");
			
			while (rs.next()) {
				Zadanie zadanie = new Zadanie(rs.getInt("id"),
												rs.getString("opis"),
												rs.getInt("doswiadczenie"),
												rs.getString("zleceniodawca"),
												0,
												rs.getInt("status"),
												rs.getInt("id_sprint"));
				zadania.add(zadanie);
			}
			
		} catch (SQLException e){
			System.out.println("Blad przy pobieraniu nie przypisanych zadan");
		}
		return zadania;
	}

	public void setPracownikToZadanie(int id_pracownika, int id_zadania){
		try{
			Statement s=connection.createStatement();  
			s.executeUpdate("UPDATE `zadanie` SET `id_pracownika`='"+id_pracownika+"' WHERE `id`='"+id_zadania+"';");
		} catch (SQLException e){
			System.out.println("Blad przypisania zadania do pracownika");
		}
	}
}
