
import java.util.HashMap;
import java.util.Map;

/**
 * You've decided to make an advanced version of a
 * variant of the game Mahjong, incorporating runs.
 * 
 * Players have a number of hand, each marked 0-9.
 * The hand can be grouped into pairs or triples of
 * the same tile or runs.
 * 
 * A run is a series of three consecutive hand,
 * like 123, 678, or 456. 0 counts as the lowest tile,
 * so 012 is a valid run, but 890 is not.
 * 
 * A complete hand consists of exactly one pair, and
 * any number (including zero) of triples and/or
 * three-tile runs. Each tile is used in exactly one
 * triple, pair, or run.
 * 
 * Write a function that returns true or false
 * depending on whether or not the collection
 * represents a complete hand under these rules.
 * 
 * hand1 = "11123" # True. 11 123
 * hand2 = "12131" # True. Also 11 123. hand are not necessarily sorted.
 * hand3 = "11123455" # True. 111 234 55
 * hand4 = "11122334" # True. 11 123 234
 * hand5 = "11234" # True. 11 234
 * hand6 = "123456" # False. Needs a pair
 * hand7 = "11133355577" # True. 111 333 555 77
 * hand8 = "11223344556677" # True. 11 234 234 567 567 among others
 * hand9 = "12233444556677" # True. 123 234 44 567 567
 * hand10 = "11234567899" # False.
 * hand11 = "00123457" # False.
 * hand12 = "0012345" # False. A run is only three hand
 * hand13 = "11890" # False. 890 is not a valid run
 * hand14 = "99" # True.
 * hand15 = "111223344" # False.
 * 
 * All Test Cases
 * advanced(hand1) => True
 * advanced(hand2) => True
 * advanced(hand3) => True
 * advanced(hand4) => True
 * advanced(hand5) => True
 * advanced(hand6) => False
 * advanced(hand7) => True
 * advanced(hand8) => True
 * advanced(hand9) => True
 * advanced(hand10) => False
 * advanced(hand11) => False
 * advanced(hand12) => False
 * advanced(hand13) => False
 * advanced(hand14) => True
 * advanced(hand15) => False
 * 
 * Complexity Variable
 * N - Number of hand in the input string
 */
class MiniMahjongWinningHand2 {

  public boolean isWinningHand(String hand) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < hand.length(); i++) {
      int c = hand.charAt(i) - '0';
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() < 2)
        continue;
      Map<Integer, Integer> newMap = new HashMap<>(map);
      newMap.put(entry.getKey(),
          entry.getValue() - 2);
      if (isWinningHand(newMap)) {
        return true;
      }
    }
    return false;
  }

  private boolean isWinningHand(Map<Integer, Integer> newMap) {
    // remove triplets
    for (int i = 0; i <= 9; i++) {
      int val = newMap.getOrDefault(i, 0);
      newMap.put(i, val % 3);
    }

    // remove all possible runs
    for (int i = 0; i < 7; i++) {
      int val1 = newMap.getOrDefault(i, 0);
      int val2 = newMap.getOrDefault(i + 1, 0);
      int val3 = newMap.getOrDefault(i + 2, 0);
      int run = Math.min(Math.min(val1, val2),
          val3);
      if (run > 0) {
        newMap.put(i, val1 - run);
        newMap.put(i + 1, val2 - run);
        newMap.put(i + 2, val3 - run);
      }
    }

    // any value remaining
    for (Integer value : newMap.values()) {
      if (value > 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String hand1 = "11123";
    String hand2 = "12131";
    String hand3 = "11123455";
    String hand4 = "11122334";
    String hand5 = "11234";
    String hand6 = "123456";
    String hand7 = "11133355577";
    String hand8 = "11223344556677";
    String hand9 = "12233444556677";
    String hand10 = "11234567899";
    String hand11 = "00123457";
    String hand12 = "0012345";
    String hand13 = "11890";
    String hand14 = "99";
    String hand15 = "111223344";
    MiniMahjongWinningHand2 obj = new MiniMahjongWinningHand2();
    System.out.println(hand1 + ":" + obj.isWinningHand(hand1));
    System.out.println(hand2 + ":" + obj.isWinningHand(hand2));
    System.out.println(hand3 + ":" + obj.isWinningHand(hand3));
    System.out.println(hand4 + ":" + obj.isWinningHand(hand4));
    System.out.println(hand5 + ":" + obj.isWinningHand(hand5));
    System.out.println(hand6 + ":" + obj.isWinningHand(hand6));
    System.out.println(hand7 + ":" + obj.isWinningHand(hand7));
    System.out.println(hand8 + ":" + obj.isWinningHand(hand8));
    System.out.println(hand9 + ":" + obj.isWinningHand(hand9));
    System.out.println(hand10 + ":" + obj.isWinningHand(hand10));
    System.out.println(hand11 + ":" + obj.isWinningHand(hand11));
    System.out.println(hand12 + ":" + obj.isWinningHand(hand12));
    System.out.println(hand13 + ":" + obj.isWinningHand(hand13));
    System.out.println(hand14 + ":" + obj.isWinningHand(hand14));
    System.out.println(hand15 + ":" + obj.isWinningHand(hand15));
  }
}
