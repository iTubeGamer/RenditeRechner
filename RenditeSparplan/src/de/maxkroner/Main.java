package de.maxkroner;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int eingezahlt = 0;
		double gesamtRendite;
		double gesamtRenditeLetztesJahr = 1;
		double kontostand = 0;
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geschätzte Rendite pro Jahr in Prozent?");
		double jaehrlicheRendite = 1 + (scanner.nextDouble()/100);
		double monatlicheRendite = Math.pow(jaehrlicheRendite, 1.0/12);
		System.out.println("Monatliche Rendite beträgt: " + String.format("%.4f", (monatlicheRendite - 1) * 100) + "%");
		System.out.println("Monatliche Einzahlung?");
		int einzahlungProMonat = scanner.nextInt();
		System.out.println("Erhöhung der monatlichen Einzahlung pro Jahr?");
		int erhoehungProJahr = scanner.nextInt();
		System.out.println("Anzahl Jahre?");
		int jahre = scanner.nextInt();
		
		for (int i=1; i<=jahre; i++){
			int monatlicheEinzahlungDiesesJahr = einzahlungProMonat + (i-1)*erhoehungProJahr;
			for (int k=1; k<=12; k++){
				eingezahlt = eingezahlt + monatlicheEinzahlungDiesesJahr;
				kontostand = kontostand * monatlicheRendite;
				kontostand = kontostand + monatlicheEinzahlungDiesesJahr;
			}

			gesamtRendite = (kontostand/eingezahlt) - 1;
			System.out.println("Jahr " + i);
			System.out.println("eingezahlt: " + String.format("%d€", eingezahlt));
			System.out.println("kontostand: " + String.format("%.2f€", kontostand));
			System.out.println("Gesamtrendite: " + String.format("%.2f", gesamtRendite * 100) + "%");
			if (i > 1){
				System.out.println("Differenz: " + String.format("%.2f", (gesamtRendite - gesamtRenditeLetztesJahr) * 100));
				System.out.println("Faktor: " + String.format("%.4f", (gesamtRendite / gesamtRenditeLetztesJahr)));
			}
			
			gesamtRenditeLetztesJahr = gesamtRendite;
		}
		scanner.close();
	}

}
