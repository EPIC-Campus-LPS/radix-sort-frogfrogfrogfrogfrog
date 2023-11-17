import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RadixSort radixSort = new RadixSort();

        String[] result = radixSort.radixSort();

        if (result != null){
            for (String element : result){
                System.out.println(element);
            }
        }
    }
}
