package km;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    public int solution(int[] A) {
        List<Long> nums = Arrays.stream(A).asLongStream().boxed().collect(Collectors.toList());
        Deque<Long> deque = new ArrayDeque<>();
        int mx = -1;
        for (Long num : nums) {
            if (deque.isEmpty() || deque.size() == 1) {
                deque.push(num);
            } else {
                Long firstPop = deque.pop();
                Long secondPop = deque.pop();
                if (secondPop == num) {
                    deque.push(secondPop);
                    deque.push(firstPop);
                    deque.push(num);
                } else {
                    deque.clear();
                    deque.push(firstPop);
                    deque.push(num);
                }
            }
            mx = Math.max(mx, deque.size());
        }

        return mx;
    }

}
