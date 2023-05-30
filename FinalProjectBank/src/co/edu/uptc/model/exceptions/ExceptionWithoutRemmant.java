package co.edu.uptc.model.exceptions;

public class ExceptionWithoutRemmant extends Exception{

	public ExceptionWithoutRemmant() {
		super("Saldo insuficinete \nNo cuenta con el suficiente saldo para completar la acción");
	}
}
