package test;

import database.*;
import dao.*;

public class DBExample {

	public static void main(String[] args) {

		DataBase db = new DataBase();
		
		Pracownik pracownik;
		
		pracownik = db.getPracownikByID(1);
		
		System.out.print(pracownik.toString());
		
		
	}

}
