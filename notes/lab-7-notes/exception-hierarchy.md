| Exception                  | When is thrown                                            | Where it is caught          |
|----------------------------|-----------------------------------------------------------|-----------------------------|
| InvalidAmountException     | It is used when there is an amount entered is negative or 0 | it is caught in bankService |
| InsufficientFundsException | It is used when the requested > than amount actually in the account | It is caught in ATM service |
| InvalidPinException        | When the entered pin does not match teh accounts pin      |  it is caught in bankServices                        |
| AccountNotFoundException   | Account number entered when it is not a valid account     |  it is caught in bankServices                        |
-