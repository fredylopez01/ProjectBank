package co.edu.uptc.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

import co.edu.uptc.model.exceptions.ExceptionAmountCero;
import co.edu.uptc.model.exceptions.ExceptionSamePassword;
import co.edu.uptc.model.exceptions.ExceptionWithoutRemmant;

public class Bank {
	private TreeSet<Person> customers;
	private ArrayList<Check> checks;
	
	
	public Bank() {
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
	
	public void consign(Check check, double amount) throws ExceptionAmountCero {
		if(amount > 0) {
			check.setRemmant(check.getRemmant() + amount);
		} else {
			throw new ExceptionAmountCero();
		} 

	}
	
	public void withdraw(Check check, double amount) throws ExceptionAmountCero {
		if(amount < 0) {
			check.setRemmant(check.getRemmant() + amount);
		} else {
			throw new ExceptionAmountCero();
		}
	}
	
	public boolean withdrawCurrent(Current check, double amount) throws ExceptionWithoutRemmant, ExceptionAmountCero {
		if(amount <= (check.getRemmant()+check.getOverdraf())) {
			withdraw(check, -amount);
			return true;
		} else {
			throw new ExceptionWithoutRemmant();
		}
	}
	
	public boolean withdrawSavings(Savings check, double amount) throws ExceptionWithoutRemmant, ExceptionAmountCero {
		if(check.getRemmant() > 0 && amount <= check.getRemmant()) {
			withdraw(check, -amount);
			return true;
		} else {
			throw new ExceptionWithoutRemmant();
		}
	}
	
	public void transfer(Check check, double amount, Check checkTwo) throws ExceptionWithoutRemmant, ExceptionAmountCero {
		if(check instanceof Current) {
			transferCurrent((Current)check, amount, checkTwo);
		} else if(check instanceof Savings) {
			transferSavings((Savings)check, amount, checkTwo);
		}
	}
	
	public void transferCurrent(Current check, double amount, Check checkTwo) throws ExceptionWithoutRemmant, ExceptionAmountCero {
		if(withdrawCurrent(check, amount)) {
			withdraw(checkTwo, amount);
			if(checkTwo.isBlocked()) {
				checkTwo.setBlocked(false);
			}
		}
	}
	
	public void transferSavings(Savings check, double amount, Check checkTwo) throws ExceptionWithoutRemmant, ExceptionAmountCero {
		if(withdrawSavings(check, amount)) {
			withdraw(checkTwo, amount);
			if(checkTwo.isBlocked()) {
				checkTwo.setBlocked(false);
			}
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
