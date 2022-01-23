package collections;

// Servendomi del pattern visitor ne implemento l'interfaccia e creo un metodo che restituisce una stringa contenente
// una guida d'auito per il viaggio, che si differenzia in base se città destinazione è nell'entroterra, al mare oppure in montagna.

public class GenerateGuides implements Visitor<String> {

	@Override
	public String visit(City c) {
		return "5 consigli per visitare una città senza stancarsi troppo:\r\n"
				+ "5) Informati!\r\nSe vuoi ottimizzare la tua permanenza e trascorrere la tua vacanza senza inutili complicazioni, forse dovresti dedicare un po’ di tempo alla pianificazione e alla ricerca di informazioni che ti potrebbero essere utili.\n"
				+ "4) Organizzati!\r\nprepara un accurato programma di visita al quale attenerti. Lasciare tutto all’improvvisazione, infatti, non è il metodo più indicato per chi non ha energie e tempo da perdere.\n"
				+ "3) Usa i mezzi pubblici!\r\nDifficile girare una grande città a piedi: se non vuoi stancarti e non vuoi spendere un patrimonio, impara a spostarti proprio come farebbero gli abitanti del luogo.\n"
				+ "2) Ritaglia del tempo per te stesso!\r\nImpara a costruire le tappe del tuo viaggio in accordo con i tuoi ritmi, dedicando il tuo tempo anche a fermarti nei luoghi che più ti piacciono, in contemplazione.\n"
				+ "1) Impara a scegliere!\r\nTempo ed energie sono risorse limitate: questo significa che, anche in viaggio, dovrai essere pronto a scegliere a cosa dedicarli. Seleziona alcune mete per te importanti e mettile in cima alla lista delle tue priorità. In questo modo, anche se non riuscirai a completare tutto il tuo programma di viaggio, potrai riuscire comunque a visitare senza fretta né fatica inutile le tue tappe del cuore.";
	}

	@Override
	public String visit(SeaCity s) {
		return "5 cose da fare al mare almeno una volta nella vita\r\n"
				+ "1) per i più avventurosi, la spiaggia è il posto giusto per cimentarsi in nuove attività sportive come corsi ed escursioni in kayak\r\n"
				+ "2) perché non tornare bambini con i castelli di sabbia? tornare indietro nel tempo costruendo castelli più semplici o cimentandoti in sculture più ardite. Anche le gare con i vicini di ombrellone hanno il loro fascino e si concludono nel modo più divertente in assoluto: saltandoci sopra in compagnia\r\n"
				+ "3) l’alba o il tramonto sono momenti perfetti per allontanare l’ansia e sconfiggere lo stress rilassandosi con un po’ di yoga e di meditazione in spiaggia, sulla riva del mare, quando non è sommersa di ombrelloni, regalando così a corpo e spirito una sensazione di benessere impareggiabile\r\n"
				+ "4) un’altra attività che riscuote sempre molto successo è esplorare il mare in pedalò, scegliendo o la versione classica o quelle più divertenti a forma di cigno o con lo scivolo per godersi il panorama lontano dallo stress della spiaggia affollata\r\n"
				+ "5) che cosa c’è di più bello che scoprire un luogo attraverso i suoi piatti tipici? Ogni luogo ha le sue ricette segrete ed è giusto assaporarle\r\n";
	}

	@Override
	public String visit(MountainCity m) {
		return "Prima volta in Montagna: 5 cose da sapere\r\n"
				+ "1) In montagna il tempo cambia velocemente ed è classico il breve acquazzone di fine pomeriggio dopo una giornata di sole\r\n"
				+ "2) A causa del punto 1 serve portare una valigia ben fornita di abiti di ogni tipo. Le cose da avere sempre con se’ sono un impermeabile tipo K-Way, uno strato caldo (es. un pile), un cappellino, e abiti anche più pesanti se pensate di andare in alta quota e/o sui ghiacciai. Indispensabili anche uno zaino e alcuni oggetti. Portate abiti casual, meglio se tecnici.\r\n"
				+ "3) La scarpa da montagna è più che importante, è la base per una vacanza estiva serena e piacevole! Le scarpe da ginnastica, da footing, da basket, usatele giusto in paese: sui sentieri servono le scarpe apposite.\r\n"
				+ "4) Per il turista normale il vero riferimento per le escursioni deve essere la carta dei sentieri estivi che si trova nell’Ufficio del Turismo. Lasciate perdere gps, mappe dettagliate, guide complicate: l’opuscolo dell’APT è più che sufficiente per organizzare le escursioni sui sentieri segnalati. Vi troverete le indicazioni della difficoltà e i tempi di percorrenza\r\n"
				+ "5) Alternative ai sentieri di montagna ci sono e sono godibili. A livello di sport, la scelta spazia dalla mountain bike al cavallo, dal golf alla piscina. Per i più sedentari, escursioni con impianti di risalita, eventi gastronomici e ovviamente il “baiting” ovvero starsene in baita a prendere il sole, sorseggiando una buona birra!\r\n";

	}

}
