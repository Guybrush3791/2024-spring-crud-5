package org.java.spring_crud5.db.serv;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.java.spring_crud5.db.pojo.Product;
import org.java.spring_crud5.db.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> findAll() {

        return productRepo.findAll();
    }

    @Transactional
    public List<Product> findAllWProducts() {

        List<Product> products = productRepo.findAll();

        for (Product product : products) {

            Hibernate.initialize(product.getOrders());
        }

        return products;
    }

    public Optional<Product> findById(int id) {

        return productRepo.findById(id);
    }

    public void save(Product product) {

        productRepo.save(product);
    }

    public void delete(Product product) {

        productRepo.delete(product);
    }
}
