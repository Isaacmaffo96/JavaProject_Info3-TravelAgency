package user;

import java.util.ArrayList;

import collections.TravelPackage;
import collections.UserFacade;
import exceptions.ReservationNotValidException;

// Lista delle soluzioni (pacchetti di viaggio) disponibili per un utente in base ai vincoli selezionati

public class Solutions {

	private UserFacade f;
	private Constraints constraints;
	private ArrayList<TravelPackage> solutions;

	public Solutions(UserFacade f, Constraints constraints) throws ReservationNotValidException {
		this.f = f;
		this.constraints = constraints;
		this.solutions = new ArrayList<>();
		populateSolutions();
	}

	// vado a inserire nella lista gli oggetti pacchetti di viaggio che rispettano i vincoli dell'utente
	private void populateSolutions() throws ReservationNotValidException {
		f.populateSolutions(constraints, solutions);
		if(solutions.isEmpty()) throw new ReservationNotValidException("Non sono state trovate soluzioni per le opzioni selezionate ");
	}

	// cerco la soluzione i-esima e lancio una eccezione se l'indice non è presente 
	public TravelPackage find(int i) throws ReservationNotValidException {
		if(i<0 || i>solutions.size()-1)	throw new ReservationNotValidException(" Il pacchetto selezionato non esiste");
		return solutions.get(i);
	}

	@Override
	public String toString() {
		int i = 1;
		String result = null;
		for (TravelPackage travelPackage : solutions) {
			if(result == null) result = i++ + ". " + travelPackage.toString() + "\n";
			else result += i++ + ". " + travelPackage.toString() + "\n";
		}
		return result;
	}

}
