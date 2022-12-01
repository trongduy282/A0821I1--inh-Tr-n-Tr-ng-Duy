package com.bookstoreonline.bookstore.dao;



import com.bookstoreonline.bookstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

