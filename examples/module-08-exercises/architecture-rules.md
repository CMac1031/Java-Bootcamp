| Dependency | Decision                                                                            | Why |
| ---------- |-------------------------------------------------------------------------------------| --- |
| controller → service | acceptable                                                                          | |
| service → repository | acceptable                                                                          | |
| repository → entity | acceptable                                                                          | |
| entity → controller | problematic: domain depends on transport                                            | |
| repository → controller | problematic: persistence depends on presentation                                    | |
| service → DTO | needs context; acceptable in this lab’s simple mapping, but avoid transport leakage | |
| DTO → repository | problematic: boundary model should not perform storage                              | |

Explain why: changes can ripple both directions, isolated tests become harder, and package ownership is unclear.
It can be ripple in both because other classes rely on the same order that the incomplete classes need to work on. 
controller → service → repository → entity
Higher-level request handling may call inward services and repositories.
Domain/entity and repository packages must not import controller classes.


| # | Confirm | Notes |
| - | ------- | ----- |
| 1 | Seven dependencies classified | Pass  |
| 2 | Cycle is repaired | Pass  |
| 3 | Architecture rule is written | Pass  |