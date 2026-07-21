# Notes 
### What is the difference between HelloWorld.java and HelloWorld.class?
HelloWorld.java is the code that the programmer writes which a human can understand easier. While, the HelloWorld.class is the byte size code which a computer can understand. 
### Step 6 table
| Code element | Memory area |
| ------------ | ---------- |
| Locals `x`, `y`, `sum` in `main` | Stack (locals in `main` frame) |
| Parameters `a`, `b` and local `result` in `add` | Stack (`add` frame) |
| Method call `add(x, y)` | New stack frame pushed, then popped on return |
| Class metadata for `Calculator` | Metaspace |
| Temporary `String` for `"Sum = " + sum` | Heap (String / builder intermediates) |

### Step 8 Notes
There are a lot of java.lang.String related classes. 

### Step 10 Notes
size_t InitialHeapSize= 301989888
size_t MaxHeapSize= 4831838208
size_t SoftMaxHeapSize= 4831838208
bool UseG1GC= true 

### Checkpoint A answer
- Pass
- Pass
- Forced error to change class name to HelloPython, but the class name must match the file name in Java. 
- After a successful compile, Java does not need the .java file because the JVM runs the compiled bytecode stored in the .class file.

### Checkpoint B Answer
- Pass
- Pass, it above above this
- The JVM creates a stack  for main, then pushes a new frame containing the arguments when main calls add, add calculates and returns the result, its frame is popped, and main receives the result and continues running
- There is not going to be any change to the class file if you don't recompile it. We see that here. We change the java code then run the old class code. We yield the same result. When we recompile the java code, we get a new .class byte code. So when we run the .class code, we get a different result because we recompiled the new java code.

### Checkpoint C Answer
- Pass (Step 9 SS)
- Pass (Step 8 SS's)
- Pass (Step 10 SS)
- Java CRM service runs bytecode, then stores objects in the heap, and uses threads to process multiple requests

### Cross cutting
- Pass 
- Pass
- Pass

### Cheat Sheet table
| Command | Purpose |
| ------- | ------- |
| `javac File.java` | Compile one source |
| `javac *.java` | Compile all sources (bash; on PowerShell prefer named files) |
| `java ClassName` | Run `ClassName.main` (no `.class` suffix) |
| `javap ClassName` | Show public members |
| `javap -c ClassName` | Disassemble bytecode |
| `javap -c -p ClassName` | Include private members |
| `java -verbose:class ClassName` | Trace class loads (classic) |
| `java -Xlog:class+load ClassName` | Trace class loads (Unified JVM Logging) |
| `java -Xms64m -Xmx64m ClassName` | Set initial / max heap |
| `java -XX:+PrintFlagsFinal -version` | Dump final flag values |

