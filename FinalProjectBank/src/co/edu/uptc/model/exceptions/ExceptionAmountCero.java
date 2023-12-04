package co.edu.uptc.model.exceptions;

public class ExceptionAmountCero extends Exception{
	private static final long serialVersionUID = 1L;

	public ExceptionAmountCero() {
		super("La cifra que ingreso es invalida.");
	}
}
