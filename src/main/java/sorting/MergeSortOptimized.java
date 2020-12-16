package sorting;

/*
 * The optimization here is to avoid merge operation as and when the two sorted sub-array are in sequence
 */
public class MergeSortOptimized<T extends Comparable<T>> extends MergeSort<T> {
  @Override
  protected void sortSubArray(T[] array, T[] aux, int start, int end) {
    if (start == end)
      return;
    int mid = start + ((end - start) / 2);
    sortSubArray(array, aux, start, mid);
    sortSubArray(array, aux, mid + 1, end);
    // Optimization
    if (array[start].compareTo(array[mid]) <= 0 && array[mid].compareTo(array[end]) <= 0)
      return;
    merge(array, aux, start, mid, end);

  }
}
