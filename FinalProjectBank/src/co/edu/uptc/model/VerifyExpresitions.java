package co.edu.uptc.model;

import java.util.regex.Pattern;

public class VerifyExpresitions {
	
	public boolean isCorrectFormatNumberCheck(String numberCheck) {
		String regExp = "(\\d+)";
		return Pattern.matches(regExp, numberCheck);
	}
	
	public boolean isCorrectFormatPassword(String password) {
		String regExp = "(\\d{4})";
		return Pattern.matches(regExp, password);
	}
	
	
}
