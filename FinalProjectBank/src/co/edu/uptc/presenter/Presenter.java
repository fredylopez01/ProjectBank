package co.edu.uptc.presenter;

import java.time.LocalDate;
import java.util.regex.Pattern;

import co.edu.uptc.model.Bank;
import co.edu.uptc.model.Check;
import co.edu.uptc.model.Current;
import co.edu.uptc.model.Person;
import co.edu.uptc.model.Savings;
import co.edu.uptc.model.exceptions.ExceptionAmountCero;
import co.edu.uptc.model.exceptions.ExceptionBadFormatDate;
import co.edu.uptc.model.exceptions.ExceptionSamePassword;
import co.edu.uptc.model.exceptions.ExceptionWithoutRemmant;
import co.edu.uptc.view.View;

public class Presenter {
	private Bank bankTest;
	private View viewTest;
	
	public Presenter() {
		bankTest = new Bank();
		viewTest = new View();
	}
	
	public static void main (String [] args) {
		Presenter presenterTest = new Presenter();	
		presenterTest.run();
	}
	
	public void run() {
		load();
		int option = 0;
		do {
			bankTest.blockSavingsChecks();
			option = optionMenu();
			switch(option) {
				case 1:
					creation();
					break;
				case 2:
					changePassword();
					break;
				case 3:
					blockCount();
					break;
				case 4:
					consultRemmant();
					break;
				case 5:
					consign();
					break;
				case 6:
					withdraw();
					break;
				case 7:
					transfer();
					break;
				case 8:
					liquidateInterest();
					break;
				case 9:
					showChecks();
					break;
				case 10:
					showUsers();
					break;
				case 11:
					viewTest.showMessage("Ha sido un placer, vuelva pronto", "Salida", viewTest.getCorrect());
					System.exit(0);
				default:
					viewTest.showMessage("Opción invalida", "Error", viewTest.getIncorrect());
			}
		} 
		while(option != 11);
	}
	

	public void load() {
		Person person = new Person("Camilo", 1054);
		Current currentCheck = new Current(person, "a123", LocalDate.of(2020, 2, 4), 50000);
		Savings savingsCheck = new Savings(person, "b123", LocalDate.of(2023, 1, 1));
		bankTest.checkIn(person);
		bankTest.addCheck(currentCheck);
		bankTest.addCheck(savingsCheck);
	}
	
	public int optionMenu() {
		return viewTest.readInt(LocalDate.now() + "\nBienvenido a su Banco de confianza\n\n1. Crear Usuario \n2. Cambiar contraseña \n3. Bloquear cuenta"
				+ "\n4. Consultar saldo \n5. Consignar \n6. Retirar \n7. Transferir a otros usuarios \n8. Liquidar intereses \n9. Ver información de cuentas"
				+ "\n10. Mostrar lista de usuarios \n11. Salir \n\nDigite Opción", "Página Principal-Menú", viewTest.getBankIcon());
	}
	
	public void creation() {
		int option = viewTest.readInt("1. Registrarse \n2. Crear cuenta corriente \n3. Crear cuenta de ahorros", "Crear Ususario", viewTest.getCreateUser());
		if(option == 1) {
			checkIn();
		} else if(option == 2 || option == 3) {
			createCheck(option);
		} else {
			viewTest.showMessage("Opción invalida", "Error", viewTest.getIncorrect());
		}
	}
	
	public void checkIn() {
		if(bankTest.checkIn(createPerson())) {
			viewTest.showMessage("Persona registrada correctamente", "Correcto", viewTest.getCorrect());	
		} else {
			viewTest.showMessage("Persona ya registrada", "Error", viewTest.getIncorrect());
		}
	}
	
	public Person createPerson() {
		String name = viewTest.readString("Nombre del nuevo usuario: ", "Pregunta", viewTest.getSignQuestion());
		int id = viewTest.readInt("Identificación: ", "Pregunta", viewTest.getSignQuestion());
		return new Person(name, id);
	}
	
