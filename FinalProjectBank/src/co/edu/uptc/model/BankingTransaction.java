package co.edu.uptc.model;

import java.time.LocalDate;

public class BankingTransaction {
	private LocalDate date;
	private double amount;
	private String type;
	
	public BankingTransaction(LocalDate date, double amount, String type) {
		this.date = date;
		this.amount = amount;
		this.type = type;
	}
	
	public String toString() {
		return date + "    " + type + "    " + amount + "\n";
	}
}
