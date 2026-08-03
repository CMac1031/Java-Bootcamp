## lab17-001


- Prompt used: Review tests for duplicate email, `listAll()`, and correlation IDs on `BusinessException`. Use `CUS-1001` and `CUS-1002`, plain Java 21, and no Spring, JPA, or Mockito.
- Output summary: Added meaningful service tests using shared CRM fixtures and domain-specific assertions.
- Decision: Edit, then accept
- Reason (1 sentence): Tests now assert customer IDs, statuses, exception codes, HTTP-like status hints, and correlation IDs, while avoiding random or real PII and phantom Spring/JPA imports.

| Check | Result | Evidence                                                                                           |
| --- | --- |----------------------------------------------------------------------------------------------------|
| Can every assertion fail after a regression? | Pass | Tests assert customer IDs, statuses, exception codes, HTTP-like status hints, and correlation IDs. |
| Shared CRM fixture IDs used? | Pass | Tests use Amina `CUS-1001`, Ravi `CUS-1002`, and missing customer `CUS-9999`.                      |
| No random or real PII? | Pass | Only fictional `example.com` addresses are used.                                                   |
| No phantom Spring/JPA imports? | Pass | Tests use JUnit, Java, and existing Northstar classes only.                                        |
| Independent `@BeforeEach`? | Pass | Every test receives a fresh repository, validator, and service.                                    |
| Maven tests run after edits? | Pass | `mvn -q test` ran                                                                                  |

### Weak assertion rejected

Rejected:

```java
assertNotNull(service);
```

