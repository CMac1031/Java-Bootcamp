### Lab 17 — CRM 
```bash
cd ~/java-bootcamp/examples/lab17-crm
mvn test
mvn -q test ## if you want to suppress the Maven banner
mvn clean verify ##JaCoCO Coverage report + test results
```
Then you open index.html in `target/site/jacoco/index.html` to see the coverage report.
| Class                  | Location                                   | Purpose                                                        |
|------------------------|--------------------------------------------|----------------------------------------------------------------|
| `CustomerServiceTests` | `src/test/java/com/northstar/crm/service/` | Lab 17  tests, duplicates, exceptions, not-found, and list all |
| `CustomerTests` | `src/test/java/com/northstar/crm/entity/`  |   Entity equality & toString |

### Coverage Goal 
Coverage Goals:
- Line coverage: ≥80%
- Branch coverage: ≥75%
- CustomerService: No uncovered paths in happy + error flows


### Copilot Review
- Review the `ai-mockito-review.md` file in `copilot-notes/`

### Branches covered:
Service package still covers 100% of the happy path and error flows. The entity package covers equality and toString. It still covers 90% of the service branch, but has some uncovered paths.
### Checkpoint A — Tooling

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | -------- |
| 1 | `lab17-crm` under `examples/` | Pass  |
| 2 | Surefire 3.x + JaCoCo with service `0.80` rule | Pass  |
| 3 | JUnit 5 on test classpath | Pass  |

### Checkpoint B — Core suite

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | --------- |
| 1 | Happy path: add/find Amina; activate Ravi | Pass  |
| 2 | Negatives: duplicate, illegal transition, not-found | Pass  |
| 3 | Parameterized legal/illegal transitions | Pass |

### Checkpoint C — Gate + AI discipline

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | ----- |
| 1 | `mvn clean verify` passes ≥80% service coverage | Pass  |
| 2 | Deliberate gate failure recorded then restored | Pass  |
| 3 | Copilot review log or manual equivalent | Pass  |

### Checkpoint D — Hygiene

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | ---- |
| 1 | Two consecutive `mvn test` identical success | Pass |
| 2 | README runbook complete | Pass |
| 3 | No secrets / committed jacoco site / `target/` | Pass |
