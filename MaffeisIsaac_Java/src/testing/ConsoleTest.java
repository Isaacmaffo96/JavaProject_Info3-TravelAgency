package testing;

import java.sql.Date;
import java.util.Scanner;

import collections.Cities;
import collections.UserFacade;
import exceptions.CityNotValidException;
import exceptions.FieldNotValidException;
import exceptions.ReservationNotValidException;
import user.Person;
import user.UserManagment;

public class ConsoleTest {

	static void addConsoleTest(Cities cities, UserFacade uf) {
		Scanner in = new Scanner(System.in);
		/*
		 * System.out.
		 * println("Benvenuto nella nostra agenzia di viaggi, ci fornisca i suoi dati per iniziare"
		 * ); System.out.println("Sei uno studente? (Si/No)"); Person p2 = null; String
		 * st = in.nextLine().strip(); if(st.equals("Si") || st.equals("Sì") ||
		 * st.equals("si") || st.equals("sì")) { System.out.
		 * println("Nome, Cognome , Data di Nascita(YYYY,MM,DD), Codice Fiscale, Indirizzo, Nome Istituto "
		 * ); String s[] = in.nextLine().strip().split(","); p2 = new Student(s[0],
		 * s[1], new
		 * Date(Integer.parseInt(s[2]),Integer.parseInt(s[3]),Integer.parseInt(s[4])),
		 * s[5], s[6],s[7]); } else { System.out.
		 * println("Nome, Cognome , Data di Nascita(YYYY,MM,DD), Codice Fiscale, Indirizzo "
		 * ); String s[] = in.nextLine().strip().split(","); p2 = new Person(s[0], s[1],
		 * new
		 * Date(Integer.parseInt(s[2]),Integer.parseInt(s[3]),Integer.parseInt(s[4])),
		 * s[5], s[6]); } UserManagment um2 = new UserManagment(p2, uf);
		 */

		// per semplicità si può usare già una persona creata
		Person p2 = new Person("Mario", "Rossi", new Date(1996, 05, 10), "RSSMRA88T22D245B",
				"Via roma 7 Dalmine 24044 Bg");
		UserManagment um2 = new UserManagment(p2, uf);

		boolean processoCorrect = false;
		do {
			System.out.println("Dove vuole viaggiare? Mare, Montagna oppure in Città? ");
			boolean destinationCorrect = false;
			do {
				try {
					um2.setDestination(in.nextLine()); // imposto la destinazione (mare,montagna o città)
					destinationCorrect = true;
				} catch (FieldNotValidException e) { // eccezione se sbaglio a scrivere mare,montagna o città (va bene
														// sia in italiano che in inglese)
					System.out.println(
							e.getMessage() + "\nDigidare nuovamente dove vuole viaggiare: Mare, Montagna o Città? ");
				}
			} while (!destinationCorrect);
			System.out.println("In che giorno della settimana vuole partire? ");
			boolean FromDayCorrect = false;
			do {
				try {
					um2.setFromDay(in.nextLine()); // imposto da che giorno partire
					FromDayCorrect = true;
				} catch (FieldNotValidException e) { // eccezione se sbaglio a scrivere il giorno della settimana (va
														// bene sia in italiano che in inglese)
					System.out.println(e.getMessage()
							+ "\nDigitare nuovamente in che giorno della settimana vuole partire: Lunedì, Martedì, Mercoledì, Giovedì, Venerdì, Sabato o Domenica? ");
				}
			} while (!FromDayCorrect);
			System.out.println("E in quale vuole tornare? ");
			boolean toDayCorrect = false;
			do {
				try {
					um2.setToDay(in.nextLine()); // imposto il giorno in cui tornare
					toDayCorrect = true;
				} catch (FieldNotValidException e) { // eccezione se sbaglio a scrivere il giorno della settimana (va
														// bene sia in italiano che in inglese)
					System.out.println(e.getMessage()
							+ "\nDigitare nuovamente in che giorno della settimana vuole tornare: Lunedì, Martedì, Mercoledì, Giovedì, Venerdì, Sabato o Domenica? ");
				}
			} while (!toDayCorrect);
			System.out.println("Per finire, da quale città vuole partire? (Codice)");
			boolean departureCityCorrect = false;
			do {
				try {
					String s1 = in.nextLine(); // esc per uscire, nel caso non ci siano pacchetti vacanza dalla città
												// selezionata
					if (s1.equals("esc") || s1.equals("Esc") || s1.equals("ESC")) {
						in.close();
						return;
					}
					um2.setDepartureCity(s1); // imposto da che città partire
					departureCityCorrect = true;
				} catch (FieldNotValidException e) { // eccezione nel caso digito un codice non valido (con più o meno
														// di 3 caratteri)
					System.out.println(
							e.getMessage() + "\nDigitare nuovamente da quale città vuole partire tra le seguenti:");
					System.out.println(um2.printCitiesList()); // stampo la lista delle città per visionare i codici
				} catch (CityNotValidException e) { // ecezione nel caso non esiste la città con il codice selezionato
					System.out.println(e.getMessage()
							+ "\nDigitare esc per uscire, oppure digitare un'altra città tra le seguenti");
					System.out.println(um2.printCitiesList()); // stampo la lista delle città per visionare i codici
				}
			} while (!departureCityCorrect);
			try {
				um2.generateSolutions(); // genero una lista di soluzioni in base ai vincoli appena scelti
				System.out.println("Soluzioni trovate:\n" + um2.displaySolutions()
						+ "\nSelezionare il numero del pacchetto desiderato oppure 0 per non selezionare niente e riprovare, esc per uscire : ");
				boolean solutionCorrect = false;
				do { // vado a scegliere la soluzione desiderata
					try {
						String s2 = in.nextLine();
						if (s2.equals("esc") || s2.equals("Esc") || s2.equals("ESC")) {
							in.close();
							return; // digito esc per uscire
						}
						int choise = Integer.parseInt(s2.strip());
						if (choise == 0) { // digito 0 per riprovare il procedimento
							processoCorrect = false;
							break; // ricomincio da capo
						}
						um2.chooseSolution(choise - 1); // scelgo la soluzione selezionata e prenoto
						System.out.println("Vuoi affittare un mezzo? (Sì/No)\n" + um2.rentalInfo()); // affitto di un
																										// mezzo
						String resp = in.nextLine();
						if (resp.equals("si") || resp.equals("sì") || resp.equals("Si") || resp.equals("Sì")
								|| resp.equals("SI") || resp.equals("SÌ"))
							um2.rental(); // aggiungo alla prenotazione l'affitto di un mezzo, aggiornando il costo
						System.out.println(um2.printReservation()); // stampo la prenotazione
						System.out.println("Vuoi stampare la guida? (Sì/No)"); // guida (gratis)
						String response = in.nextLine();
						if (!response.equals("No") && !response.equals("NO") && !response.equals("no"))
							System.out.println(um2.printGuide()); // stampo la guida
						solutionCorrect = true;
						processoCorrect = true;
					} catch (NumberFormatException | ReservationNotValidException e) { // eccezione se digito un numero
																						// di pacchetto non presente in
																						// lista
						System.out.println(e.getMessage() + "\nSelezionare nuovamente il pacchetto desiderato");
					}
				} while (!solutionCorrect);
			} catch (ReservationNotValidException e1) { // eccezione se la prenotazione non va a buon fine (non trovo
														// soluzioni o non voglio procedere con la prenotazione)
				System.out.println(e1.getMessage() + "\nVuole riprovare? digitare esc per uscire.");
				processoCorrect = false;
				String s3 = in.nextLine(); // esc esco altrimenti riprovo da capo
				if (s3.equals("esc") || s3.equals("Esc") || s3.equals("ESC"))
					break;
			}
		} while (!processoCorrect);
		in.close();
	}

}
