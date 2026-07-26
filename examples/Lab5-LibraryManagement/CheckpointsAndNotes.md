### Checkpoint A
| # | Confirm | Your notes |
| - | ------- | --------- |
| 1 | `src/com/academy/library/` contains `Book`, `Member`, (`BorrowRecord`), service types, `Main` | Pass  |
| 2 | All files declare `package com.academy.library;` | Pass  |
| 3 | Edited with VS Code and/or IntelliJ per [`_IDE-CONVENTIONS.md`](../../_IDE-CONVENTIONS.md) | Pass  |

### Checkpoint B
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | List / Set / Map / TreeSet / TreeMap fields present as designed | Pass  |
| 2 | Duplicate book/member IDs rejected | Pass  |
| 3 | Borrow uses `HashMap`; return clears the entry | Pass  |

### Checkpoint C
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `javac -d out src/com/academy/library/*.java` succeeds | Pass  |
| 2 | `java -cp out com.academy.library.Main` shows the menu | Pass  |
| 3 | Sample session produces Add / Register / Borrow / Reports themes | Pass  |
| 4 | Exit prints `Thank You` | Pass  |

# Checkpoint D
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Screenshots under `notes/` (or LMS) | Pass |
| 2 | Short note explaining why List vs Set vs Map for each field | Pass |
| 3 | Optional performance table filled | N/A  |
- books and memebers use arrayLists because inserted and deleted easily and efficiently, bookIds and memberIds need to be unique so we use hashsets, BorrowRecords uses HashMap because each book ID is connected to the member ID that borrowed it

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 0 | Module 5 Exercises 1–7 Pass criteria are complete **before** Lab Step 1 | Pass  |
| 1 | Work in `java-bootcamp/examples/Lab5-LibraryManagement/` with `package com.academy.library` | Pass  |
| 2 | List / Set / Map / TreeSet / TreeMap fields wired; duplicate IDs rejected | Pass  |
| 3 | Borrow/return uses `HashMap`; map and availability flag stay in sync | Pass  |
| 4 | `javac -d out src/com/academy/library/*.java` and menu sample session succeed | Pass  |
| 5 | You can justify each collection choice (List vs Set vs Map) in your notes | Pass  |
| 6 | Screenshots/evidence under `notes/screenshots/lab-5/` without secrets | Pass  |