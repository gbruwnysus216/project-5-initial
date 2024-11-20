package com.example.sorting;

import java.util.logging.Logger;

public class SortingUtility {

    // intellij doesn't seem to like System.out.println() so I'm using a logger instead
    private static final Logger messageLogger = Logger.getLogger(SortingUtility.class.getName());
    /**
     * Selection Sort
     * Sorts the given array (in place) the Selection Sort algorithm.
     * inefficent on large lists
     * @param data the array to be sorted
     * @param <T>  the type of elements in the array
     */

    public static <T extends Comparable<T>> void selectionSort(T[] data) {
        //check if the array data is empty
        if(data == null ||data.length == 0) {
            messageLogger .warning("Array is empty");
        }else {
            int min;
            //iterate through the array
            for (int index = 0; index < data.length - 1; index++) {
                //assume the min is the first element
                min = index;
                for (int scan = index + 1; scan < data.length; scan++) {
                    //find minium value
                    if (data[scan].compareTo(data[min]) < 0) {
                        min = scan;
                    }
                }
                //swap minimum value with the lowest index
                swap(data, min, index);
            }
        }
    }
    /**
     * swap
     * Swaps the values at the given indices in the given array.
     * @param data   the array in which to swap values
     * @param index1 the index of the first value to be swapped
     * @param index2 the index of the second value to be swapped
     * @param <T>    the type of elements in the array
     */

    public static <T extends Comparable<T>> void swap(T[] data, int index1, int index2){
        //make a temp variable to hold the value of index1
        T temp = data[index1];
        // swap the value of index1 with index2
        data[index1] = data[index2];
        //finally swap the value of index2 with the value of index1 stored in temp
        data[index2] = temp;
    }

    /**
     * Gnome Sort
     * Sorts the given array (in place) using the Gnome Sort algorithm.
     * @param data the array to be sorted
     * @param <T>  the type of elements in the array
     */
    public static <T extends Comparable<T>> void gnomeSort(T[] data) {
        if (data == null || data.length == 0) {
            messageLogger.warning("Array is empty");
        } else {
            int pos = 0;
            //while the position is less than the length of the array
            while (pos < data.length) {
                //if the position is 0 or the value at the current position is greater than the value at the previous position
                if (pos == 0 || data[pos].compareTo(data[pos - 1]) > 0) {
                    //increment the position
                    pos++;
                } else {
                    //swap the value at the current position with the value at the previous position
                    swap(data, pos, pos - 1);
                    //decrement the position
                    pos--;
                }
            }
        }
    }
    /**
     * Cocktail Shaker Sort
     * Sorts the given array (in place) using the Cocktail Shaker Sort algorithm.
     * @param data the array to be sorted
     * @param <T>  the type of elements in the array
     */

    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {
        if (data == null || data.length == 0) {
            messageLogger.warning("Array is empty");
        } else {
            boolean swapped;
            do {
                swapped = false;
                for (int i = 0; i < data.length - 1; i++) {
                    if (data[i].compareTo(data[i + 1]) > 0) {
                        swap(data, i, i + 1);
                        swapped = true;
                    }
                }
                if (!swapped) {
                    break;
                }
                swapped = false;
                for (int i = data.length - 2; i >= 0; i--) {
                    if (data[i].compareTo(data[i + 1]) > 0) {
                        swap(data, i, i + 1);
                        swapped = true;
                    }
                }
            } while (swapped);
        }
    }
  /**
     * shellSort
     * Sorts the given array (in place) using the Shell Sort algorithm.
     * @param data the array to be sorted
     * @param <T>  the type of elements in the array
     */
    public static <T extends Comparable<T>> void shellSort(T[] data) {
        if(data == null || data.length ==0){
            messageLogger.warning("Array is empty");
        }else {
            //create an array of gaps
            int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
            //for each gap in the gaps array

            for (int gap : gaps) {
                for (int i = gap; i < data.length; i++) {
                    T temp = data[i];
                    int j;
                    for (j = i; (j >= gap && data[j - gap].compareTo(temp) > 0); j -= gap) {
                        data[j] = data[j - gap];
                    }
                    data[j] = temp;
                }
            }
        }
    }

   /**
     * bubbleSort
     * Sorts the given array (in place) using the Bubble Sort algorithm.
     * @param data the array to be sorted
     * @param <T>  the type of elements in the array
     */

    public static <T extends Comparable<T>> void bubbleSort(T[] data){
        if(data == null ||data.length == 0) {
            messageLogger.warning("Array is empty");
        }else {
            int position, scan;

            for (position = data.length - 1; position >= 0; position--) {
                for (scan = 0; scan <= position - 1; scan++) {
                    if (data[scan].compareTo(data[scan + 1]) > 0) {
                        swap(data, scan, scan + 1);
                    }
                }
            }
        }
    }

    /**
     * quickSort
     * @param data
     * @param min
     * @param max
     * @param <T>
     */

    public static <T extends Comparable<T>> void quickSort(T[] data, int min, int max){

        if(min < max){
            int pivot = partition(data, min, max);
            quickSort(data, min, pivot - 1);
            quickSort(data, pivot + 1, max);
        }
    }

    /**
     * partition
     * Partitions the given array between the min and max indices.
     * @param data the array to be partitioned
     * @param min  the minimum index of the partition
     * @param max  the maximum index of the partition
     * @param <T>  the type of elements in the array
     * @return the index of the pivot
     */

    private static <T extends Comparable<T>> int partition(T[] data, int min, int max){
        T pivot = data[min];
        int left = min;
        int right = max;

        while(left < right){
            while(data[left].compareTo(pivot) <= 0 && left < right){
                left++;
            }
            while(data[right].compareTo(pivot) > 0){
                right--;
            }
            if(left < right){
                swap(data, left, right);
            }
        }
        swap(data, min, right);
        return right;
    }

    /**
     * timeLogger
     * Logs the time taken to rsort the given sort method on the given data.
     * @param data       the data to be sorted
     * @param sortMethod the sort method to be timed
     * @param sortName   the name of the sort method
     * @param <T>        the type of elements in the array
     */
    private static final Logger timeLogger = Logger.getLogger(SortingUtility.class.getName());

    public static <T extends Comparable<T>> void timeLogger(T[] data, Runnable sortMethod, String sortName) {
        long startTime = System.currentTimeMillis();
        sortMethod.run();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(sortName + " took " + duration + " milliseconds.");
    }

}





