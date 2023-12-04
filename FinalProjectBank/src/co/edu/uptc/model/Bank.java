package co.edu.uptc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

import co.edu.uptc.model.exceptions.ExceptionAmountCero;
import co.edu.uptc.model.exceptions.ExceptionSamePassword;
import co.edu.uptc.model.exceptions.ExceptionWithoutRemmant;

public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;
	private String password;
	private TreeSet<Person> customers;
	private ArrayList<Check> checks;
	
	
	public Bank(String password) {
		this.password = password;
		customers = new TreeSet<Person>();
		checks = new ArrayList<Check>();
	}
	
	public boolean checkIn(Person person) {
		return customers.add(person);
	}
	
	public boolean addCheck(Check check) {
		return checks.add(check); 
	}
	
	public Person searchPerson(int id) {
		Person owner = null;
		for(Person i: customers) {
			if(i.getId() == id) {
				owner = i;
			}
		}
		return owner;
	}
	
	public void changePassword(Check check, String password) throws ExceptionSamePassword {
		if(check.getPassword().equals(password)) {
			throw new ExceptionSamePassword();
		} else {
			check.setPassword(password);
		}
	}
	
	public Check searchCheck(int numberCheck) {
		Check check = null;
		for(int i = 0; i < checks.size(); i++) {
			if(checks.get(i).getNumber() == numberCheck) {
				check = checks.get(i);
			}
		}
		return check;
	}
	
	public boolean verifyPassword(Check check, String password) {
		boolean response = false;
		if(check.getPassword().equals(password)) {
			response = true;
		}
		return response;
	}
	
	public boolean blockCount(Check check) {
		boolean isBlocked = false;
		if(!check.isBlocked()) {
			check.setBlocked(true);
			isBlocked = true;
		}
		return isBlocked;
	}
	
	public void blockSavingsChecks() {
		for(int i = 0; i < checks.size(); i++) {
			if(checks.get(i) instanceof Savings) {
				Savings check = (Savings) checks.get(i);
				if(check.getRemmant() > 0 && check.getRemmant() < Savings.getMiniumBalance()) {
					checks.get(i).setBlocked(true);
				}
			}
		}
	}
	
	public void consign(Check check, double amount, LocalDate date) throws ExceptionAmountCero {
		if(amount > 0) {
			check.setRemmant(check.getRemmant() + amount);
			registerBankingTransaction(check, amount, date, "Ingreso");
		} else {
			throw new ExceptionAmountCero();
		} 

	}
	
	public void withdraw(Check check, double amount, LocalDate date) throws ExceptionAmountCero {
		if(amount < 0) {
			check.setRemmant(check.getRemmant() + amount);
			registerBankingTransaction(check, amount, date, "Egreso");
		} else {
			throw new ExceptionAmountCero();
		}
	}
	
	public boolean withdrawCurrent(Current check, double amount, LocalDate date) throws ExceptionWithoutRemmant, ExceptionAmountCero {
		if(amount <= (check.getRemmant()+check.getOverdraf())) {
			withdraw(check, -amount, date);
			return true;
		} else {
			throw new ExceptionWithoutRemmant();
		}
	}
	
	public boolean withdrawSavings(Savings check, double amount, LocalDate date) throws ExceptionWithoutRemmant, ExceptionAmountCero {
		if(check.getRemmant() > 0 && amount <= check.getRemmant()) {
			withdraw(check, -amount, date);
			return true;
		} else {
			throw new ExceptionWithoutRemmant();
		}
	}
	
	public void transfer(Check check, double amount, Check checkTwo, LocalDate date) throws ExceptionWithoutRemmant, ExceptionAmountCero {
		if(check instanceof Current) {
			transferCurrent((Current)check, amount, checkTwo, date);
		} else if(check instanceof Savings) {
			transferSavings((Savings)check, amount, checkTwo, date);
		}
	}
	
	public void transferCurrent(Current check, double amount, Check checkTwo, LocalDate date) throws ExceptionWithoutRemmant, ExceptionAmountCero {
		if(withdrawCurrent(check, amount, date)) {
			consign(checkTwo, amount, date);
		}
	}
	
	public void transferSavings(Savings check, double amount, Check checkTwo, LocalDate date) throws ExceptionWithoutRemmant, ExceptionAmountCero {
		if(withdrawSavings(check, amount, date)) {
			consign(checkTwo, amount, date);
		}
	}
	
	public void liquidateInterest(LocalDate date) {
		for(int i = 0; i < checks.size(); i++) {
			if(checks.get(i) instanceof Savings) {
				Savings check = (Savings) checks.get(i);
				check.liquidateInterest(date);
			}
		}
	}
	
	public void registerBankingTransaction(Check check, double amount, LocalDate date, String type) {
		check.getBankingTransactions().add(new BankingTransaction(date, amount, type));
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TreeSet<Person> getCustomers() {
		return customers;
	}

	public void setCustomers(TreeSet<Person> customers) {
		this.customers = customers;
	}

	public ArrayList<Check> getChecks() {
		return checks;
	}

	public void setChecks(ArrayList<Check> checks) {
		this.checks = checks;
	}
	
}
