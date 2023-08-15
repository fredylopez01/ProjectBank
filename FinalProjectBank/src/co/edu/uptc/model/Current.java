package co.edu.uptc.model;

import java.time.LocalDate;

public class Current extends Check {
	private double overdraf;
	private double debt;
	
	public Current(int number, Person owner, String password, LocalDate creationDate, double overdraf) {
		super(number, owner, password, creationDate);
		this.overdraf = overdraf;
	}
	
	public double calculateDebt() {
		debt = overdraf+ super.getRemmant();
		if(debt > overdraf) {
			debt = 0;
		} else if(debt <= overdraf) {
			debt = overdraf-debt;
		}
		return debt;
	}

	public double getOverdraf() {
		return overdraf;
	}

	public void setOverdraf(double overdraf) {
		this.overdraf = overdraf;
	}

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}
	
}
