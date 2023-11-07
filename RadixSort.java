import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RadixSort {
    public String[] radixSort() {

        Scanner read = new Scanner(System.in);
        System.out.println("enter the name of the file you want to sort");

        String userInput = read.nextLine();

        try {

            //reads the contents of the file
            File file = new File(userInput + ".txt");
            Scanner readFile = new Scanner(file);


        } catch (FileNotFoundException e) {
            System.out.println("something happened oops");
        }

    }
}
