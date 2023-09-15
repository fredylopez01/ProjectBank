package co.edu.uptc.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.uptc.model.Bank;

public class Persistence {
	private String route;
	
	public Persistence(String route) {
		this.route = route;
	}
	
	public Bank loadDates() {
		Bank bank = null;
		try {
			ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream(route));
			bank = (Bank) recuperarFichero.readObject();
			recuperarFichero.close();
			return bank;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			bank = loadB();
		}
		return bank;
	}

	public Bank loadB(){
		Bank bank = new Bank("123");
		return bank;
	}
	
	public void saveDates(Bank bankTest) throws FileNotFoundException, IOException {
		FileOutputStream file = new FileOutputStream(route);
		ObjectOutputStream escribirFichero = new ObjectOutputStream(file);
		escribirFichero.writeObject(bankTest);
		escribirFichero.close();
	}
}
