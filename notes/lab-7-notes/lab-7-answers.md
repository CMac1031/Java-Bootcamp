Why are InvalidAmountException and friends checked in this lab, while NullPointerException is unchecked?
- These problems are expected within this business application whereas a NullPointerException is something that fly under the radar that might now be caught until the application is running. 
What does throws on Account.withdraw(...) force callers to do?
- It forces the caller to either catch with a try catch or just a throws clause
Why catch specific exceptions before a broad catch (Exception ex)?
- Specific catches allow to know where the error happened whereas a broad catch can be hard to track down. If there is a ton of Exception ex, it'll be hard to find.
What guarantee does finally give you that catch alone does not?
- It allows the code to run whether there is an exception or not. 
Why prefer try-with-resources over reader.close() in a finally block?
- It requires less code, and automatically closes the reader. 
Why log stack traces to a file while showing short messages to the ATM user?
- It can be confusing for anyone to figure out where a problem is in the code, but they help a lot with stack tracing.
Where should validation throw—deep in Account or only in Main? Why?
- It should happen in Account because main should only handle the tip of the iceberg/user inputs where Account uses/owns all of the data.
How will CRM later reuse “domain exception + boundary catch + log” (without claiming CRM is done today)?
- CRM can throw exceptions for any area in the application. This does not stop the application and tracks all of the exceptions in a log. 

### Reflection Questions:
What is the difference between checked and unchecked exceptions?
- Checked exceptions are expected errors that could be thrown by the programmer that the user could cause. Unchecked usually does not have to be dealt with because they are typically programmer errors.
Why should custom exceptions be used?
- They clearly explain what the problem is in the code, and where the error is occurring. 
What is exception propagation?
- Exception propagation is when teh exception travels through the method calls until it reaches the top of the stack.
What is the purpose of finally?
- Finally is the block that runs after the try, catch blocks. It runs if there is an exception or not. 
Why is try-with-resources preferred?
- It requires less code, and automatically closes the reader, and it less likely to leak memory.
 When should throw be used?
- It should be used inside a method.
When should throws be used?
- It should be used in the method declaration 
Why is logging important in enterprise applications?
- Logging records errors, timestamps, stack traces, and useful context. This is important because it can make finding the issue in the code easier.
What happens if an exception is not handled?
- If it is not handled, it will eventually crash the program.
How does proper exception handling improve software reliability?
- Proper exception handling prevents preventable problems from crashing the program. This also can protect data 
(Forward look) How would a future CRM map domain exceptions (not found / validation) to API errors using the same boundary-catch + log pattern—without claiming CRM is implemented today?
- They could also throw similar exceptions which could prevent application failure. 