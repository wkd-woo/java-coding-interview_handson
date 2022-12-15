package arrayString.RotateMatrix;

public class Arrays {
    public static void main(String[] args) {
        int s = 5;

        // 동일한 행렬 3개
        int[][] m1 = new int[s][s]; // rotateInNew 메서드를 호출할 때 사용
        int[][] m2 = new int[s][s]; // rotateWithTranspose 메서드를 호출할 때 사용
        int[][] m3 = new int[s][s]; // rotateRing 메서드를 호출할 때 사용

        // 숫자 0, 1, 2, ..., (s - 1)로 행렬을 초기화
        int v = 0;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                m1[i][j] = ++v;
                m2[i][j] = m1[i][j];
                m3[i][j] = m1[i][j];
            }
        }

        System.out.println("Initial matrix:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", m1[i][j]);
            }

            System.out.println();
        }

//        System.out.println();
//        int[][] result = rotateInNew(m1);
//        System.out.println("Rotated counterclockwise by 90 degrees via new matrix:");
//        for (int i = 0; i < s; i++) {
//            for (int j = 0; j < s; j++) {
//                System.out.format("%4s", result[i][j]);
//            }
//
//            System.out.println();
//        }

        System.out.println();
        Arrays.rotateWithTranspose(m2);
        System.out.println("Rotated counterclockwise by 90 degrees via transpose:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", m2[i][j]);
            }

            System.out.println();
        }

        System.out.println();
        rotateRing(m3);
        System.out.println("Rotated counterclockwise by 90 degrees ring by ring:");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                System.out.format("%4s", m3[i][j]);
            }

            System.out.println();
        }
    }

    public static void transpose(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
    }

    public static boolean rotateWithTranspose(int m[][]) {
        if (m == null || m.length == 0) {
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        if (m.length != m[0].length) {
            throw new IllegalArgumentException("The given matrix must be of type nxn");
        }

        transpose(m);

        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0, k = m[0].length - 1; j < k; k--) {
                int temp = m[j][i];
                m[j][i] = m[k][i];
                m[k][i] = temp;
            }
        }

        return true;
    }

    public static boolean rotateRing(int[][] m) {
        if (m == null || m.length == 0) {
            throw new IllegalArgumentException("The given matrix cannot be null or empty");
        }

        if (m.length != m[0].length) {
            throw new IllegalArgumentException("The given matrix must be of type nxn");
        }

        int len = m.length;

        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = m[i][j];

                // 오른쪽 -> 위쪽
                m[i][j] = m[j][len - 1 - i];

                // 아래쪽 -> 오른쪽
                m[j][len - 1 - i] = m[len - 1 - i][len - 1 - j];

                // 왼쪽 -> 아래쪽
                m[len - 1 - i][len - 1 - j] = m[len - 1 - j][i];

                // 위쪽 -> 왼쪽
                m[len - 1 - j][i] = temp;

            }
        }
        return true;
    }
}
