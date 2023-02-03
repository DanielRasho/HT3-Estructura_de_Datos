package App_main;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.getNumericValue;

public class SortingMethods {

    public static <T extends Comparable<T>> List<T> GnomeSort(List<T> listMethods) {
        // Algoritmo para Gnome Sort
        int x = 1; // index 1
        int y = 2; // index 2
        while (x < listMethods.size()) { // Si el item actual es mayor o igual al anterior, se sigue con el siguiente
            // item
            if (listMethods.get(x - 1).compareTo(listMethods.get(x)) <= 0) {
                x = y;
                y++;
            } else { // Cambiar el item anterior por el actual
                Collections.swap(listMethods, x, x - 1);
                x--; // Acceder al item anterior
            }
        }
        return listMethods;
    }

    public static <T extends Comparable<T>> List<T> MergeSort(List<T> listMethods) {
        // Algoritmo para Merge Sort
        if (listMethods.size() > 1) { // Realiza el sorting si la lista tiene más de un item
            int mitad = listMethods.size() / 2; // Calcula el index de la mitad de la lista
            List<T> left = listMethods.subList(0, mitad); // Lista izquierda
            List<T> right = listMethods.subList(mitad, listMethods.size()); // Lista derecha
            // Ordenar recursivamente las listas de izquierda y derecha
            left = MergeSort(left);
            right = MergeSort(right);
            // Combinar las listas ordenadas de la izquierda y la derecha
            listMethods = merge(left, right);
        }
        return listMethods;
    }

    // Combinar dos listas ordenadas
    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        // index para las listas de la izquierda y la derecha
        int x = 0;
        int y = 0;
        List<T> result = new ArrayList<T>(left.size() + right.size()); // Inicializar la lista en donde estará un único
        // ArrayList con todos los items
        while (x < left.size() && y < right.size()) { // Se inicializa hasta el momento en que las listas esten vacías
            // Compara los items en los índices actuales en ambas listas
            if (left.get(x).compareTo(right.get(y)) <= 0) {
                result.add(left.get(x));
                y++;
            } else {
                // Añade el elemento más pequeño a la lista de resultados.
                result.add(right.get(y));
                y++;
            }
        }
        // Añade los elementos restantes de la lista de la izquierda
        while (x < left.size()) {
            result.add(left.get(x));
            x++;
        }
        // Añade los elementos restantes de la lista de la derecha
        while (y < right.size()) {
            result.add(right.get(y));
            y++;
        }
        return result; // Imprime la lista ordenada
    }

    /**
     * Implementation of Quick Sort.
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
     * @param data Data to sort
     * @param getNumericValue Getter function for fetching the numeric attribute of the object.
     * @return Sorted List based on a numeric parameter.
     * @param <T> Object type of the items stored in the given data.
     */
    public static <T extends Comparable<T>> List<T> RadixSort(List<T> data, Function<T, Integer> getNumericValue) {
        for(int i = 0; i < 6; i++){
            data = orderByBuckets(data, getNumericValue, i);
        }
        return data;
    }

    public static <T extends Comparable<T>> List<T> ShellSort(List<T> listMethods) {
        // Algoritmo para Shell Sort

        // Inicialice el valor del espacio como la mitad del tamaño de la lista
        int gap = listMethods.size() / 2;
        // Inicializar hasta que el valor del espacio sea 0
        while (gap > 0) {
            // Recorrer la lista con el valor del espacio como el tamaño de paso
            for (int x = gap; x < listMethods.size(); x++) {
                // Guardar el item actual
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
            // Dividir el espacio a la mitad
            gap = gap / 2;
        }
        return listMethods;
    }

    /**
     * Takes the first object of a collection and position it, in the place
     * it would be, if the array will be fully sorted.
     * @param data Data to analyze.
     * @param left Left boundary to start sorting.
     * @param right Right boundary to end sorting.
     * @return Index in which the first object
     * @param <T> Object type of the items stored in the given data.
     */
    private static <T extends Comparable<T>> int partition(List<T> data, int left, int right){
        while(true){
            T leftValue = data.get(left);
            T rightValue = data.get(right);

            // Looking for values that are inferior and swapping them.
            while (left < right &&
                    data.get(left).compareTo(data.get(right)) < 0)
                right --;

            if(left < right) {
                Collections.swap(data, left, right);
                left++;
            }
            else return left;

            // Looking for values that are superior and swapping them.
            while(left < right &&
                    data.get(left).compareTo(data.get(right)) < 0) left ++;

            if(left < right) {
                Collections.swap(data, left, right);
                right --;
            }
            else return right;
        }
    }

    /**
     * Sorts the values within a collection from a given start to end.
     * @param data Data to sort
     * @param left Left boundary to start sorting.
     * @param right Right boundary to end sorting.
     * @param <T> Object type of the items stored in the given data.
     */
    private static <T extends Comparable<T>> void QuickSortRecursive(List<T> data, int left, int right) {
        int pivot;
        if (left >= right) return;
        pivot = partition(data, left, right);
        QuickSortRecursive(data, left, pivot -1);
        QuickSortRecursive(data, pivot + 1, right);
    }

    /**
     * Return the digit in the selected index.
     * @param number Number to take the digit from.
     * @param digitIndex Index of the digit to be retrieved, starting from 0;
     * @return The digit in the asked index.
     */
    private static int getDigit(int number, int digitIndex){
        if (digitIndex == 0) return number % 10; // Returning the last digit.
        else return getDigit(number/10, digitIndex - 1);
    }

    /**
     * Sort a set of values based on a numeric attribute, by grouping them in buckets of objects that
     * have the same digit in an specified digitIndex.
     * @param data Data to be classified.
     * @param getNumericValue Getter function for fetching the numeric attribute of the object.
     * @param digitIndex
     * @return Sorted List based on the selected index.
     * @param <T> Object type of the items stored in the given data.
     */
    private static <T extends Comparable<T>> List<T> orderByBuckets (List<T> data, Function<T, Integer> getNumericValue, int digitIndex){
        int i, j;
        int dataSize = data.size();
        T value;
        // Creating buckets of data.
        ArrayList<ArrayList<T>> BucketSet = new ArrayList<>();
        // Create buckets to hold values
        for(j = 0; j < 10; j++) BucketSet.add(new ArrayList<T>());

        // Classifying values by its digit on digitIndex.
        for(i = 0; i < dataSize; i++){
            value =data.get(i);
            j = getDigit(getNumericValue.apply(value) , digitIndex);
            BucketSet.get(j).add(value);
        }

        // Unpacking values withing each bucket.
        List<T> SortedData = new ArrayList<>();
        for (ArrayList<T> bucket: BucketSet)
            SortedData = Stream.concat(SortedData.stream(), bucket.stream()).collect(Collectors.toList());
        return SortedData;
    }
}