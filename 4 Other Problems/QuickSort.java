
class QuickSort implements SortingAlgo {

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private int partition(int[] nums, int low,
      int high) {
    int pivot = nums[high];
    int i = low;

    for (int j = low; j < high; j++) {
      if (nums[j] < pivot) {
        swap(nums, i++, j);
      }
    }
    swap(nums, i, high);
    return i;
  }

  private void quickSort(int[] nums, int low,
      int high) {
    if (low < high) {
      int partitionIndex = partition(nums, low,
          high);
      quickSort(nums, 0, partitionIndex - 1);
      quickSort(nums, partitionIndex + 1, high);
    }
  }

  @Override
  public void sort(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    int[] arr = { 8, 6, 14, 77, 1, 13 };
    int n = arr.length;

    SortingAlgo sort = new QuickSort();
    sort.sort(arr);
    System.out.println("Sorted array: ");
    printArray(arr, n);
  }

  static void printArray(int[] arr, int size) {
    for (int i = 0; i < size; i++)
      System.out.print(arr[i] + " ");
    System.out.println();
  }
}