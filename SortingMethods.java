package App_main;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static java.lang.Character.getNumericValue;

public class SortingMethods {

    /**
     * Implementation of Gnome Sort algorithm.
     * 
     * @param listComparable List of comparable elements to be sorted
     * @return The sorted list of comparable elements
     */

    public static <T extends Comparable<T>> List<T> GnomeSort(List<T> listMethods) {
        int i = 1;
        while (i < listMethods.size()) {
            // if "i" es 0 o el elemento previo es menor o igual al elemento actual.
            if (i == 0 || listMethods.get(i - 1).compareTo(listMethods.get(i)) <= 0) {
                i++;
            } else {
                // Cambiar el elemento actual con el elemnto previo
                T temp = listMethods.get(i);
                listMethods.set(i, listMethods.get(i - 1));
                listMethods.set(i - 1, temp);

                i--;
            }
        }
        return listMethods;
    }

    /**
     * Implementation of Merge Sort algorithm.
     * 
     * @param listComparable The list of comparables to be sorted
     * @return The sorted list of comparables
     */
    public static <T extends Comparable<T>> List<T> MergeSort(List<T> listMethods) {
        if (listMethods.size() <= 1) {
            return listMethods;
        }
        int mid = listMethods.size() / 2;
        List<T> left = listMethods.subList(0, mid);
        List<T> right = listMethods.subList(mid, listMethods.size());
        left = MergeSort(left);
        right = MergeSort(right);
        return merge(left, right);
    }

    /**
     * Merge method is a method for the MergeSort method that merges both sorted
     * lists.
     * 
     * @param left  The left sorted list
     * @param right The right sorted list
     * @return The merged sorted list
     */
    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<T>();
        int iLeft = 0;
        int iRight = 0;
        while (iLeft < left.size() && iRight < right.size()) {
            if (left.get(iLeft).compareTo(right.get(iRight)) <= 0) {
                result.add(left.get(iLeft));
                iLeft++;
            } else {
                result.add(right.get(iRight));
                iRight++;
            }
        }
        while (iLeft < left.size()) {
            result.add(left.get(iLeft));
            iLeft++;
        }
        while (iRight < right.size()) {
            result.add(right.get(iRight));
            iRight++;
        }
        return result;
    }

    /**
     * Implementation of Quick Sort.
     * 
     * @param data Data to sort.
     * @return Sorted List based on a numeric paramater.
     * @param <T> Object type of the items stored in the given data.
     */
    public static <T extends Comparable<T>> List<T> QuickSort(List<T> data) {
        QuickSortRecursive(data, 0, data.size() - 1);
        return data;
    }

    /**
     * Implementation of Radix Sort Algorithm
     * 
     * @param data            Data to sort
     * @param getNumericValue Getter function for fetching the numeric attribute of
     *                        the object.
     * @return Sorted List based on a numeric parameter.
     * @param <T> Object type of the items stored in the given data.
     */
    public static <T extends Comparable<T>> List<T> RadixSort(List<T> data, Function<T, Integer> getNumericValue) {
        for (int i = 0; i < 6; i++) {
            data = orderByBuckets(data, getNumericValue, i);
        }
        return data;
    }

    /**
     * Implementation of ShellSort algorithm.
     * 
     * @param list - The list to be sorted
     * @return The sorted list
     */
    public static <T extends Comparable<T>> List<T> ShellSort(List<T> listMethods) {

        int gap = listMethods.size() / 2;
        // Inicializar hasta que el valor del espacio sea 0
        while (gap > 0) {
            for (int x = gap; x < listMethods.size(); x++) {
                T temp = listMethods.get(x);
                int y;
                // Comparar el item actual con los items anteriores en el espacio
                for (y = x; y >= gap && listMethods.get(y - gap).compareTo(temp) > 0; y -= gap) {
                    // Mover el item más grande a la derecha
                    listMethods.set(y, listMethods.get(y - gap));
                }
                // Insertar el item actual en su nueva posición
                listMethods.set(y, temp);
            }
            gap = gap / 2;
        }
        return listMethods;
    }

    /**
     * Takes the first object of a collection and position it, in the place
     * it would be, if the array will be fully sorted.
     * 
     * @param data  Data to analyze.
     * @param left  Left boundary to start sorting.
     * @param right Right boundary to end sorting.
     * @return Index in which the first object
     * @param <T> Object type of the items stored in the given data.
     */
    private static <T extends Comparable<T>> int partition(List<T> data, int left, int right) {
        while (true) {
            T leftValue = data.get(left);
            T rightValue = data.get(right);

            // Looking for values that are inferior and swapping them.
            while (left < right &&
                    data.get(left).compareTo(data.get(right)) < 0)
                right--;

            if (left < right) {
                Collections.swap(data, left, right);
                left++;
            } else
                return left;

            // Looking for values that are superior and swapping them.
            while (left < right &&
                    data.get(left).compareTo(data.get(right)) < 0)
                left++;

            if (left < right) {
                Collections.swap(data, left, right);
                right--;
            } else
                return right;
        }
    }

    /**
     * Sorts the values within a collection from a given start to end.
     * 
     * @param data  Data to sort
     * @param left  Left boundary to start sorting.
     * @param right Right boundary to end sorting.
     * @param <T>   Object type of the items stored in the given data.
     */
    private static <T extends Comparable<T>> void QuickSortRecursive(List<T> data, int left, int right) {
        int pivot;
        if (left >= right)
            return;
        pivot = partition(data, left, right);
        QuickSortRecursive(data, left, pivot - 1);
        QuickSortRecursive(data, pivot + 1, right);
    }

    /**
     * Return the digit in the selected index.
     * 
     * @param number     Number to take the digit from.
     * @param digitIndex Index of the digit to be retrieved, starting from 0;
     * @return The digit in the asked index.
     */
    private static int getDigit(int number, int digitIndex) {
        if (digitIndex == 0)
            return number % 10; // Returning the last digit.
        else
            return getDigit(number / 10, digitIndex - 1);
    }

    /**
     * Sort a set of values based on a numeric attribute, by grouping them in
     * buckets of objects that
     * have the same digit in an specified digitIndex.
     * 
     * @param data            Data to be classified.
     * @param getNumericValue Getter function for fetching the numeric attribute of
     *                        the object.
     * @param digitIndex
     * @return Sorted List based on the selected index.
     * @param <T> Object type of the items stored in the given data.
     */
    public static <T extends Comparable<T>> List<T> orderByBuckets(List<T> data, Function<T, Integer> getNumericValue,
            int digitIndex) {
        int i, j;
        int dataSize = data.size();
        T value;
        // Creating buckets of data.
        ArrayList<ArrayList<T>> BucketSet = new ArrayList<>();
        // Create buckets to hold values
        for (j = 0; j < 10; j++)
            BucketSet.add(new ArrayList<T>());

        // Classifying values by its digit on digitIndex.
        for (i = 0; i < dataSize; i++) {
            value = data.get(i);
            j = getDigit(getNumericValue.apply(value), digitIndex);
            BucketSet.get(j).add(value);
        }

        // Unpacking values withing each bucket.
        List<T> SortedData = new ArrayList<>();
        for (ArrayList<T> bucket : BucketSet)
            SortedData = Stream.concat(SortedData.stream(), bucket.stream()).collect(Collectors.toList());
        return SortedData;
    }
}