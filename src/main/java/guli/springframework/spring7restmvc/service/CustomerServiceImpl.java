package guli.springframework.spring7restmvc.service;

import guli.springframework.spring7restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

   private Map<UUID, Customer> customerMap;

   public CustomerServiceImpl() {
       this.customerMap = new HashMap<>();

       Customer customer1 =
               Customer.builder()
               .customerName("Guli")
               .id(UUID.randomUUID())
               .version(4321)
               .createdDate(LocalDateTime.now())
               .lastModifiedDate(LocalDateTime.now())
               .build();

       Customer customer2 =
               Customer.builder()
               .customerName("Hanna")
               .id(UUID.randomUUID())
               .version(3232)
               .createdDate(LocalDateTime.now())
               .lastModifiedDate(LocalDateTime.now())
               .build();

       Customer customer3 =
               Customer.builder()
               .customerName("Toddy")
               .id(UUID.randomUUID())
               .version(5133)
               .createdDate(LocalDateTime.now())
               .lastModifiedDate(LocalDateTime.now())
               .build();

       this.customerMap.put(customer1.getId(), customer1);
       this.customerMap.put(customer2.getId(), customer2);
       this.customerMap.put(customer3.getId(), customer3);
   }

   @Override
   public List<Customer> getAllCustomers() {
       return new ArrayList<>(this.customerMap.values());
   }

    @Override
    public Optional<Customer> getCustomerById(UUID id) {
        return Optional.of(this.customerMap.get(id));
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
       Customer newCustomer =
               Customer.builder()
               .customerName(customer.getCustomerName())
               .id(UUID.randomUUID())
               .version(3123)
               .createdDate(LocalDateTime.now())
               .lastModifiedDate(LocalDateTime.now())
               .build();

       this.customerMap.put(newCustomer.getId(), newCustomer);

       return newCustomer;
    }

    @Override
    public void updateById(UUID customerId, Customer customer) {
       Customer existingCustomer = this.customerMap.get(customerId);
       existingCustomer.setCustomerName(customer.getCustomerName());

       this.customerMap.put(existingCustomer.getId(), existingCustomer);
    }

    public void deleteById(UUID customerID) {
       this.customerMap.remove(customerID);
    }

    public void updatePatchById(UUID customerID, Customer customer) {
       Customer existingCustomer = this.customerMap.get(customerID);

       if (StringUtils.hasText(customer.getCustomerName())) {
           existingCustomer.setCustomerName(customer.getCustomerName());
       }

    }
}
