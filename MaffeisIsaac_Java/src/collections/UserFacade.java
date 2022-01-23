package collections;

import java.util.ArrayList;

import user.Constraints;

//sottoclasse della superclasse Facade
//permette all'utente di interagire con il programma senza operare direttamente sugli oggetti
// permette di aggiungere pacchetti viaggio alla lista delle soluzioni proposta
// per fare questo filtra la lista dei pacchetti con i vincoli dell'utente

public class UserFacade extends Facade {

	public UserFacade(Cities cities, TravelPackages travelPackages) {
		super(cities, travelPackages);
	}

	public ArrayList<? extends CityObject> populateSolutions(Constraints constraints,
			ArrayList<TravelPackage> solutions) {
		for (TravelPackage travelPackage : travelPackages.getTravelPackagesList()) {
			if (packageCheck(travelPackage, constraints, solutions)) {
				solutions.add(travelPackage);
				support.QuickSort.quicksort(solutions); // ordino in base prezzo
			}
		}
		return null;
	}

	// controllo se il pacchetto di viaggio della lista combacia con i vincoli dell'utente
	private boolean packageCheck(TravelPackage travelPackage, Constraints constraints,
			ArrayList<TravelPackage> solutions) {
		if (destinationCheck(travelPackage, constraints, solutions)) {
			if (travelPackage.getFromDay().equals(constraints.getFromDay()))
				if (travelPackage.getToDay().equals(constraints.getToDay()))
					if (travelPackage.getDepartureCity().equals(constraints.getDepartureCity()))
						return true;
		}
		return false;
	}

	// controllo la destinazione in base all'istanza ereditaria dell'oggeto CityObject
	private boolean destinationCheck(TravelPackage travelPackage, Constraints constraints,
			ArrayList<TravelPackage> solutions) {
		return ((travelPackage.getDestinationCity() instanceof City
				&& constraints.getDestination().equals(Destination.CITY))
				|| (travelPackage.getDestinationCity() instanceof SeaCity
						&& constraints.getDestination().equals(Destination.SEA))
				|| (travelPackage.getDestinationCity() instanceof MountainCity
						&& constraints.getDestination().equals(Destination.MOUNTAIN)));
	}

}
