package com.cameron.colour_code_finder;

import java.util.ArrayList;
import java.util.Scanner;

public class Search extends ImportColours{
    public static void main(String[] args) {
        ImportColours importColours = new ImportColours();
        importColours.ImportAllColours();
        // Getting the arrayLists from ImportColours to be used within Search class
        ArrayList<String> colourNames = getColourNames();
        ArrayList<String> colourNamesComplete = getColourNamesComplete();

        System.out.println("Enter the colour to search for (enter help for information): ");
        Scanner scanner = new Scanner(System.in);
        String itemToFind = scanner.nextLine();
        if(itemToFind.equalsIgnoreCase("help")){
            System.out.println("--- HELP");
            System.out.println("--- Please note: If two hex codes are returned when you search for one colour, it is because two of the same colour exist and they are slightly different.");
            System.out.println("--- List of available colours:");
            // print out all colour's and their hex code
            for (String colourName : colourNames) {
                System.out.println(colourName);
            }
            System.out.println("Enter the colour to search for: ");
            itemToFind = scanner.nextLine();
        }

        // Search colourNamesComplete arrayList and if colour is found, print output
        int index = 0;
        for(String string : colourNamesComplete){
            if(string.matches(itemToFind)){
                System.out.println(colourNamesComplete.get(index+1));
            }
            index++;
        }
    }
}