package com.cameron.colourcodefinder;

import java.util.ArrayList;
import java.util.Scanner;

public class Search extends ImportColours{
    public static void main(String[] args) {
        ImportColours importColours = new ImportColours();
        // Call method importAllColours
        importColours.ImportAllColours();
        // Getting the arrayLists from ImportColours to be used within Search class
        ArrayList<String> colourNames = getColourNames();
        ArrayList<String> colourNamesComplete = getColourNamesComplete();
        while(true) {
            System.out.println("Enter the colour to search for (enter help for information or quit to exit): ");
            Scanner scanner = new Scanner(System.in);
            String itemToFind = scanner.nextLine();
            if(itemToFind.equalsIgnoreCase("help")) {
                System.out.println("--- HELP");
                System.out.println("--- Please note: If two hex codes are returned when you search for one colour, it is because two of the same colour exist and they are slightly different.");
                System.out.println("--- To exit the program, enter 'quit'.");
                System.out.println("--- List of available colours:");
                // Print out all colour's and their hex code
                for (String colourName : colourNames) {
                    System.out.println(colourName);
                }
                System.out.println("Enter the colour to search for: ");
                itemToFind = scanner.nextLine();
            }
            if (itemToFind.contains("quit")) {
                System.exit(0);
            }
            // Call method to find colour code
            if (!FindColourCode(colourNamesComplete, itemToFind)) {
                System.out.println("Unable to find colour. Try again.");
            }
        }
    }

    private static Boolean FindColourCode(ArrayList<String> colourNamesComplete, String itemToFind) {
        // Search colourNamesComplete arrayList and if colour is found, print output
        int index = 0;
        for(String string : colourNamesComplete){
            if(string.matches(itemToFind)){
                // index+1 for hex code
                System.out.println(colourNamesComplete.get(index+1));
                // index+2 for rgb value
                System.out.println(colourNamesComplete.get(index+2));
                return true;
            }
            index++;
        }
        return false;
    }
}