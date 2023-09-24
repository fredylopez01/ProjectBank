package co.edu.uptc.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import co.edu.uptc.model.Bank;
import co.edu.uptc.model.Current;
import co.edu.uptc.model.Person;

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
		Person person = new Person("Camilo", 1055);
		bank.checkIn(person);
		bank.addCheck(new Current(1, person, "a123", LocalDate.of(2023, 3, 27), 10000));
		return bank;
	}
	
	public void saveDates(Bank bankTest) throws FileNotFoundException, IOException {
		FileOutputStream file = new FileOutputStream(route);
		ObjectOutputStream escribirFichero = new ObjectOutputStream(file);
		escribirFichero.writeObject(bankTest);
		escribirFichero.close();
	}
}
