package collections;

// Servendomi del pattern visitor ne implemento l'interfaccia e creo un metodo che restituisce un tipo enumerativo 
// diverso in base all'oggeto che chiama la classe, che rappresenta la prenotazione di un mezzo (Macchina,Moto d'acqua oppure eBike)

public class Rental implements Visitor<RentalEnum>{

	@Override
	public RentalEnum visit(City c) {
		return RentalEnum.Car;
	}

	@Override
	public RentalEnum visit(SeaCity s) {
		return RentalEnum.jetSky;
	}

	@Override
	public RentalEnum visit(MountainCity m) {
		return RentalEnum.eBike;
	}

}
