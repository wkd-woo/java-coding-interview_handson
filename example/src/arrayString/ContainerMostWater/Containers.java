package arrayString.ContainerMostWater;

public class Containers {
    public static void main(String[] args) {
        int[] heights = {1, 4, 6, 2, 7, 3, 8, 5, 3};

        int max = maxAreaOptimized(heights);

        System.out.println("Result : " + max);
    }

    public static int maxAreaOptimized(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(heights[left], heights[right]) * (right - left));
            if (heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
