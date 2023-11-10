import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        RadixSort radixSort = new RadixSort();

        String[] result = radixSort.radixSort();

        if (result != null){
            for (String element : result){
                System.out.println(element);
            }
        }
    }
}
