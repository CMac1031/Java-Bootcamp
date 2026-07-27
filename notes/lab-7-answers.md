Why are InvalidAmountException and friends checked in this lab, while NullPointerException is unchecked?
What does throws on Account.withdraw(...) force callers to do?
Why catch specific exceptions before a broad catch (Exception ex)?
What guarantee does finally give you that catch alone does not?
Why prefer try-with-resources over reader.close() in a finally block?
Why log stack traces to a file while showing short messages to the ATM user?
Where should validation throw—deep in Account or only in Main? Why?
How will CRM later reuse “domain exception + boundary catch + log” (without claiming CRM is done today)?