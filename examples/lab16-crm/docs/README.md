### Checkpoint A — Repository boundary

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | -------- |
| 1 | `lab15-crm` under `examples/` | Pass  |
| 2 | `CustomerRepository` + private-Map in-memory impl | Pass  |
| 3 | No Map exposed to callers | Pass  |

### Checkpoint B — Service + validator

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `CustomerService` interface + `DefaultCustomerService` | Pass  |
| 2 | `CustomerValidator` with ALLOWED transitions | Pass  |
| 3 | Shared repository instance in wiring | Pass  |

### Checkpoint C — Behavior proof

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `CUS-1002` activates PROSPECT → ACTIVE | Pass  |
| 2 | `CUS-1001` ACTIVE → PROSPECT rejected; status unchanged | Pass  |
| 3 | Correlation ID present on failure | Pass  |

### Checkpoint D — Tests + docs

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `CustomerValidatorTest` green | Pass  |
| 2 | README transition table + wiring | Pass  |
| 3 | Failure experiments recorded; no secrets/`target/` staged | Pass  |