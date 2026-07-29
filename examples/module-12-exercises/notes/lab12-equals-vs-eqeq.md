# Lab 12 — Equals vs ==

## Reference

| Check | Use | Why |
| --- | --- | --- |
| status ACTIVE? | Objects.equals / enum | String identity is unsafe |
| same Customer instance? | == | Reference equality only |
| id CUS-1001? | equals | Value equality |

## Step 2 — Bad snippet

Write a bad line: `if (status == "ACTIVE")` and label it Fail.

## Step 3 — Good snippet

Write a good conceptual check for Amina ACTIVE using equals or enum.
`if (Objects.equals(status, CustomerStatus.ACTIVE))` or `if (status == CustomerStatus.ACTIVE)` and label it Pass.
## Step 4 — JDK note

Note: prefer enums on JDK 21 sketches when status set is closed.

## Scope
Pre-lab only — do not finish the full graded lab in this exercise.

| # | Confirm | Notes |
| --- | --- | --- |
| 1 | File exists at `notes/lab12-equals-vs-eqeq.md` | Pass  |
| 2 | Table plus null-safe row | Pass  |
| 3 | Bad and good snippets present | Pass  |
| 4 | Enum preference noted | Pass  |