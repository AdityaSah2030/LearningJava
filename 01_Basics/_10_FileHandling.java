// Program to demonstrate File Handling in Java

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _10_FileHandling {

    public static void main(String[] args) throws IOException {

        File file = new File("example.txt");


        // -------------------------------------------------------
        // 1. CREATE FILE
        // -------------------------------------------------------

        if (file.createNewFile()) {
            System.out.println("File created.");
        } else {
            System.out.println("File already exists.");
        }


        // -------------------------------------------------------
        // 2. FILE INFORMATION
        // -------------------------------------------------------

        System.out.println("\n---- File Information ----");

        System.out.println("Name        : " + file.getName());
        System.out.println("Path        : " + file.getPath());
        System.out.println("Absolute    : " + file.getAbsolutePath());
        System.out.println("Exists      : " + file.exists());
        System.out.println("Is File     : " + file.isFile());
        System.out.println("Is Directory: " + file.isDirectory());
        System.out.println("Readable    : " + file.canRead());
        System.out.println("Writable    : " + file.canWrite());
        System.out.println("Size        : " + file.length() + " bytes");


        // -------------------------------------------------------
        // 3. FileWriter
        //
        // Writes character data to a file.
        // By default, existing content is overwritten.
        // -------------------------------------------------------

        FileWriter writer = new FileWriter(file);

        writer.write("Hello Java!\n");
        writer.write("Learning File Handling.");

        writer.close();

        System.out.println("\nData written using FileWriter.");


        // -------------------------------------------------------
        // 4. APPEND MODE
        //
        // true prevents overwriting and adds data at the end.
        // -------------------------------------------------------

        FileWriter appendWriter = new FileWriter(file, true);

        appendWriter.write("\nThis line was appended.");

        appendWriter.close();

        System.out.println("Data appended to file.");


        // -------------------------------------------------------
        // 5. BufferedWriter
        //
        // Used for efficient character output.
        // -------------------------------------------------------

        BufferedWriter bufferedWriter =
            new BufferedWriter(new FileWriter(file, true));

        bufferedWriter.newLine();
        bufferedWriter.write("Written using BufferedWriter.");

        bufferedWriter.close();


        // -------------------------------------------------------
        // 6. FileReader
        //
        // Reads character data from a file.
        // -------------------------------------------------------

        System.out.println("\n---- FileReader ----");

        FileReader reader = new FileReader(file);

        int ch;

        while ((ch = reader.read()) != -1) {
            System.out.print((char) ch);
        }

        reader.close();


        // -------------------------------------------------------
        // 7. BufferedReader
        //
        // Reads text efficiently, line by line.
        // -------------------------------------------------------

        System.out.println("\n\n---- BufferedReader ----");

        BufferedReader bufferedReader =
            new BufferedReader(new FileReader(file));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();


        // -------------------------------------------------------
        // 8. FileOutputStream
        //
        // Writes raw byte data.
        // -------------------------------------------------------

        File byteFile = new File("bytes.txt");

        FileOutputStream outputStream =
            new FileOutputStream(byteFile);

        String text = "Hello Bytes!";

        outputStream.write(text.getBytes());

        outputStream.close();

        System.out.println("\nData written using FileOutputStream.");


        // -------------------------------------------------------
        // 9. FileInputStream
        //
        // Reads raw byte data.
        // -------------------------------------------------------

        System.out.println("\n---- FileInputStream ----");

        FileInputStream inputStream =
            new FileInputStream(byteFile);

        int data;

        while ((data = inputStream.read()) != -1) {
            System.out.print((char) data);
        }

        inputStream.close();


        // -------------------------------------------------------
        // 10. TRY-WITH-RESOURCES
        //
        // Automatically closes resources after use.
        // -------------------------------------------------------

        System.out.println("\n\n---- Try-With-Resources ----");

        try (BufferedReader br =
                new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }


        // -------------------------------------------------------
        // 11. CREATE DIRECTORY
        // -------------------------------------------------------

        File directory = new File("MyFolder");

        if (directory.mkdir()) {
            System.out.println("\nDirectory created.");
        } else {
            System.out.println("\nDirectory already exists.");
        }


        // -------------------------------------------------------
        // 12. CREATE NESTED DIRECTORIES
        //
        // mkdirs() creates parent directories if required.
        // -------------------------------------------------------

        File nestedDirectory =
            new File("Parent/Child/GrandChild");

        if (nestedDirectory.mkdirs()) {
            System.out.println("Nested directories created.");
        }


        // -------------------------------------------------------
        // 13. RENAME FILE
        // -------------------------------------------------------

        File renamedFile = new File("renamed_example.txt");

        if (file.renameTo(renamedFile)) {
            System.out.println("File renamed.");
        }


        // -------------------------------------------------------
        // 14. DELETE FILE
        // -------------------------------------------------------

        if (renamedFile.delete()) {
            System.out.println("File deleted.");
        }


        // -------------------------------------------------------
        // 15. DELETE DIRECTORY
        //
        // Directory must be empty for delete() to succeed.
        // -------------------------------------------------------

        if (directory.delete()) {
            System.out.println("Directory deleted.");
        }
    }
}