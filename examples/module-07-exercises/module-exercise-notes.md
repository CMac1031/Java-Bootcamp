Step 3:
Each risky statement has its own try. After one catch finishes, execution continues into the next block.
### Pass Criteria for lab 1 
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | All three specific exception names print | Pass  |
| 2 | Final continuation line prints | Pass  |
| 3 | You can name the prevention for each failure | Pass |

Why: Files, readers, and streams close more safely with try-with-resources.

For AutoCloseable resources, prefer Exercise 3. It closes the resource and preserves suppressed exceptions.
### Pass Criteria for lab 2
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Success and failure paths both execute | Pass  |
| 2 | Cleanup prints twice | Pass  |
| 3 | You can explain the normal finally guarantee and limitation | Pass  |

Why: Manual close() is easy to forget on exceptional exits.

Search your code: there should be no reader.close(). Closure occurs when execution leaves the resource block.
### Pass Criteria for lab 3
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Both file lines print | Pass  |
| 2 | No explicit `close()` appears | Pass  |
| 3 | Missing-file path is handled | Pass  |

### Pass Criteria for lab 4
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Both verified messages print | Pass  |
| 2 | Compiler experiment proves checked handling | Pass |
| 3 | You can explain `throw` vs `throws` | Pass  |

### Pass Criteria for lab 5
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Output reports shortfall `50.00` | Pass  |
| 2 | Balance remains `100.00` | Pass  |
| 3 | Caller enforces catch-or-declare | Pass  |

### Pass Criteria for lab 6
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Catch occurs only in `main` | Pass  |
| 2 | Trace includes all four methods | Pass  |
| 3 | You can explain stack unwinding and catch boundaries | Pass  |


- Skip & Continue: importing 10,000 CSV rows — one bad row should not stop the other 9,999.
- Fail Fast: a required config value is missing at startup — do not limp along with a null.
- Graceful Degradation: a recommendations service is down — show the page without recommendations instead of a 500 error.
- Circuit Breaker: a downstream payment API is timing out repeatedly — stop hammering it and fail fast for a cooldown period.
### Pass Criteria for lab 7
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | `fetchWithRetry` shows retry attempts and eventually a result | Pass  |
| 2 | You forced and observed the fallback path | Pass  |
| 3 | You wrote one real scenario each for Skip & Continue, Fail Fast, Graceful Degradation, and Circuit Breaker | Pass  |
-
### Pass Criteria for lab 8
| # | Confirm | Your notes |
| - | ------- | --------- |
| 1 | Log includes severity, operation, demo account ID, and exception | Pass |
| 2 | User message contains no stack trace | Pass  |
| 3 | Catch block is not empty | Pass |
| 4 | You can name data that must never be logged | Pass  |

