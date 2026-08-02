| Layer concept | Package folder | Owns | Must NOT own |
| ------------- | -------------- | ---- | ------------ |
| Presentation | `controller` | Accept/return DTOs; map calls | SQL, business rules |
| Business | `service` | Rules, orchestration | HTTP headers, JDBC details |
| Persistence | `repository` | Save/find | REST mapping |
| Domain | `entity` | Customer fields | Request JSON shapes |
| Contracts | `dto` | Request/response | Persistence annotations (later JPA stays on entity) |
| Cross-cutting | `config`, `exception` | Wiring, failure types | Happy-path create logic |


christophermcenroe@MacBook-Pro-2 java-bootcamp % cd ~/java-bootcamp/examples/lab8-crm
mvn -q clean compile
find src/main/java -name '*.java' | sort
git status
src/main/java/com/northstar/crm/Main.java
src/main/java/com/northstar/crm/config/AppConfig.java
src/main/java/com/northstar/crm/controller/CustomerController.java
src/main/java/com/northstar/crm/dto/CustomerRequest.java
src/main/java/com/northstar/crm/dto/CustomerResponse.java
src/main/java/com/northstar/crm/entity/Customer.java
src/main/java/com/northstar/crm/exception/CustomerNotFoundException.java
src/main/java/com/northstar/crm/repository/CustomerRepository.java
src/main/java/com/northstar/crm/service/CustomerService.java
On branch main
Your branch is up to date with 'origin/main'.

Changes not staged for commit:
(use "git add <file>..." to update what will be committed)
(use "git restore <file>..." to discard changes in working directory)
modified:   docs/notes/CODING-STANDARDS.md

no changes added to commit (use "git add" and/or "git commit -a")

### Failure Tests
1. Rename pom.xml to pom.xml.bak and run `mvn compile` — it should fail with a missing POM error.
2. run mvn clean compile twice - the second time should be faster because the first time will have compiled the classes and stored them in the target folder.
3. Call new CustomerRepository().findById("CUS-1001") - it should return null because the repository is empty.

### Manual Verification:
pwd is .../lab8-crm (or agreed alternate name).
- pass 
mvn clean compile prints BUILD SUCCESS.
- pass
find src/main/java -name '*.java' | sort lists all expected stubs + Main.
- pass
java -cp target/classes com.northstar.crm.Main prints packages + CUS-1001 / CUS-1002.
- pass
docs/CODING-STANDARDS.md and docs/layer-flow.md exist and mention layers.
- pass
rg springframework src (or equivalent search) finds nothing required.
- pass
git check-ignore -v target (or git status) shows target/ untracked/ignored.
- pass
Stub call intentional failure: repository findById("CUS-1001") throws UnsupportedOperationException if you exercise it from a temporary harness.
- pass
Re-run compile twice—second run still succeeds.
- pass
Notes include correlation ID lab-request-001 and NOW vs FUTURE boundaries.
- pass

### Reflection Questions
Which design decision most affected correctness of the skeleton?
- Using Maven’s standard directory structure and matching each Java package declaration to its folder ensured that Maven could find and compile every class correctly.
What evidence proves the layered structure is real, not only aspirational?
- The find src/main/java -name '*.java' | sort output shows actual classes inside the controller, service, repository, entity, DTO, config, and exception packages.
Which failure was hardest to diagnose (pathing, packages, POM)?
- The hardest failure to diagnose was the missing POM error when renaming pom.xml to pom.xml.bak. It required understanding Maven's build lifecycle and the importance of the POM file in defining project structure and dependencies.
