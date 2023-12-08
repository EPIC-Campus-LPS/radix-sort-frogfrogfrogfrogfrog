import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {
    java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();


    @org.junit.jupiter.api.Test
    void radixSort() throws IOException {
        RadixSort radixSort = new RadixSort();
        String[] result = radixSort.radixSort();
        System.setOut(new java.io.PrintStream(out));
        if (result != null){
            for (String element : result){
                System.out.print(element.trim() + " ");
            }
        }
        assertEquals("attitude ceiling cylinder demonstration dilemma dozen innovation miss surround worry ", out.toString());
    }
}