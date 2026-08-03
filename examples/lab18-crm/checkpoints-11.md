### Checkpoint A — Project + test deps

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `lab11-crm` copied from Lab 10 under `examples/` | Pass  |
| 2 | JUnit 5 + Mockito on **test** scope; Surefire present | Pass |
| 3 | Copilot still Ready | Pass  |

### Checkpoint B — Core tests green

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `CustomerTest` (2) and `CustomerServiceTest` (4) pass | Pass  |
| 2 | Sample IDs `CUS-1001` / `CUS-1002` used in tests | Pass  |
| 3 | No JUnit 4 imports | Pass  |

### Checkpoint C — Refactor + mock

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `CustomerNotifier` extracted and called from `updateStatus` | Pass  |
| 2 | No-arg `CustomerService()` still works (no-op notifier) | Pass  |
| 3 | `CustomerNotifierMockTest` verifies PROSPECT → ACTIVE | Pass  |
| 4 | `validateCustomerId` is the single blank-ID check | Pass  |

### Checkpoint D — Notes + guidelines + experiments

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Entries `lab11-001`–`lab11-004` complete | Pass  |
| 2 | False-confidence rejection documented | Pass  |
| 3 | Coverage gaps documented; acceptance checklist present | Pass  |
| 4 | Failure experiments recorded; `mvn clean test` green | Pass  |