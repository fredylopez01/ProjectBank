package co.edu.uptc.model;

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {
	private String name;
	private int id;
	
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Person o) {
		return id-o.id;
	}
	
}
