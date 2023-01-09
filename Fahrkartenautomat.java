import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		
		
		// Kartenauswahl (ersetzt Geldbetrag eingeben)
		begruessung();
		
		zuZahlenderBetrag = fahrkartenbestellungErfassung(tastatur);

		// Geldeinwurf
		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);

		// Fahrscheinausgabe
		fahrscheinAusgabe();

		// Rückgeldberechnung und -ausgabe
		rueckgeldAusgeben(zuZahlenderBetrag, eingezahlterGesamtbetrag);

		tastatur.close();
	}
	
	public static void begruessung() {
		
		System.out.println("Herzlich Willkommen!\n");
		
		System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:"); // neu
		System.out.println("Kurzstrecke AB [2,00 EUR] (1)"); // neu
		System.out.println("Einzelfahrschein AB [3,00 EUR] (2)"); // neu
		System.out.println("Tageskarte Regeltarif AB [8,80 EUR] (3)"); // neu
		System.out.println("4-Fahrten-Karte AB [9,40 EUR] (4)\n"); // neu
		
	}
	
	public static double fahrkartenbestellungErfassung(Scanner tastatur) {
		
		double zuZahlenderBetrag;
		double ticketPreis = 0; // verändert
		int anzahlTickets = 0;
		boolean korrekteEingabe = false; // neu
		int auswahlTickets = 0; // neu
		
		while (korrekteEingabe == false) { // neu
			System.out.print("Ihre Wahl: "); // neu
			auswahlTickets = tastatur.nextInt(); // neu
			if (auswahlTickets >= 1 && auswahlTickets <= 4) { // neu
				korrekteEingabe = true; // neu
			} // neua
			else { // neu
				System.out.println(" >>falsche Eingabe<< "); // neu 
			} // neu
		} // neu
		
		if (auswahlTickets == 1) ticketPreis = 2.0; // neu
		else if (auswahlTickets == 2) ticketPreis = 3.0; // neu
		else if (auswahlTickets == 3) ticketPreis = 8.8; // neu
		else if (auswahlTickets == 4) ticketPreis = 9.4; // neu	 
		
		// Ticketanzahl
		
		korrekteEingabe = false; // neu
		
		while (korrekteEingabe == false) { 
			System.out.print("Anzahl der Tickets: ");
			anzahlTickets = tastatur.nextInt();

			if (anzahlTickets >= 1 && anzahlTickets <= 10) 
				korrekteEingabe = true;
			else
				System.out.println(" >> Wählen Sie bitte eine Anzahl von 1 bis 10 Tickets aus. <<\n");

		} 
		
		zuZahlenderBetrag = ticketPreis * anzahlTickets;

		
		return zuZahlenderBetrag;
		
	}
	
	public static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
		
		double eingezahlterGesamtbetrag;
		double nochZuZahlen;
		double eingeworfeneMuenze;
		
		eingezahlterGesamtbetrag = 0.0;
		nochZuZahlen = 0.0;
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = zuZahlenderBetrag - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %4.2f Euro\n", nochZuZahlen);

			System.out.print("Eingabe (mind. 5 Cent, höchstens 2 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}
		return eingezahlterGesamtbetrag;
		
	}
	
	public static void fahrscheinAusgabe() {
		
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
		
	}
	
	public static void rueckgeldAusgeben(double zuZahlenderBetrag, double eingezahlterGesamtbetrag){
		
		double rueckgabebetrag;
		
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.format("Der Rückgabebetrag in Höhe von %4.2f Euro \n", rueckgabebetrag);
			System.out.println("wird in folgenden Münzen ausgezahlt:");

			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag >= 0.05) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");
		
	}
	
}