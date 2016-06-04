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
												rs.getInt("status"));
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
			s.executeUpdate("UPDATE `zadanie` SET `status`="+status+" WHERE `id`="+id);
		} catch(SQLException e){
			
		}	
	}

}
