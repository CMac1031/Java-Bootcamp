# Lab 17 — AAA Service Tests Plan

## Step 1 — Happy path

- Arrange: Create Ravi with ID `CUS-1002` and status `PROSPECT`. Use correlation ID `lab-request-001`.
- Act: Call `changeStatus("CUS-1002", ACTIVE, "lab-request-001")`.
- Assert: Ravi is returned with status `ACTIVE` and the saved customer is also `ACTIVE`.

## Step 2 — Not found

- Arrange: Use missing customer ID `CUS-9999` and correlation ID `lab-request-001`.
- Act: Call `changeStatus("CUS-9999", ACTIVE, "lab-request-001")`.
- Assert: A `BusinessException` is thrown with code `CUSTOMER_NOT_FOUND`, status `404`, and correlation ID `lab-request-001`.

## Step 3 — Illegal

- Arrange: Create Amina with ID `CUS-1001` and status `ACTIVE`. Use correlation ID `lab-request-001`.
- Act: Call `changeStatus("CUS-1001", PROSPECT, "lab-request-001")`.
- Assert: A `BusinessException` is thrown with code `ILLEGAL_STATUS_TRANSITION`, status `409`, and correlation ID `lab-request-001`.

## Scope
Pre-lab only — do not finish the full graded lab in this exercise.