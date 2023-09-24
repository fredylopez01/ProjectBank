package co.edu.uptc.model;

import java.io.Serializable;
import java.time.LocalDate;

public class BankingTransaction implements Serializable {
	private static final long serialVersionUID = 1L;
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
