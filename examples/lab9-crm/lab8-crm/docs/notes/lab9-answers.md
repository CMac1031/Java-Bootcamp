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


pwd ends with lab9-crm.
- yes
mvn validate … mvn install each succeed individually (evidence file filled).
- yes
mvn test runs PlaceholderTest with 0 failures.
- yes
mvn dependency:tree shows spring-context (compile) and junit-jupiter (test).
- yes
mvn help:active-profiles shows dev by default; -Pprod activates prod.
- yes
java -jar target/customer-service.jar prints skeleton banner / example customer IDs.
- yes
mvn -B verify succeeds non-interactively.
- yes
Search POM/properties for passwords → none.
- yes
git status does not stage target/ or secrets.
- yes
Concepts/reflection drafts mention artifact GAV vs CUS-1001 distinction.
- yes

### Failure Handling
1. Set spring.version to nonsense; mvn compile
- should fail with missing dependency error
2. Change PlaceholderTest to assertTrue(false); mvn test / mvn verify
- should fail with test failure
3. Run mvn install twice
- should succeed on second run


### Reflection Questions
Which design decision most affected build correctness?
- Using Maven’s standard project layout and keeping pom.xml in the project root most affected build correctness.
What evidence proves the lifecycle walk was real (not only package once)?
- The lifecycle evidence records successful runs of validate, compile, test, package, verify, and install.
Which failure was hardest to diagnose?
- The missing-POM failure was hardest because the terminal appeared to be inside lab9-crm, but the actual Maven project was nested inside lab9-crm/lab8-crm.
