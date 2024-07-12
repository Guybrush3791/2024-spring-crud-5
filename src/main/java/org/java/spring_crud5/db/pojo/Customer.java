package org.java.spring_crud5.db.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 128)
    private String lastname;

    @Column(nullable = true, length = 128)
    private String email;

    @Column(nullable = true, length = 32)
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer() {
    }

    public Customer(
            String name, String lastname,
            String email, String phone) {

        setName(name);
        setLastname(lastname);
        setEmail(email);
        setPhone(phone);
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    public String toString() {

        return "Customer{\n" +
                "id=" + id + ",\n" +
                "name='" + name + "',\n" +
                "lastname='" + lastname + "',\n" +
                "email='" + email + "',\n" +
                "phone='" + phone + "'\n" +
                "}";
    }
}
