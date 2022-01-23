package user;

import java.util.Date;

// L'utente finale a cui è destinato il programma
// Si devono immagazzinare nell'oggetto le sue generalità

public class Person {

	private String name;
	private String surname;
	private Date birthDate;
	private String fiscalCode;
	private String address;

	public Person(String name, String surname, Date birthDate, String fiscalCode, String address) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.fiscalCode = fiscalCode;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public String getAddress() {
		return address;
	}

}