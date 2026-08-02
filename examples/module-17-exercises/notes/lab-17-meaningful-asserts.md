# Lab 17 — Meaningful Asserts

## Step 1 — Weak

`assertNotNull(result)` after activate — label weak.

## Step 2 — Strong

Assert Ravi id CUS-1002 and status ACTIVE after activate.
assertEquals("CUS-1002", result.getCustomerId());
assertEquals(CustomerStatus.ACTIVE, result.getStatus());

## Step 3 — Exception assert

Amina (CUS-1001) is already ACTIVE. Because the same-status policy is to reject the transition, plan to use:

BusinessException exception = assertThrows(
BusinessException.class,
() -> service.changeStatus(
"CUS-1001",
CustomerStatus.ACTIVE,
"lab-request-001"));

assertEquals("BUSINESS_CONFLICT", exception.getCode());
assertEquals(409, exception.getStatusHint());
assertEquals("lab-request-001", exception.getCorrelationId());

Also verify that Amina’s status remains unchanged:

## Step 4 — Prep only

Write: *Prepare for Lab 17; do not complete full suite now.*

## Scope
Pre-lab only — do not finish the full graded lab in this exercise.