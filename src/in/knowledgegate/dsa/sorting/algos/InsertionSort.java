package in.knowledgegate.dsa.sorting.algos;

/**
 * Implement a sorting algo for Insertion Sort
 */
public class InsertionSort implements SortingAlgo {
  @Override
  public void sort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      int key = nums[i];
      int j = i - 1;
      while (j >= 0 && nums[j] > key) {
        nums[j+1] = nums[j];
        j--;
      }
      nums[j+1] = key;
    }
  }
}
