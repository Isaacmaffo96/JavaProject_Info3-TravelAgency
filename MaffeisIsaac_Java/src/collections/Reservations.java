package collections;

import java.util.ArrayList;
import exceptions.ReservationNotValidException;

// Lista di tutte le prenotazioni effettuate, la creo usando il pattern singleton poichè ne voglio solo una per tutto il programma

public class Reservations {
	
	private static Reservations reservationsInstance = null;
	private ArrayList<Reservation> reservations;
	
	private Reservations() {
		this.reservations = new ArrayList<>();
	}
	
// creo la lista delle prenotazioni come singleton perchè ne devo avere solo una
	static Reservations instanceReservationsList() {
		if(reservationsInstance == null)
			reservationsInstance = new Reservations();
		return reservationsInstance;
	}
	
	void addReservation(Reservation reservation) throws ReservationNotValidException {
		if(reservations.contains(reservation))
			throw new ReservationNotValidException("Prenotazione già presente nella lista");
		reservations.add(reservation);
	}

	String printReservationsList() {
		return reservations.toString();
	}
	
}
