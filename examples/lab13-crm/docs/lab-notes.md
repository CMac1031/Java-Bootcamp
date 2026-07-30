| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Namespace URI published | Pass / Fail |
| 2 | WSDL location placeholder documented | Pass / Fail |
| 3 | Three operations named and described | Pass / Fail |
| 4 | Sample success envelopes for CUS-1001 / CUS-1002 | Pass / Fail |
| 5 | Fault examples for not-found and validation | Pass / Fail |
| 6 | Correlation ID convention (`lab-request-001` style) | Pass / Fail |
| 7 | Explicit note: implementation arrives in Lab 24 | Pass / Fail |
| 8 | Optional: screenshot of VS Code XSD/WSDL outline | Pass / Fail |

## Implementation Checkpoints

### Checkpoint A — Layout + XSD core


| # | Confirm | Your notes |
| - | ------- | --------- |
| 1 | `lab13-crm` under `examples/` with contracts/samples/docs | Pass  |
| 2 | `operation-matrix.md` lists three operations | Pass  |
| 3 | `customer.xsd` has CustomerStatus + CustomerType | Pass  |

### Checkpoint B — Full contract


| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Six request/response elements present | Pass  |
| 2 | WSDL messages + portType for Create/Update/Get | Pass  |
| 3 | document/literal binding + placeholder `localhost:8080/ws` | Pass  |

### Checkpoint C — Samples + faults

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | --------- |
| 1 | Create/Update/Get success samples with correct namespaces | Pass  |
| 2 | CUS-1001 / CUS-1002 / lab-request-001 used consistently | Pass  |
| 3 | Not-found + validation fault samples present | Passl |

### Checkpoint D — Handoff + experiments

_Mark **Pass** or **Fail** in your lab notes._

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | README checklist complete; Lab 24 note explicit | Pass  |
| 2 | Well-formedness evidence captured | Pass  |
| 3 | Failure experiments documented | Pass  |
| 4 | No secrets; no running SOAP server claimed | Pass  |

Which design decision most affected partner usability?
-Using one consistent namespace and providing complete request, response, and fault samples most improved partner usability.

What evidence proves the contract is implementable in Lab 24?
-The WSDL defines CreateCustomer, GetCustomer, and UpdateCustomer, and all contract and sample XML files pass xmllint well-formedness checks.

Which failure was hardest to diagnose (namespace vs element name)?
- The failure that was hardest to diagnose was the schemaLocation mismatch, which caused a schema validation error in SOAPUI. It required careful checking of the WSDL and XSD files to identify the incorrect reference.