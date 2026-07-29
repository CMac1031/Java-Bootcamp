# AI test/refactor notes — Lab 11

## lab11-001 — generated exploratory test
- Accepted / rejected trivial assertion?
- Notes:

## lab11-002 — CustomerServiceTest
Lab 11-002 Refactoring Record
Smell Name: Duplicated Lookup Logic (DRY Violation)
Location: CustomerService.addCustomer()
Refactor Applied:
•
Before: Stream-based .anyMatch() to check if customer exists
•
After: Replaced with findByCustomerId(customer.getCustomerId()).isPresent()
•
Benefit: Single source of truth for lookup logic; eliminates code duplication
Tests Proving Behavior Unchanged:
1.
CustomerServiceTest.testAddCustomerStoresNewCustomer()
◦
Verifies new customer is stored ✓
2.
CustomerServiceTest.testAddCustomerWithDuplicateCustomerIdThrowsIllegalStateException()
◦
Verifies duplicate customerId still throws IllegalStateException ✓
3.
Mock Test (suggested):
@Test
void testAddCustomerCallsFindByCustomerId() {
CustomerService service = new CustomerService();
Customer customer = new Customer("CUS-1001", "Amina Khan", ...);

       service.addCustomer(customer);
       service.addCustomer(customer); // Should throw
       
       assertThrows(IllegalStateException.class, ...);
}
Status: Refactor complete, behavior verified unchanged.
## lab11-003 — CustomerNotifier extract + Mockito
Uncovered Behavior in CustomerService:
1.
listAll() returns unmodifiable list
◦
Test that modifying the returned list throws UnsupportedOperationException
@Test
void testListAllReturnsUnmodifiableList() {
customerService.addCustomer(customer);
var list = customerService.listAll();
assertThrows(UnsupportedOperationException.class, () -> list.add(new Customer(...)));
}
2.
findByCustomerId returns empty Optional
◦
Test when customer doesn't exist (not just the happy path)
@Test
void testFindByCustomerIdReturnsEmptyWhenNotFound() {
assertTrue(customerService.findByCustomerId("CUS-9999").isEmpty());
}
3.
findByStatus returns empty list
◦
Test when no customers match the status
@Test
void testFindByStatusReturnsEmptyListWhenNoMatches() {
customerService.addCustomer(new Customer("CUS-1001", ..., CustomerStatus.ACTIVE, ...));
assertTrue(customerService.findByStatus(CustomerStatus.PROSPECT).isEmpty());
}
4.
addCustomer with null customer
◦
Test the null check throws IllegalArgumentException
5.
No-arg constructor creates no-op notifier
◦
Test that updateStatus() doesn't fail when using default constructor
6.
Notifier receives correct old/new status
◦
Mock test verifying the notifier is called with exact old and new status values

## lab11-004 — coverage gaps / acceptance guidelines
Acceptance guidelines for AI-generated tests and refactors:
1. Every assertion must be able to fail — if I can't describe an input that
   breaks it, it isn't a real test.
2. Every refactor must be backed by a passing test suite run before and after.
3. No accepted suggestion may introduce a dependency not already in pom.xml.
4. I can explain, without re-reading Copilot's explanation, why the code
   is correct.
5. Coverage gaps are documented, not silently ignored.