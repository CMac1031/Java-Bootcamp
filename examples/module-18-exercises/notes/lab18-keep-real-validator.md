# Lab 18 — When to Keep Real Validator

## Mock repo?

Mock `CustomerRepository` because it represents an I/O boundary and allows repository behavior to be controlled during tests.

## Real validator?

Keep `CustomerValidator` real because it is deterministic, fast, and contains important status-transition rules.

## Mock notifier?

Mock the notifier to prevent tests from sending real emails or performing other external I/O.

## Rule

Mock I/O boundaries and unstable dependencies. Keep pure, fast domain helpers real when practical.

## Debug / design challenge

If the validator always allows `ACTIVE → PROSPECT`, the test misses an illegal-transition bug that the real validator would reject.

## Predict the behavior

`DefaultCustomerService` should not be mocked when it is the system under test. Create a real service and provide its mocked repository and notifier dependencies.

## Scope

Pre-lab only.