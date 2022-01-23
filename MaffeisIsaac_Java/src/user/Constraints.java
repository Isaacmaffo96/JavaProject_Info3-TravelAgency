package user;

import collections.CityObject;
import collections.Day;
import collections.Destination;
import collections.UserFacade;
import exceptions.CityNotValidException;
import exceptions.FieldNotValidException;

// Classe legata all'oggetto Persona, ne rappresenta i vincoli scelti da quest'ultima per scegliere il pacchetto di viaggio desiderato

public class Constraints {

	// VINCOLI:
	private Destination destination;
	private CityObject departureCity;
	private Day fromDay;
	private Day toDay;
	private UserFacade f;

	public Constraints(UserFacade f) {
		this.f = f;
		this.destination = null;
		this.departureCity = null;
		this.fromDay = null;
		this.toDay = null;
	}

	void setDestination(String s) throws FieldNotValidException {
		String dst = s.strip().toUpperCase();
		try {
			this.destination = Destination.valueOf(dst);
		} catch (IllegalArgumentException e) {
			throw new FieldNotValidException("Il campo destinazione può avere valore come valore la stringa: mare, montagna o città");
		}
	}

	void setDepartureCity(String s) throws CityNotValidException, FieldNotValidException {
		if (s.strip().length() != 3)
			throw new FieldNotValidException("Il codice deve avere 3 caratteri " + s);
		try {
			this.departureCity = f.findCity(s.strip().toUpperCase());
			if(departureCity==null)	throw new NullPointerException();
		} catch (NullPointerException e) {
			throw new CityNotValidException("Non ci sono pacchetti per la città di partenza selezionata");
		}
	}

	void setFromDay(String s) throws FieldNotValidException {
		String tmp = s.strip().toUpperCase();
		try {
			this.fromDay = Day.valueOf(tmp);
		} catch (IllegalArgumentException e) {
			throw new FieldNotValidException("Il campo giorno può avere valore come valore la stringa: Lunedì, Martedì, Mercoledì, Giovedì, Venerdì, Sabato o Domenica.");
		}
	}

	void setToDay(String s) throws FieldNotValidException {
		String tmp = s.strip().toUpperCase();
		try {
			this.toDay = Day.valueOf(tmp);
		} catch (IllegalArgumentException e) {
			throw new FieldNotValidException("Il campo giorno può avere valore come valore la stringa: Lunedì, Martedì, Mercoledì, Giovedì, Venerdì, Sabato o Domenica.");
		}
	}

	public Destination getDestination() {
		return destination;
	}
	
	public CityObject getDepartureCity() {
		return departureCity;
	}

	public Day getFromDay() {
		return fromDay;
	}

	public Day getToDay() {
		return toDay;
	}

	// per essere valido il vincolo deve avere non nulli questi campi
	boolean validateConstraints() {
		if (destination != null && departureCity != null && fromDay != null && toDay != null)
			return true;
		return false;
	}

}
