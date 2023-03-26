package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {

		Libretto lib = new Libretto();
		
		//Punto 1
		lib.add(new Voto("Analisi 1",29,LocalDate.of(2021, 2, 15)));
		lib.add(new Voto("Fisica 2",21,LocalDate.of(2022, 6, 10)));
		lib.add(new Voto("Informatica",25,LocalDate.of(2021, 7, 10)));
		lib.add(new Voto("Fisica 3",22,LocalDate.of(2022, 6, 10)));
		
		//Punto 2
		System.out.println("\n2)");
		lib.stampaPuntiUguali(25);
		
		//Punto 3
		System.out.println("\n3)");
		Voto v = lib.cercaVotoPerCorso("Analisi 1");
		System.out.println(v.getPunti());
		
		//Punto 4
		System.out.println("\n4)");
		Voto a1bis = new Voto("Analisi 1",29,LocalDate.of(2025, 2, 15));
		Voto a1ter = new Voto("Analisi 1",30,LocalDate.of(2025, 2, 15));
		System.out.println(a1bis+" è duplicato "+lib.esisteVotoDuplicato(a1bis));
		System.out.println(a1ter+" è duplicato "+lib.esisteVotoDuplicato(a1ter));
		
		//Punto 5
		System.out.println("\n5)");
		System.out.println(a1bis+" è in conflitto "+lib.esisteConflitto(a1bis));
		System.out.println(a1ter+" è in conflitto "+lib.esisteConflitto(a1ter));
		
		//Punto 6
		System.out.println("\n6)");
		try {
			lib.add(new Voto("Analisi 1",29,LocalDate.of(2021, 2, 15)));
		} catch (IllegalArgumentException e){
			System.out.println("Errore nell'inserimento del voto");
			System.out.println(e.getMessage());
		}
		
		//Punto 7
		System.out.println("\n7)");
		System.out.println("LIBRETTO ORIGINARIO");
		lib.stampa();
		Libretto migliore = lib.librettoMigliorato();
		System.out.println("LIBRETTO MIGLIORATO");
		migliore.stampa();
		System.out.println("LIBRETTO ORIGINARIO DOPO");
		lib.stampa();
		
		//Punto 8
		System.out.println("\n8)");
		System.out.println("LIBRETTO ORDINATO PER NOME");
		lib.librettoOrdinatoAlfabeticamente().stampa();
		System.out.println("LIBRETTO ORDINATO PER VOTO");
		lib.librettoOrdinatoPerVoto().stampa();
		
		//Punto 9
		System.out.println("\n9)");
		System.out.println("LIBRETTO ORIGINARIO >=24");
		lib.cancellaVotiInferiori(24);
		lib.stampa();
	}

}
