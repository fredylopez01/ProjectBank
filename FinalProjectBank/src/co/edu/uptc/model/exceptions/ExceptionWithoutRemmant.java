package co.edu.uptc.model.exceptions;

public class ExceptionWithoutRemmant extends Exception{
	private static final long serialVersionUID = 1L;

	public ExceptionWithoutRemmant() {
		super("Saldo insuficinete \nNo cuenta con el suficiente saldo para completar la acción");
	}
}
