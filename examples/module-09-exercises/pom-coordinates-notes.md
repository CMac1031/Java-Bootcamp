## Coordinate map

| Element | Meaning | Northstar CRM example |
| ------- | ------- | --------------------- |
| `groupId` | Organization / product namespace | `com.northstar` |
| `artifactId` | Module name inside that group | `customer-service` |
| `version` | Release or snapshot label | `0.1.0-SNAPSHOT` |
| `packaging` | Output type (`jar`, `war`, `pom`, …) | `jar` |
| GAV string | Combined identity | `com.northstar:customer-service:0.1.0-SNAPSHOT` |

```xml
<groupId>com.northstar</groupId>
<artifactId>customer-service</artifactId>
<version>0.1.0-SNAPSHOT</version>
<packaging>jar</packaging>
```

| Question | Your answer      |
| -------- |------------------|
| What is the `groupId`? | com.northstar    |
| What is the `artifactId`? | customer-service |
| What is the `version`? | 0.1.0-SNAPSHOT   |
| What is the packaging? | jar              |
| Write the full GAV (`groupId:artifactId:version`) |    groupId:artifactId:version              |
A -SNAPSHOT version means the artifact is still under active development and may change without a new release number.

Explain why each is wrong for Northstar CRM Lab 9:

groupId set to com.example while the Java packages are com.northstar.crm;
- should be set to com.northstar
artifactId set to CustomerService (PascalCase);
- should be all lower case separated by hypens
omitting <packaging> and assuming WAR for a plain Java library/app JAR;
- should be jar because jar is default for maven
committing a different version on every laptop with no team agreement.
- the team should just commit to a version because this can cause problems later down the line
  | # | Confirm | Notes |
  | - | ------- | ----- |
  | 1 | Five coordinate answers match the reference | Pass  |
  | 2 | You explain what `-SNAPSHOT` means | Pass  |
  | 3 | You identify at least two coordinate mistakes | Pass  |

