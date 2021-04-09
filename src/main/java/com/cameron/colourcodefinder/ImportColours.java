package com.cameron.colourcodefinder;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class ImportColours {
    private static ArrayList<String> colourNames = new ArrayList<>();
    private static final ArrayList<String> colourData = new ArrayList<>();
    private static final ArrayList<String> colourNamesComplete = new ArrayList<>();

    public void ImportAllColours() {
        Document doc;
        try {
            doc = Jsoup.connect("https://jonasjacek.github.io/colors/").get();

            // Get all hex codes
            Elements links = doc.select("td");
            // Elements headers = doc.select("th");
            for(Element link : links) {
                // Get the value from href attributes
                colourData.add(link.text());
            }

            for (String colourData : colourData) {
                String[] split = colourData.split(" "); // This gives you an array of items split on spaces " "
                String name = split[0]; // and the first item split[0] will be the colourName
                name = name.replaceAll("(SYSTEM)", ""); // replaces all occurrences of "(SYSTEM)" with nothing effectively removing them

                colourNamesComplete.add(name);
                colourNames.add(name);
            }
            // Removing hsl value for each colour in colourNames
            colourNames.removeIf(s -> s.contains("hsl"));
            // Removing hsl value for each colour in colourNamesComplete
            colourNamesComplete.removeIf(s -> s.contains("hsl"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Getters and Setters

    public static ArrayList<String> getColourNames() {
        return colourNames;
    }

    public static void setColourNames(ArrayList<String> colourNames) {
        ImportColours.colourNames = colourNames;
    }

    public static ArrayList<String> getColourNamesComplete() {
        return colourNamesComplete;
    }

}