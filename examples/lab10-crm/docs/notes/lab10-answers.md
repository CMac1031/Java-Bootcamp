### Manual Verification
Copilot status Ready; workspace is lab10-crm.
-pass
Customer / CustomerStatus compile with zero JPA/Spring imports.
-pass
CustomerService rejects blank ID, duplicate ID, unknown ID on update.
-pass
Main prints both sample customers; PROSPECT list includes CUS-1002; after activation status is ACTIVE.
-pass
ai-review-notes.md has lab10-001–lab10-004.
At least one deliberately caught Copilot mistake documented.
No real PII/secrets in prompts or committed files.
git status shows no staged target/ or IDE junk.
mvn -q clean compile succeeds.
You can explain accepted AI lines without reopening Chat

### Reflection Questions
Most dangerous suggestion you caught, and how.
- 
One prompt change that improved the accepted output.
- Being very specific about the expected behavior of the `addCustomer` method, including edge cases like duplicate IDs and blank IDs, helped improve the output.
What you would tell a tech lead to prove you did not blind-accept AI.
- I would tell them that I carefully reviewed each AI-generated line, ensuring it aligned with our coding standards and requirements, and that I tested the code thoroughly before committing it.