package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.repository.CustomerRepository;
import com.northstar.crm.repository.InMemoryCustomerRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Test
    void addsAminaThenFindsHerById() {
        CustomerService service = createService();
        Customer amina = customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                CustomerStatus.ACTIVE
        );

        service.addCustomer(amina);

        Customer found = service.findById("CUS-1001").orElseThrow();

        assertEquals("CUS-1001", found.getCustomerId());
        assertEquals("Amina Khan", found.getFullName());
        assertEquals(CustomerStatus.ACTIVE, found.getStatus());
    }

    @Test
    void rejectsDuplicateCustomerId() {
        CustomerService service = createService();

        service.addCustomer(customer(
                "CUS-1002",
                "Ravi Singh",
                "ravi.singh@example.com",
                CustomerStatus.PROSPECT
        ));

        Customer duplicate = customer(
                "CUS-1002",
                "Other Customer",
                "other@example.com",
                CustomerStatus.PROSPECT
        );

        assertThrows(
                IllegalStateException.class,
                () -> service.addCustomer(duplicate)
        );
    }

    @Test
    void unknownCustomerReturnsEmptyOptional() {
        CustomerService service = createService();

        assertTrue(service.findById("CUS-9999").isEmpty());
    }

    @Test
    void rejectsBlankCustomerId() {
        CustomerService service = createService();

        Customer invalid = customer(
                " ",
                "Amina Khan",
                "amina.khan@example.com",
                CustomerStatus.ACTIVE
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> service.addCustomer(invalid)
        );
    }

    @Test
    void rejectsDuplicateEmail() {
        CustomerService service = createService();

        service.addCustomer(customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                CustomerStatus.ACTIVE
        ));

        Customer duplicateEmail = customer(
                "CUS-1003",
                "Different Customer",
                "amina.khan@example.com",
                CustomerStatus.PROSPECT
        );

        assertThrows(
                IllegalStateException.class,
                () -> service.addCustomer(duplicateEmail)
        );
    }

    @Test
    void findByIdUsesStringContentEquality() {
        CustomerService service = createService();
        Customer amina = customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                CustomerStatus.ACTIVE
        );

        service.addCustomer(amina);

        String separateStringObject = new String("CUS-1001");
        Customer found = service.findById(separateStringObject).orElseThrow();

        assertSame(amina, found);
        assertEquals("CUS-1001", found.getCustomerId());
    }

    private CustomerService createService() {
        CustomerRepository repository =
                new InMemoryCustomerRepository();

        CustomerValidator validator =
                new CustomerValidator(repository);

        return new DefaultCustomerService(repository, validator);
    }

    private Customer customer(
            String customerId,
            String fullName,
            String email,
            CustomerStatus status) {

        return new Customer(
                customerId,
                fullName,
                email,
                null,
                status,
                LocalDateTime.now()
        );
    }
}