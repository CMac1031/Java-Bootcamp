package com.northstar.crm;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.repository.CustomerRepository;
import com.northstar.crm.repository.InMemoryCustomerRepository;
import com.northstar.crm.service.CustomerService;
import com.northstar.crm.service.CustomerValidator;
import com.northstar.crm.service.DefaultCustomerService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CustomerRepository repository =
                new InMemoryCustomerRepository();

        CustomerValidator validator =
                new CustomerValidator(repository);

        CustomerService service =
                new DefaultCustomerService(repository, validator);

        Customer amina = new Customer(
                "CUS-1001",
                "Amina Khan",
                "amina.khan@example.com",
                "555-0101",
                CustomerStatus.ACTIVE,
                LocalDateTime.now()
        );

        Customer ravi = new Customer(
                "CUS-1002",
                "Ravi Singh",
                "ravi.singh@example.com",
                "555-0102",
                CustomerStatus.PROSPECT,
                LocalDateTime.now()
        );

        service.addCustomer(amina);
        service.addCustomer(ravi);

        System.out.println("All customers: " + service.listAll());

        System.out.println(
                "PROSPECT customers: "
                        + service.listAll().stream()
                        .filter(customer ->
                                customer.getStatus()
                                        == CustomerStatus.PROSPECT)
                        .toList()
        );

        Customer activated = service.changeStatus(
                "CUS-1002",
                CustomerStatus.ACTIVE,
                "lab-request-001"
        );

        System.out.printf(
                "activated %s status=%s%n",
                activated.getCustomerId(),
                activated.getStatus()
        );
        try {
            service.changeStatus(
                    "CUS-1001",
                    CustomerStatus.PROSPECT,
                    "lab-request-001"
            );
        } catch (IllegalStateException exception) {
            System.out.println(
                    "expected failure: " + exception.getMessage()
            );
        }

        System.out.println(
                "CUS-1001 still: "
                        + service.findById("CUS-1001")
                        .orElseThrow()
                        .getStatus()
        );

        System.out.println(
                "After Ravi activation: "
                        + service.findById("CUS-1002")
                        .orElseThrow()
                        .getStatus()
        );
    }
}