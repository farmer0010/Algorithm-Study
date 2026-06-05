package Day93;

// 등굣길
// 계속 되는 폭우로 일부 지역이 잠겨서
// 물에 잠기지 않은 지역을 통해 학교를 가려고함
// 집에서 학교까지 가는 길은 m * n 의 격자 모양으로 나타낼수 있음

// 가장 왼쪽 위 , 즉 집이 있는 곳의 좌표는 1,1로 나타내고
// 학교가 있는 곳의 좌표는 m,n으로 나타냄
// 격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열이
// 매개 변수로 주어짐

// 방향은 오직 오른쪽과 아래로만 움직여, 집에서 학교까지 갈수있는
// 최단 경로의 개수를 (수)로 나눈 나머지를 리턴하도록 하시오

class WayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];

        for(int[] p : puddles){
            if(puddles.length > 0)
                dp[p[1]][p[0]] = -1;
        }
        dp[1][1] = 1;

        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
            {
                if(i == 1 && j == 1)
                    continue;
                if(dp[i][j] == -1)
                {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }

        return dp[n][m];
    }
}
