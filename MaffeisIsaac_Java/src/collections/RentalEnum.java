package collections;

// Mezzo da affittare durante la vacanza comprensivo di costo

public enum RentalEnum {

	Car(150), eBike(90), jetSky(100), No(0);

	private int price;

	RentalEnum(int i) {
		this.price = i;
	}

	int getPrice() {
		return price;
	}

}
