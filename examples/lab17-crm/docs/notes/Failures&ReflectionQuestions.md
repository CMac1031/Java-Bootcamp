## Failures Experiments
1	Break DI wiring in @BeforeEach	Tests fail clearly	Fix collaborators
- I temporarily passed `null` instead of `CustomerValidator` to `DefaultCustomerService`. The happy-path test failed because the service could not validate the customer.
- then restored it to pass a valid `CustomerValidator` instance, and the test passed again.
3	Run mvn -q test twice	Identical results	Keep isolation
- yields identical results 
5. Raise coverage minimum to 0.99
- Edited pom.xml file from 0.80 coverage minimum to 0.99 and edited out one of th tests to make the coverage drop below 0.99. The build failed as expected, then I restored the test and the build passed again.

## Reflection Questions
Which design decision most affected correctness?
- Using BeforeEach to initialize dependencies ensured that each test had a clean slate and that the service was properly configured with valid collaborators. This design decision prevented data leakage between tests and allowed for proper validation of customer data before persisting it. This design decision ensured that the service behaved correctly and consistently across different test scenarios.
What evidence proves the implementation works?
- Looking at JaCoCo report where it reports >=80% coverage for service packages.
Which failure was hardest to diagnose?
- The hardest failure to rewire lab16 tests and ensure that the correct exceptions were thrown and handled. 