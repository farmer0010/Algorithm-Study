package Day127;

// 가장 큰 정 사각형 찾기

// 1과 0이 채워진 board 표가 있다 표칸은 1*1 정사각형으로 이루어져있고
// 표에서 1로 이루어진 가장 큰 정사각형을 찾아 return하는 함수를 만들어라

class LargestSquare
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0)
                    dp[i][j] = 0;
                if((i == 0 || j == 0) && board[i][j] == 1)
                    dp[i][j] = 1;
                else{
                    if(board[i][j] == 1){
                        int small = Math.min(dp[i-1][j], Math.min((dp[i][j-1]),dp[i-1][j-1]));
                        dp[i][j] = small + 1;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                answer = Math.max(answer, dp[i][j]);
        }

        return answer * answer;
    }
}
