### Exercise 1 Notes

main frame is created.
Person is allocated; main.person refers to it.
Calling printPerson creates a second frame.
Both frames temporarily hold references to the same Person.
printPerson returns; its frame is removed.
main returns; its frame is removed.

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Program compiles and prints the verified output | Pass  |
| 2 | You can identify both stack frames | Pass  |
| 3 | You can distinguish `person` reference from `Person` object | Pass |
- he lowercase person variable is a reference stored in a stack frame, while the Person object created with a constructor is the actual object allocated on the heap.

### Exercise 2 Notes
An object is not collectible merely because one reference becomes null.
It becomes GC-eligible only when no live strong-reference path can reach it.
Eligibility does not guarantee immediate collection, and System.gc() is only
a request.

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Output confirms both references initially share one object | Pass |
| 2 | You identify the exact GC-eligibility point | Pass  | 
| 3 | You state that `System.gc()` is not guaranteed | Pass  |
- when you set the variable to null this 
- You can request that the gc does its job, but that is if the JVM wants to do it 

### Exercise 3 Notes

The program allocated about 250 MB over time despite a 64 MB maximum heap.
GC log entries appeared between rounds. A before/after value that decreased
shows that memory was reclaimed. Exact pause times varied on my machine.

| # | Confirm | Your notes |
| - | ------- | --------- |
| 1 | Program completes under `-Xmx64m` | Pass |
| 2 | You captured one GC event and one completion line | Pass  |
| 3 | You can explain “allocated over time” vs “simultaneously live” | Pass |
- Allocated over time” is the total number of objects created during the program, while simultaneously live is the number of objects still reachable at the same moment.

### Exercise 4 Notes

Command:
java -XX:+UseG1GC -Xms16m -Xmx64m -Xlog:gc GcObserve

Evidence:
The log began with "Using G1" and showed G1 evacuation pauses.
The collector flag selects G1; it does not guarantee a particular pause time.

| # | Confirm | Your notes |
| - | ------- | -------- |
| 1 | Log explicitly says `Using G1` | Pass |
| 2 | Program still completes under the bounded heap | Pass |
| 3 | You can explain why exact pause duration is not guaranteed | Pass |
- pause times depend on allocation patterns, live objects, heap pressure, hardware, and JVM decisions. 

### Exercise 5 Notes
Command:
java -XX:+UseZGC -Xms16m -Xmx64m -Xlog:gc GcObserve

Evidence:
The log began with "Using The Z Garbage Collector" instead of "Using G1".
Pause-related log lines look different — ZGC does most of its work concurrently,
so it does not report the same kind of stop-the-world "Evacuation Pause" G1 does.

| # | Confirm | Your notes |
| - | ------- | ---------- |
| 1 | Log explicitly says `Using The Z Garbage Collector` | Pass |
| 2 | Program still completes under the bounded heap | Pass  |
| 3 | You can name one difference between the G1 and ZGC log output | Pass  |
- G1 logs additional events while the ZGC just logs the GC making it faster.

### Exercise 6:
loaded RetentionDemo class
→ static CACHE field
→ ArrayList entries
→ byte[] objects

| # | Confirm | Your notes |
| - | ------- | --------- |
| 1 | Program safely retains exactly 10,000 objects | Pass |
| 2 | You trace the static-field retaining path | Pass |
| 3 | You explain why GC cannot free reachable objects | Pass |
| 4 | You name at least one bounded-cache fix | Pass |
- The garbage collector cannot reclaim the arrays while the reachable static collection still holds strong references to them.
- The program can clear unused entries, impose a maximum cache size, or use an eviction policy.