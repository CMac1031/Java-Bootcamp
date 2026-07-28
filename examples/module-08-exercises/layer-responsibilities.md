## Layer map

| Layer/package | Owns | Does not own |
| ------------- | ---- | ------------ |
| `controller` | Transport boundary, request/response mapping | Business rules, storage |
| `service` | Validation, orchestration, business policy | HTTP details, SQL |
| `repository` | Save/find abstraction | UI formatting, business workflow |
| `entity` | Domain state/identity | HTTP request shape |
| `dto` | Boundary input/output shape | Persistence behavior |
| `config` | Object/application configuration | Customer operations |
| `exception` | Meaningful failure types | Catch-all utility logic |

| Task | Layer      |
| ---- |------------|
| Accept future create-customer input | customer   |
| Reject blank customer name | service    |
| Find customer by ID | repository |
| Represent customer ID/name/status | entity     |
| Represent create request fields | dto        |
| Define customer-not-found failure | config     |
| Wire application objects later | exception  |

Controller maps request
→ Service validates/orchestrates
→ Repository saves/finds
→ Service returns result
→ Controller maps response

isolated testing;
replacing storage without changing controller;
keeping transport concerns out of business logic;
making ownership discoverable.

Layer boundaries allows different parts of the system to be tested separately. Storage can be replaced without a controller due to the fact the controller can communicate through the service. ALso it is very easy to estabilish what is theirs. 


| # | Confirm | Notes |
| - | ------- | ----- |
| 1 | Seven tasks assigned correctly | Pass |
| 2 | God-controller flow repaired | Pass |
| 3 | You explain at least two benefits of boundaries | Pass |

