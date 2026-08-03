### Checkpoint A — Model types

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | ---- |
| 1 | `lab16-crm` under `examples/` | Pass |
| 2 | `ErrorResponse` always includes `correlationId` + `errors` | Pass  |
| 3 | `BusinessException` factories for notFound/conflict | Pass  |

### Checkpoint B — Handler + facade

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | ----- |
| 1 | `GlobalExceptionHandler` maps business/validation/unexpected | Pass  |
| 2 | Facade returns `ApiResult` Ok/Fail | Pass  |
| 3 | Catch order: business before generic | Pass  |

### Checkpoint C — Demo evidence

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | ---- |
| 1 | 400 validation JSON with field errors + `lab-request-001` | Pass |
| 2 | 404 for `CUS-9999` | Pass |
| 3 | 409 illegal transition; `CUS-1001` still ACTIVE | Pass  |

### Checkpoint D — Tests + hygiene

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | ---- |
| 1 | `GlobalExceptionHandlerTest` green | Pass |
| 2 | No stack traces / secrets in client payloads or Git | Pass |
| 3 | Error-model notes + status choices documented | Pass |