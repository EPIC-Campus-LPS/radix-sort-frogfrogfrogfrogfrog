import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.FileWriter;

/**
 * This class implements a radix sort algorithm
 *
 * @author Cardin Nguyen
 * @version 1.1, 12/8/2023
 * @see Scanner
 */
public class RadixSort {
    /**
     * Sorts a text file alphabetically using radix sort
     * @return a new text file named "key.txt" that contains the sorted text file
     * @throws IOException
     */
    public String[] radixSort() throws IOException {

        //creates file/scanner classes to read file
        LinkedList<String> fileContents = new LinkedList<>();
        File file = new File("text.txt");
        Scanner scan = new Scanner(file);

        //scans through the entire file and puts it inside a linked list while also finding the longest length string
        int longestLength = 0;

        while (scan.hasNextLine()) {
            String data = scan.nextLine();
            fileContents.add(data);


            if (data.length() > longestLength) {
                longestLength = data.length();
            }
        }

        scan.close();

        //goes through the entire linked list
        for (int i = 0; i < fileContents.size(); i++) {

            //pads the indexed element with spaces until length of longest string
            if (fileContents.get(i).length() < longestLength) {

                String paddedWord = fileContents.get(i);

                while (paddedWord.length() < longestLength) {
                    paddedWord = paddedWord + " ";
                }

                fileContents.set(i, paddedWord);
            }
        }

        //initializes a hashmap
        HashMap<String, LinkedList<String>> alphabetTable = new HashMap<>();

        //creates a slot for empty space
        alphabetTable.put(Character.toString(' '), new LinkedList<>());

        //creates a slot for every character in the alphabet
        for (char index = 'a'; index <= 'z'; index++) {
            alphabetTable.put(Character.toString(index), new LinkedList<>());
        }

        //repeats the loop as many times as the length of the longest string
        for (int i = longestLength - 1; i >= 0; i--) {

            //puts the contents of the file into the hashmap alphabetically (based on current character)
            for (String word : fileContents) {

                //makes the indexed character based on the for the outside for loop
                String indexedCharacter = String.valueOf(word.charAt(i)).toLowerCase();

                //makes a new linked list in order to access the list in the hashmap
                LinkedList<String> modifiedList = alphabetTable.get(indexedCharacter);
                modifiedList.add(word);
            }

            //puts the hashmap contents into file contents based on order found by the last loop
            fileContents.clear();

            //initializes a linked list to access the hashmap
            LinkedList<String> accessList = alphabetTable.get(Character.toString(' '));

            //checks the access
            if (accessList != null) {

                fileContents.addAll(accessList);
                alphabetTable.put(Character.toString(' '), new LinkedList<>());
            }

            for (char index = 'a'; index <= 'z'; index++) {

                //redefines the list based on the index
                accessList = alphabetTable.get(Character.toString(index));

                fileContents.addAll(accessList);
                alphabetTable.put(Character.toString(index), new LinkedList<>());
            }
        }

        //creates a new filewriter to write into a new file
        FileWriter writer = new FileWriter("key.txt");

        for (String word : fileContents) {
            writer.write(word + "\n");
        }

        writer.close();

        return fileContents.toArray(new String[0]);
    }
}

