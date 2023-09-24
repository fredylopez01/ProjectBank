package co.edu.uptc.model.exceptions;

public class ExceptionBadFormatDate extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionBadFormatDate() {
		super("Formato de fecha incorrecto");
	}
}
