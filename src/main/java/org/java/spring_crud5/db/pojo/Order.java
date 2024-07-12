package org.java.spring_crud5.db.pojo;

import java.util.List;

import org.java.spring_crud5.myInt.Payable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_order")
public class Order implements Payable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

    @ManyToMany
    private List<Product> products;

    public Order() {
    }

    public Order(Customer customer) {

        setCustomer(customer);
    }

    public Order(Customer customer, List<Product> products) {

        this(customer);

        setProducts(products);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public int getFullPrice(boolean vat) {

        if (products == null)
            return 0;

        // return products.stream().map(p -> p.getFullPrice(vat)).reduce(0,
        // Integer::sum);
        return products.stream().mapToInt(p -> p.getFullPrice(vat)).sum();

        // int price = 0;
        // for (Product product : products) {
        // price += product.getFullPrice(vat);
        // }

        // return price;
    }

    @Override
    public String toString() {

        return "Order{\n" +
                "id=" + id + "\n" +
                "full-price=" + getFullPrice(false) + "\n" +
                "full-price vat=" + getFullPrice(true) + "\n" +
                '}';
    }
}
