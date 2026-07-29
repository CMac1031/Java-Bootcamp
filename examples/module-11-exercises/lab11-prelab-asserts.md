# Exercise 3 — Trivial vs Real Asserts

## Trivial asserts
assertNotNull(customer) assertTrue(true).

## Real asserts
assertEquals(CustomerStatus.ACTIVE, find("CUS-1001").getStatus()); // Amina
assertEquals(CustomerStatus.PROSPECT, find("CUS-1002").getStatus()); // Ravi

reject AI tests that never mention domain values or outcomes.

| # | Confirm | Notes |
| --- | --- | --- |
| 1 | Two trivial and two meaningful asserts | Pass  |
| 2 | Fixtures used correctly | Pass  |
| 3 | Notes saved | Pass  |