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

### Security Questions
Which inputs are untrusted? (Downloaded Maven artifacts; later API inputs)
Where are authn/authz/validation enforced later? (App layers + CI/repo managers)
Which values are sensitive, and where stored? (Never in POM; use secrets stores)
What can be retried safely? (mvn verify, snapshot install)
What happens after a partial failure? (Failed test stops verify; no bad promotion in CI)
What would an operator monitor? (CI duration, failed verify jobs)
Which local default is unacceptable in production? (dev profile active by default with real secrets—never do that)
How are contracts versioned? (Artifact version + later OpenAPI/WSDL)

### Reflection Questions
Which design decision most affected build correctness?
Which failure was hardest to diagnose?
What evidence proves the lifecycle walk was real (not only package once)?
What breaks first at ten times the dependency count?
Which concern should move to shared infrastructure (artifact repository, CI cache)?
What must change before real customer data is used?
How does this lab connect to Lab 8 structure and Lab 10+ code?
What metric, log field, or CI signal matters most when verify fails?
Why is test scope on JUnit more than a style preference?
(Forward look) When Spring Boot arrives, what stays stable in this POM vs what changes first?
