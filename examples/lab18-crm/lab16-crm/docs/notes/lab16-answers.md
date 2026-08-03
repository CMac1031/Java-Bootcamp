### Failure Experiments
1. Repository throws bare RuntimeException
- The unexpected exception is converted into a generic `500 INTERNAL_ERROR` response.
- The client receives `Unexpected server error`, but the internal repository message and stack trace are not exposed.
2. Blank fullName + bad email together
-  `400 VALIDATION_FAILED` response occurs.
- Both validation problems appear in the `errors` map: `fullName` is blank and `email` is malformed.
3. 	Not-found twice for CUS-9999
- Both requests return `404 CUSTOMER_NOT_FOUND`.
- The message clearly states `Customer not found: CUS-9999`.

### Manual Verification
Create/get CUS-1001 still succeeds (Ok path).
- pass
Invalid email → 400 with errors.email and correlation.
- pass
CUS-9999 → 404 payload.
- pass
Illegal transition → 409 payload; status unchanged.
- pass
Correlation on every failure.
- pass
No stack traces in client-facing JSON.
  -pass 
Handler unit tests pass.
- pass
No secrets in Git; target/ ignored.
- pass
README documents status choices.
- pass
You can explain Spring @ControllerAdvice mapping in one paragraph.
- pass

### Reflections questions
Which design decision most affected correctness?
- Creating one centralized error model with BusinessException, ErrorResponse, and GlobalExceptionHandler most affected correctness.
What evidence proves the implementation works?
- Maven running all of the tests then passing, and the manual verification of the expected responses for various failure scenarios provide evidence that the implementation works as intended.
Which failure was hardest to diagnose?
- It was updating all of the tests from lab 15 to use the new error model and ensuring that the correct exceptions were thrown and handled properly. This required careful attention to detail and a thorough understanding of the new error handling structure.