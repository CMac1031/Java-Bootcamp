| Phase | Northstar example |
| --- | --- |
| Arrange | Build CUS-1002 Ravi as PROSPECT |
| Act | Call activate (conceptual) |
| Assert | Status becomes ACTIVE; correlation lab-request-001 logged later |

activate_prospectRavi_setsStatusActive

Step 2 — Name the test
Propose: activate_prospectRavi_setsStatusActive (style only).

Step 3 — Boundary
Note: full Mockito isolation waits for Lab 18; here only structure the test story.
Prepare for Lab 11; do not complete full AI-assisted suite now.
| # | Confirm | Notes |
| --- | --- | --- |
| 1 | AAA table present | Pass  |
| 2 | Test name proposed | Pass  |
| 3 | Lab 18 boundary noted | Pass  |