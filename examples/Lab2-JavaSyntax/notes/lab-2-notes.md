| Goal | Command theme |
| ---- | ------------- |
| Compile to `../../../out` (Windows) | Named `javac -d out` lines for the three sources |
| Compile to `../../../out` (macOS/Linux) | `javac -d out src/com/academy/student/*.java` |
| Run main | `java -cp out com.academy.student.Main` |
| List sources (Windows) | `Get-ChildItem -Recurse src\*.java` |
| List sources (macOS/Linux) | `find src -name '*.java'` |

### Method map (suggested)

| Class | Methods |
| ----- | ------- |
| `Student` | constructor, getters/setters, `display()` |
| `StudentManager` | `displayMenu`, `addStudent`, `displayStudents`, `searchStudent`, `calculateAverage`, helpers |
| `Main` | `main` + switch |

### `printf` cheat sheet

| Pattern | Meaning |
| ------- | ------- |
| `%-8d` | Left-aligned int, width 8 |
| `%-20s` | Left-aligned string, width 20 |
| `%-8.2f` | Float with 2 decimals |
| `%n` | Platform newline |

---
### Short Answers
- Why must the package folder tree match package com.academy.student?
  - In Java, this allows the compilers to locate and combine classes easier/consistently by name.
- Why prefer nextLine() + parse over nextInt() in a menu app?
  - It less likely to crash the program because you can put anything in nextLine() then parse it and it won't crash. On contrary, if you put anything other than an integer in nextInt() it will crash the program.
- Why keep a studentCount instead of relying on students.length alone?
  - student.lengths is a fixed length while studentCount changes dynamically to know how many students are in the array.
- What belongs in Main versus StudentManager? 
  - There should be very little in main such as the main method, and basic steps to access all the actual work that StudentManager posses. Student Manager should have all of the grunt work in it so the Main looks nice and clean. Student Manager should also look clean, but it is doing all of the work. 
- How does this console CRUD prepare you for later Spring/customer labs without implementing them here?
  - It will later prepare me to apply the CRUD(creating, reading, updating, and deleting records) concept to larger Spring/customer labs 


| # | Confirm | Your notes |
| - | ------- | --------- |
| 0 | Module 2 Exercises 1–7 Pass criteria are complete **before** Lab Steps 3+ | Pass |
| 1 | Package folders match `com.academy.student` under `examples/Lab2-JavaSyntax/src/` | Pass  |
| 2 | `Student` / `StudentManager` / thin `Main` compile and run | Pass  |
| 3 | One shared `Scanner`; add path works for demo `101` / `John` / `Java` / `91` | Pass  |
| 4 | Display prints a `printf` student table | Pass  |
| 5 | Search and average menu paths work | Pass |
| 6 | `javac -d out` and `java -cp out com.academy.student.Main` succeed from the terminal | Pass  |
| 7 | You can explain each layer without copying the solution | Pass  |

