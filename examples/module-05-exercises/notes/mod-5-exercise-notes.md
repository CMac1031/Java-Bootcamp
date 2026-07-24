### Lab 1 Notes
After adds:  [Java Fundamentals, Clean Code, Effective Java, Java Fundamentals]
After set:   [Java Fundamentals, Clean Architecture, Effective Java, Java Fundamentals]
After remove:[Clean Architecture, Effective Java, Java Fundamentals]


| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Final size is `3` and order matches verified output | Pass  |
| 2 | You can explain why one duplicate remains | Pass  |
| 3 | You can state the valid index range | Pass  |
- There are 2 instances of Java Fundamentals, and we only called to remove 1
- 0 (arrayName).size()-1


### Lab 2 Notes
Sets determine duplicates using equals and hashCode. Strings already implement them. Lab 5 must define identity carefully when custom objects are stored in sets.

| # | Confirm | Your notes |
| - | ------- | -------- |
| 1 | Duplicate add returns `false`; size remains `3` | Pass |
| 2 | Sorted view is `[Databases, Java, Testing]` | Pass |
| 3 | You do not rely on `HashSet` iteration order | Pass |

### Lab 3 Notes
put("ISBN-JAVA", 5) does not create a duplicate key. It changes that key’s value from 3 to 5.


| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Java count changes from `3` to `5` | Pass  |
| 2 | Missing ISBN safely reports `0` | Pass  |
| 3 | You can explain key uniqueness and unspecified order | Pass  |

### Lab 4 Notes
TreeMap keys always iterate in sorted order — that part is guaranteed. HashMap key order is not a contract; it may differ between runs or JDK versions, so never depend on it for display order.

| # | Confirm | Your notes |
| - | ------- |-----------|
| 1 | `TreeMap` prints titles in alphabetical order | Pass      |
| 2 | `firstKey()` / `lastKey()` print the correct titles | Pass  |
| 3 | You can explain why `HashMap` order should never be relied upon | Pass  |

### Lab 5 Notes
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Remaining list is `[Java 21, Clean Code]` | Pass |
| 2 | Failure experiment produces concurrent-modification evidence | Pass  |
| 3 | You can explain the iterator remove protocol | Pass |

### Lab 6:
# Collection choices

| # | Scenario | Need (order / unique / key→value / sorted) | Interface | Implementation | Why                             |
| - | -------- |--------------------------------------------| ------ | -------------- |---------------------------------|
| 1 | Ordered catalog; duplicate titles allowed | order                                      | `List` | ArrayList<> | Indexed sequence; duplicates OK |
| 2 | Unique registered book IDs |                                            | Set<String> | HashSet<> | No duplicates; fast membership  |
| 3 | Book ID → current borrower ID | key → value                                | Map<String, String> | HashMap<> | Direct key → value lookup no dupes |
| 4 | Alphabetically sorted categories | sorted +unique                             | Set<String> | TreeSet<> |    Unique values; natural sort order                             |
| 5 | Category → count, sorted by category | key → value + sorted                       | Map<String, Integer> | TreeMap<> |  Key → value with sorted keys                               |
| 6 | Checkout history in event order | order not unique                           | List<BorrowRecord> | ArrayList<> |      Append + iterate in insertion order                           |

If unique IDs must also preserve registration order, what changes?
- If unique IDs must also preserve registration order, use LinkedHashSet<> instead of HashSet<>. It prevents duplicates while maintaining insertion order.
If borrower lookup must preserve insertion order for display, what changes?
Reference: LinkedHashMap.
- t keeps key-value lookup while iterating entries in insertion order.
If many insertions/removals occur in the middle, is LinkedList automatically best?
Reference: No. Access pattern and traversal cost matter; measure rather than assume.
- No, LinkedList is not automatically best for many middle insertions and removals. Finding a middle position requires traversal, so the overall performance depends on the access pattern; measure instead of assuming.


| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | All six scenarios have interface + implementation | Pass |
| 2 | Choices account for order, uniqueness, or key lookup | Pass  |
| 3 | You can explain when linked or sorted variants matter | Pass  |
- Linked variants such as LinkedLists  matter when insertion order must be preserved while sorted variants such as TreeSet  matter when elements or keys must remain automatically sorted 

## Lab 07
| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | First checkout is `true`; duplicate member checkout is `false` | Pass  |
| 2 | Final list and map match verified output | Pass  |
| 3 | Unavailable-title test leaves state unchanged | Pass  |
| 4 | You can state the checkout invariant | Pass  |