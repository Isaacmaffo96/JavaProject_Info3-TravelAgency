package collections;

// Destinazioni 

public enum Destination {

	CITY("Citt�"), SEA("Mare"), MOUNTAIN("Montagna");

	String label;

	private Destination(String label) {
		this.label = label;
	}

}
