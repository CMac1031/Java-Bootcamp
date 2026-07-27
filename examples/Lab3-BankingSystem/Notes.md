## SOLID PRINCIPLES
| Principle | Lab 3 evidence |
| --------- | -------------- |
| SRP | Models vs `BankService` vs thin `Main` |
| OCP | New account type via subclass, not editing every switch in models |
| LSP | Savings/Current usable wherever `Account` is expected |
| ISP | Small `Printable` with one method |
| DIP | Menu depends on `BankService` API, not raw arrays |
- Each class has one  job.  Whether that is the Accounts, BankService, or Main, they each serve a purpose within the package.
- Account.java can be extended to other subclasses without editing the classes that it has extended to.
- A subclass should be able to work where it there is a parent class without breaking.
- Prefer small interfaces because you can implement it wherever you need, but it is not foreced to be there
- Its better to rely on something more robust within a system than some thing that can dynamicallly change.

| Checkpoint | You have… | Pass or fail |
| ---------- | --------- |--------------|
| A — Model | Customer, abstract Account, Savings, Current, Printable, Transaction | Pass | 
| B — Service + menu | `BankService` + `Main` compile |Pass |
| C — Operations | Create, deposit, withdraw, polymorphic display |Pass |
| D — Design | UML + SOLID checklist done |Pass |

### Reflection Questions
Why should Account be abstract rather than a concrete empty type?
- It should abstract because you can modify the methods without changing the class. 
Where does dynamic dispatch show up when you call displayAccount() on Account[]?
- It occurs when the JVM decides which method to call. 
How does Printable differ from extending a base class?
- Printable is an Interface it can be implemented by multiple classes while a base class can only extend one class.
What would break if Main owned all arrays instead of BankService?
- This break SRP(Single Responsibility Princinple) because it would make the main class handle more than one thing. This would make it harder to manage the system and fix bugs. 
How do today’s Customer/Account patterns prepare you for later CRM entity design without building Spring here?
- A future CRM could apply the same patters as Customer and Account use to bigger scalable enterprises such as Spring services. 

### Success Criteria 
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 0 | Module 3 Exercises 1–8 Pass criteria are complete **before** Lab Steps 3+ | Pass  |
| 1 | Package folders match `com.academy.bank` under `examples/Lab3-BankingSystem/src/` | Pass  |
| 2 | Abstract `Account` hierarchy + `Printable` compile; cannot `new Account(...)` | Pass |
| 3 | Create customer C101 + savings; deposit/withdraw work | Pass  |
| 4 | Polymorphic display via `Account[]` (no unnecessary casts) | Pass  |
| 5 | Thin `Main` + `BankService` orchestration; SOLID checklist explained | Pass  |
| 6 | UML matches files (includes service/Main growth from Exercise 8) | Pass |
| 7 | `javac -d out` and `java -cp out com.academy.bank.Main` succeed | Pass  |