
class ArraySum {
    public static void main(String[] args) {
        System.out.println("Sum:" + sum(new int[] { 5, 6 }));
        System.out.println("Sum:" + sum(new int[] { 1, 2, 3, 4, 5 }));
    }

    private static int sum(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }
}
