### Checkpoint A
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `java-bootcamp/examples/Lab7-ATMSystem/src/com/academy/atm/` exists | Pass  |
| 2 | Four custom exceptions + `Account` + `transactions.txt` + `logs/` present | Pass  |
| 3 | Seed accounts: `1001`/`1234`/$11000 and `1002`/`5678`/$5000 | Pass  |
| 4 | Edited via IntelliJ (or optional VS Code) on your laptop | Pass  |

### Checkpoint B
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `ATMService`, `LoggerUtil`, `Transaction`, `Main` present | Pass  |
| 2 | `javac -d out src/com/academy/atm/*.java` succeeds | Pass |
| 3 | `java -cp out com.academy.atm.Main` from **project root** shows menu 1–7 | Pass  |
| 4 | Exit prints `Thank You` and terminates | Pass  |

### Checkpoint C
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Withdraw more than balance (e.g. `20000` on `1001`) → Insufficient Balance; menu continues | Pass  |
| 2 | Invalid amount / bad PIN / missing account produce ERROR messages (not crashes) | Pass  |
| 3 | Invalid numeric input shows the Part 3 messages and continues | Pass  |
| 4 | `finally` prints return-to-menu text after operations | Pass |
| 5 | try-with-resources handles missing/unreadable `transactions.txt` with the IOException message | Pass |

### Checkpoint D
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `logs/application.log` contains ERROR (and ideally INFO) entries under the project root | Pass |
| 2 | Exception hierarchy notes filled; reflection drafted | Pass  |
| 3 | Screenshots of success **and** failure paths saved (no secrets) | Pass  |


### Success Criteria
| # | Confirm | Your notes |
| - | ------- | -------- |
| 0 | Module 7 Exercises 1–8 Pass criteria are complete **before** Lab Step 1 | Pass |
| 1 | Work in `java-bootcamp/examples/Lab7-ATMSystem/` with `package com.academy.atm` | Pass |
| 2 | Custom exceptions + login/deposit/withdraw; insufficient-funds path works | Pass |
| 3 | Menu recovers after failures; `logs/application.log` has diagnostic entries | Pass  |
| 4 | `javac -d out` / `java -cp out com.academy.atm.Main` succeed **from project root** | Pass  |
| 5 | You can narrate throw site → catch boundary → log → return to menu | Pass  |
| 6 | Screenshots/evidence under `notes/screenshots/lab-7/` without secrets or real PINs | Pass  |