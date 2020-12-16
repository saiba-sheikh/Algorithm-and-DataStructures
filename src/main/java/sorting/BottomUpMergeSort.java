package sorting;

import java.util.Arrays;

/*
 * This is an iterative way of performing a merge sort.
 * Here we divide the array/list in smaller groups, starting of size 1
 * and merge them forming a sorted array
 * 
 * Time complexity :  ( N log N )
 */
public class BottomUpMergeSort<T extends Comparable<T>> extends MergeSort<T> {

  @Override
  public void sort(T[] array) {
    T[] aux = Arrays.copyOf(array, array.length);
    // Loop1 : to divide input in groups
    for (int size = 1; size < array.length; size = size + size) {
      // Loop2: merge each group
      for (int start = 0; start < array.length - size; start += size + size) {
        merge(array, aux, start, start + size - 1, Math.min(start + size + size - 1, array.length - 1));
      }
    }
  }

}
