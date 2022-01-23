package collections;

import java.util.zip.DataFormatException;
import exceptions.CityNotValidException;

// sottoclasse della superclasse Facade
// permette al manutentore di aggiungere città e pacchetti viaggio manualmente

public class MaintFacade extends Facade {

	private Reservations reservations;
	
	public MaintFacade(Cities cities, TravelPackages travelPackages) {
		super(cities, travelPackages);
		this.reservations = Reservations.instanceReservationsList();  // genero la lista delle prenotazioni
	}
	
	// Formato della stringa: CODE, City Name, Region, Country, Destinazione (Enum).
	public void addCity(String c) throws CityNotValidException {
		String str[] = c.trim().split(",");
		String code = str[0].strip();
		if (code.length() != 3)
			throw new CityNotValidException("Il codice deve essere di 3 caratteri");
		String dst = (str[4].split("\\."))[0].strip().toUpperCase();			
		Destination key = Destination.valueOf(dst); 
		CityObject city;
		switch (key) {
		case CITY: {
			city = new City(str[0].strip(), str[1].strip(), str[2].strip(), str[3].strip());
			break;
		}
		case SEA: {
			city = new SeaCity(str[0].strip(), str[1].strip(), str[2].strip(), str[3].strip());
			break;
		}
		case MOUNTAIN: {
			city = new MountainCity(str[0].strip(), str[1].strip(), str[2].strip(), str[3].strip());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
		if (findCity(code) == null)
			throw new CityNotValidException("Città già esistente " + code);
		cities.addCity(city);
	}

	// Formato della stringa: Codice città di partenza, Codice città di arrivo,
	// Giorno Partenza, Giorno Arrivo, Trasporto, prezzo
	// lancio eccezioni se trovo problemi
	public void addTravelPackage(String t) throws CityNotValidException, DataFormatException {
		String str[] = t.trim().split(",");
		String depaurtureCityCode = str[0].strip();
		if (depaurtureCityCode.length() != 3)
			throw new CityNotValidException("Il codice deve essere di 3 caratteri");
		CityObject departureCity = findCity(depaurtureCityCode);
		if (departureCity == null)
			throw new CityNotValidException("Città non esistente " + depaurtureCityCode);
		String destinationCityCode = str[1].strip();
		if (destinationCityCode.length() != 3)
			throw new CityNotValidException("Il codice deve essere di 3 caratteri");
		CityObject destinationCity = findCity(destinationCityCode);
		if (destinationCity == null)
			throw new CityNotValidException("Città non esistente " + destinationCityCode);
		Day fromDay = Day.valueOf(str[2].strip().toUpperCase());
		Day toDay = Day.valueOf(str[3].strip().toUpperCase());
		TravelPackage travelPackage = new TravelPackage(departureCity, destinationCity, fromDay, toDay, str[4].strip(),
				Float.parseFloat(str[5]));
		travelPackages.addTravelPackage(travelPackage);
	}
		
	public String printReservationsList() {
		return reservations.printReservationsList();  // stampo la lista delle prenotazioni
	}

}
