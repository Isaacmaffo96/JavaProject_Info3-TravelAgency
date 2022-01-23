package collections;

import exceptions.ReservationNotValidException;
import user.Person;
import user.Student;

// Prenotazione, viene creata dopo che l'utente visiona i pacchetti e ne sceglie uno
// Contiene le informazioni della persona che la ha effettuata, il pacchetto che ha scelto, la guida,
// il mezzo affittato (se lo si ha affittato) e il costo totale
// le prenotazioni vengono create con un numero progressivo e immagazzinate in una lista di prenotazioni

public class Reservation {

	private static int numberOfReservations = 0;
	private static Reservations reservations = Reservations.instanceReservationsList(); // istanza della lista delle
																						// prenotazioni
	private TravelPackage travelPackage;  // pacchetto selezionato
	private Person person;
	private float price;
	private int numberOfReservation;
	private String guide;
	private RentalEnum rent;
	private static Rental rentalClass = new Rental();

	public Reservation(TravelPackage travelPackage, Person person) throws ReservationNotValidException {
		if (travelPackage == null)
			throw new ReservationNotValidException("Il pacchetto selezionato è inesistente");
		this.travelPackage = travelPackage;
		this.person = person;
		if (person instanceof Student) // sconto del 20% se studente
			this.price = (float) (travelPackage.getPrice() * 0.8);
		else
			this.price = travelPackage.getPrice();
		this.numberOfReservation = ++numberOfReservations;
		this.guide = travelPackage.getDestinationCity().printGuide();
		this.rent = RentalEnum.No; // di default non è selezionato nessun affitto
		reservations.addReservation(this);
	}

	public String getGuide() {
		return guide;
	}

	public String rental() {
		this.rent = travelPackage.getDestinationCity().accept(rentalClass);
		this.price = price + rent.getPrice();
		return rent.name();
	}

	public String rentalInfo() {
		if (travelPackage.getDestinationCity() instanceof City)
			return "Affitto di una macchina al costo di " + RentalEnum.Car.getPrice() + "€";
		else if (travelPackage.getDestinationCity() instanceof SeaCity)
			return "Affitto di una moto d'acqua al costo di " + RentalEnum.jetSky.getPrice() + "€";
		else if (travelPackage.getDestinationCity() instanceof MountainCity)
			return "Affitto di una e-bike al costo di " + RentalEnum.eBike.getPrice() + "€";
		return null;
	}

	@Override
	public String toString() {
		return "Prenotazione nr.  " + numberOfReservation + "\nNome: " + person.getName() + "\tCognome: "
				+ person.getSurname() + "\tCodice Fiscale: " + person.getFiscalCode() + "\nIndirizzo: "
				+ person.getAddress() + "\nPartenza da " + travelPackage.getDepartureCity().getCode() + " il "
				+ travelPackage.getFromDay().label + "\nDestinazione " + travelPackage.getDestinationCity().getCode()
				+ " fino al " + travelPackage.getToDay().label + "\nMezzo di trasporto: " + travelPackage.getTransport()
				+ "\tNoleggio: " + rent.name() + " \nCosto complessivo " + price + "€.";
	}

}
