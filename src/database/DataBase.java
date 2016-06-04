package database;
import java.sql.Connection;
import java.sql.Statement;

import dao.Pracownik;

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

}
