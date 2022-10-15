package arrayString.MaxMatrixOfOne;

public class Matrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1, 1, 1},
                {1, 1, 0, 0, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 0},
        };

        int max = ofOneOptimized(matrix);
        System.out.println("\n\nMax: " + max);
    }

    public static int ofOneOptimized(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("The given matrix cannot be null");
        }

        int maxSubMatrixSize = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] subMatrix = new int[rows][cols];

        // 첫번째 열 복사
        for (int i = 0; i < cols; i++) {
            subMatrix[0][i] = matrix[0][i];
        }

        // 첫번째 행 복사
        for (int i = 0; i < rows; i++) {
            subMatrix[i][0] = matrix[i][0];
        }

        // 행렬의 나머지 영역을 순회하며 matrix[i][j] == 1 인지 확인
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) { // **
                    subMatrix[i][j] = Math.min(subMatrix[i - 1][j - 1], Math.min(subMatrix[i][j - 1], subMatrix[i - 1][j])) + 1;

                    maxSubMatrixSize = Math.max(maxSubMatrixSize, subMatrix[i][j]); // 최댓값 갱신
                }
            }
        }

        // subMatrix 출력
        for (int i = 0; i < subMatrix.length; i++) {
            System.out.println();
            for (int j = 0; j < subMatrix[i].length; j++) {
                System.out.print(subMatrix[i][j] + " ");
            }
        }

        return maxSubMatrixSize;
    }
}
