### Manual Verification:
mvn -q clean test passes (≈7 tests, document exact count).
- pass 
CustomerTest proves equals/toString with real assertions.
- pass
CustomerServiceTest covers add / duplicate / update / unknown-ID.
- pass
Mock test verifies notifier args for CUS-1002.
- pass
CustomerNotifier is a useful extraction—not a Spring/JPA paste.
- pass
Notes lab11-001–lab11-004 present.
- pass
At least one false-confidence assertion rejected.
No secrets / real PII in tests or prompts.
git status clean of target/ junk.
You can explain every accepted AI test/refactor without reopening Chat.