	public void createCheck(int option) {
		Person person = bankTest.searchPerson(viewTest.readInt("Ingrese la identificación del usuario", "Pregunta", viewTest.getSignQuestion()));;
		if(person != null) {
			Check check = null;
			try {
				if(option == 2) {
						check = createCurrent(person);
				} else if(option == 3) {
					check = createSavings(person);
				}
				bankTest.addCheck(check);
				viewTest.showMessage("Cuenta creada correctamente\n" + showCheck(check), "Correcto", viewTest.getCorrect());
			} catch (ExceptionBadFormatDate e) {
				viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
			}
		} else {
			viewTest.showMessage("Persona no registrada", "Error", viewTest.getIncorrect());
		}
	}
	
	public Current createCurrent(Person owner) throws ExceptionBadFormatDate {
		String password = viewTest.readString("Ingrese la contraseña", "Pregunta", viewTest.getSignQuestion());
		double overdraf = Double.parseDouble(viewTest.readString("Ingrese el sobregiro que tendra esta cuenta", "Cuanto", viewTest.getSignDollar()));
		return new Current(owner, password, registerDate(), overdraf);
	}
	
	public Savings createSavings(Person owner) throws ExceptionBadFormatDate {
		String password = viewTest.readString("Ingrese la contraseña", "Pregunta", viewTest.getSignQuestion());
		return new Savings(owner, password, registerDate());
	}
	
