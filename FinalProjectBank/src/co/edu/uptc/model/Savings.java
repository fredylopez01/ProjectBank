package co.edu.uptc.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Savings extends Check {
	private double interest;
	private static double miniumBalance;
	private LocalDate interestDate;

	public Savings(int number,Person owner, String password, LocalDate creationDate) {
		super(number, owner, password, creationDate);
		miniumBalance = 5000;
		interestDate = creationDate;
		interest = 0.1;
	}
	
	public void liquidateInterest(LocalDate presentDate) {
		if(presentDate.isAfter(interestDate)) {
			int days = (int) ChronoUnit.DAYS.between(interestDate, presentDate);
			setRemmant(getRemmant() + days*(getRemmant()*interest)/365);
			interestDate = presentDate;
		}
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public static double getMiniumBalance() {
		return miniumBalance;
	}

	public static void setMiniumBalance(double miniumBalance) {
		Savings.miniumBalance = miniumBalance;
	}

}
