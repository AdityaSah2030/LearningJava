# Java Environment Setup

Welcome to the Java learning repository!

## Prerequisites
To compile and run Java code, you need the Java Development Kit (JDK) installed on your system.

### Installing the JDK
- Download the latest **JDK** (Java Development Kit) from the official Oracle website or use an open-source build like **Adoptium (Eclipse Temurin)** or **Amazon Corretto**.
- Ensure that the JDK `bin` directory is added to your system's `PATH` environment variable.

### Verifying Installation
Open your terminal or command prompt and run:
```bash
java -version
javac -version
```
If both commands return a version number, your setup is correct.

## Compiling and Running Java Code
Java uses a two-step process to run code.

1. **Compile**: 
   ```bash
   javac FileName.java
   ```
   This compiles your source code into Bytecode and creates a `FileName.class` file.

2. **Run**:
   ```bash
   java FileName
   ```
   This starts the JVM and runs the `.class` file (do not add the `.class` extension when running).

## IDEs and Text Editors
You can use any text editor or IDE. Recommended ones include:
- **IntelliJ IDEA** (JetBrains IDE)
- **Eclipse**
- **Visual Studio Code (VS Code)** (with Java Extension Pack)
