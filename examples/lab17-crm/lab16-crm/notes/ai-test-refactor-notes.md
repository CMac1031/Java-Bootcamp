Difference between an exploratory Copilot-generated test and a deliberately designed suite?
What makes an assertion “false confidence”?
Why extract CustomerNotifier before mocking, instead of mocking concrete CustomerService?
What is a code smell, and which Lab 10 smell is the clearest refactor candidate?
Why is high coverage % not the same as meaningful coverage?
What regression risk exists when refactoring without a full suite—and how do today’s tests help?
When should you trust a Copilot extract-method vs verify manually?
What acceptance criteria should a reviewer apply before merging an AI-generated test or refactor?
Why keep JUnit/Mockito at test scope?
How does this preview set up Labs 17–18 without replacing them?

## lab11-001 — generated exploratory test
### Prompt
Add one more test to `CustomerServiceTest`.

#### Weak Suggestion 
```Java
@Test
void testCustomerServiceExists() {
    assertNotNull(customerService);
}
```
Copilot generated me a real test- so I asked it to make me a trivial one above
```Java 
@Test
void testFindByStatusReturnsCustomersWithMatchingStatus() {
Customer customer1 = new Customer(
"CUS-1001",
"Amina Khan",
"amina@northstar.com",
"+1-555-0101",
CustomerStatus.ACTIVE,
LocalDateTime.now()
);

    Customer customer2 = new Customer(
            "CUS-1002",
            "Ravi Singh",
            "ravi@northstar.com",
            "+1-555-0102",
            CustomerStatus.PROSPECT,
            LocalDateTime.now()
    );

    Customer customer3 = new Customer(
            "CUS-1003",
            "Priya Patel",
            "priya@northstar.com",
            "+1-555-0103",
            CustomerStatus.ACTIVE,
            LocalDateTime.now()
    );

    customerService.addCustomer(customer1);
    customerService.addCustomer(customer2);
    customerService.addCustomer(customer3);

    var activeCustomers = customerService.findByStatus(CustomerStatus.ACTIVE);

    assertEquals(2, activeCustomers.size());
    assertTrue(activeCustomers.contains(customer1));
    assertTrue(activeCustomers.contains(customer3));
    assertFalse(activeCustomers.contains(customer2));
}
```
## lab11-002 — CustomerServiceTest
### Prompt- Review CustomerService for code smells: duplicated logic, long methods,
unclear names. Suggest one specific refactor.
Code Smell: Duplicated lookup logic in addCustomer()
Current:
boolean exists = customers.stream()
.anyMatch(c -> c.getCustomerId().equals(customer.getCustomerId()));

if (exists) {
throw new IllegalStateException("Customer with customerId '" + customer.getCustomerId() + "' already exists");
}
Refactor: Use the existing findByCustomerId() method:
if (findByCustomerId(customer.getCustomerId()).isPresent()) {
throw new IllegalStateException("Customer with customerId '" + customer.getCustomerId() + "' already exists");
}
Benefit:
•
Eliminates stream duplication (already done in findByCustomerId())
•
Single source of truth for lookup logic
•
More maintainable — if lookup logic changes, only one place to fix
•
Clearer intent: "if customer exists, throw"
This is a DRY violation — findByCustomerId() already encapsulates the lookup, and addCustomer() reimplements it. Small refactor, big clarity win.