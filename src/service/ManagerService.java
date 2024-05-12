package service;

import interfaces.ManagerServiceInterface;
import model.Customer;

import java.util.List;

import static model.Customer.CUSTOMERS;

public class ManagerService implements ManagerServiceInterface {
    @Override
    public void addCustomer(Customer customer) {
        CUSTOMERS.add(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        CUSTOMERS.stream()
                .filter(customer -> customer.getId().equals(customerId))
                .findFirst()
                .ifPresent(CUSTOMERS::remove);
    }

    @Override
    public List<Customer> getCustomers() {
        return CUSTOMERS;
    }

    @Override
    public Customer getCustomer(Long id) {
        return CUSTOMERS.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst().orElseThrow();
    }
}
