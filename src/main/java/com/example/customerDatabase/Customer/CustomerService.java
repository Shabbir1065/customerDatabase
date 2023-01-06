package com.example.customerDatabase.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());

        if (customerOptional.isPresent()){
            throw new IllegalStateException("email has already been registered");
        }
        System.out.println(customer);
        customerRepository.save(customer);
    }

    @Transactional
    public void updateCustomer(Long customerId, String name, String email, String phoneNum, String address) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException(
                        "Customer with id " + customerId + " does not exist"
                ));

        if (name != null && name.length() > 0 && !Objects.equals(customer.getName(),name)){
            customer.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(customer.getEmail(),email)){
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            if (customerOptional.isPresent()){
                throw new IllegalStateException("email has already been registered");
            }
            customer.setEmail(email);
        }

        if (phoneNum != null && phoneNum.length() == 10 && !Objects.equals(customer.getPhoneNum(),phoneNum)){
            customer.setPhoneNum(phoneNum);
        }

        if (address != null && address.length() > 0 && !Objects.equals(customer.getAddress(),address)){
            customer.setAddress(address);
        }

    }

    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);

        if (!exists){
            throw new IllegalStateException("Customer with id " + customerId + " does not exist");
        }

        customerRepository.deleteById(customerId);
    }
}
