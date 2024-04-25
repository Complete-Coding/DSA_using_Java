
class ArrayCopy {

    public static void main(String[] args) {
        int[] newCopy = copy(new int[] { 1, 2, 3, 4, 5 });
    }

    private static int[] copy(int[] array) {
        int[] newCopy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newCopy[i] = array[i];
        }
        return newCopy;
    }
}