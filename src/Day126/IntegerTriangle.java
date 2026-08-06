package Day126;

// 정수 삼각형

// 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로중 거쳐간 숫자의 합이
// 가장 큰 경우를 찾으려고 한다. 아래칸으로 이동 할떄는 대각선의 방향으로 한칸 오른칸 또는
// 왼쪽으로만 이동이 가능함

// 샌드박스
// dp로 풀어야해 근데 어떤식으로 코드를 작성해야지 누적 값 형태로 차근 차큰 내려갈수
// 있을까를 고민해봐야 함
// 일단 이걸 그림으로 보면 아래로 이동하는 대각선 경로는 [i+1][j]와 [i+1][j+1] 방향으로
// 이동 가능함 그러면 누적되는 값은 [i][j] + [i+1][j], [i][j] + [i+1][j+1] 이 두가지 선택
// 식으로 계속 누적된다 볼수있음, 우리는 이걸 이걸 코드로 변환하려면 어떻게 해야할까?

import java.util.Arrays;

class IntegerTriangle {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], 0);
        }
        dp[0][0] = triangle[0][0];

        for(int i = 0; i < n -1; i++){
            for(int j = 0; j < i +1; j++){
                dp[i+1][j] = Math.max(dp[i +1][j], dp[i][j] + triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
            }
        }

        int answer = 0;

        for(int i = 0; i < dp[n-1].length; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }

        return answer;
    }
}
