package interfaces;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public interface ManagerServiceInterface {
    void addCustomer(Customer customer);
    void deleteCustomer(Long customerId);
    List<Customer> getCustomers();
    Customer getCustomer(Long id);
}
