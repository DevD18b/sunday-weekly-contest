public class problem1 {

    // 1 --> 0001
    // 3 --> 0011
    // 5 --> 0101
    // 7 --> 0111
    // 9 --> 1001
    // so from here we can recognize one thing that odd numbers have one at start.
    // and just to make number maximum we will put ones at most significant bit and
    // rest we have zeros in between.

    public static String makeOddStringMaximum(String str) {

        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return "1".repeat(Math.max(0, count - 1)) + "0".repeat(str.length() - count) + "1";

    }
}