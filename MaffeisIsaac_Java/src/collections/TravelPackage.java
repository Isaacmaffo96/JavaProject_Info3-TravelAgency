package collections;

// un pacchetto di viaggio comprende la città di partenza, la città di arrivo, il giorno di partenza, il giorno di arrivo, il trasporto e il prezzo

public class TravelPackage implements Comparable<TravelPackage> {

	private CityObject departureCity;
	private CityObject destinationCity;
	private Day fromDay;
	private Day toDay;
	private String transport;
	private float price;

	public TravelPackage(CityObject departureCity, CityObject destinationCity, Day fromDay, Day toDay, String transport,
			float price) {
		this.departureCity = departureCity;
		this.destinationCity = destinationCity;
		this.fromDay = fromDay;
		this.toDay = toDay;
		this.transport = transport;
		this.price = price;
	}

	CityObject getDepartureCity() {
		return departureCity;
	}

	CityObject getDestinationCity() {
		return destinationCity;
	}

	Day getFromDay() {
		return fromDay;
	}

	Day getToDay() {
		return toDay;
	}

	String getTransport() {
		return transport;
	}

	float getPrice() {
		return price;
	}

	@Override
	public int compareTo(TravelPackage o) { // in base al prezzo di ciascun pacchetto
		if (this.price < o.price)
			return -1;
		else if (this.price > o.price)
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() { // 4 condizioni solo per essere più corretti grammaticalmente
		if (!fromDay.equals(Day.SUNDAY) && !toDay.equals(Day.SUNDAY))
			return "Da " + departureCity.getName() + " a " + destinationCity.getName() + " dal " + fromDay.label
					+ " al " + toDay.label + " con " + transport + ", costo = " + price + "€.";
		else if (!fromDay.equals(Day.SUNDAY) && toDay.equals(Day.SUNDAY))
			return "Da " + departureCity.getName() + " a " + destinationCity.getName() + " dal " + fromDay.label
					+ " alla " + toDay.label + " con " + transport + ", costo = " + price + "€.";
		else if (fromDay.equals(Day.SUNDAY) && toDay.equals(Day.SUNDAY))
			return "Da " + departureCity.getName() + " a " + destinationCity.getName() + " dalla " + fromDay.label
					+ " alla " + toDay.label + " con " + transport + ", costo = " + price + "€.";
		else
			return "Da " + departureCity.getName() + " a " + destinationCity.getName() + " dalla " + fromDay.label
					+ " al " + toDay.label + " con " + transport + ", costo = " + price + "€.";
	}

}
