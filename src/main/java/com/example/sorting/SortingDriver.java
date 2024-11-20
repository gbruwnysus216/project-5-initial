package com.example.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.example.sorting.SortingUtility.timeLogger;

public class SortingDriver {

    public static void main(String[] args) {

        // Generate array of random Integers
        Integer[] arr = IntStream.generate(() -> (int) (Math.random() * 50000))
                                 .boxed()
                                 .limit(10)
                                 .toArray(Integer[]::new);

        Integer[] arrayInorder = IntStream.rangeClosed(1, 999)
                .boxed()
                .toArray(Integer[]::new);

        Integer[] copy0 = copyArray(arr);
        Integer[] copy1 = copyArray(arr);
        Integer[] copy2 = copyArray(arr);
        Integer[] copy3 = copyArray(arr);
        Integer[] copy4 = copyArray(arr);
        Integer[] emptyArray = new Integer[0];

        System.out.println("\nUnsorted data...");
        printFirstTenOfArray(arr);

        System.out.println("\nSelection Sort...");
        SortingUtility.selectionSort(copy0);
        printFirstTenOfArray(copy0);
        SortingUtility.timeLogger(copy0, () -> SortingUtility.selectionSort(copy0), "Shell Sort");

        System.out.println("\nSelection Sort zero check...");
        SortingUtility.selectionSort(emptyArray);
        printFirstTenOfArray(emptyArray);
        SortingUtility.timeLogger(emptyArray, () -> SortingUtility.selectionSort(emptyArray), "Selection Sort");

        System.out.println("\nUnsorted data...");
        printFirstTenOfArray(arr);

        System.out.println("\nGnome Sort...");
        SortingUtility.gnomeSort(copy1);
        printFirstTenOfArray(copy1);
        SortingUtility.timeLogger(copy1, () -> SortingUtility.gnomeSort(copy1), "Gnome Sort");

        System.out.println("\nGnome Sort zero check...");
        SortingUtility.gnomeSort(emptyArray);
        printFirstTenOfArray(emptyArray);
        SortingUtility.timeLogger(emptyArray, () -> SortingUtility.gnomeSort(emptyArray), "Gnome Sort");

        System.out.println("\nCocktail Shaker Sort...");
        SortingUtility.cocktailShakerSort(copy2);
        printFirstTenOfArray(copy2);
        SortingUtility.timeLogger(copy2, () -> SortingUtility.cocktailShakerSort(copy2), "Cocktail Shaker Sort");

        System.out.println("\nCocktail Shaker Sort zero check...");
        SortingUtility.cocktailShakerSort(emptyArray);
        printFirstTenOfArray(emptyArray);
        SortingUtility.timeLogger(emptyArray, () -> SortingUtility.cocktailShakerSort(emptyArray), "Gnome Sort");

        System.out.println("\nbubbleSort...");
        SortingUtility.bubbleSort(copy3);
        printFirstTenOfArray(copy3);
        SortingUtility.timeLogger(copy3, () -> SortingUtility.bubbleSort(copy3), "bubbleSort");

        System.out.println("\nbubbleSort zero check...");
        SortingUtility.bubbleSort(emptyArray);
        printFirstTenOfArray(emptyArray);
        SortingUtility.timeLogger(emptyArray, () -> SortingUtility.bubbleSort(emptyArray), "bubbleSort");

        System.out.println("\nquickSort...");
        SortingUtility.quickSort(copy4,1,500);
        printFirstTenOfArray(copy4);
        SortingUtility.timeLogger(copy4, () -> SortingUtility.quickSort(copy4, 1,5), "quickSort");

        System.out.println("\nquickSort zero check...");
        SortingUtility.quickSort(emptyArray,1,500);
        printFirstTenOfArray(emptyArray);
        SortingUtility.timeLogger(emptyArray, () -> SortingUtility.quickSort(emptyArray,1,5), "quickSort");
    }

    private static <T> void printFirstTenOfArray(T[] obj) {

        if (obj != null) {

            int counter = 1;
            System.out.println("\nFirst 10 of Array...");

            for (T i : obj) {
                System.out.println(counter + ": " + i.toString());

                if (counter >= 10) {
                    break;
                }
                counter++;
            }

        } else {
            System.out.println("Array is null.");
        }
    }

    private static <T> T[] copyArray(T[] obj) {

        T[] copy = (T[]) Arrays.copyOf(obj, obj.length);

        return copy;
    }

}
