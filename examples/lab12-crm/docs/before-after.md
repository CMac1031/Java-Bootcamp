Main data flow after refactor (create / get / update status)
- Create: Validate input, check for duplicate ID, store customer
- Get: Retrieve customer by ID
- Update Status: Validate new status, update customer record
Trust boundary and where validation lives after cleanup
- Validation occurs at the service layer, ensuring that all customer data is properly validated before being stored or updated.
Success/failure contract (duplicate ID, unknown ID, blank name)
- Success: Customer is created or updated successfully
- Failure: Duplicate ID results in an IllegalStateException, unknown ID results in an empty Optional
Stable identity (CUS-1001) vs mutable fields (status, email)
- Stable identity: The customerId (e.g., CUS-1001) is immutable and serves as the unique identifier for each customer.
- Mutable fields: Fields such as status and email can be updated over time, reflecting changes in the customer's information or relationship with the business.
Retry/idempotency implications for create vs get
- Create: The create operation is not idempotent; attempting to create a customer with the same ID will result in an error (IllegalStateException).
- Get: The get operation is idempotent; retrieving a customer by ID multiple times will return the same result.
Local in-memory shortcut vs production persistence
- Local in-memory storage is used for development and testing purposes, allowing for quick iterations without the overhead of a database. In production, persistent storage (e.g., PostgreSQL) should be used to ensure data durability and reliability.
Logs/evidence for support (lab-request-001)
- Logs are generated for each customer operation, providing evidence for support requests and troubleshooting.
Two JVM instances = independent memory (conflict risk)
- Two JVM instances running the application will have independent memory spaces, which can lead to conflicts if they are not properly synchronized or if they attempt to access shared resources without coordination. This risk must be managed through proper design and deployment strategies.
Which SOLID ideas fit this lab’s size, and which are deferred?
- The Single Responsibility Principle and Open/Closed Principle fit this lab’s size, while the Liskov Substitution Principle and Interface Segregation Principle are deferred for future consideration.
Why freezing a before snapshot matters more than “I rewrote it cleanly”?
- Freezing a before snapshot is important because it provides a reference point for the original state of the codebase, allowing developers to compare changes and ensure that refactoring does not introduce regressions or unintended side effects. It also helps in tracking progress and maintaining accountability for the changes made during the refactoring process.

### Reflection Questions
Write 3–6 sentence answers:

Which design decision most affected correctness?
- The decision to centralize validation logic in the service layer most affected correctness, as it ensures that all customer data is consistently validated before any operations are performed. This reduces the risk of invalid data being stored or processed, which could lead to errors and inconsistencies in the system.
Which smell was hardest to justify removing?
- The hardest smell to justify removing was the duplication of validation logic across different layers. While it may have seemed convenient to have validation in multiple places, it led to inconsistencies and made the code harder to maintain. By consolidating validation into a single location, we improved maintainability and reduced the risk of errors, but it required careful consideration to ensure that all necessary checks were still being performed.
What evidence proves the refactor preserves intended behavior?
- The evidence that proves the refactor preserves intended behavior includes passing unit tests that cover various scenarios, such as adding a new customer, handling duplicate IDs, and retrieving customers by ID. Additionally, the use of mock tests to verify that the correct methods are called during operations provides further assurance that the refactor maintains the expected functionality. Logs generated during operations also serve as evidence of correct behavior, allowing for traceability and verification of actions taken by the system.
What breaks first at ten times method length if smells return?
- If smells return, the first thing that would break at ten times method length is the maintainability and readability of the code. As methods become excessively long, it becomes difficult for developers to understand the logic and flow of the code, leading to increased chances of introducing bugs during modifications. Additionally, longer methods can lead to performance issues and make it harder to isolate and test individual components, further complicating debugging and maintenance efforts.
Which concern should move to shared infrastructure (logging, IDs)?
- The concern that should move to shared infrastructure is logging and ID management. Centralizing logging allows for consistent log formats, levels, and destinations, making it easier to monitor and troubleshoot issues across different services. Similarly, managing IDs in a shared infrastructure ensures that unique identifiers are generated and maintained consistently, reducing the risk of conflicts and improving data integrity across the system.
What must change before real customer data is used?
- Before real customer data is used, several changes must be implemented to ensure security, privacy, and compliance. This includes implementing proper authentication and authorization mechanisms to control access to sensitive data, encrypting sensitive information both at rest and in transit, and ensuring that data storage complies with relevant regulations (e.g., GDPR, HIPAA). Additionally, thorough testing should be conducted to validate that the system handles real customer data correctly and securely, and monitoring should be set up to detect any anomalies or breaches in real-time.
How does this lab connect to Labs 8–11 standards and Lab 13 contracts?
- This lab connects to Labs 8–11 standards by adhering to established coding practices, such as SOLID principles, centralized validation, and proper testing strategies. It builds upon the foundation laid in previous labs by refining the architecture and improving maintainability while ensuring that the system behaves as expected. In relation to Lab 13 contracts, this lab sets the stage for defining clear API contracts and versioning strategies, ensuring that future integrations and enhancements can be made without breaking existing functionality. The focus on logging, error handling, and supportability also aligns with the goals of maintaining a robust and reliable system as it evolves through subsequent labs.
What metric, log field, or support clue matters most after refactor?
- The most important metric after the refactor is the error rate, as it provides insight into the stability and reliability of the system. Monitoring log fields such as correlation IDs and timestamps is also crucial for tracing requests and diagnosing issues effectively. Additionally, support clues like specific exception messages and stack traces can help identify the root cause of problems quickly, enabling faster resolution and minimizing downtime for users. Overall, these metrics and logs are essential for maintaining a high level of service quality and ensuring that any issues are promptly addressed.
(Forward look) Which deferred SOLID step (e.g. repository DIP) comes next—and why not today?
- The next deferred SOLID step is the implementation of the Dependency Inversion Principle (DIP) for the repository layer. This would involve creating interfaces for the repository and having the service layer depend on those interfaces rather than concrete implementations. The reason this step is not implemented today is that it requires additional design considerations and may introduce complexity that is not necessary for the current scope of the lab. By deferring this step, we can focus on stabilizing the current functionality and ensuring that the core features are working correctly before introducing more advanced architectural patterns.