import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;

public class RadixSort {
    public String[] radixSort() throws FileNotFoundException {

        LinkedList<String> fileContents = new LinkedList<>();
        File file = new File("text.txt");
        Scanner scan = new Scanner(file);

        //scans through the entire file and puts it inside a linked list while also finding the longest length string
        int longestLength = 0;

        while (scan.hasNextLine()){
            String data = scan.nextLine();
            fileContents.add(data);

            if(data.length() > longestLength){
                longestLength = data.length();
            }
        }

        //goes through the entire linked list
        for(int i = 0; i < fileContents.size(); i++){

            //pads the indexed element with spaces until length of longest string
            if(fileContents.get(i).length() < longestLength){

                String paddedWord = fileContents.get(i);

                while (paddedWord.length() < longestLength){
                    paddedWord = paddedWord + " ";
                }

                fileContents.set(i,paddedWord);
            }
        }

        //initializes a hashmap and a linked list to put inside the hashmap
        HashMap<String, LinkedList<String>> alphabetTable = new HashMap<>();

        return null;
    }

    /*
    public String[] radixSort() throws FileNotFoundException {

        //initializes a hashmap and a linked list to put inside the hashmap
        HashMap<String, LinkedList<String>> alphabetTable = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();

        for (char index = 'a'; index <= 'z'; ++index) {
            alphabetTable.put(Character.toString(index), new LinkedList<>());
        }

        //reads the text file and puts it in the hashmap alphabetically
        File file = new File("text.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()){
            String data = scan.nextLine();
            String firstChar = String.valueOf(data.charAt(0)).toLowerCase();
            LinkedList<String> listModified = alphabetTable.get(firstChar);
            listModified.add(data);
        }

        // Print the entire HashMap
        for (String key : alphabetTable.keySet()) {
            LinkedList<String> value = alphabetTable.get(key);
            System.out.println("Key: " + key + ", List: " + value);
        }

        return null;
    }

     */
}
