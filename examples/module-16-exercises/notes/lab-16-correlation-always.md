# Lab 16 — Correlation on Every Error

## Step 1 — Success path

Activating Ravi (`CUS-1002`, initially `PROSPECT`) successfully still echoes or logs the correlation ID `lab-request-001`.

## Step 2 — Failure path

A not-found response for `CUS-9999` includes the same correlation ID, `lab-request-001`, so the failure can be traced through the logs.

## Step 3 — Missing header

If the request does not include a correlation ID, the application should generate one and use it throughout the request—implementation waits for a later lab.

## Self-check

- Amina: `CUS-1001` / `ACTIVE`
- Ravi: `CUS-1002` / `PROSPECT`
- Correlation ID: `lab-request-001`
- No blanks remain: Pass

## Scope

Pre-lab only—do not finish the full graded Lab 16 in this exercise.