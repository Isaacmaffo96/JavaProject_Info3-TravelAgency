package user;

import collections.Reservation;
import collections.UserFacade;
import exceptions.CityNotValidException;
import exceptions.FieldNotValidException;
import exceptions.ReservationNotValidException;

// Classe che gestisce l'interazione dell'utente con il programma
// permette di settare i vincoli
// scegliere la soluzione desiderata
// stampare la prenotazione

public class UserManagment {

	private Person person;
	private UserFacade f;
	private Constraints constraints;
	private Solutions solutions;
	private Reservation reservation;

	public UserManagment(Person person, UserFacade f) {
		this.person = person;
		this.f = f;
		this.constraints = new Constraints(f);
		this.solutions = null;
		this.reservation = null;
	}

	// Imposto i vincoli
	
	public void setDestination(String s) throws FieldNotValidException {
		constraints.setDestination(transalate(s));
	}

	public void setDepartureCity(String s) throws CityNotValidException, FieldNotValidException {
		constraints.setDepartureCity(transalate(s));
	}

	public void setFromDay(String s) throws FieldNotValidException {
		constraints.setFromDay(transalate(s));
	}

	public void setToDay(String s) throws FieldNotValidException {
		constraints.setToDay(transalate(s));
	}

	// Soluzioni proposte dal programma
	
	public void generateSolutions() throws ReservationNotValidException {
		if (constraints.validateConstraints())
			this.solutions = new Solutions(f, constraints);
	}

	public String displaySolutions() {
		return solutions.toString();
	}

	public void chooseSolution(int i) throws ReservationNotValidException {
		if (reservation == null)
			this.reservation = new Reservation(solutions.find(i), person);
	}

	// Prenotazione
	
	public String printReservation() {
		return reservation.toString();
	}

	// Lista delle città
	
	public String printCitiesList() {
		return f.printCitiesList();
	}

	// Guida turistica
	
	public String printGuide() {
		return reservation.getGuide();
	}

	// Noleggio del mezzo
	
	public String rental() {
		return reservation.rental();
	}

	public String rentalInfo() {
		return reservation.rentalInfo();
	}

	// traduco in inglese poichè nel programma i tipi enumerativi sono memorizzati in lingua inglese
	private String transalate(String s) {
		if (s.strip().toLowerCase().equals("mare"))
			return "SEA";
		if (s.strip().toLowerCase().equals("montagna"))
			return "MOUNTAIN";
		if (s.strip().toLowerCase().equals("citta"))
			return "CITY";
		if (s.strip().toLowerCase().equals("città"))
			return "CITY";
		if (s.strip().toLowerCase().equals("lunedi"))
			return "MONDAY";
		if (s.strip().toLowerCase().equals("lunedì"))
			return "MONDAY";
		if (s.strip().toLowerCase().equals("martedi"))
			return "TUESDAY";
		if (s.strip().toLowerCase().equals("martedì"))
			return "TUESDAY";
		if (s.strip().toLowerCase().equals("mercoledi"))
			return "WEDNESDAY";
		if (s.strip().toLowerCase().equals("mercoledì"))
			return "WEDNESDAY";
		if (s.strip().toLowerCase().equals("giovedi"))
			return "THURSDAY";
		if (s.strip().toLowerCase().equals("giovedì"))
			return "THURSDAY";
		if (s.strip().toLowerCase().equals("venerdi"))
			return "FRIDAY";
		if (s.strip().toLowerCase().equals("venerdì"))
			return "FRIDAY";
		if (s.strip().toLowerCase().equals("sabato"))
			return "SATURDAY";
		if (s.strip().toLowerCase().equals("domenica"))
			return "SUNDAY";
		return s;
	}

}
