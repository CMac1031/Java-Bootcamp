# Lab 18 — ArgumentCaptor Preview

Declare ArgumentCaptor<Customer>.
verify(repo).save(captor.capture()).
Assert captor.getValue().getStatus() == ACTIVE for Ravi.
Prepare for Lab 18; do not complete full suite now.

## Scope
Pre-lab only.

# Lab 18 — ArgumentCaptor Preview

## Declare
Declare an ArgumentCaptor<Customer> to hold the customer passed to the repository:

ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);

## Verify + capture
After activating Ravi, verify that save() was called and capture its argument:

verify(repository).save(captor.capture());

## Assert
Assert that the captured customer has the expected status:

assertEquals(ACTIVE, captor.getValue().getStatus());

## Scope
Pre-lab only.