package testing;

import java.io.IOException;
import java.util.Date;

import collections.Cities;
import collections.MaintFacade;
import collections.TravelPackages;
import collections.UserFacade;
import exceptions.CityNotValidException;
import exceptions.FieldNotValidException;
import exceptions.ReservationNotValidException;
import maintenance.Maintainer;
import user.Person;
import user.Student;
import user.UserManagment;

public class TestMain {

	public static void main(String[] args) throws IOException {

		// Avviamento, carico i dati
		Cities cities = Cities.createCities();
		TravelPackages travelPackages = TravelPackages.ceateTravelPackages();

		// imposto i Facade
		MaintFacade mf = new MaintFacade(cities, travelPackages);
		UserFacade uf = new UserFacade(cities, travelPackages);

		// creo manutentore
		Maintainer maintainer = new Maintainer("1041473", mf);
		TestTravelPackages.addTestData(maintainer);

//		// Visionare le Liste
//		System.out.println(cities.cities.toString());
//		System.out.println(travelPackages.travelPackagesList.toString());

		// creo Utente
		Person p1 = new Person("Marco", "Verdi", new Date(1992, 07, 12), "VRDMRC92L12A794U",
				"Via G.Matteotti  24 Seriate Bg");
		UserManagment um1 = new UserManagment(p1, uf);

		// creo Studente
		Person s1 = new Student("Andrea", "Bianchi", new Date(1999, 02, 25), "BNCNDR99B25A794F",
				"Via Repubblica  2 Curno Bg", "UniBg");
		UserManagment um2 = new UserManagment(s1, uf);

		// Svolgimento
		// Test prestabilito
		try {
			um1.setDestination("Sea"); // imposto la destinazione (mare,città,montagna) (in italiano o in inglese)
			um1.setFromDay("Friday"); // imposto il giorno della settimana in cui partire (in italiano o in inglese)
			um1.setToDay("Sunday"); // imposto il giorno della settimana in cui tornare (in italiano o in inglese)
			um1.setDepartureCity("Bgy"); // imposto la città di partenza (codice di 3 carattri)
			System.out.println("Destinazione: Mare, dal Venerdì alla Domenica, partenza da Bgy.");
			um1.generateSolutions(); // creo la lista delle soluzioni in base ai vincoli
			System.out.println(um1.displaySolutions()); // mostro le soluzioni trovate e le propongo al cliente
			um1.chooseSolution((2) - 1); // scelgo la soluzione nr. 2 (indice mostrato nella lista soluzioni)
			System.out.println("Hai scelto l'opzione 2.");
			um1.rental(); // affitto un mezzo (moto d'acqua dato che andiamo al mare)
			System.out.println(um1.printReservation()); // stampo la prenotazione con il prezzo aggiornato con la moto
														// d'acqua
			System.out.println(um1.printGuide()); // stampo la guida (gratuitamente)
		} catch (FieldNotValidException e) { // gestisco le varie eccezioni
			e.printStackTrace();
		} catch (CityNotValidException e) {
			e.printStackTrace();
		} catch (ReservationNotValidException e) {
			e.printStackTrace();
		}

		// studente (20% di sconto)
		try {
			um2.setDestination("Mountain");// imposto la destinazione (mare,città,montagna) (in italiano o in inglese)
			um2.setFromDay("Friday");// imposto il giorno della settimana in cui partire (in italiano o in inglese)
			um2.setToDay("Sunday");// imposto il giorno della settimana in cui tornare (in italiano o in inglese)
			um2.setDepartureCity("Bgy");// imposto la città di partenza (codice di 3 carattri)
			System.out.println("Destinazione: Montagna, dal Venerdì alla Domenica, partenza da Bgy.");
			um2.generateSolutions();// creo la lista delle soluzioni in base ai vincoli
			System.out.println(um2.displaySolutions());// mostro le soluzioni trovate e le propongo al cliente
			um2.chooseSolution((4) - 1); // scelgo la soluzione nr. 1 (indice mostrato nella lista soluzioni)
			System.out.println("Hai scelto l'opzione 4.");
//			um2.rental(); // affitto un mezzo (sconto non applicabile sull'affitto)
			System.out.println(um2.printReservation()); // stampo la prenotazione
//			System.out.println(um2.printGuide()); // stampo la guida (gratuitamente)
		} catch (FieldNotValidException e) { // gestisco eventuali eccezioni
			e.printStackTrace();
		} catch (CityNotValidException e) {
			e.printStackTrace();
		} catch (ReservationNotValidException e) {
			e.printStackTrace();
		}

//		// Test eccezioni
//		
//		Person p3 = new Person("Alberto", "Neri", new Date(1999, 8, 14), "NRELRT99M14H501G",
//				"Via della Libertà  5 Roma");
//		UserManagment um3 = new UserManagment(p1, uf);
//		
//		// TEST1: Campo non corretto 
//		try {
//			um3.setDestination("Usa"); // imposto la destinazione (mare,città,montagna) (in italiano o in inglese)
//		} catch (FieldNotValidException e) {  // inserisco un valore sbagliato nel campo
//			e.printStackTrace(); // stampo il messaggio di errore e vado avanti col test
//		}
//		
//		// TEST2: Inserisco una città non contenuta nel programma
//		try {
//			um3.setDestination("City"); // imposto la destinazione (mare,città,montagna) (in italiano o in inglese)
//			um3.setFromDay("Monday"); // imposto il giorno della settimana in cui partire (in italiano o in inglese)
//			um3.setToDay("Friday"); // imposto il giorno della settimana in cui tornare (in italiano o in inglese)
//			um3.setDepartureCity("BRC"); // imposto la città di partenza (codice di 3 carattri)
//		} catch (FieldNotValidException e) { 
//			e.printStackTrace();
//		} catch (CityNotValidException e) {  // città non valida (Sbagliata oppure non presente nel programma)
//			e.printStackTrace();
//		}
//
//		// TEST3: Scelgo dei vincoli che portano a non avere soluzioni
//		try {
//			um3.setDestination("City"); // imposto la destinazione (mare,città,montagna) (in italiano o in inglese)
//			um3.setFromDay("Monday"); // imposto il giorno della settimana in cui partire (in italiano o in inglese)
//			um3.setToDay("Friday"); // imposto il giorno della settimana in cui tornare (in italiano o in inglese)
//			um3.setDepartureCity("FCO"); // imposto la città di partenza (codice di 3 carattri)
//			System.out.println("Destinazione: Città, dal Lunedì al Venerdì, partenza da FCO.");
//			um3.generateSolutions(); // creo la lista delle soluzioni in base ai vincoli
//		} catch (FieldNotValidException e) { 
//			e.printStackTrace();
//		} catch (CityNotValidException e) {
//			e.printStackTrace();
//		} catch (ReservationNotValidException e) { // genero una eccezione poichè non trovo nessuna soluzione
//			e.printStackTrace(); // stampo il messaggio di errore e vado avanti col test
//		}

		// Test con Input da console interattivo, con gestione delle eccezioni
		ConsoleTest.addConsoleTest(cities, uf);

		// Lista delle prenotazioni effettuate
		System.out.println("Lista delle prenotazioni effettuate\n" + maintainer.printReservationList());
	}
}
