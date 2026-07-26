What are the advantages of Streams over loops?
- Streams require less manual management of indexes, temporary collections, and mutable variables. This often makes data-processing code more concise, readable, and less prone to mistakes. Streams are not necessarily faster or more memory-efficient than loops, but they can make complex collection operations easier to understand and maintain.
When should Streams be preferred?
- Streams should be preferred when dealing with large collections of data that needs to be sorted,transformed, filtered, grouped, or calculated in a specific order. It is specially useful whenever there is a clear requirement for them to be used. 
What is the difference between filter() and map()?
- filter() gets rid of the data that does not meet the conditions while map() transform that said value into a new one. 
Why is reduce() useful?
- It is useful because it can combime multiple elements into one result.
What does Collectors.groupingBy() do?
- It groups the collection into some sort of category or map. For example, if you would group by department, it would group the employees by departmemnt.
What is the benefit of using Optional?
- Optional safely represents a value that may not exist, such as the result of finding the highest-paid employee in an empty list. It requires the programmer to handle the missing result and helps prevent NullPointerException errors.
Why are Lambda Expressions more readable?
- It is more concise and readible because there is less code to read and understand. It can turn multiple lines of code into 1 line and the programmer can easily understand what is happening.
When should method references be used?
- References should only be used when they just call a prexisting method without adding additional logic. 
Which stream operation is terminal? Give three examples from your lab.
- forEach(),count(), collect() are all terminal because they all trigger intermediate functions.
How do Streams improve enterprise Java applications?
- They improve code readibility, and maintability. This makes the code more robust, and easier to test.
(Forward look) How would a future CRM use filter / map / groupingBy on customers the same way this lab uses them on employees—without claiming the CRM is implemented today?
- A future CRM could use filter to select active customer in a certain region, map could transform customer objects into something they need, and groupingBy() could organize customers by whatever they see fit. 
