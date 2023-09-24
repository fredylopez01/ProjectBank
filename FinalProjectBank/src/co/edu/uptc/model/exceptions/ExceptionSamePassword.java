package co.edu.uptc.model.exceptions;

public class ExceptionSamePassword extends Exception{
	private static final long serialVersionUID = 1L;

	public ExceptionSamePassword() {
		super("La contraseña es igual a la anterior.\nDebe ingresar una contraseña diferente");
	}
	
}
