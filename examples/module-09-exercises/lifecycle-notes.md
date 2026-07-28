## Lifecycle (default)

```text
validate → compile → test → package → verify → install → deploy
```

| Phase | What it proves |
| ----- | -------------- |
| `validate` | POM/model is structurally OK |
| `compile` | Production sources compile to `target/classes` |
| `test` | Unit tests under Surefire pass |
| `package` | Artifact exists under `target/` (e.g. JAR) |
| `verify` | Extra checks/integrations tied to the package succeed |
| `install` | Artifact copied into the local `~/.m2` repository |
| `deploy` | Artifact published to a remote repository (CI/release, not casual laptop) |

## Steps

### Step 1 — Match command to intent

| Intent | Command      |
| ------ |--------------|
| Confirm POM parses before coding further | mvn validate |
| Compile production Java only (stops before tests if you use the phase carefully) | mvn compile  |
| Run unit tests | mvn test     |
| Produce `target/customer-service.jar` | mvn package  |
| Run package plus verification checks CI cares about | mvn verify   |
| Put the JAR into your local Maven cache | mvn install  |

4. package
1. validate
6. install
2. compile
5. verify
3. test


Continuous Integration usually runs mvn -B verify so the build is batch/non-interactive and stops after verification without casually installing or deploying from every laptop.


| # | Confirm | Notes |
| - | ------- | ----- |
| 1 | Six intent → command rows match | Pass  |
| 2 | Lifecycle order is correct without `deploy` | Pass  |
| 3 | You state why CI uses `mvn -B verify` | Pass  |
