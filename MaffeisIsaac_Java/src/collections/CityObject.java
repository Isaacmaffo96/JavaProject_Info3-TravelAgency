package collections;

// classe astratta, nessun oggetto deve essere di questa classe, ma mi fornisce campi e metodi da implementare nelle classi figlie
// implementa l'interfaccia Comparable per comparare li città e disporle in ordine alfabetico in base al codice
// e Visitable per seguire il pattern visitor

public abstract class CityObject implements Comparable<CityObject> , Visitable{

	private String code;
	private String name;
	private String region;
	private String country;
	static GenerateGuides generateGuides = new GenerateGuides();
	
	public CityObject(String code, String name, String region, String country) {
		this.code = code.toUpperCase();
		this.name = name;
		this.region = region;
		this.country = country;
	}
	
	String getCode() {
		return code;
	}
	
	String getName() {
		return name;
	}
	
	String printGuide() {
		return null;
	}
	
	@Override
	public int compareTo(CityObject o) {
		return this.code.compareTo(o.code);
	}

	@Override
	public String toString() {
		return code + ", " + name + ", " + region + ", " + country + ".";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CityObject)
			return equals((CityObject) obj);
		return super.equals(obj);
	}
	// due città sono uguali se hanno lo stesso codice
	public boolean equals(CityObject c) {
		if (this.code.equals(c.code))
			return true;
		return false;
	}

}
