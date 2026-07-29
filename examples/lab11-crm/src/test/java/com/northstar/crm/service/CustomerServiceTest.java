package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService();
    }

    @Test
    void testAddCustomerStoresNewCustomer() {
        Customer customer = new Customer(
                "CUS-1001",
                "Amina Khan",
                "amina@northstar.com",
                "+1-555-0101",
                CustomerStatus.ACTIVE,
                LocalDateTime.now()
        );

        Customer result = customerService.addCustomer(customer);

        assertEquals(customer, result);
        assertTrue(customerService.listAll().contains(customer));
    }

    @Test
    void testAddCustomerWithDuplicateCustomerIdThrowsIllegalStateException() {
        Customer customer1 = new Customer(
                "CUS-1001",
                "Amina Khan",
                "amina@northstar.com",
                "+1-555-0101",
                CustomerStatus.ACTIVE,
                LocalDateTime.now()
        );

        Customer customer2 = new Customer("CUS-1001",  // Same customerId
                "Different Name",
                "different@northstar.com",
                "+1-555-9999",
                CustomerStatus.PROSPECT,
                LocalDateTime.now()
        );

        customerService.addCustomer(customer1);

        assertThrows(IllegalStateException.class, () -> customerService.addCustomer(customer2));
    }

    @Test
    void testUpdateStatusChangesCustomerStatus() {
        Customer customer = new Customer(
                "CUS-1001",
                "Amina Khan",
                "amina@northstar.com",
                "+1-555-0101",
                CustomerStatus.PROSPECT,
                LocalDateTime.now()
        );

        customerService.addCustomer(customer);

        Customer updated = customerService.updateStatus("CUS-1001", CustomerStatus.ACTIVE);

        assertEquals(CustomerStatus.ACTIVE, updated.getStatus());
        assertEquals(CustomerStatus.ACTIVE, customerService.findByCustomerId("CUS-1001").get().getStatus());
    }

    @Test
    void testUpdateStatusWithUnknownCustomerIdThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> customerService.updateStatus("CUS-9999", CustomerStatus.ACTIVE));
    }
    @Test
    void addCustomerRejectsDuplicateCustomerId() {
        CustomerService service = new CustomerService();

        Customer customer = new Customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                "555-0101",
                CustomerStatus.ACTIVE,
                LocalDateTime.now()
        );

        service.addCustomer(customer);

        assertThrows(
                IllegalStateException.class,
                () -> service.addCustomer(customer)
        );
    }


}