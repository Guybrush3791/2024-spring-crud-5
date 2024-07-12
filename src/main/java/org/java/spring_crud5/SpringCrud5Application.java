package org.java.spring_crud5;

import java.util.List;

import org.java.spring_crud5.db.pojo.Customer;
import org.java.spring_crud5.db.pojo.Order;
import org.java.spring_crud5.db.pojo.Product;
import org.java.spring_crud5.db.serv.CustomerService;
import org.java.spring_crud5.db.serv.OrderService;
import org.java.spring_crud5.db.serv.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrud5Application implements CommandLineRunner {

	/**
	 * REPO: 2024-spring-crud-5
	 * 
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
	 * Un cliente puo' effettuare piu' ordini, ogni ordine contiene piu' prodotti.
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
	 * relazioni man mano che vengono implementate.
	 * 
	 * E' possibile definire altre classi/interfacce qualora lo si ritenga
	 * oppurtuno.
	 * 
	 */

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(SpringCrud5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// tableTest();
		// relationTest();
		fullPriceTest();
	}

	public void tableTest() {

		Customer c1 = new Customer("Guybrush", "Threepwood", "mia@mail.com", null);
		Customer c2 = new Customer("Elaine", "Marley", null, "123344456");
		Customer c3 = new Customer("LeChuck", "LeChuck", "lechuck@mail.com", "23423423432");

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println("-----------------------------------------------------------------------");

		customerService.save(c1);
		customerService.save(c2);
		customerService.save(c3);

		List<Customer> customers = customerService.findAll();
		customers.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------");

		customerService.delete(c2);

		c1.setName("Marco");
		c1.setLastname("Rossi");
		customerService.save(c1);

		customers = customerService.findAll();
		customers.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------");

		Order o1 = new Order(customers.get(0));
		Order o2 = new Order(customers.get(1));
		Order o3 = new Order(customers.get(1));

		System.out.println(o1);
		System.out.println(o1.getCustomer());
		System.out.println(o2);
		System.out.println(o2.getCustomer());
		System.out.println(o3);
		System.out.println(o3.getCustomer());
		System.out.println("-----------------------------------------------------------------------");

		orderService.save(o1);
		orderService.save(o2);
		orderService.save(o3);

		List<Order> orders = orderService.findAll();
		orders.forEach(o -> System.out.println(o + "\n" + o.getCustomer()));
		System.out.println("-----------------------------------------------------------------------");

		orderService.delete(o2);

		orders = orderService.findAll();
		orders.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------");

		Product p1 = new Product("Rubber Chicken", 100, 22);
		Product p2 = new Product("Sword", 200, 10);
		Product p3 = new Product("Map", 300, 40);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println("-----------------------------------------------------------------------");

		productService.save(p1);
		productService.save(p2);
		productService.save(p3);

		List<Product> products = productService.findAll();
		products.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------");

		productService.delete(p2);

		p1.setPrice(500);
		p1.setVat(5);
		productService.save(p1);

		products = productService.findAll();
		products.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------");
	}

	public void relationTest() {

		Customer c1 = new Customer("Guybrush", "Threepwood", "mia@mail.com", null);
		Customer c2 = new Customer("Elaine", "Marley", null, "123344456");
		Customer c3 = new Customer("LeChuck", "LeChuck", "lechuck@mail.com", "23423423432");

		customerService.save(c1);
		customerService.save(c2);
		customerService.save(c3);

		List<Customer> customers = customerService.findAll();

		Order o1 = new Order(customers.get(0));
		Order o2 = new Order(customers.get(1));
		Order o3 = new Order(customers.get(1));

		orderService.save(o1);
		orderService.save(o2);
		orderService.save(o3);

		Product p1 = new Product("Rubber Chicken", 100, 22);
		Product p2 = new Product("Sword", 200, 10);
		Product p3 = new Product("Map", 300, 40);

		productService.save(p1);
		productService.save(p2);
		productService.save(p3);

		List<Product> products = productService.findAll();
		List<Order> orders = orderService.findAllWProducts();

		o1 = orders.get(0);
		o2 = orders.get(1);
		o3 = orders.get(2);

		o1.addProduct(products.get(0));
		o1.addProduct(products.get(1));
		o1.addProduct(products.get(2));

		o2.addProduct(products.get(1));
		o2.addProduct(products.get(2));

		o3.addProduct(products.get(0));

		orderService.save(o1);
		orderService.save(o2);
		orderService.save(o3);
	}

	public void fullPriceTest() {

		Customer c1 = new Customer("Guybrush", "Threepwood", "mia@mail.com", null);
		Customer c2 = new Customer("Elaine", "Marley", null, "123344456");
		Customer c3 = new Customer("LeChuck", "LeChuck", "lechuck@mail.com", "23423423432");

		customerService.save(c1);
		customerService.save(c2);
		customerService.save(c3);

		List<Customer> customers = customerService.findAll();

		Order o1 = new Order(customers.get(0));
		Order o2 = new Order(customers.get(1));
		Order o3 = new Order(customers.get(1));

		orderService.save(o1);
		orderService.save(o2);
		orderService.save(o3);

		Product p1 = new Product("Rubber Chicken", 100, 22);
		Product p2 = new Product("Sword", 200, 10);
		Product p3 = new Product("Map", 300, 40);

		productService.save(p1);
		productService.save(p2);
		productService.save(p3);

		List<Product> products = productService.findAll();
		List<Order> orders = orderService.findAllWProducts();

		o1 = orders.get(0);
		o2 = orders.get(1);
		o3 = orders.get(2);

		o1.addProduct(products.get(0));
		o1.addProduct(products.get(1));
		o1.addProduct(products.get(2));

		o2.addProduct(products.get(1));
		o2.addProduct(products.get(2));

		o3.addProduct(products.get(0));

		orderService.save(o1);
		orderService.save(o2);
		orderService.save(o3);

		orders.forEach(System.out::println);
	}
}
