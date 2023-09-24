import java.util.Stack;

public class BeautifulTower2 {

    public static long maximumSumOfHeights(int[] arr) {

        int[] immediatePrevSmall = prevSmallerIndex(arr);
        int[] immediateNextSmall = nextSmallerIndex(arr);

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (immediateNextSmall[i] == -1) {
                immediateNextSmall[i] = n;
            }
        }
        int[] leftMaximumSum = new int[n];
        leftMaximumSum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int prevIndex = immediatePrevSmall[i];
            int numberOfElement = i - prevIndex;
            leftMaximumSum[i] = leftMaximumSum[i] + numberOfElement * arr[i];
            if (prevIndex != -1) {
                leftMaximumSum[i] += leftMaximumSum[prevIndex];
            }
        }

        int[] rightMaximumSum = new int[n];
        rightMaximumSum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int nextIndex = immediateNextSmall[i];
            int numberOfElement = nextIndex - i;
            rightMaximumSum[i] = rightMaximumSum[i] + numberOfElement * arr[i];
            if (nextIndex != n) {
                rightMaximumSum[i] += rightMaximumSum[nextIndex];
            }
        }
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, leftMaximumSum[i] + rightMaximumSum[i] - arr[i]);
        }
        return ans;

    }

    public static int[] prevSmallerIndex(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] ans = new int[arr.length];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() != -1 && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public static int[] nextSmallerIndex(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() != -1 && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
