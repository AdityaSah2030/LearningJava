/**
 * FileIO
 *
 * This program demonstrates basic file input/output operations in Java:
 *
 * 1. Writing data to a file:
 *    - Uses BufferedWriter wrapped around a FileWriter.
 *    - Employs try-with-resources to ensure that the stream is closed automatically.
 *
 * 2. Reading data from a file:
 *    - Uses BufferedReader wrapped around a FileReader.
 *    - Reads the file line by line.
 *
 * 3. Checking file existence:
 *    - Uses the File class to verify that the file exists before reading.
 *
 * To compile: javac 10_fileIO.java
 * To run:     java 10_fileIO
 */

import java.io.*;

public class FileIODemo {
    public static void main(String[] args) {
        String fileName = "example.txt";
        // Data to be written into the file.
        String[] lines = {
            "This is the first line.",
            "This is the second line.",
            "This is the third line."
        };

        // Write the data to the file.
        writeToFile(fileName, lines);

        // Read and display the data from the file.
        readFromFile(fileName);
    }

    /**
     * Writes an array of strings to a file.
     *
     * @param fileName the name of the file to write to.
     * @param lines an array of strings representing lines to write.
     */
    public static void writeToFile(String fileName, String[] lines) {
        System.out.println("Writing to file: " + fileName);
        // Using try-with-resources to ensure the BufferedWriter is closed automatically.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();  // Write a newline character.
            }
            System.out.println("Writing completed successfully.");
        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
        }
        System.out.println();
    }

    /**
     * Reads the contents of a file and prints them to the console.
     *
     * @param fileName the name of the file to read from.
     */
    public static void readFromFile(String fileName) {
        System.out.println("Reading from file: " + fileName);
        File file = new File(fileName);
        // Check if the file exists before reading.
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }
        // Using try-with-resources to ensure the Buf
