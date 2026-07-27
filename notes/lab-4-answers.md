===== Performance Measurement =====

===== JVM Memory Report: Start =====
Total Memory : 130 MB
Free Memory  : 127 MB
Used Memory  : 2 MB
Max Memory   : 512 MB
-----------------------------

Objects      Used Memory    Execution Time
--------------------------------------------------
10           0.00 MB        1.445 ms          
100          0.46 MB        0.064 ms          
1000         0.46 MB        0.304 ms          
100000       10.46 MB       6.737 ms          
1000000      107.02 MB      61.537 ms

Additional measurements:
Loop execution (10M iterations) : 16.454 ms | sum = 49999995000000
int[1,000,000] allocation       : 4.103 ms

===== JVM Memory Report: Before Large byte[] =====
Total Memory : 128 MB
Free Memory  : 126 MB
Used Memory  : 1 MB
Max Memory   : 512 MB
-----------------------------

===== JVM Memory Report: Before Large byte[] =====
Total Memory : 128 MB
Free Memory  : 126 MB
Used Memory  : 1 MB
Max Memory   : 512 MB
-----------------------------

===== JVM Memory Report: After Large byte[] =====
Total Memory : 128 MB
Free Memory  : 115 MB
Used Memory  : 12 MB
Max Memory   : 512 MB
-----------------------------

===== JVM Memory Report: After Releasing Large byte[] =====
Total Memory : 128 MB
Free Memory  : 126 MB
Used Memory  : 1 MB
Max Memory   : 512 MB
-----------------------------
Stack vs Heap?
-Stack is for short term use such as local variables, method calls , and references. Heap Stores created objects and arrays that may use other methods.
Why locals on the Stack?
- Variables belong to the method that is sitting in the stack, so when the method finishes method is popped.
Why objects on the Heap?
- Objects may need to stay alive when the method is popped, so this information is stored in the heap 
When is an object GC-eligible?
- Whenever an object no longer has a strong reference or null value.
Does System.gc() guarantee collection?
- No, it does not. It is a recomendation 
What caused the leak?
- We kept adding static objects to an array and it was out of reach for the garbage collector 
How did clearing the list fix it?
- Allocate into a local list and nulls the references, so the garbage collector can remove them
Why are WeakReferences useful?
- It can be useful for temporary objects
What happens when the heap is exhausted?
- JVM tries to get the memory back through garbage collection.
Which laptop tool would you try first for rising heap—and why?
- not sure..
How could a CRM unbounded cache repeat this leak?
- YOu can have a lot of customer data that floods and causes the  leak