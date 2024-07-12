package org.java.spring_crud5.db.pojo;

import java.util.List;

import org.java.spring_crud5.myInt.Payable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product implements Payable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int vat;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public Product() {
    }

    public Product(String name, int price, int vat) {

        setName(name);
        setPrice(price);
        setVat(vat);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {

        orders.add(order);
    }

    @Override
    public int getFullPrice(boolean vat) {

        return price + (vat ? price * this.vat / 100 : 0);
    }

    @Override
    public String toString() {

        return "Product{\n" +
                "id=" + id + "\n" +
                "name='" + name + '\'' + "\n" +
                "price=" + price + "\n" +
                "vat=" + vat + "\n" +
                '}';
    }
}
