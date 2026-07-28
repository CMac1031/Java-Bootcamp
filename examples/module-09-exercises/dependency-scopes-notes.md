
## Scope map

| Scope | On compile classpath? | On runtime classpath? | Typical use |
| ----- | --------------------- | --------------------- | ------------ |
| `compile` (default) | Yes | Yes | Application libraries you call from production code |
| `test` | Tests only | Tests only | JUnit, Mockito, test helpers |
| `runtime` | No | Yes | Drivers needed to run but not compile against |
| `provided` | Yes | No (container supplies) | Servlet API on an app server; JDK-provided APIs |

## Steps

### Step 1 — Assign a scope

| Dependency need | Scope    |
| --------------- |----------|
| JUnit Jupiter used only in `src/test/java` | test     |
| Spring Context API called from production sources (Lab 9 learning placeholder) | compile  |
| JDBC driver you never import in Java source but need at runtime later | runtime  |
| API the application server will provide in production | provided |

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter</artifactId>
  <version>5.11.4</version>
  <!-- no scope — defaults to compile -->
</dependency>
```

JUnit becomes a production dependency: it is packaged/resolved for the main app, pollutes the runtime classpath, and signals the wrong intent to teammates and CI.

Test libraries always use `<scope>test</scope>`.
Do not leave JUnit on the default `compile` scope.


| # | Confirm | Notes |
| - | ------- | ----- |
| 1 | Four scope assignments match the reference | Pass  |
| 2 | You explain the JUnit-without-scope mistake | Pass |
| 3 | Team rule is written | Pass |