package co.edu.uptc.presenter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Pattern;

import co.edu.uptc.model.Bank;
import co.edu.uptc.model.BankingTransaction;
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
//		bankTest = new Bank("123");
		bankTest = loadDates();
//		load();
		viewTest = new View();
	}
	
	public void load() {
		Person person = new Person("Camilo", 1054);
		bankTest.checkIn(person);
		Current current = new Current(123, person, "a123", LocalDate.of(2023, 01, 01), 10000);
		Savings savings = new Savings(543,person, "b123", LocalDate.of(2023, 3, 27));
		bankTest.addCheck(current);
		bankTest.addCheck(savings);
	}
	
	public static void main (String [] args) {
		Presenter presenterTest = new Presenter();	
		presenterTest.run();
	}
	
	public void run() {
		int option;
		do {
			option = viewTest.readInt(LocalDate.now() + "\n\nEntrar como: \n1. Administrador \n2. Usuario \n3. Salir", "Panel-Princpal", viewTest.getMainIcon());
			switch(option) {
			case 1:
				manager();
				break;
			case 2:
				user();
				break;
			case 3:
				saveDates();
				viewTest.showMessage("Ha sido un placer. Vuelva pronto.", "Salida", viewTest.getCorrect());
				System.exit(0);
			default:
				viewTest.showMessage("Opción invalida", "Error", viewTest.getIncorrect());
			}
		} while(option != 3);
	}
	
	public void manager() {
		if(viewTest.readString("Ingrese la contraseña", "Login-Administrador", viewTest.getChangePassword()).equals(bankTest.getPassword())) {
			int option = 0;
			do {
				bankTest.blockSavingsChecks();
				option = optionManager();
				switch(option) {
					case 1:
						changePasswordManager();
						break;
					case 2:
						blockCountManager();
						break;
					case 3:
						unBlockCountManager();
						break;
					case 4:
						liquidateInterest();
						break;
					case 5:
						showChecks();
						break;
					case 6:
						showUsers();
						break;
					case 7:
						viewTest.showMessage("Ha sido un placer, vuelva pronto", "Salida", viewTest.getCorrect());
						break;
					default:
						viewTest.showMessage("Opción invalida", "Error", viewTest.getIncorrect());
				}
			} 
			while(option != 7);
		} else {
			viewTest.showMessage("Contraseña incorrecta", "Error", viewTest.getIncorrect());
		}
	}
	
	public void saveDates() {
		try {
			ObjectOutputStream escribirFichero = new ObjectOutputStream(new FileOutputStream("src\\co\\edu\\uptc\\model\\dates.dat"));
			escribirFichero.writeObject(bankTest);
			viewTest.showMessage("Información correctamente guardada", "Cerrando sesión", viewTest.getCorrect());
			escribirFichero.close();
		} catch(IOException e) {
			viewTest.showMessage(e.getMessage(), "Cerrando sesion", viewTest.getIncorrect());
		}
	}
	
	public Bank loadDates() {
		try {
			ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("src\\co\\edu\\uptc\\model\\dates.dat"));
			
			Bank bank = (Bank) recuperarFichero.readObject();
			recuperarFichero.close();
			return bank;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public int optionManager() {
		return viewTest.readInt(LocalDate.now() + "\nBienvenido \n\n1. Cambiar contraseña \n2. Bloquear cuenta "
				+ "\n3. Desbloquear cuenta \n4. Liquidar interes \n5. Ver información de cuentas \n6. Mostrar lista de usuarios "
				+ "\n7. Salir \n\nDigite opción ", "Panel-Administrador", viewTest.getManagerIcon());
	}
	
	public void changePasswordManager() {
		String password = viewTest.readString("Ingrese la contraseña", "Login-Administrador", viewTest.getChangePassword());
		if(password.equals(bankTest.getPassword())) {
			try {
				changePasswordManagerProcess(password);
			} catch (ExceptionSamePassword e) {
				viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
			}
		} else {
			viewTest.showMessage("Contraseña incorrecta", "Error", viewTest.getIncorrect());
		}
	}
	
	public void changePasswordManagerProcess(String password) throws ExceptionSamePassword {
		String newPassword = viewTest.readString("Ingrese la nueva contraseña", "Pregunta", viewTest.getSignQuestion());
		if(password.equals(newPassword)) {
			throw new ExceptionSamePassword();
		} else {
			bankTest.setPassword(newPassword);
		}
	}
	
	public void blockCountManager() {
		Check check = bankTest.searchCheck(viewTest.readInt("Ingrese el número de la cuenta", "Bloquear Cuenta", viewTest.getBlockCheck()));
		if(check != null) {
			if(bankTest.blockCount(check)) {
				viewTest.showMessage("Cuenta bloqueada correctamente", "Correcto", viewTest.getCorrect());
			} else {
				viewTest.showMessage("La cuenta ya esta bloqueada", "Correcto", viewTest.getCorrect());
			}
		} else {
			viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
		}
	}
	
	public void unBlockCountManager() {
		Check check = bankTest.searchCheck(viewTest.readInt("Ingrese el número de la cuenta", "Desbloquear Cuenta", viewTest.getBlockCheck()));
		if(check != null) {
			if(check.isBlocked()) {
				check.setBlocked(false);
				viewTest.showMessage("Cuenta desbloqueada correctamente", "Correcto", viewTest.getCorrect());
			} else {
				viewTest.showMessage("La cuenta ya esta desbloqueada", "Correcto", viewTest.getCorrect());
			}
		} else {
			viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
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
					+ check.getOwner().getId() + "\nFecha de creación: "+ check.getCreationDate() + "\nTipo de cuenta: ");
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
	
	public void user() {
		int option = 0;
		do {
			bankTest.blockSavingsChecks();
			option = viewTest.readInt(LocalDate.now() + "\nBienevenido a su Banco de confianza \n\n1. Ingresar \n2. Registrarse \n3. Crear cuenta "
					+ "\n4. Salir", "Panel-Usuario", viewTest.getUserIcon());
			switch(option) {
				case 1:
					check();
					break;
				case 2:
					checkIn();
					break;
				case 3:
					creation();
					break;
				case 4:
					viewTest.showMessage("Ha sido un placer, vuelva pronto", "Salida", viewTest.getCorrect());
					break;
				default:
					viewTest.showMessage("Opción invalida", "Error", viewTest.getIncorrect());
			}
		} 
		while(option != 4);
	}
	
	public void check() {
		Check check = bankTest.searchCheck(viewTest.readInt("¿Número de la cuenta?", "Ingresar", viewTest.getChangePassword()));
		if(verifyCheck(check)) {
			menuUser(check);
		}
		
	}
	
	public void menuUser(Check check) {
		int option = 0;
		do {
			bankTest.blockSavingsChecks();
			option = optionUser();
			switch(option) {
				case 1:
					changePassword(check);
					break;
				case 2:
					blockCount(check);
					break;
				case 3:
					unBlockCount(check);
					break;
				case 4:
					consultRemmant(check);
					break;
				case 5:
					consign();
					break;
				case 6:
					withdraw(check);
					break;
				case 7:
					transfer(check);
					break;
				case 8:
					showHisoryTransactions(check);
					break;
				case 9:
					viewTest.showMessage("Ha sido un placer, vuelva pronto", "Salida", viewTest.getCorrect());
					break;
				default:
					viewTest.showMessage("Opción invalida", "Error", viewTest.getIncorrect());
			}
		} 
		while(option != 9);
	}
	
	public int optionUser() {
		return viewTest.readInt(LocalDate.now() + "\nBienvenido a su Banco de confianza\n\n1. Cambiar contraseña "
				+ "\n2. Bloquear cuenta \n3. Desbloquear cuenta \n4. Consultar saldo \n5. Consignar \n6. Retirar \n7. Transferir a otros usuarios"
				+ "\n8. Historial de una cuenta \n9. Salir \n\nDigite Opción", "Panel-Cuenta", viewTest.getBankIcon());
	}
	
	public void changePassword(Check check) {
		if(verifyCheck(check)) {
			try {
				bankTest.changePassword(check, viewTest.readString("Ingrese la nueva contraseña", "Pregunta", viewTest.getSignQuestion()));
			} catch(ExceptionSamePassword e) {
				viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
			}
		} else {
			viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
		}
	}
	
	
	public void blockCount(Check check) {
		if(verifyCheck(check)) {
			if(bankTest.blockCount(check)) {
				viewTest.showMessage("Cuenta bloqueada correctamente", "Correcto", viewTest.getCorrect());
			} else {
				viewTest.showMessage("La cuenta ya esta bloqueada", "Correcto", viewTest.getCorrect());
			}
		}
	}
	
	public void unBlockCount(Check check) {
		if(check != null) {
			if(bankTest.verifyPassword(check, viewTest.readString("Ingrese la contraseña para poder realizar la acción", "Pregunta", viewTest.getSignQuestion()))) {
				if(check.isBlocked()) {
					check.setBlocked(false);
					viewTest.showMessage("Cuenta desbloqueada correctamente", "Correcto", viewTest.getCorrect());
				} else {
					viewTest.showMessage("La cuenta ya esta desbloqueada", "Correcto", viewTest.getCorrect());
				}
			} else {
				viewTest.showMessage("Contraseña incorrecta", "Error", viewTest.getIncorrect());
			}
		} else {
			viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
		}
	}
	
	public void consultRemmant(Check check) {
		if(check != null) {
			viewTest.showMessage(showCheck(check), "Información", viewTest.getSignDollar());
		} else {
			viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
		}
	}
	
	public void consign() {
		Check check = bankTest.searchCheck(viewTest.readInt("¿Número de la cuenta?", "Ingresar", viewTest.getChangePassword()));
		if(check != null) {
			if(!check.isBlocked()) {
				try {
					double amount = Double.parseDouble(viewTest.readString("¿Cuánto quiere  consignar?", "Cuanto", viewTest.getSignDollar()));
					bankTest.consign(check, amount, LocalDate.now());
					viewTest.showMessage("Acción exitosa", "Correcto", viewTest.getCorrect());
				} catch(ExceptionAmountCero e) {
					viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
				}
			} else {
				viewTest.showMessage("Cuenta bloqueada", "Error", viewTest.getIncorrect());
			}
		} else {
			viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
		}
	}
	
	public void withdraw(Check check) {
		if(verifyCheck(check)) {
			double amount = Double.parseDouble(viewTest.readString("¿Cuanto quiere  retirar?", "Cuanto", viewTest.getSignDollar()));
			withdrawProcess(check, amount);
		}
	}
	
	public void withdrawProcess(Check check, double amount) {
		try {
			if(check instanceof Current) {
				bankTest.withdrawCurrent((Current) check, amount, LocalDate.now());
			} else if(check instanceof Savings) {
				bankTest.withdrawSavings((Savings) check, amount, LocalDate.now());
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
	
	public void transfer(Check check) {
		if(verifyCheck(check)) {
			Check checkTwo = bankTest.searchCheck(viewTest.readInt("¿Número de la cuenta destino?", "Consignar", viewTest.getConsign()));
			if(checkTwo != null) {
				double amount = Double.parseDouble(viewTest.readString("¿Cuánto quiere  transferir?", "Cuánto", viewTest.getSignDollar()));
				transferProcess(check, amount, checkTwo);
			} else {
				viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
			}
		}
	}
	
	public void transferProcess(Check check, double amount, Check checkTwo) {
		try {
			bankTest.transfer(check, amount, checkTwo, LocalDate.now());
			viewTest.showMessage("Tranferencia Exitosa", "Correcto", viewTest.getCorrect());
		} catch (ExceptionWithoutRemmant e) {
			viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
		} catch (ExceptionAmountCero e) {
			viewTest.showMessage(e.getMessage(), "Excepción", viewTest.getIncorrect());
		}
	}
	
	
	public void showHisoryTransactions(Check check) {
		StringBuilder message = new StringBuilder("Fecha               Motivo     Cantidad\n");
		if(check != null) {
			if(check.getBankingTransactions().isEmpty()) {
				message.replace(0, 39, "No se han registrado movimientos\nen esta cuenta hasta el momento");
			} else {
				for(BankingTransaction i: check.getBankingTransactions()) {
					message.append(i.toString());
				}
			}
			viewTest.showMessage(message.toString(), "Historial de Transacciónes", viewTest.getSignDollar());
		} else {
			viewTest.showMessage("Cuenta no existente", "Error", viewTest.getIncorrect());
		}
	}

	public void checkIn() {
		Person person = createPerson();
		if(person != null) {
			if(bankTest.checkIn(person)) {
				viewTest.showMessage("Persona registrada correctamente", "Correcto", viewTest.getCorrect());	
			} else {
				viewTest.showMessage("Persona ya registrada", "Error", viewTest.getIncorrect());
			}
		}
	}
	
	public Person createPerson() {
		Person person = null;
		String regExp = "[A-Z\\a-z]+";
		String name = viewTest.readString("Nombre del nuevo usuario: ", "Pregunta", viewTest.getSignQuestion());
		if(Pattern.matches(regExp, name)) {
			int id = viewTest.readInt("Identificación: ", "Pregunta", viewTest.getSignQuestion());
			person = new Person(name, id);
		} else {
			viewTest.showMessage("Nombre invalido", "Error", viewTest.getIncorrect());
		}
		return person;
	}
	
	public void creation() {
		int option = viewTest.readInt("1. Crear cuenta corriente \n2. Crear cuenta de ahorros", "Crear cuenta", viewTest.getCreateUser());
		if(option == 1 || option == 2) {
			createCheck(option);
		} else {
			viewTest.showMessage("Opción invalida", "Error", viewTest.getIncorrect());
		}
	}
	
	public void createCheck(int option) {
		Person person = bankTest.searchPerson(viewTest.readInt("Ingrese la identificación del usuario", "Pregunta", viewTest.getSignQuestion()));;
		if(person != null) {
			Check check = null;
			if(option == 1) {
					check = createCurrent(person);
			} else if(option == 2) {
				check = createSavings(person);
			}
			bankTest.addCheck(check);
			viewTest.showMessage("Cuenta creada correctamente\n" + showCheck(check), "Correcto", viewTest.getCorrect());
		} else {
			viewTest.showMessage("Persona no registrada", "Error", viewTest.getIncorrect());
		}
	}
	
	public Current createCurrent(Person owner) {
		String password = viewTest.readString("Ingrese la contraseña", "Pregunta", viewTest.getSignQuestion());
		double overdraf = Double.parseDouble(viewTest.readString("Ingrese el sobregiro que tendra esta cuenta", "Cuanto", viewTest.getSignDollar()));
		return new Current(bankTest.getChecks().get((bankTest.getChecks().size()-1)).getNumber(), owner, password, LocalDate.now(), overdraf);
	}
	
	public Savings createSavings(Person owner) {
		String password = viewTest.readString("Ingrese la contraseña", "Pregunta", viewTest.getSignQuestion());
		return new Savings(bankTest.getChecks().get((bankTest.getChecks().size()-1)).getNumber(),owner, password, LocalDate.now());
	}
	
//	public LocalDate registerDate() throws ExceptionBadFormatDate {
//		String regExp = "(0[1-9]|[12][0-9]|3[01])(/|-)(0[1-9]|1[0-2])(/|-)(\\d{4})";
//		LocalDate dateFinal = null; 
//		String date = viewTest.readString("Fecha de creación con formato: dd/mm/aaaa", "Pregunta", viewTest.getSignQuestion());
//		if(Pattern.matches(regExp, date)) {
//			String[] dateParts = date.split("/|-");
//			dateFinal = LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]));
//		} else {
//			throw new ExceptionBadFormatDate();
//		}
//		return dateFinal;
//	}
}
