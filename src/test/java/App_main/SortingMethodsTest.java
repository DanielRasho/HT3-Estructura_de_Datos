package App_main;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortingMethodsTest {

    static List<Integer> unsortedNumbers = new ArrayList<Integer>();

    @BeforeClass
    public static void setup(){
        unsortedNumbers.add(4);
        unsortedNumbers.add(2);
        unsortedNumbers.add(1);
        unsortedNumbers.add(3);
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
}