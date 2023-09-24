package co.edu.uptc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Check implements Serializable {
	private static final long serialVersionUID = 1L;
	private Person owner;
	private int number;
	private double remmant;
	private String password;
	private boolean isBlocked;
	private LocalDate creationDate;
	private ArrayList<BankingTransaction> bankingTransactions;
	
	public Check(int firts, Person owner, String password, LocalDate creationDate) {
		this.owner = owner;
		this.number = (firts += (int) (Math.random()*1000+1));
		this.password = password;
		this.creationDate = creationDate;
		bankingTransactions = new ArrayList<BankingTransaction>();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getRemmant() {
		return remmant;
	}

	public void setRemmant(double remmant) {
		this.remmant = remmant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public ArrayList<BankingTransaction> getBankingTransactions() {
		return bankingTransactions;
	}
	
	public void setBankingTransactions(ArrayList<BankingTransaction> bankingTransactions) {
		this.bankingTransactions = bankingTransactions;
	}
	
}
