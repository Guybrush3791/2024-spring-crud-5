package org.java.spring_crud5.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.java.spring_crud5.db.pojo.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
