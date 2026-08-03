# Lab 18 — Stub vs Verify

Stub: when(repo.findById("CUS-1002")).thenReturn(raviProspect)
Verify: verify(repo).save(…)
Both: stubs feed inputs; verifies prove side-effect calls.

## Scope
Pre-lab only.
## Stub (arrange)

```java
when(repository.findById("CUS-1002"))
        .thenReturn(Optional.of(raviProspect));
```

## Verify (assert)

```java
verify(repository).findById("CUS-1002");
verify(repository).save(raviActive);
```
## One Sentece-both roles
Studs provide controlled Inputs into a system under test, while Verifies assert that the system under test interacted with its dependencies as expected.

## Scope
Pre-lab only.