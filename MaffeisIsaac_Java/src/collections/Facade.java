package collections;

// Utilizzo il pattern Facade per poter interagire con classi pi� esterne fornendo una serie di componenti e metodi, nascondendo gli oggetti pi� interni
// Utilizzo due Facade, uno per il Manutentore e uno per l'utente finale
// Creo allora la classe astratta Facade con i campi e metodi che hanno in comune e che erediteranno poi le sottoclassi

public abstract class Facade {

	Cities cities; // lista delle citt�
	TravelPackages travelPackages; // lista dei pacchetti di viaggio
	// creo queste liste   

	public Facade(Cities cities, TravelPackages travelPackages) {
		this.cities = cities;
		this.travelPackages = travelPackages;
	}

	public CityObject findCity(String code) {
		return cities.findCity(code); // cerco la citt� nella lista delle citt� tramite il codice
	}

	public String printCitiesList() {
		return cities.printCities(); // stampo la lista delle citt�
	}
}
