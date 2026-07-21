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


| # | What to capture | How | Pass criteria                                        | Pass or Fail |
| - | --------------- | --- |------------------------------------------------------|--------------|
| 1 | Java / javac versions | Terminal screenshot | OpenJDK **21** visible                           |    Pass          |
| 2 | Successful compilation | `javac` + listing of `.class` files | Four `.class` files present                          | Pass         |
| 3 | Program outputs | Run all four mains | Exact strings from Expected results                  | Pass         |
| 4 | Bytecode | `javap -c HelloWorld` (and ideally Calculator) | `getstatic`/`ldc`/`invokevirtual` visible            | Pass         |
| 5 | Class loading | `-verbose:class` or `-Xlog:class+load` | JDK classes + `Employee`                             | Pass         |
| 6 | Sources in Explorer | IDE screenshot | Folder `jvm-compilation-lab` with four `.java` files | Pass         |
| 7 | (Optional) Flags | `PrintFlagsFinal` filter | `MaxHeapSize` / `UseG1GC` lines                      | Pass         |

### Security Questions
- Why might an enterprise forbid copying raw .class files between machines without a reproducible build (Maven/CI)? 
  - Most enterprise already have the source for this stuff, so it would be redundant to copying the raw code.
- If a future CRM JVM writes a heap dump on OOM, what privacy risk appears if customer PII sits in memory? Who should access dumps?
  - Heap dump might contain too much private information which could leak to the public. It should be accessed to classified personel.
- Why must you never print passwords or cloud access keys—even in a tiny training main?
  - Someone could steal the details, abuse the passcode, then impersonate someone to steal the data or leak it. 
- What risk exists if a malicious Employee.class appears earlier on the classpath than your build output?
  - It could be malicious which could harm the codebase, steal data, and execute unauthorized actions as a code.
- Why is casually setting -Xmx without matching container memory limits dangerous in production?
  - It could contain too much memory which would infringe on the heap. This could cause the program to crash. 
-  Name three controls Northstar would add before real customer workloads (non-root user, memory limits, CI-signed artifacts, no secrets in logs).
  - Run application as non-root user, enforce memory limits, prevent sensitive information to get into the logs.


### Short lab report answers
- What does javac do?
  - It compiles the java code(programmer code) to produce byte code for the computer to run. 
- What is bytecode?
  - compiled code from the java source code
- Why is bytecode platform-independent?
  -  So it can be run on any operating system
- What is the role of the JVM? 
  - It can load, verify and run byte code. 
- Where are objects stored? 
  - Objects are stored in the JVM’s heap memory.
- Where are method calls / frames stored?  
    - Method calls are stored in the thread's class. 
- What happens when a class is loaded?
  - JVM finds class file then it loads it into memory then it verifies to for use. 

### Reflection Questions 
- Which mental model changed most: “Java runs my .java file” versus “JVM runs bytecode”?
  - My original understanding was that the JVM ran Java source code directly. Now, I understand the complete compilation process: javac compiles the .java source code into bytecode, which is stored in a .class file and executed by the JVM.
- Why does enterprise onboarding spend time on javap before Spring annotations?
  - Javap provides an understanding of the bytecode generated by the Java compiler and shows the instructions the JVM executes when running the program.
- When Calculator printed a stale result, what process would you use in a large Maven CRM project to avoid the same bug class?
  - I would just remove extra or non-needed classes so I would remove all of them. 
- How does loading hundreds of classes at startup explain “JVM process up” versus “application ready”? 
  - There are multiple processes in a JVM so a process could be finished but an application could not be ready. 
- What evidence would convince a grader the bytecode screenshot is from your HelloWorld? 
  - If it was my terminal, it would have my unique path in it also, the unique bytecode produced. 
- Looking forward: which Lab 1 idea will matter first when the CRM runs under Docker—heap limits, class loading, or bytecode inspection?
  - Heap memory limits will matter the most because we need the JVM memory limit to fit with the container's limit.


