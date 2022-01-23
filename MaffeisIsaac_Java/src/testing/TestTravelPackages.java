package testing;

import java.util.zip.DataFormatException;

import exceptions.CityNotValidException;
import maintenance.Maintainer;

class TestTravelPackages {

	static void addTestData(Maintainer p) {
		// Formato della stringa: Codice città di partenza, Codice città di arrivo, Giorno
		// Partenza, Giorno Arrivo, Trasporto, prezzo
		try {
			// Da BGY
			p.addPackage("BGY,MXP,Saturday,Sunday,Pullman,40");
			p.addPackage("BGY,FLR,Monday,Wednesday,Treno,200");
			p.addPackage("BGY,AHO,Friday,Sunday,Aereo,450");
			p.addPackage("BGY,PMO,Saturday,Sunday,Aereo,350");
			p.addPackage("BGY,BRI,Sunday,Tuesday,Aereo,390");
			p.addPackage("BGY,BRI,Friday,Sunday,Aereo,500");
			p.addPackage("BGY,BRI,Saturday,Sunday,Aereo,340");
			p.addPackage("BGY,PSA,Wednesday,Friday,Aereo,400");
			p.addPackage("BGY,PSA,Tuesday,Thursday,Treno,200");
			p.addPackage("BGY,CAG,Monday,Friday,Aereo,470");
			p.addPackage("BGY,TRN,Friday,Sunday,Treno,200");
			p.addPackage("BGY,MXP,Monday,Tuesday,Treno,50");
			p.addPackage("BGY,AHO,Monday,Sunday,Aereo,700");
			p.addPackage("BGY,TRN,Monday,Saturday,Treno,390");
			p.addPackage("BGY,PSA,Thursday,Saturday,Pullman,290");
			p.addPackage("BGY,TPS,Friday,Sunday,Aereo,580");
			p.addPackage("BGY,GOA,Friday,Sunday,Pullman,250");
			p.addPackage("BGY,CTA,Saturday,Saturday,Aereo,1100");
			p.addPackage("BGY,AHO,Saturday,Saturday,Aereo,990");
			p.addPackage("BGY,BRI,Saturday,Saturday,Aereo,1400");
			p.addPackage("BGY,FCO,Saturday,Saturday,Treno,670");
			p.addPackage("BGY,NAP,Saturday,Saturday,Treno,720");
			p.addPackage("BGY,TRN,Saturday,Saturday,Pullman,490");
			p.addPackage("BGY,TRN,Saturday,Saturday,Pullman,490");
			p.addPackage("BGY,TRT,Friday,Sunday,Pullman,250");
			p.addPackage("BGY,TRT,Friday,Sunday,Treno,390");
			p.addPackage("BGY,TRT,Monday,Friday,Pullman,400");
			p.addPackage("BGY,BLZ,Saturday,Sunday,Pullman,190");
			p.addPackage("BGY,BLZ,Saturday,Sunday,Treno,220");
			p.addPackage("BGY,BLZ,Wednesday,Saturday,Pullman,350");
			p.addPackage("BGY,BLZ,Friday,Sunday,Pullman,290");
			p.addPackage("BGY,BLZ,Friday,Sunday,Treno,320");
			p.addPackage("BGY,CDA,Friday,Sunday,Pullman,700");
			p.addPackage("BGY,CDA,Saturday,Saturday,Pullman,2400");
			p.addPackage("BGY,CDA,Monday,Sunday,Pullman,2100");
			p.addPackage("BGY,SON,Friday,Saturday,Pullman,190");
			p.addPackage("BGY,SON,Friday,Sunday,Pullman,220");
			p.addPackage("BGY,CMY,Monday,Sunday,Pullman,2600");
			p.addPackage("BGY,CMY,Friday,Sunday,Pullman,900");
			p.addPackage("BGY,CMY,Sunday,Sunday,Pullman,3000");
			p.addPackage("BGY,BRD,Friday,Sunday,Pullman,390");
			p.addPackage("BGY,BRD,Saturday,Sunday,Pullman,310");


		} catch (CityNotValidException e) {
			e.printStackTrace();
		} catch (DataFormatException e) {
			e.printStackTrace();
		}
	}

}
