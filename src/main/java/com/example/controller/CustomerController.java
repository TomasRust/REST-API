
package com.example.controller;

//import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatamysql.CustomerRepository;
import com.example.restservice.entity.Customer;


@RestController
@RequestMapping("/api/v1")
public class CustomerController {
 
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomerbyId(
    @PathVariable(value = "customerId") Long customerId) throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("Customer not found on :: "+ customerId));
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<Customer> updateCustomer(
    @PathVariable(value = "customerId") Long customerId,
    @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
         Customer customer = customerRepository.findById(customerId)
          .orElseThrow(() -> new ResourceNotFoundException("Customer not found on :: "+ customerId));
  
        customer.setEmailId(customerDetails.getEmail());
        customer.setLastName(customerDetails.getLastName());
        customer.setFirstName(customerDetails.getFirstName());
//        customer.setUpdatedAt(new Date());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
   }

   @DeleteMapping("/customers/{customerId}")
   public Map<String, Boolean> deleteUser(
       @PathVariable(value = "customerId") Long customerId) throws Exception {
       Customer customer = customerRepository.findById(customerId)
          .orElseThrow(() -> new ResourceNotFoundException("Customer not found on :: "+ customerId));

       customerRepository.delete(customer);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}