package co.edu.uptc.model.exceptions;

public class ExceptionAmountCero extends Exception{
	public ExceptionAmountCero() {
		super("La cifra que ingreso es invalida.");
	}
}
