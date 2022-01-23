package user;

import java.util.Date;

// Student � figlia della classe Person, rappresenta uno studente
// � identica alla superclasse, se non per il campo relativo al nome della scuola
// � importante perch� gli studenti ottengono un 20% di sconto

public class Student extends Person {

	private String schoolName;

	public Student(String name, String surname, Date birthDate, String fiscalCode, String address, String schoolName) {
		super(name, surname, birthDate,fiscalCode,address);
		this.schoolName = schoolName;
	}

}
