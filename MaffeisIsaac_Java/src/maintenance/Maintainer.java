package maintenance;

import java.util.zip.DataFormatException;

import collections.MaintFacade;
import exceptions.CityNotValidException;

// il Manutentore avvia il programma e può controllarne l'operato aggiungendo città, pacchetti di viaggio e controllando la lista delle prenotazioni

public class Maintainer {
	
	private String ID;
	private MaintFacade f;

	public Maintainer(String ID, MaintFacade f) {
		this.ID = ID;
		this.f = f;
	}
	
	// aggiungere una nuova città alla lista
	public void addCity(String city) throws CityNotValidException {
		f.addCity(city);
	}	
	
	//aggiungere un nuovo pacchetto viaggio
	public void addPackage(String travelPackage) throws CityNotValidException, DataFormatException {
		f.addTravelPackage(travelPackage);
	}	
	
	//stamapre la lista delle prenotazioni complessive
	public String printReservationList() {
		return f.printReservationsList();
	}

}
