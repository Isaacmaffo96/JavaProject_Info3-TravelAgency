package collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

// Classe che contiene la lista delle città, la creo usando il pattern singleton poichè ne voglio solo una per tutto il programma
// La lista delle città la prendo dal file Cities.txt e poi vado a popolare la TreeMap (Mappa con ordinamento sulle chiavi)
// come chiave della mappa uso il codice della città (3 caratteri) biunivoco per ogni città 
// voglio la mappa ordinata sulle chiavi poichè posso presentarla al cliente in modo più chiaro

public class Cities {

	private static Cities citiesInstance = null;
	private TreeMap<String, CityObject> cities; // Mappa con ordinamento sulle chiavi
	private final String file = "src\\collections\\Cities.txt";
	// Formato del file di testo: CODE, City Name, Region, Country,
	// Enum_Destination. (eventuali commenti)

	private Cities() throws IOException {
		this.cities = new TreeMap<>();
		addCities();
	}

// creo la lista della città come singleton perchè ne devo avere solo una
	public static Cities createCities() throws IOException {
		if (citiesInstance == null)
			citiesInstance = new Cities();
		return citiesInstance;
	}

	void addCity(CityObject c) {
		cities.put(c.getCode(), c);
	}

	CityObject findCity(String code) {
		return cities.get(code);
	}

	String printCities() {
		return cities.toString();
	}
// pattern file di testo : Codice, Nome Città, Regione, Nazione, Destination (enum). 
// esempio: BGY, Bergamo, Lombardia, Italy, city.
	private void addCities() throws IOException { // aggiungo la lista delle città dal file
		FileReader fr = new FileReader(file);
		BufferedReader bf = new BufferedReader(fr);
		String line = null;
		while ((line = bf.readLine()) != null) {
			String[] str = line.strip().split(",");
			String dst = (str[4].split("\\."))[0].strip().toUpperCase(); 
			Destination key = Destination.valueOf(dst); // valori possibili di Destination: CITY,SEA,MOUNTAIN
			switch (key) {
			case CITY: {
				City city = new City(str[0].strip(), str[1].strip(), str[2].strip(), str[3].strip());
				cities.put(city.getCode(), city);
				break;
			}
			case SEA: {
				SeaCity city = new SeaCity(str[0].strip(), str[1].strip(), str[2].strip(), str[3].strip());
				cities.put(city.getCode(), city);
				break;
			}
			case MOUNTAIN: {
				MountainCity city = new MountainCity(str[0].strip(), str[1].strip(), str[2].strip(), str[3].strip());
				cities.put(city.getCode(), city);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
		}
		bf.close();
		fr.close();
	}

}
