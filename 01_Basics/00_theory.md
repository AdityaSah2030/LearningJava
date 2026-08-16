# Java Theory Basics

Java is a high-level, class-based, object-oriented programming language designed to have as few implementation dependencies as possible.

## 1. JVM, JRE, and JDK

To understand how Java works, you need to understand these three core components:

### JVM (Java Virtual Machine)
- The JVM is an engine that provides a runtime environment to drive the Java Code or applications.
- It converts Java bytecode into machine language. 
- **Platform Dependent**: JVMs are available for many hardware and software platforms. You need a specific JVM for Windows, a different one for Linux, etc. This is what actually runs your code.

### JRE (Java Runtime Environment)
- The JRE is a software package that provides Java class libraries, the Java Virtual Machine (JVM), and other components to run applications written in Java.
- **Purpose**: If you only want to *run* a Java program, you only need the JRE installed. It does not contain development tools like compilers or debuggers.

### JDK (Java Development Kit)
- The JDK is a full-featured software development kit. It contains everything in the JRE, plus development tools such as the compiler (`javac`), an archiver (`jar`), and a documentation generator (`javadoc`).
- **Purpose**: If you want to *write and compile* Java programs, you need the JDK.

## 2. Compilation and Execution in Java

Java uses a unique two-step process: compilation and interpretation (via JVM).

1. **Compilation (`javac`)**: When you compile a Java file (e.g., `Program.java`), the Java compiler doesn't compile it directly to machine code (like C/C++ does). Instead, it compiles it into an intermediate form called **Bytecode** (`Program.class`).
2. **Execution (`java`)**: The JVM takes this Bytecode and translates it into machine code for the specific platform it is running on.

## 3. Platform Independence vs. Platform Dependence

- **Java is Platform Independent (Write Once, Run Anywhere):** The compiled `.class` file (Bytecode) can be run on *any* operating system that has a JVM installed. The Bytecode itself is agnostic to the underlying hardware.
- **The JVM is Platform Dependent:** Because the JVM has to interact with the underlying operating system to execute the machine code, the JVM software itself is specific to each OS (Windows, macOS, Linux).

## 4. JIT (Just-In-Time) Compiler

- The JVM typically interprets Bytecode line by line, which can be slower than running purely compiled code (like C++).
- To optimize performance, the JVM includes the **JIT Compiler**.
- At runtime, the JIT compiler identifies "hot spots" (code that is executed frequently) and compiles that specific Bytecode directly into native machine code. This way, subsequent calls to that code run much faster, combining the portability of Bytecode with the speed of compiled code.
