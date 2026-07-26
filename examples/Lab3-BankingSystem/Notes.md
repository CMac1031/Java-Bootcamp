## SOLID PRINCIPLES
| Principle | Lab 3 evidence |
| --------- | -------------- |
| SRP | Models vs `BankService` vs thin `Main` |
| OCP | New account type via subclass, not editing every switch in models |
| LSP | Savings/Current usable wherever `Account` is expected |
| ISP | Small `Printable` with one method |
| DIP | Menu depends on `BankService` API, not raw arrays |
- Each class has one main job. Customer, Account, and Transaction represent banking data and rules. BankService coordinates operations, while Main only displays the menu and calls service methods.
- The account model can be extended with another subclass, such as BusinessAccount, without changing the existing SavingsAccount or CurrentAccount classes. Shared loops using Account can automatically work with the new subclass.
- A SavingsAccount or CurrentAccount can be used anywhere an Account is expected. For example, both can be stored in Account[], and calling withdraw() or displayAccount() executes the appropriate overridden method.
- Printable is a small interface containing only printDetails(). Classes implementing it are not forced to implement unrelated operations such as sending emails or processing payments.
- Main asks BankService to perform banking operations instead of directly accessing the customer, account, and transaction arrays. This keeps menu code separated from storage details.

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
- 
How does Printable differ from extending a base class?
- Printable is an Interface it can be implemented by multiple classes while a base class can only extend one class.
What would break if Main owned all arrays instead of BankService?
- This break SRP(Single Responsibility Pricinple) because it would make the main class handle more than one thing. This would make it harder to manage the system and fix bugs. 
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