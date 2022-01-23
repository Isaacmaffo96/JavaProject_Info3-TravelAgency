package collections;

import java.util.ArrayList;

//Classe che contiene la lista dei pacchetti, la creo usando il pattern singleton poichè ne voglio solo una per tutto il programma

public class TravelPackages {

	private static TravelPackages travelPackagesInstance = null;
	private ArrayList<TravelPackage> travelPackagesList;

	private TravelPackages() {
		this.travelPackagesList = new ArrayList<>();
	}
	
	// creo la lista dei pacchetti come singleton perchè ne devo avere solo una
	public static TravelPackages ceateTravelPackages() {
		if (travelPackagesInstance == null)
			travelPackagesInstance = new TravelPackages();
		return travelPackagesInstance;
	}

	void addTravelPackage(TravelPackage t)  {
		travelPackagesList.add(t);
	}

	ArrayList<TravelPackage> getTravelPackagesList() {
		return travelPackagesList;
	}
	
	

}