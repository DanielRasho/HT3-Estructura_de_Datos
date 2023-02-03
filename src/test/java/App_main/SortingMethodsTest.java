package App_main;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortingMethodsTest {

    static List<Integer> unsortedNumbers = new ArrayList<Integer>();
    static List<Integer> sortedNumbers = new ArrayList<Integer>();

    @BeforeClass
    public static void setup(){
        unsortedNumbers.add(2);
        unsortedNumbers.add(6);
        unsortedNumbers.add(11);
        unsortedNumbers.add(3);
        unsortedNumbers.add(4);

        sortedNumbers.add(2);
        sortedNumbers.add(3);
        sortedNumbers.add(4);
        sortedNumbers.add(6);
        sortedNumbers.add(11);
    }

    @Test
    public void testGnomeSort() {
        List<Integer> tempList = SortingMethods.GnomeSort(unsortedNumbers);
        for (Integer i: tempList) {
            System.out.println(i);
        }
        assertEquals(tempList, sortedNumbers);
    }

    @Test
    public void testMergeSort() {
    }

    @Test
    public void testShellSort() {
    }

    @Test
    public void testQuickSort(){
        List<Integer> tempList = SortingMethods.QuickSort(unsortedNumbers);
        for (Integer i: tempList) {
            System.out.println(i);
        }
        assertEquals(tempList, sortedNumbers);
    }

    @Test
    public void testRadixSort(){
        List<Integer> tempList = SortingMethods.RadixSort(unsortedNumbers, Integer::intValue);
        for (Integer i: tempList) {
            System.out.println(i);
        }
        assertEquals(tempList, sortedNumbers);
    }
}