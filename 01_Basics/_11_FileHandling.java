// Program to demonstrate File Handling in Java
// Covers: FileWriter, FileReader, BufferedWriter, BufferedReader, File class, delete

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class _11_FileHandling {

    public static void main(String[] args) {

        // -------------------------------------------------------
        // JAVA FILE I/O — KEY CLASSES
        //
        // File          → represents a file/directory path (doesn't read/write)
        // FileWriter    → writes characters to a file
        // FileReader    → reads characters from a file
        // BufferedWriter→ wraps FileWriter for faster, line-based writing
        // BufferedReader→ wraps FileReader for faster, line-based reading
        // PrintWriter   → wraps FileWriter, adds print/println/printf
        // -------------------------------------------------------

        String fileName = "sample.txt";

        // -------------------------------------------------------
        // 1. FILE CLASS — metadata about a file (no reading/writing)
        // -------------------------------------------------------
        System.out.println("---- File class ----");
        File file = new File(fileName);
        System.out.println("File name   : " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Exists?     : " + file.exists());           // false — not created yet

        // Create new file programmatically
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }


        // -------------------------------------------------------
        // 2. WRITING TO FILE — FileWriter + BufferedWriter
        //    FileWriter(name, append) → 2nd arg true = append, false/omit = overwrite
        // -------------------------------------------------------
        System.out.println("\n---- Writing to file (BufferedWriter) ----");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            // try-with-resources — bw is auto-closed after this block
            bw.write("Line 1: Hello, Java File Handling!");
            bw.newLine();       // writes OS-appropriate newline (\n on Linux, \r\n on Windows)
            bw.write("Line 2: Writing with BufferedWriter.");
            bw.newLine();
            bw.write("Line 3: Fast and efficient.");
            bw.newLine();
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }


        // -------------------------------------------------------
        // 3. APPENDING TO FILE — FileWriter(name, true)
        // -------------------------------------------------------
        System.out.println("\n---- Appending to file ----");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write("Line 4: This line was appended.");
            bw.newLine();
            bw.write("Line 5: Append mode keeps existing content.");
            bw.newLine();
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.out.println("Append error: " + e.getMessage());
        }


        // -------------------------------------------------------
        // 4. WRITING WITH PrintWriter (println, printf support)
        // -------------------------------------------------------
        System.out.println("\n---- Writing with PrintWriter ----");
        try (PrintWriter pw = new PrintWriter(new FileWriter("data.txt"))) {
            pw.println("Name: Alice");
            pw.println("Age: 25");
            pw.printf("Score: %.2f%n", 98.5);
            System.out.println("PrintWriter write complete.");
        } catch (IOException e) {
            System.out.println("PrintWriter error: " + e.getMessage());
        }


        // -------------------------------------------------------
        // 5. READING FROM FILE — FileReader + BufferedReader
        // -------------------------------------------------------
        System.out.println("\n---- Reading from file (BufferedReader) ----");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNum = 1;
            // readLine() returns null when end of file is reached
            while ((line = br.readLine()) != null) {
                System.out.println("Line " + lineNum++ + ": " + line);
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }


        // -------------------------------------------------------
        // 6. READING FILE — character by character (FileReader alone)
        // -------------------------------------------------------
        System.out.println("\n---- Reading char by char ----");
        try (FileReader fr = new FileReader("data.txt")) {
            int ch;
            // read() returns the char as int, returns -1 at end of file
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);    // cast int back to char for display
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }


        // -------------------------------------------------------
        // 7. READING USER INPUT AND WRITING TO FILE
        // -------------------------------------------------------
        System.out.println("\n\n---- User input → File ----");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a note to save to file: ");
        String userNote = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("notes.txt", true))) {
            bw.write(userNote);
            bw.newLine();
            System.out.println("Note saved to notes.txt");
        } catch (IOException e) {
            System.out.println("Error saving note: " + e.getMessage());
        }

        // Read back the notes file
        System.out.println("\nContents of notes.txt:");
        try (BufferedReader br = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }


        // -------------------------------------------------------
        // 8. FILE METADATA & DIRECTORY OPERATIONS
        // -------------------------------------------------------
        System.out.println("\n---- File Metadata ----");
        File f = new File(fileName);
        System.out.println("Name        : " + f.getName());
        System.out.println("Path        : " + f.getPath());
        System.out.println("Absolute    : " + f.getAbsolutePath());
        System.out.println("Exists?     : " + f.exists());
        System.out.println("Is file?    : " + f.isFile());
        System.out.println("Is dir?     : " + f.isDirectory());
        System.out.println("Size (bytes): " + f.length());
        System.out.println("Can read?   : " + f.canRead());
        System.out.println("Can write?  : " + f.canWrite());

        // Create a directory
        File dir = new File("myFolder");
        if (dir.mkdir()) {
            System.out.println("\nDirectory 'myFolder' created.");
        }

        // List files in current directory
        File currentDir = new File(".");
        String[] fileList = currentDir.list();
        System.out.println("\nFiles in current directory:");
        if (fileList != null) {
            for (String name : fileList) {
                System.out.println("  " + name);
            }
        }


        // -------------------------------------------------------
        // 9. DELETING FILES
        // -------------------------------------------------------
        System.out.println("\n---- Deleting files ----");
        File toDelete = new File("data.txt");
        if (toDelete.delete()) {
            System.out.println("data.txt deleted successfully.");
        } else {
            System.out.println("Failed to delete data.txt (may not exist).");
        }

        sc.close();
    }
}


/*
=============================================
FILE I/O — FLOW DIAGRAM
=============================================

WRITING:
Your Program
    → FileWriter("filename.txt")        [opens file for writing]
        → BufferedWriter(fileWriter)     [adds buffering for speed]
            → bw.write("text")           [writes to buffer]
            → bw.newLine()               [adds newline]
        → auto-closed by try-with-resources  [flushes buffer + closes]

READING:
File on disk
    → FileReader("filename.txt")        [opens file for reading]
        → BufferedReader(fileReader)     [adds buffering for speed]
            → br.readLine()              [reads one line at a time]
                                        [returns null at end of file]
        → auto-closed by try-with-resources

=============================================
WRITE MODES
=============================================

new FileWriter("file.txt")           → OVERWRITE (default)
new FileWriter("file.txt", false)    → OVERWRITE (explicit)
new FileWriter("file.txt", true)     → APPEND (keeps existing)

=============================================
EXCEPTION HANDLING IN FILE I/O
=============================================

All file operations throw IOException (checked exception).
Options:
1. try-catch block (shown in examples above)
2. throws IOException in method signature (shown in 02_BufferedReader_IO.java)
3. try-with-resources automatically closes stream even if exception occurs

=============================================
JAVA vs C — FILE HANDLING
=============================================

| Feature      | C                     | Java                         |
|--------------|-----------------------|------------------------------|
| Open file    | fopen("f", "r")       | new FileReader("f")          |
| Write        | fprintf, fputs        | fw.write(), bw.write()       |
| Read line    | fgets                 | br.readLine()                |
| Close        | fclose (manual)       | try-with-resources (auto)    |
| Check exists | (manual)              | file.exists()                |
| Delete       | remove()              | file.delete()                |

=============================================
*/

