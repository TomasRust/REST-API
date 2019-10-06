package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.restservice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}