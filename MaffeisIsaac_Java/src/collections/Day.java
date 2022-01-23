package collections;

// Giorni della settimana

public enum Day {
	MONDAY("Luned�"),
	TUESDAY("Marted�"),
	WEDNESDAY("Mercoled�"),
	THURSDAY("Gioved�"),
	FRIDAY("Venerd�"),
	SATURDAY("Sabato"),
	SUNDAY("Domenica");
	
	final String label;
	
	private Day(String label) {
		this.label=label;
	}

}
