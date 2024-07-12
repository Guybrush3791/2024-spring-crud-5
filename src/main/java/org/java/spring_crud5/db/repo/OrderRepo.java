package org.java.spring_crud5.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.java.spring_crud5.db.pojo.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
