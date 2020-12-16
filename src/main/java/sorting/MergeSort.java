package sorting;

import java.util.Arrays;

/*
 * Merge sort is a divide and conquer algorithm used to sort lists/arrays
 * The basis idea behind the algorithm is divide the array in sub-arrays, 
 * sort the smallest 1s and then merge them back forming a sorted array.
 * 
 * Merge sort is called as the stable sorting algorithm, because in case of ties,
 * the ordering as per the original array is preserved.
 * 
 * Time Complexity: O( N logN ), logN - splits and N for merging 
 * 
 * Merge Sort is preferable while sorting Objects, because of its stability
 */
public class MergeSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

  @Override
  public void sort(T[] array) {
    sortIt(array);
  }

  protected void sortSubArray(T[] array, T[] aux, int start, int end) {
    if (start == end)
      return;
    int mid = start + ((end - start) / 2);
    sortSubArray(array, aux, start, mid);
    sortSubArray(array, aux, mid + 1, end);
    merge(array, aux, start, mid, end);

  }

  protected void merge(T[] array, T[] aux, int start, int mid, int end) {
    // TODO Auto-generated method stub
    int pos = start, temp = mid + 1;
    for (int i = start; i <= end; i++) {
      aux[i] = array[i];
    }
    while (start <= mid && temp <= end) {
      int comp = (aux[start]).compareTo(aux[temp]);
      if (comp <= 0) {
        array[pos++] = aux[start++];
      } else {
        array[pos++] = aux[temp++];
      }
    }
    while (start <= mid)
      array[pos++] = aux[start++];
    while (temp <= end)
      array[pos++] = aux[temp++];

  }

  private void sortIt(T[] array) {
    T[] aux = Arrays.copyOf(array, array.length);
    sortSubArray(array, aux, 0, array.length - 1);
  }
}
