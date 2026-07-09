package Day110;

// 행렬의 곱셈

// 2차원 행렬의 arr1, arr2를 입력 받아 행렬을 곱한 결과를
// 반환하시오
// 행렬의 곱셉은 i번째 행 * j 번쨰 열을 곱하는 식으로 이루어짐

// 3중 for문을 도는거같은데 첫 번째 for문에서는 첫번째
// 배열의 열의 개수만큼 돌아야되는거같고 , 두번째 for문은
// 행의 개수 만큼 돌아야가는거같고 세번째 for문은 두번쨰 배열의
// 열을 기준으로 돌아야될 것같고 그림을 그려봤을떈 그럼
// k과 어떻게 교차 이동하는 표적점을 만들지 생각하는 능력이 중요할듯

class MatrixMultiplication {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int len1 = arr1.length;
        int[][] answer = new int[len1][arr2[0].length];

        for (int i = 0; i < len1; i++) {
            for(int j = 0; j < arr2[0].length; j++) {
                for(int k = 0; k < arr2.length; k++) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                }
            }
        }

        return answer;
    }
}