	public LocalDate registerDate() throws ExceptionBadFormatDate {
		String regExp = "(0[1-9]|[12][0-9]|3[01])(/|-)(0[1-9]|1[0-2])(/|-)(\\d{4})";
		LocalDate dateFinal = null; 
		String date = viewTest.readString("Fecha de creación con formato: dd/mm/aaaa", "Pregunta", viewTest.getSignQuestion());
		if(Pattern.matches(regExp, date)) {
			String[] dateParts = date.split("/|-");
			dateFinal = LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]));
		} else {
			throw new ExceptionBadFormatDate();
		}
		return dateFinal;
	}
	
	public void changePassword() {
		Check check = bankTest.searchCheck(viewTest.readInt("¿Número de la cuenta?", "Cambiar Contraseña", viewTest.getChangePassword()));
		if(verifyCheck(check)) {
			try {
				bankTest.changePassword(check, viewTest.readString("Ingrese la nueva contraseña", "Pregunta", viewTest.getSignQuestion()));
			} catch(ExceptionSamePassword e) {
				viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
			}
		}
	}
	
	public void blockCount() {
		Check check = bankTest.searchCheck(viewTest.readInt("Ingrese el número de la cuenta", "Bloquear Cuenta", viewTest.getBlockCheck()));
		if(verifyCheck(check)) {
			if(bankTest.blockCount(check)) {
				viewTest.showMessage("Cuenta bloqueada correctamente", "Correcto", viewTest.getCorrect());
			} else {
				viewTest.showMessage("La cuenta ya esta bloqueada", "Correcto", viewTest.getCorrect());
			}
		}
	}
	
	public void consultRemmant() {
		Check check = bankTest.searchCheck(viewTest.readInt("Ingrese el número de la cuenta", "Consultar Saldo", viewTest.getConsultRemmant()));
		if(check != null) {
			viewTest.showMessage(showCheck(check), "Información", viewTest.getSignDollar());
		} else {
			viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
		}
	}
	
	public void consign() {
		Check check = bankTest.searchCheck(viewTest.readInt("¿Número de cuenta destino?", "Consignar", viewTest.getConsign()));
		if(check != null) {
			try {
				double amount = Double.parseDouble(viewTest.readString("¿Cuánto quiere  consignar?", "Cuanto", viewTest.getSignDollar()));
				bankTest.consign(check, amount);
				viewTest.showMessage("Acción exitosa", "Correcto", viewTest.getCorrect());
				if(check.isBlocked()) {
					check.setBlocked(false);
				}
			} catch(ExceptionAmountCero e) {
				viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
			}
		} else {
			viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
		}
	}
	
	public void withdraw() {
		Check check = bankTest.searchCheck(viewTest.readInt("¿Número de su cuenta?", "Retirar", viewTest.getWithdraw()));
		if(verifyCheck(check)) {
			double amount = Double.parseDouble(viewTest.readString("¿Cuanto quiere  retirar?", "Cuanto", viewTest.getSignDollar()));
			withdrawProcess(check, amount);
		}
	}
	
	public void withdrawProcess(Check check, double amount) {
		try {
			if(check instanceof Current) {
				bankTest.withdrawCurrent((Current) check, amount);
			} else if(check instanceof Savings) {
				bankTest.withdrawSavings((Savings) check, amount);
			}
			viewTest.showMessage("Retiro existoso", "Correcto", viewTest.getCorrect());
		} catch (ExceptionWithoutRemmant e) {
			viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
		} catch (ExceptionAmountCero e) {
			viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
		}
	}
	
	public boolean verifyCheck(Check check) {
		boolean isCorrect = false;
		if(check != null) {
			if(!check.isBlocked()) {
				if(bankTest.verifyPassword(check, viewTest.readString("Ingrese la contraseña para poder realizar la acción", "Pregunta", viewTest.getSignQuestion()))) {
					isCorrect = true;
				} else {
					viewTest.showMessage("Contraseña incorrecta", "Error", viewTest.getIncorrect());
				}
			} else {
				viewTest.showMessage("Cuenta bloqueada", "Error", viewTest.getIncorrect());
			}
		} else {
			viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
		}
		return isCorrect;
	}
	
	public void transfer() {
		Check check = bankTest.searchCheck(viewTest.readInt("¿Número de su cuenta?","Transferir", viewTest.getTransfer()));
		if(verifyCheck(check)) {
			Check checkTwo = bankTest.searchCheck(viewTest.readInt("¿Número de la cuenta destino?", "Consignar", viewTest.getConsign()));
			if(checkTwo != null) {
				double amount = Double.parseDouble(viewTest.readString("¿Cuánto quiere  transferir?", "Cuánto", viewTest.getSignDollar()));
				transferProcess(check, amount, checkTwo);
			}else {
				viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
			}
		}
	}
	
	public void transferProcess(Check check, double amount, Check checkTwo) {
		try {
			bankTest.transfer(check, amount, checkTwo);
			viewTest.showMessage("Tranferencia Exitosa", "Correcto", viewTest.getCorrect());
		} catch (ExceptionWithoutRemmant e) {
			viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
		} catch (ExceptionAmountCero e) {
			viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
		}
	}
	
	public void liquidateInterest() {
		bankTest.liquidateInterest(LocalDate.now());
		viewTest.showMessage("Actualización Exitosa", "Correcto", viewTest.getCorrect());
	}
	
	public void showChecks() {
		StringBuilder message = new StringBuilder();
		for(int i = 0; i < bankTest.getChecks().size(); i++) {
			message.append(showCheck(bankTest.getChecks().get(i)));
		}
		viewTest.showMessage(message.toString(), "Cuentas", viewTest.getShowUsers());
	}
	
	
	public String showCheck(Check check) {
		StringBuilder message = new StringBuilder();
		message.append("------Numero de cuenta: " + check.getNumber() + "------\nPropietario: " + check.getOwner().getName() + "\nIdentificación: " 
					+ check.getOwner().getId() + "\nFrecha de creación: "+ check.getCreationDate() + "\nTipo de cuenta: ");
		if(check instanceof Current) {
			Current checkCurrent = (Current)check;
			message.append("Corriente \nDeuda: " + checkCurrent.calculateDebt());
		} else if(check instanceof Savings) {
			message.append("Ahorros");
		}
		message.append("\nSaldo: $" + check.getRemmant() + "\n\n");
		return message.toString();
	}
	
	public void showUsers() {
		StringBuilder message = new StringBuilder();
		for(Person i: bankTest.getCustomers()) {
			message.append("Nombre: " + i.getName() +  "\nIdentificación: " + i.getId() + "\n\n");
		}
		viewTest.showMessage(message.toString(), "Usuarios", viewTest.getShowUsers());
	}
	
}
