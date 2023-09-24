public class BeautifulTower1 {

    // toh mujhe ek height array diya hua hai
    // and unhone mujhe bola hai aapko in heights
    // ka use kr keh BeautifulTower1 form krna hai
    // jaha pr condition yeh hai ki heights[i]
    // will the greater then 1 and less then the maximum height.
    // and the second condition is height[i-1] <= height[i].
    // and right half meh height[k]<=height[k+1].
    // now we need to build this mountain array in a way that.
    // \\
    // \\ ----> this is kind of the structure we need to form
    // \\
    // \\

    // brute can work here as what i will say meh har ek height[i]
    // ko peak index maan kr keh
    // mountain array build krne ki koshish karunga and simplyy i am gonna find
    // maximum sum har array keh liyee.

    public static int solver(int[] height) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            maxSum = Math.max(maxSum, buildMountain(height, i));
        }
        return maxSum;
    }

    public static int buildMountain(int[] arr, int index) {

        int n = arr.length;
        int minHeight = arr[index];

        int maxSum = 0;
        for (int i = index - 1; i >= 0; i--) {
            minHeight = Math.min(minHeight, arr[i]);
            maxSum += minHeight;
        }
        minHeight = arr[index];
        for (int i = index + 1; i < arr.length; i++) {
            minHeight = Math.min(minHeight, arr[i]);
            maxSum += minHeight;
        }
        return maxSum;
    }

}
