## Lab 15 Failure Experiments

| # | Experiment | Observation | Conclusion |
|---|---|---|---|
| 1 | Repository `save` throws | Service surfaced the repository exception. CUS-1001 remained stored and CUS-1002 was not added. | Persistence errors are not silently swallowed. |
| 2 | `CLOSED → ACTIVE` and `ACTIVE → PROSPECT` | Both threw `IllegalStateException`. | Keep the transition rules. |
| 3 | Activate CUS-1002 twice | First `PROSPECT → ACTIVE` succeeded; second `ACTIVE → ACTIVE` failed and status remained ACTIVE. | Same-status changes are rejected, matching the README. |

### Reflection
Which inputs are untrusted (all client fields reaching the service)?
- All client-provided fields
Where are authn/authz/validation enforced (shape at facade; meaning in validator; auth still absent)?
- Shape at facade; meaning in validator; auth still absent
Which values are sensitive, and where stored?
- Customer IDs and personal information stored in the repository
