## Sample tree (study only)

```text
com.northstar:build-demo:jar:0.1.0-SNAPSHOT
+- org.junit.jupiter:junit-jupiter:jar:5.11.4:test
|  \- org.junit.jupiter:junit-jupiter-params:jar:5.11.4:test
\- (no production compile dependencies in the mini project)
```

| Term | Meaning |
| ---- | ------- |
| Direct dependency | Declared in **your** `pom.xml` |
| Transitive dependency | Pulled in because a direct dependency needs it |
| Scope column (`:test`) | Where that artifact is visible |

## Steps

### Step 1 — Classify rows

| Artifact | Direct or transitive? | Scope shown |
| -------- |-----------------------|-------------|
| `junit-jupiter` | direct                | test        |
| `junit-jupiter-params` | transitive            | test        |

Answer in notes:

| Question | Answer |
| -------- | ------ |
| What does `-B` mean? | Batch mode — less interactive prompts, friendlier for CI logs |
| Why `verify` instead of casual `install` on every push? | Proves package + checks without writing into every agent’s `~/.m2` unless the pipeline intentionally installs |
| Preferred CI-style command for this bootcamp | `mvn -B verify` |
Teammates and CI should reproduce the build with `mvn -B verify`.

| # | Confirm | Notes |
| - | ------- | ----- |
| 1 | Direct vs transitive for Jupiter rows is correct | Pass |
| 2 | You ran or explained `mvn dependency:tree` | Pass  |
| 3 | Notes include `mvn -B verify` as the CI habit | Pass  |
