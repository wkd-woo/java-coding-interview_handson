package arrayString.MergeKSortedArr;

import java.util.*;

public class MaxHeap {

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
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });

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
