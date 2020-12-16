package Sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import sorting.BottomUpMergeSort;
import sorting.MergeSort;
import sorting.SortingAlgorithm;

public class TestSortingAlgorithm {

  private SortingAlgorithm<Integer> sortInteger;
  private static Integer[] array = { 2, 6, 1, 8, 10, 7 };

  @Test
  public void testMergeSort() {
    sortInteger = new MergeSort<Integer>();
    sortInteger.sort(array); // Arrays.sort(a);
    System.out.println("After Sorting :" + Arrays.toString(array));
    assertTrue(isSorted(array));
  }

  @Test
  public void TestBottomUpMergeSort() {
    sortInteger = new BottomUpMergeSort<Integer>();
    sortInteger.sort(array); // Arrays.sort(a);
    System.out.println("After Sorting :" + Arrays.toString(array));
    assertTrue(isSorted(array));
  }

  private boolean isSorted(Integer[] array) {
    boolean res = true;
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] < array[i])
        continue;
      else {
        res = false;
        break;
      }
    }
    return res;
  }
}
