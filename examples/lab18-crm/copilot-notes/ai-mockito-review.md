## lab18-001

Did it mock the class under test? Reject if yes.
- No 
Are stubs minimal (no unused when)?
- Yes
Does verification match the real validator call order?
- Yes
Any Thread.sleep or real DB?
- no
Run mvn -q test after accepting?
-yes

CoPilot notes:
- Prompt used: Review lab18 tests for Mockito anti-patterns, stubbing, and verification
- did not use the right method name for some reason, had to change that 
- Other than that it gave the correct tests and did not mock the class under test. It also did not use any Thread.sleep or real DB calls. The stubs were minimal and the verification matched the real validator call order. Overall, the tests passed and were accepted.