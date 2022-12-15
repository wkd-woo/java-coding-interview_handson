package arrayString.TrapRainWater;

import java.util.Stack;

public class Bars {

    public static void main(String[] args) {
        int[] bars = {1, 0, 0, 4, 0, 2, 0, 1, 6, 2, 3};
        // int[] bars = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};  // 25
        // int[] bars = {0, 3, 0, 4, 3, 0, 3, 5, 4, 3, 4, 3}; // 10
        // int[] bars = {1, 0, 2, 2, 4, 0, 1, 5, 2, 1, 6, 1}; // 15
        // int[] bars = {0, 0, 0, 3}; // 0
        // int[] bars = {4, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 14
        // int[] bars = {0, 1, 2}; // 0

        int water1 = trapViaArray(bars);
        int water2 = trapViaStack(bars);
        int water3 = trapOptimized(bars);
        System.out.println("Result: " + water1 + " | " + water2 + " | " + water3);
    }

    public static int trapViaArray(int[] bars) {
        if (bars == null || bars.length == 0) {
            return 0;
        }

        int n = bars.length - 1;
        int water = 0;

        int[] left = new int[n];
        left[0] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], bars[i - 1]);
        }

        int right = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 1; i--) {
            right = Math.max(right, bars[i + 1]);

            if (Math.min(left[i], right) > bars[i]) {
                water += Math.min(left[i], right) - bars[i];
            }
        }
        return water;
    }

    // 실행 시간이 O(n), left[] 스택을 저장하기 위한 보조 공간이 O(n)
    public static int trapViaStack(int[] bars) {
        if (bars == null || bars.length == 0) {
            return 0;
        }

        int water = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < bars.length; i++) {
            while (!stack.empty() && bars[i] > bars[stack.peek()]) {
                int topBar = stack.pop();

                // 스택이 비어 있으면 빗물이 고일 수 없습니다.
                if (stack.empty()) {
                    continue;
                }

                int width = i - stack.peek() - 1;
                int height = Math.min(bars[i], bars[stack.peek()]) - bars[topBar];

                water += width * height;
            }

            stack.push(i);
        }

        return water;
    }

    // 실행 시간이 O(n)이고 공간 복잡도가 O(1)
    public static int trapOptimized(int[] bars) {
        // 포인터 2개를 사용합니다. left는 0, right는 bars.length-1을 나타냅니다.
        int left = 0;
        int right = bars.length - 1;

        int water = 0;

        int maxBarLeft = bars[left];
        int maxBarRight = bars[right];

        while (left < right) {
            // 왼쪽 포인터를 오른쪽으로 이동합니다.
            if (bars[left] <= bars[right]) {
                left++;
                maxBarLeft = Math.max(maxBarLeft, bars[left]);
                water += (maxBarLeft - bars[left]);
                // 오른쪽 포인터를 왼쪽으로 이동합니다.
            } else {
                right--;
                maxBarRight = Math.max(maxBarRight, bars[right]);
                water += (maxBarRight - bars[right]);
            }
        }

        return water;
    }
}
