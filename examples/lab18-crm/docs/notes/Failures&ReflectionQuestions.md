### Failure Experiments
| # | Experiment | Observe | Restore |
| - | ---------- | ------- | ------- |
| 1 | Stub `findById` to throw `RuntimeException` | Service/handler error path; test intentionally red/green | Restore Optional stub |
| 2 | Stub ACTIVE Amina; change to PROSPECT | Exception; `never().save` | Keep as permanent negative test |
| 3 | `verify(times(1)).save` then call service twice without reset | Verification failure | Fresh mocks via `@BeforeEach` |
| 4 | Add unused `when(...).thenReturn(...)` | `UnnecessaryStubbingException` | Remove stub or justify `lenient()` in notes |
| 5 | Reject/temporary accept a Copilot `Thread.sleep` | Documents why sleeps banned | Remove sleep |
1. pass
2. pass-test made permanent negative test
3. pass
4. pass
5. A suggested Thread.sleep was rejected because it would make the test slower

### Manual Verification
CustomerServiceMockitoTest isolates DefaultCustomerService from the real Map.
- pass
Activate-Ravi stubs find/save and asserts ACTIVE with lab-request-001.
- pass
Unknown ID verifies never().save.
- pass
ArgumentCaptor asserts Amina’s ID/name/status on save.
- pass
BDDMockito test demonstrates equivalent semantics.
- pass
Lab 17 tests still pass (or intentionally migrated with notes).
- pass
Illegal transition stub path never saves (optional but recommended).
- pass
No sensitive values in tests or Git.
- pass
Two consecutive mvn test runs match.
- pass
README documents which suites are mocked vs real-repo.
- pass

### Reflection Questions
Which design decision most affected correctness (shared mock repo vs @InjectMocks alone)?
- Using one shared mocked repository for both CustomerValidator and DefaultCustomerService most affected correctness.
What evidence proves the implementation works (captor values, never().save)?
- The ArgumentCaptor verifies the correct values are saved, and never().save confirms no invalid transitions are persisted.
Which failure was hardest to diagnose (UnnecessaryStubbing, wrong verify count, …)?
- The hardest failure to diagnose was the UnnecessaryStubbingException, which occurred when a stubbed method was not called during the test. This required careful review of the test logic and stubbing to ensure that only necessary stubs were present.