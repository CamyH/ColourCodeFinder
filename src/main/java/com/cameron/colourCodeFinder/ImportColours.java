package com.cameron.colourCodeFinder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class ImportColours {
    private static ArrayList<String> colourNames = new ArrayList<String>();
    private static ArrayList<String> colourData = new ArrayList<String>();
    private static ArrayList<String> colourNamesComplete = new ArrayList<String>();
    private static final ArrayList<Integer> numberList = new ArrayList<Integer>();

    public static void main(String[] args) {
        Document doc;
        try {
            doc = Jsoup.connect("https://jonasjacek.github.io/colors/").get();

            // get title of the page
            String title = doc.title();

            // get all hex codes
            Elements links = doc.select("td");
            //Elements headers = doc.select("th");
            for(Element link : links) {
                // get the value from href attributes
                colourData.add(link.text());
            }

            for(int i = 0; i < 256; i++){
                numberList.add(i);
            }

            for(int pos = 0; pos < colourData.size(); pos++) {
                String[] split = colourData.get(pos).split(" "); //# This gives you an array of items split on spaces " "
                String name = split[0]; //# and the first item split[0] will be the colourName
                name = name.replaceAll("(SYSTEM)", ""); //# replaces all occurences of "(SYSTEM)" with nothing effectively removing them

                colourNamesComplete.add(name);
                colourNames.add(name);
            }
            // removing rgb value for each colour in colourNamesComplete
            for(int i = 0; i < colourNamesComplete.size(); i++){
                if(colourNamesComplete.get(i).contains("rgb")){
                    colourNamesComplete.remove(i);
                }
            }
            // removing hsl value for each colour in colourNamesComplete
            for(int i = 0; i < colourNamesComplete.size(); i++){
                if(colourNamesComplete.get(i).contains("hsl")){
                    colourNamesComplete.remove(i);
                }
            }

            // removing rgb value for each colour in colourNames
            for(int i = 0; i < colourNames.size(); i++){
                if(colourNames.get(i).contains("rgb")){
                    colourNames.remove(i);
                }
            }
            // removing hsl value for each colour in colourNames
            for(int i = 0; i < colourNames.size(); i++){
                if(colourNames.get(i).contains("hsl")){
                    colourNames.remove(i);
                }
            }
            // removing hsl value for each colour in colourNames
            for(int i = 0; i < colourNames.size(); i++){
                if(colourNames.get(i).contains("#")){
                    colourNames.remove(i);
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    // Getters and Setters
    public static ArrayList<String> getcolourNames() {
        return colourNames;
    }

    public static void setcolourNames(ArrayList<String> colourNames) {
        ImportColours.colourNames = colourNames;
    }

    public static ArrayList<String> getColourData() {
        return colourData;
    }

    public static void setColourData(ArrayList<String> colourData) {
        ImportColours.colourData = colourData;
    }

    public static ArrayList<String> getcolourNamesComplete() {
        return colourNamesComplete;
    }

    public static void setcolourNamesComplete(ArrayList<String> colourNamesComplete) {
        ImportColours.colourNamesComplete = colourNamesComplete;
    }
}