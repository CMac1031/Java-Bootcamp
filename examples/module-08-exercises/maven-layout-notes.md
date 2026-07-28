customer-management-platform/
├── pom.xml
├── docs/
│   └── CODING-STANDARDS.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/northstar/crm/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       ├── java/
│       │   └── com/northstar/crm/
│       └── resources/
└── target/
Lab 1
| File | Destination |
| ---- | ----------- | 
| `Customer.java` | src/main/java|
| `CustomerServiceTest.java` | src/test/java|
| `application.properties` |src/main/resources |
| `sample-customers.json` | used only by tests | src/test/resources|
| `CODING-STANDARDS.md` | customer-managment-platform/docs|
| `Customer.class` | customer-managment-platform/target|

target/ is generated from source by Maven. It can be deleted and rebuilt, so it should be ignored rather than committed.
production Java in src/test/java;
- those are the test files not the source code 
passwords committed in application.properties;
- they should not be in the in the properties, but secret
hand-editing target/classes;
- those are for byte code class
test fixtures in production resources without a runtime need
- test files should be in the test files not production
### Lab 1 Pass criteria 
| # | Confirm | Notes |
| - | ------- | ----- |
| 1 | Six files classified correctly | Pass  |
| 2 | You explain why `target/` is ignored | Pass  |
| 3 | You state that resources must not contain committed secrets | Pass  |







