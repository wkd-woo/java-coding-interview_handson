package arrayString.SearchInCircularArray;

public class Arrays {
    public static void main(String[] args) {

    }

    public static int find(int[] m, int x) {
        if (m == null || m.length == 0) {
            return -1;
        }

        int left = 0;
        int right = m.length - 1;

        while (left <= right) {
            // 중앙값 지정
            int middle = left + right / 2;

            // 타겟을 찾았을 때
            if (m[middle] == x) {
                return middle;
            }

            /**   좌측에서 탐색        우측에서 탐색
             * left <--> middle , middle <--> right
             */
            // 오른쪽 영역이 정렬된 상태인지 확인
            if (m[middle] <= m[middle + 1]) {
                // 목푯값이 범위 안에 있는지 확인
                if (x > m[middle] && x <= m[right]) {
                    left = middle + 1;
                } else { // 범위 안에 없으면 탐색    범위 좁힘
                    right = middle - 1;
                }
            } else { // 우측이 정렬 안되어있으면
                if (x >= m[left] && x < m[middle]) { // 좌측 범위에 x가 있는지 확인
                    right = middle - 1;
                } else { // 범위 안에 없으면 탐색 범위 좁힘
                    left = middle + 1;
                }
            }
        }
        return -1;
    }
}
