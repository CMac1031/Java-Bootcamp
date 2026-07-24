### Lab01 
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | All four files compile and `LambdaDemo` runs | Pass  |
| 2 | Both implementations return `true` at 60,000 | Pass  |
| 3 | Both implementations return `false` at 75,000 | Pass  |
| 4 | You can explain what `employee -> ...` means | Pass  |

### Lab02:
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Exactly four employees print at the 60,000 threshold | Pass  |
| 2 | Evan does not appear in the filtered output | Pass |
| 3 | Source size remains 5 and filtered size is 4 | Pass  |
| 4 | You can explain why `filter` is an intermediate operation | Pass |

### Lab03:
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | All five names print in source order | Pass |
| 2 | Lambda and method-reference versions match | Pass |
| 3 | Uppercase transformation works | Pass  |
| 4 | You can explain the `Employee` → `String` type change | Pass  |

### Lab04
| # | Confirm | Your notes |
| - | ------- |------------|
| 1 | Highest output is Diana — 90000 | Pass       |
| 2 | Lowest output is Evan — 55000 | Pass       |
| 3 | The same comparator is reused for both reductions | Pass       |
| 4 | You can explain the purpose of `Optional` here | Pass |
### Lab05
map produced a new list of proposed values; it did not modify the immutable Employee records in the source list
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Alice's proposed salary is 79200.00 | Pass  |
| 2 | All five proposals are correct | Pass |
| 3 | Alice's original salary remains 72000.00 | Pass  |
| 4 | You can explain why this is a transformation, not mutation | Pass  |
- it just creates a new salary it doesn't mutate the orginal value 

### Lab06

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Finance, HR, and IT counts are 1, 2, and 2 | Pass  |
| 2 | Output is deterministic and alphabetical | Pass  |
| 3 | Adding Fatima changes only Finance to 2 | Pass  |
| 4 | You can explain grouping key versus downstream collector | Pass  |

### Lab07
filter: Stream<Employee> -> Stream<Employee>
map:    Stream<Employee> -> Stream<String>
sorted: Stream<String>   -> Stream<String>
toList: Stream<String>   -> List<String>

Employee object contains both the department and name while the mapped String contains only the employee’s name and no longer provides access to department 

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Output is exactly `[Alice, Charlie]` | Pass  |
| 2 | The pipeline contains filter, map, sorted, and toList | Pass  |
| 3 | Case-insensitive test works | Pass  |
| 4 | You can trace the element type after each operation | Pass  |

### Lab08
Parallel stream operations should be:

stateless;
free of shared mutable counters or lists;
independent between elements;
associative when reducing;
large or expensive enough to justify splitting work.

Why: Parallel pipelines are only trustworthy when each element can be processed independently.

The predicate reads one immutable Employee and returns a boolean. It does not write shared state, so processing order cannot change the count.

| Run | Sequential ns | Parallel ns | Faster |
|---|---:|---:|---|
| 1 | 749459 | 1125167 | Sequential |
| 2 | 767917 | 1108208 | Sequential |
| 3 | 277917 | 1034167 | Sequential |
| 4 | 254000 | 1159500 | Sequential |
| 5 | 272125 | 871167 | Sequential |

Sequential execution was faster in all five recorded runs. Sequential is better when there is small amount of data, but parallel is better when there is a ton of data.

