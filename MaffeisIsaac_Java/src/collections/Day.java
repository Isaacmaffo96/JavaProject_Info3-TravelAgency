package collections;

// Giorni della settimana

public enum Day {
	MONDAY("Lunedì"),
	TUESDAY("Martedì"),
	WEDNESDAY("Mercoledì"),
	THURSDAY("Giovedì"),
	FRIDAY("Venerdì"),
	SATURDAY("Sabato"),
	SUNDAY("Domenica");
	
	final String label;
	
	private Day(String label) {
		this.label=label;
	}

}
