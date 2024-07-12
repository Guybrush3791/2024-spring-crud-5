package org.java.spring_crud5.db.serv;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.java.spring_crud5.db.pojo.Order;
import org.java.spring_crud5.db.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> findAll() {

        return orderRepo.findAll();
    }

    @Transactional
    public List<Order> findAllWProducts() {

        List<Order> orders = orderRepo.findAll();

        for (Order order : orders) {

            Hibernate.initialize(order.getProducts());
        }

        return orders;
    }

    public Optional<Order> findById(int id) {

        return orderRepo.findById(id);
    }

    public void save(Order order) {

        orderRepo.save(order);
    }

    public void delete(Order order) {

        orderRepo.delete(order);
    }
}
