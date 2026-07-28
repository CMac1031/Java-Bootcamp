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