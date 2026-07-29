1. Putting System.out.println(...) or email-sending code directly inside activate(...) is a testability smell. It mixes customer status logic with external I/O, making the method harder to test and giving it more than one responsibility.


Method signature:
public void notifyActivated(String customerId)

Purpose:
Notify relevant systems/handlers when a customer transitions to ACTIVE status.

Responsibilities:
1. Validate customerId is not null/blank
2. Look up the customer by customerId (fail if not found)
3. Send notification(s):
    - Log event: "Customer activated: CUS-1001"
    - Email notification (optional)
    - Event publish (optional, for async listeners)
4. Return void or return notification confirmation

Exceptions:
- IllegalArgumentException if customerId is null/blank
- CustomerNotFoundException if customer not found

Design considerations:
- Should this verify the customer's status is actually ACTIVE?
- Should this be called from CustomerService.updateStatus()?
- Single responsibility: just notify, don't update the customer
- Could accept full Customer object instead of just customerId
- Could return a confirmation/receipt of notification sent
- No Spring yet, so:
    * No @Service annotation
    * No @Autowired dependencies
    * Use constructor injection for dependencies if needed

Stronger prompts name the CustomerNotifier collaborator so AI does not bury output or email I/O directly inside the customer service.

CustomerService → CustomerNotifier → future email/event implementation

| # | Confirm | Notes |
| --- | --- | --- |
| 1 | Smell named | Pass |
| 2 | Interface sketched | Pass  |
| 3 | Out-of-scope hosting noted | Pass  |