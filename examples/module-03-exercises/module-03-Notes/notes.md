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

### Pass Criteria for Lab 2
| # | Confirm | Your notes |
| - | ------- | -------- |
| 1 | Demo prints rejection and final balance `120.00` | Pass |
| 2 | Direct `account.balance` access fails to compile | Pass |
| 3 | You can explain why no public `setBalance` exists | Pass |

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