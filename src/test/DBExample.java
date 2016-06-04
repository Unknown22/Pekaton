package test;

import java.util.ArrayList;
import java.util.List;

import database.*;
import model.*;

public class DBExample {

	public static void main(String[] args) {

		DataBase db = new DataBase();
		
		Pracownik pracownik;
		
		pracownik = db.getPracownikByID(1);
		
		System.out.println(pracownik.toString());
		
		List<Zadanie> zadania = new ArrayList<Zadanie>();
		
		zadania = db.getZadaniaByPracownikId(1);
		
		for (int x = 0; x < zadania.size(); x++){
			System.out.println(zadania.get(x));
			System.out.println(zadania.get(0).getOpis());
		}
		
		System.out.println(db.getIdBy("Nadia Romanov", "nd"));
		
	}

}
