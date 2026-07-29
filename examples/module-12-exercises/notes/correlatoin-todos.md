# Lab 12 — Fill Correlation One-Liner TODOs

## Step 1 — Copy TODOs

Correlation id value: lab-request-001
Log on activate entry: activate entry correlationId=lab-request-001 customerId=CUS-1002
Log on activate success for Ravi: activate success correlationId=lab-request-001 customerId=CUS-1002
Never log field: raw customer email
Place correlation in: MDC (header/MDC — pick one for now)

## Step 2 — Fill blanks

Fill with `lab-request-001`, short log phrases, and a PII field you must not log (e.g. raw email if present later).

## Step 3 — One-liner rule

Write: *Every public service entry logs correlation once.*

## Step 4 — Self-check

Confirm the correlation blank is exactly lab-request-001.

## Scope
Pre-lab only — do not finish the full graded lab in this exercise.

| # | Confirm | Notes |
| --- | --- | --- |
| 1 | File exists at `notes/lab12-correlation-todos.md` | Pass  |
| 2 | All _____ replaced | Pass  |
| 3 | lab-request-001 present | Pass  |
| 4 | PII exclusion named | Pass  |