| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `~/java-bootcamp/examples/lab9-crm` exists (copied from Lab 8) | Pass  |
| 2 | `pom.xml` has `com.northstar:customer-service:0.1.0-SNAPSHOT` and `packaging` jar | Pass  |
| 3 | Properties set `maven.compiler.release` / JDK 21 mindset | Pass  |
| 4 | Edited on VS Code laptop | Pass  |

### Checkpoint B — Dependencies, plugins, tests

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Spring placeholder + JUnit `test` scope declared | Pass  |
| 2 | `PlaceholderTest` passes under Surefire | Pass  |
| 3 | Compiler + jar `Main-Class` configured | Pass  |
| 4 | `mvn test` and `mvn package` succeed | Pass  |

### Checkpoint C — Lifecycle + tree + profiles

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `docs/lifecycle-evidence.md` covers validate → install | Pass  |
| 2 | `docs/dependency-tree.txt` annotated (direct/transitive, JUnit scope) | Pass  |
| 3 | Profiles `dev` / `test` / `prod` demonstrated with `help:active-profiles` | Pass  |
| 4 | `application-dev.properties` has no secrets | Pass  |

### Checkpoint D — JAR, CI, failures, security

_Mark each row **Pass** or **Fail** in your lab notes (GitHub markdown files are not interactive checklists)._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `java -jar target/customer-service.jar` works | Pass  |
| 2 | README documents `mvn -B verify` | Pass  |
| 3 | At least three failure experiments recorded and restored | Pass  |
| 4 | No secrets / `target/` / `.m2` dump committed | Pass  |