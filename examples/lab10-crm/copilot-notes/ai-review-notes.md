## lab10-001 — weak vs strong (entity)
- Date:
- Weak prompt used:
- Output summary:
- Strong prompt used:
- Output summary:
- Decision: accept / reject / partial
- Reason (1 sentence):

## lab10-002 — weak vs strong (addCustomer)
- 
## lab 10-003 
| # | Confirm | Your notes |
| - | ------- | --------- |
| 1 | Every import resolves against `pom.xml` deps actually present (no phantom JPA/Spring imports) | Pass  |
| 2 | Business rules from the prompt appear in code (blank ID rejected, duplicate ID rejected, unknown ID rejected)—not only in comments | Pass  |
| 3 | `equals` / `hashCode` based on `customerId` only | Pass  |
| 4 | You could explain every line to a reviewer with Copilot turned off | Pass `|
| 5 | No hardcoded secrets, real customer PII, or inappropriate test data committed | Pass  |

## lab10-004 - answer questions
What real customer data did you avoid typing into Chat, and what did you use instead (CUS-1001 / CUS-1002)?

If Copilot suggests a block that looks copied verbatim from a known library/article, what do you do before accepting?
What is your team’s rule for code Copilot generates that you do not fully understand?