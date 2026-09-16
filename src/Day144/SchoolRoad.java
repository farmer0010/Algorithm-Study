package Day144;

// 등굣길

// 물에 잠기지 않는 지역을 통해 학교를 가려고함
// 집에서 학교까지 가는 길은 m * n 크기의 격자 모양으로 나타낼 수있음

// 집이 있는 곳의 좌표를 1,1로 나타내고 학교가 있는 곳은 m * n으로 나타내는 곳에 도달해야함
// puddles은 지금 물이 담긴 좌표
// 오른쪽과 아래쪽으로만 움직여, 학교까지 갈 수있는 최단 경로의 개수를 1,000,000,007
// 로 나눠서 리턴

// 샌드박스
// 1. 판만의 지도를 그려주기
// 2. 좌표에 맞게 물울덩이 지역 표기하기

class SchoolRoad {
    public int solution(int m, int n, int[][] puddles) {

        int dp[][] = new int [m+1][n+1];

        for(int[] p : puddles){
            dp[p[0]][p[1]] = -1;
        }

        dp[1][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 && j == 1){
                    continue;
                }
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000007;
            }
        }

        return dp[m][n];
    }
}
