// Program to demonstrate Input and Output using BufferedReader in Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _02_BufferedReaderIo {

    public static void main(String[] args) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));


        // -------------------------------------------------------
        // INPUT
        // -------------------------------------------------------

        System.out.print("Enter a String: ");
        String stringValue = br.readLine();

        System.out.print("Enter an Integer: ");
        int intValue = Integer.parseInt(br.readLine());

        System.out.print("Enter a Byte: ");
        byte byteValue = Byte.parseByte(br.readLine());

        System.out.print("Enter a Short: ");
        short shortValue = Short.parseShort(br.readLine());

        System.out.print("Enter a Long: ");
        long longValue = Long.parseLong(br.readLine());

        System.out.print("Enter a Float: ");
        float floatValue = Float.parseFloat(br.readLine());

        System.out.print("Enter a Double: ");
        double doubleValue = Double.parseDouble(br.readLine());

        System.out.print("Enter a Character: ");
        char charValue = br.readLine().charAt(0);

        System.out.print("Enter a Boolean: ");
        boolean booleanValue = Boolean.parseBoolean(br.readLine());


        // -------------------------------------------------------
        // OUTPUT
        // -------------------------------------------------------

        System.out.println("\n---- OUTPUT ----");

        System.out.println("String    : " + stringValue);
        System.out.println("Integer   : " + intValue);
        System.out.println("Byte      : " + byteValue);
        System.out.println("Short     : " + shortValue);
        System.out.println("Long      : " + longValue);
        System.out.println("Float     : " + floatValue);
        System.out.println("Double    : " + doubleValue);
        System.out.println("Character : " + charValue);
        System.out.println("Boolean   : " + booleanValue);

        br.close(); // No explicit close needed here, but good practice
        
    }
}