package co.edu.uptc.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.uptc.model.Bank;
import co.edu.uptc.model.Check;
import co.edu.uptc.model.Current;
import co.edu.uptc.model.Person;
import co.edu.uptc.model.Savings;
import co.edu.uptc.model.exceptions.ExceptionAmountCero;
import co.edu.uptc.model.exceptions.ExceptionSamePassword;

public class TestBank {
	public static Bank bankTest;
	public static Person person;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bankTest = new Bank();
		person = new Person("Alexander", 1055);
		bankTest.checkIn(person);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testChangePassword() {
		Current currentCheck = new Current(person, "1234", LocalDate.of(2022, 10, 31), 50000);
		bankTest.addCheck(currentCheck);
		assertThrows(ExceptionSamePassword.class, ()-> bankTest.changePassword(currentCheck, "1234"));
	}

	@Test
	public void testConsign() {
		Savings savingsCheck = new Savings(person, "b123", LocalDate.of(2023, 1, 1));
		bankTest.addCheck(savingsCheck);
		try {
			bankTest.consign(savingsCheck, 1000, LocalDate.now());
		} catch (ExceptionAmountCero e) {
			System.out.println(e.getMessage());
		}
		double real = 1000;
		double actual = savingsCheck.getRemmant();
		assertEquals(real, actual, 0);
	}
	
	

}
