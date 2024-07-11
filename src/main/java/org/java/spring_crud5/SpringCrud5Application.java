package org.java.spring_crud5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrud5Application {

	/**
	 * TODO:
	 * 
	 * In nuovo esercizio sviluppare un'applicazione per gestire le seguenti
	 * entita':
	 * 
	 * Customer (cliente):
	 * - id : INT
	 * - name : STRING
	 * - lastname : STRING
	 * - email : STRING
	 * - phone : STRING
	 * 
	 * Order (ordine):
	 * - id : INT
	 * 
	 * Product (prodotto):
	 * - id : INT
	 * - name : STRING
	 * - price : INT
	 * - vat (iva percentuale) : INT
	 * 
	 * Un cliente puo' effettuare un ordine contenente piu' prodotti.
	 * 
	 * La classe Order deve inoltre esporre il seguente metodo:
	 * - getFullPrice(boolean vat) : INT --> restituisce il prezzo totale
	 * dell'ordine
	 * comprensivo o meno dell'iva in base al
	 * parametro booleano in ingresso
	 * 
	 * La classe Product deve inoltre esporre il seguente metodo:
	 * - getFullPrice(boolean vat) : INT --> restituisce il prezzo totale del
	 * prodotto
	 * maggiorato dell'iva se la variabile booleana
	 * in ingresso e' true
	 * 
	 * Definire sensatamente le relazioni e testare adeguatamente sia classi che
	 * relazioni
	 * man mano che vengono implementate. E' possibile definire altre
	 * classi/interfacce
	 * qualora lo si ritenga necessario.
	 * 
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringCrud5Application.class, args);
	}

}
