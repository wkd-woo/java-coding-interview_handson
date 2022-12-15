package arrayString.MergeIntervals;

import java.util.Comparator;
import java.util.Stack;

public class Arrays {
    public static void main(String[] args) {
        Interval intervals[] = new Interval[7];

        // [[12,15], [12,17], [2,4], [16,18], [4,7], [9,11], [1,2]]
        intervals[0] = new Interval(12, 15);
        intervals[1] = new Interval(12, 17);
        intervals[2] = new Interval(2, 4);
        intervals[3] = new Interval(16, 18);
        intervals[4] = new Interval(4, 7);
        intervals[5] = new Interval(9, 11);
        intervals[6] = new Interval(1, 2);

        System.out.print("The merged intervals via stack: ");
        Arrays.mergeIntervals(intervals);
    }

    public static void mergeIntervals(Interval[] intervals) {
        Stack<Interval> stack = new Stack<>();

        java.util.Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        for (Interval interval : intervals) {
            if (stack.isEmpty() || interval.start > stack.peek().end) { // 스택이 비어있으면 일단 넣는다.
                stack.push(interval);
            } else { // 스택에 요소가 있으면
                // 스택 맨 위 요소를 확인
                if (stack.peek().end >= interval.start) { // 다음 구간의 시작점이 peek의 시작점 이하라면
                    Interval item = stack.pop();
                    item.setStart(Math.min(item.start, interval.start)); // 뽑아서 시작점 더 작은 값으로 조기화
                    item.setEnd(Math.max(item.end, interval.end)); // 구간 종료점도 더 큰 것으로 초기화
                    stack.push(item);
                } else {
                    stack.push(interval);
                }
            }
        }

        while (!stack.empty()) {
            System.out.println("stack.pop() = " + stack.pop() + " ");
        }
    }

    private static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}