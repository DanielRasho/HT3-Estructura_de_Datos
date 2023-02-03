package App_main;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortingMethodsTest {

    static List<Integer> unsortedNumbers = new ArrayList<Integer>();

    @BeforeClass
    public static void setup(){
        unsortedNumbers.add(2);
        unsortedNumbers.add(6);
        unsortedNumbers.add(11);
        unsortedNumbers.add(3);
        unsortedNumbers.add(4);
    }

    @Test
    public void testGnomeSort() {
        List<Integer> tempList = SortingMethods.GnomeSort(unsortedNumbers);
        for (Integer i: tempList) {
            System.out.println(i);
        }
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
    }

    @Test
    public void testRadixSort(){
        List<Integer> tempList = SortingMethods.RadixSort(unsortedNumbers, Integer::intValue);
        for (Integer i: tempList) {
            System.out.println(i);
        }
    }

    @Test
    public void testBucketSort(){
        SortingMethods.orderByBuckets(unsortedNumbers, Integer::intValue, 0);
    }
}