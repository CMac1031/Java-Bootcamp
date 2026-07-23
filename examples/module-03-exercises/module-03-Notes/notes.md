| Term | Easy meaning | Banking example |
| ---- | ------------ | --------------- |
| Entity | A distinct domain thing with identity | Customer `C101` |
| Attribute | Data the entity owns | customer name, account balance |
| Responsibility | Work the entity should perform | account validates a withdrawal |
| Relationship | How entities connect | customer owns accounts |
| Invariant | Rule that must remain true | balance changes only through account methods |

# Banking domain notes

| Entity | Identity | Important attributes | Main responsibility |
| ------ | -------- | -------------------- | ------------------- |
| Customer | customerId | name, email, phone | Maintain customer profile |
| Account | accountNumber | owner, balance, accountType | Protect balance and perform deposits/withdrawals |
| Transaction | transactionId | account, type, amount, timestamp | Record one account operation |

## Relationships

- One Customer can own zero or more Accounts.
- One Account belongs to exactly one Customer.
- One Account can have many Transactions.
- One Transaction belongs to exactly one Account.

## Rules

- An account balance cannot be changed directly from outside Account.
- A deposit amount must be positive.
- A withdrawal cannot exceed the allowed balance.

## Short response to Lab 1 question

Main should only collect user input and coordinate the operation by asking the Account object to perform the withdrawal. Account should decide whether a withdrawal is valid because it owns the balance and is responsible for enforcing rules that protect it. 

### Pass Criteria for Lab 1
 # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `notes.md` identifies at least Customer, Account, Transaction | Pass |
| 2 | Every entity has attributes and one focused responsibility | Pass  |
| 3 | Relationships include one-to-many multiplicities | Pass |
| 4 | You can explain why Account owns withdrawal validation | Pass|
- 
### Pass Criteria for Lab 2
| # | Confirm | Your notes |
| - | ------- | -------- |
| 1 | Demo prints rejection and final balance `120.00` | Pass |
| 2 | Direct `account.balance` access fails to compile | Pass |
| 3 | You can explain why no public `setBalance` exists | Pass |
- 

## Pass criteria for Lab 3

| # | Confirm | Your notes |
| - | ------- | --------- |
| 1 | Savings prints `80.00`; Current prints `78.00` | Pass  |
| 2 | Base-type array contains both subclass objects | Pass  |
| 3 | You can explain `super` and runtime polymorphism | Pass  |

## Pass criteria for Lab 4

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Direct instantiation of `AbstractAccount` fails to compile | Pass  |
| 2 | `AbstractDemo` runs successfully through `AbstractSavings` | Pass  |
| 3 | You can explain why `abstract` forces subclasses to implement the method | Pass  |

## Pass criteria for Lab 5

| # | Confirm | Your notes |
| - | ------- | -------- |
| 1 | Output prints `Customer C101: Aman Singh` | Pass |
| 2 | The reference type in the demo is `Printable` | Pass |
| 3 | You can distinguish `extends` from `implements` | Pass |
- A class uses extends to inherit fields and methods from a parent class. A class uses implements to promise that it provides the methods required by an interface.

## SRP spot-check
The original method could change because the formula changes or because
the output format changes. These are separate responsibilities.

Main should manage menu input, BankService should coordinate banking operations, and domain classes should protect their own state.

## Pass criteria for Lab 6
| # | Confirm | Your notes |
| - | ------- | ------- |
| 1 | Output is `Interest earned: 500.00` | Pass |
| 2 | Calculation and display are separate methods | Pass |
| 3 | You can name both reasons the original method might change | Pass |
| 4 | You can connect SRP to Main / BankService / domain classes | Pass |
- It could change because the bank changes its interest formula.
- Main manages input and program flow, BankService coordinates banking operations.


### Principle checks
O — Open/Closed Principle
Idea: Open for extension, closed for modification — add new behavior by adding a class, not by editing existing ones.

Why: When CurrentAccount was added in Exercise 3, SavingsAccount and Account did not need edits for the new type to work.

Write one sentence confirming that adding FrozenAccount required no changes inside SavingsAccount or CurrentAccount.
Adding FrozenAccount did need a change for Savings Account or Current Account

L — Liskov Substitution Principle
Idea: A subclass must be usable anywhere its parent type is expected, without breaking the caller's expectations.

Why: The loop expects every Account to return a boolean and leave balance unchanged on failure. FrozenAccount honors that contract instead of throwing an unexpected exception.

I — Interface Segregation Principle
Idea: Prefer several small, focused interfaces over one large interface that forces classes to implement methods they do not need.

Why: Exercise 5's Printable has one method, printDetails().

Write one sentence: what would go wrong if Printable also required sendEmailReceipt(), and a SavingsAccount had no email system to call?
SavingsAccount would be forced to implement a method it cannot use because it has no email system.
D — Dependency Inversion Principle
Idea: Depend on an abstraction, not a concrete class, so the concrete implementation can change later.

Why: Declaring Account account = new FrozenAccount(100.00); keeps the caller focused on the shared contract, not one subclass.

Write one sentence explaining why the base type makes later swaps easier.
Using the base type Account makes later swaps easier because the caller can use a different Account subclass without changing the code that depends on the shared Account contract.

## Pass criteria for Lab7
| # | Confirm | Your notes |
| - | ------- | --------- |
| 1 | `FrozenAccount` compiles and runs inside the same loop | Pass |
| 2 | Frozen withdrawal returns `false` and leaves balance unchanged | Pass  |
| 3 | You wrote one sentence for each of OCP, LSP, ISP, and DIP | Pass  |
| 4 | You can name all five SOLID letters from memory | Pass  |


## Pass criteria for Lab8
### Lab 8 Criteria
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Diagram includes all six types | Pass  |
| 2 | Inheritance and interface arrows are correct | Pass  |
| 3 | Customer–Account and Account–Transaction multiplicities appear | Pass  |
| 4 | You can explain the three relationship types | Pass  |