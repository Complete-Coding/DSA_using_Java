
/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess
 * which number I picked.
 *
 * Every time you guess wrong, I will tell you
 * whether the number I picked is higher or lower than
 * your guess.
 *
 * You call a pre-defined API int guess(int num),
 * which returns three possible results:
 *
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 *
 *
 * Example 1:
 * Input: n = 10, pick = 6
 * Output: 6
 *
 * Example 2:
 * Input: n = 1, pick = 1
 * Output: 1
 *
 * Example 3:
 * Input: n = 2, pick = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 */
class GuessNumberHigherOrLower {
    static int numberToGuess;

    public static void main(String[] args) {
        GuessNumberHigherOrLower guesser = new GuessNumberHigherOrLower();
        numberToGuess = 99;
        System.out.println("\nnumber is:" + guesser.guessNumberNormalSearch(100));
        System.out.println();
        System.out.println("\nnumber is:" + guesser.guessNumber(100));
    }

    public int guessNumber(int n) {
        int beg = 1, end = n;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            if (res == -1)
                end = mid - 1;
            else
                beg = mid + 1;
        }
        return -1;
    }

    public int guessNumberNormalSearch(int n) {
        for (int i = 1; i <= n; i++) {
            if (guess(i) == 0)
                return i;
        }
        return -1;
    }

    private int guess(int num) {
        System.out.print(".");
        if (num == numberToGuess)
            return 0;
        else if (num < numberToGuess)
            return 1;
        return -1;
    }
}
