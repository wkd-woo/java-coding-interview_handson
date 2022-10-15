package arrayString.MergeKSortedArr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinHeap {

    public static void main(String[] args) {
        int[][] arrs = {
                {1, 2, 32, 46},
                {-4, 5, 15, 18, 20},
                {3},
                {6, 8},
                {-2, -1, 0}
        };

        int[] result = merge(arrs, arrs.length);
        System.out.println(Arrays.toString(result));
    }

    public static int[] merge(int[][] args, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] arg : args) {
            Arrays.stream(arg).boxed().forEach(heap::add);
        }

        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
