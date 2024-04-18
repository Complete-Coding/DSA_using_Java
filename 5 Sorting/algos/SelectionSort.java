
class SelectionSort implements SortingAlgo {

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  @Override
  public void sort(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (nums[j] < nums[minIndex]) {
          minIndex = j;
        }
      }
      swap(nums, minIndex, i);
    }
  }

  public static void main(String[] args) {
    int[] nums = { 8, 6, 14, 77, 1, 13 };

    SortingAlgo sortingAlgo = new SelectionSort();
    sortingAlgo.sort(nums);
    System.out.print("Sorted Array:");
    printArray(nums);
  }

  private static void printArray(int[] nums) {
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}