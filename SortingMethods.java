package org;

import java.util.List;
import java.util.Collections;
import java.util.*;

public class SortingMethods {

    public <T extends Comparable<T>> List<T> GnomeSort(List<T> listMethods) {
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

    public <T extends Comparable<T>> List<T> MergeSort(List<T> listMethods) {
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
    private <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
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

    public <T> List<T> QuickSort(List<Comparable<T>> listQuick) {
        return null;

    }

    public <T> List<T> RadixSort(List<Comparable<T>> listRadix) {
        return null;

    }

    public <T extends Comparable<T>> List<T> ShellSort(List<T> listMethods) {
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
}