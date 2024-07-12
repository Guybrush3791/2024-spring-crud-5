package org.java.spring_crud5.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.spring_crud5.db.pojo.Customer;
import org.java.spring_crud5.db.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> findAll() {

        return customerRepo.findAll();
    }

    public Optional<Customer> findById(int id) {

        return customerRepo.findById(id);
    }

    public void save(Customer customer) {

        customerRepo.save(customer);
    }

    public void delete(Customer customer) {

        customerRepo.delete(customer);
    }
}
