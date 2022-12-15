package arrayString.FindPairSumEqualK;

import java.util.*;
import java.util.List;

public class Arrays {

    public static void main(String[] args) {
        int sum = 10;
        int[] arr = new int[]{-5, -2, 5, 4, 3, 7, 2, 1, -1, -2, 15, 6, 12, -4, 3};

        List<String> result = pairs(arr, sum);

        System.out.println("Result: " + result);
    }

    public static List<String> pairs(int[] m, int k) {
        if (m == null || m.length < 2) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        java.util.Arrays.sort(m);

        int l = 0;
        int r = m.length - 1;

        while (l < r) {
            int sum = m[l] + m[r];

            if (sum == k) {
                result.add("(" + m[l] + " + " + m[r] + ")");
                l++;
                r--;
            } else if (sum < k) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }


}
