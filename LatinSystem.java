// TODO: fix declension formatting, add more cases for 2nd and 3rd declension, add vocative, add main menu and conjugation menu

package com.latinsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LatinSystem {
	
	private static Scanner scan = new Scanner(System.in);
	private static String term = "";
	private static List<String> declension3rdTerms = new ArrayList<>();
	private static List<String> declension4thTerms = new ArrayList<>();
	


	public static void main(String[] args) {
		try {
			runLatinSystemMenu();
		}
		catch(Exception e) {
			
		}
		
		
	}
	
	public static void runLatinSystemMenu() {
		System.out.println("Latin System\n");
		System.out.println("1. Declension Menu");
		System.out.println("2. Conjugation Menu");
		System.out.print("\nWelcome to the Latin System! Please enter one of the listed options: ");
		int option = scan.nextInt();
		scan.nextLine();
		
		switch(option) {
			case 1:
				runDeclensionMenu();
				break;
			case 2:
				runConjugationMenu();
				break;
			default:
				break;
		}
	}
	
	public static void runDeclensionMenu() {
		
		boolean isDeclensionMenuRunning = true;
		
		while(isDeclensionMenuRunning) {
			declension3rdTerms.add("amor");
			declension3rdTerms.add("bellator");
			declension3rdTerms.add("navis");
			
			declension4thTerms.add("actus");
			declension4thTerms.add("auditus");
			declension4thTerms.add("portus");
			declension4thTerms.add("tactus");
			
			System.out.println("\nLatin Decliner\n");
			System.out.print("Please enter your noun/adjective to decline (type x to exit): ");
			term = scan.nextLine().toLowerCase();
			
			if(term.equals("x")) {
				isDeclensionMenuRunning = false;
			} else if(term.substring(term.length()-1).equals("a")) {
				decline1st(term);
			} else if(term.substring(term.length()-2).equals("us") && declension4thTerms.contains(term)) {
				decline4th(term);
			} else if(term.substring(term.length()-2).equals("us") || term.substring(term.length()-2).equals("um") || term.substring(term.length()-2).equals("er")) {
				decline2nd(term);
			} else if(term.substring(term.length()-2).equals("es")) {
				decline5th(term);
			} else if(term.substring(term.length()-2).equals("or") || term.substring(term.length()-2).equals("is") || term.substring(term.length()-2).equals("en") || term.substring(term.length()-1).equals("o")) {
				decline3rd(term);
			}
		}
	}
	
	public static void decline1st(String term) {
		System.out.println(term + " (1st declension)\n");
		System.out.println("Nominative: \t" + term + "\t" + term + "e");
		System.out.println("Genitive: \t" + term + "e\t" + term + "rum");
		System.out.println("Dative: \t" + term + "e\t" + term.substring(0, term.length()-1) + "is");
		System.out.println("Accusative: \t" + term + "m\t" + term + "s");
		System.out.println("Ablative: \t" + term + "e\t" + term.substring(0, term.length()-1) + "is\n");
	}
	
	public static void decline2nd(String term) {
		String termWithoutEnd = term.substring(0, term.length()-2);
		
		if(term.substring(term.length()-2).equals("er") && !(term.equals("puer"))) {
			System.out.println(term + " (2nd declension)\n");
			System.out.println("Nominative: \t" + term + "\t" + termWithoutEnd + "ri");
			System.out.println("Genitive: \t" + termWithoutEnd + "ri\t" + termWithoutEnd + "rorum");
			System.out.println("Dative: \t" + termWithoutEnd + "ro\t" + termWithoutEnd + "ris");
			System.out.println("Accusative: \t" + termWithoutEnd + "rum\t" + termWithoutEnd + "ros");
			System.out.println("Ablative: \t" + termWithoutEnd + "ro\t" + termWithoutEnd + "ris");
			System.out.println("Vocative: \t" + termWithoutEnd + "re\t" + termWithoutEnd + "ri\n");
		} else if(term.substring(term.length()-2).equals("us") || term.substring(term.length()-2).equals("um")) {
			System.out.println(term + " (2nd declension)\n");
			System.out.println("Nominative: \t" + term + "\t" + termWithoutEnd + "i");
			System.out.println("Genitive: \t" + termWithoutEnd + "i\t" + termWithoutEnd + "orum");
			System.out.println("Dative: \t" + termWithoutEnd + "o\t" + termWithoutEnd + "is");
			if(term.substring(term.length()-2).equals("us")) {
				System.out.println("Accusative: \t" + termWithoutEnd + "um\t" + termWithoutEnd + "os");
			} else if(term.substring(term.length()-2).equals("um")) {
				System.out.println("Accusative: \t" + termWithoutEnd + "um\t" + termWithoutEnd + "a");
			}
			System.out.println("Ablative: \t" + termWithoutEnd + "o\t" + termWithoutEnd + "is");
			if(term.substring(term.length()-2).equals("us")) {
				System.out.println("Vocative: \t" + termWithoutEnd + "e\t" + termWithoutEnd + "i\n");
			} else {
				System.out.println("Vocative: \t" + term + "\t" + termWithoutEnd + "i\n");
			}
		} else if(term.equals("puer")) {
			System.out.println(term + " (2nd declension)\n");
			System.out.println("Nominative: \t" + term + "\t" + term + "i");
			System.out.println("Genitive: \t" + term + "i\t" + term + "orum");
			System.out.println("Dative: \t" + term + "o\t" + term + "is");
			System.out.println("Accusative: \t" + term + "um\t" + term + "os");
			System.out.println("Ablative: \t" + term + "o\t" + term + "is");
			System.out.println("Vocative: \t" + term + "\t" + term + "i\n");
		}

	}
	
	public static void decline3rd(String term) {
		String termWithoutEnd = term.substring(0, term.length()-2);
		if(term.substring(term.length()-2).equals("is")) {
			System.out.println(term + " (3rd declension)\n");
			System.out.println("Nominative: \t" + term + "\t" + termWithoutEnd + "es");
			System.out.println("Genitive: \t" + term + "\t" + termWithoutEnd + "ium");
			System.out.println("Dative: \t" + termWithoutEnd + "i\t" + termWithoutEnd + "ibus");
			System.out.println("Accusative: \t" + termWithoutEnd + "em\t" + termWithoutEnd + "es");
			System.out.println("Ablative: \t" + termWithoutEnd + "e\t" + termWithoutEnd + "ibus\n");
		} else if(term.substring(term.length()-2).equals("or")) {
			System.out.println(term + " (3rd declension)\n");
			System.out.println("Nominative: \t" + term + "\t" + term + "es");
			System.out.println("Genitive: \t" + term + "is\t" + term + "um");
			System.out.println("Dative: \t" + term + "i\t" + term + "ibus");
			System.out.println("Accusative: \t" + term + "em\t" + term + "es");
			System.out.println("Ablative: \t" + term + "e\t" + term + "ibus\\n");
		} else if(term.substring(term.length()-2).equals("en")) {
			System.out.println(term + " (3rd declension)\n");
			System.out.println("Nominative: \t" + term + "\t" + termWithoutEnd + "ina");
			System.out.println("Genitive: \t" + termWithoutEnd + "inis\t" + termWithoutEnd + "inum");
			System.out.println("Dative: \t" + termWithoutEnd + "ini\t" + termWithoutEnd + "inibus");
			System.out.println("Accusative: \t" + term + "\t" + termWithoutEnd + "ina");
			System.out.println("Ablative: \t" + termWithoutEnd + "ine\t" + termWithoutEnd + "inibus\n");
		} else if(term.substring(term.length()-1).equals("o")) {
			termWithoutEnd = term.substring(0, term.length()-1);
			System.out.println(term + " (3rd declension)\n");
			System.out.println("Nominative: \t" + term + "\t" + termWithoutEnd + "ines");
			System.out.println("Genitive: \t" + termWithoutEnd + "inis\t" + termWithoutEnd + "inum");
			System.out.println("Dative: \t" + termWithoutEnd + "ini\t" + termWithoutEnd + "inibus");
			System.out.println("Accusative: \t" + termWithoutEnd + "inem\t" + termWithoutEnd + "ines");
			System.out.println("Ablative: \t" + termWithoutEnd + "ine\t" + termWithoutEnd + "inibus\n");
		}
	}
	
	public static void decline4th(String term) {
		String termWithoutEnd = term.substring(0, term.length()-2);
		System.out.println(term + " (4th declension)\n");
		System.out.println("Nominative: \t" + term + "\t" + term);
		System.out.println("Genitive: \t" + termWithoutEnd + "us\t" + termWithoutEnd + "uum");
		System.out.println("Dative: \t" + termWithoutEnd + "ui\t" + termWithoutEnd + "ibus");
		System.out.println("Accusative: \t" + termWithoutEnd + "um\t" + termWithoutEnd + "us");
		System.out.println("Ablative: \t" + termWithoutEnd + "u\t" + termWithoutEnd + "ibus\n");
	}
	
	public static void decline5th(String term) {
		String termWithoutEnd = term.substring(0, term.length()-1);
		System.out.println(term + " (5th declension)\n");
		System.out.println("Nominative: \t" + term + "\t" + term);
		System.out.println("Genitive: \t" + termWithoutEnd + "i\t" + termWithoutEnd + "rum");
		System.out.println("Dative: \t" + termWithoutEnd + "i\t" + termWithoutEnd + "bus");
		System.out.println("Accusative: \t" + termWithoutEnd + "m\t" + termWithoutEnd + "s");
		System.out.println("Ablative: \t" + termWithoutEnd + "\t" + termWithoutEnd + "bus\n");
	}
	
	public static void runConjugationMenu() {
		boolean isConjugationMenuRunning = true;
		
		while(isConjugationMenuRunning) {
			System.out.println("\nLatin Conjugator\n");
			System.out.print("Please enter your verb to conjugate (type x to exit): ");
			term = scan.nextLine().toLowerCase();
			
			if(term.equals("x")) {
				isConjugationMenuRunning = false;
			} else if(term.substring(term.length()-2).equals("eo")) {
				conjugate2nd(term);
			}
		}
	}
	
	public static void conjugate2nd(String term) {
		String termWithoutEnd = term.substring(0, term.length()-2);
		System.out.println("Active Indicative");
		System.out.println("Present: \t" + term + " " + termWithoutEnd + "es " + termWithoutEnd + "et " + termWithoutEnd + "emus " + termWithoutEnd + "etis " + termWithoutEnd + "ent");
		System.out.println("Future: \t" + termWithoutEnd + "ebo " + termWithoutEnd + "ebis " + termWithoutEnd + "ebit " + termWithoutEnd + "ebimus " + termWithoutEnd + "ebitis " + termWithoutEnd + "ebunt");
		System.out.println("Imperfect: \t" + termWithoutEnd + "ebam " + termWithoutEnd + "ebas " + termWithoutEnd + "ebat " + termWithoutEnd + "ebamus " + termWithoutEnd + "ebatis " + termWithoutEnd + "ebant");
		System.out.println("Perfect: \t" + termWithoutEnd + "ui " + termWithoutEnd + "uisti " + termWithoutEnd + "uit " + termWithoutEnd + "uimus " + termWithoutEnd + "uistis " + termWithoutEnd + "uerunt");
		System.out.println("Future Perfect: \t" + termWithoutEnd + "uero " + termWithoutEnd + "ueris " + termWithoutEnd + "uerit " + termWithoutEnd + "uerimus " + termWithoutEnd + "ueritis " + termWithoutEnd + "uerint");
		System.out.println("Pluperfect: \t" + termWithoutEnd + "ueram " + termWithoutEnd + "ueras " + termWithoutEnd + "uerat " + termWithoutEnd + "ueramus " + termWithoutEnd + "ueratis " + termWithoutEnd + "uerant");
	}

}
