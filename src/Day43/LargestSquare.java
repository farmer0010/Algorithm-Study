package Day43;

// 가장 큰 정사각형 찾기
// 1x1의 정사각형으로 만들어진 표가있음
// 표에서 1로 이루어진 큰 정사각형을 찾아 rutrun
// 리턴값 1로 이루어진 길이를 재서 표에서 가장 큰 정사각형 값을 리턴

//샌드박스
//왜 dp로 해결해야하는가?
//현재 칸을 기준으로 오른쪽 맨 아래 꼭짓점으로 하는 정사각형?
// 일단 이 말은 잘 이해가 안되는데..
// dp[i][j]에 한변의 길이값이 얼마가 되는지 저장?
// 점화식: 왼쪽 ,위쪽, 왼쪽위 대각선이 다 1이라면
// 2*2? ..? 그리고 더 확장시키면 3*3이런식으로 퍼지는데
// 얘를 점화식으로 어떻게 짤지 잘 모르겠음..
// 예외케이스 행과 열의 왼쪽 ,위쪽, 왼쪽위의 인덱스가 0이하로 떨어지
// 지지않는 쪽에서만 작업하도록 해야할듯?

class LargestSquare
{
    public int solution(int [][]board)
    {
        int maxLength = 0;

        int rows = board.length;
        int cols = board[0].length;
        int[][] dp = new int[rows+1][cols+1];

        for (int i = 1; i <= rows; i++){
            for (int j = 1; j <= cols; j++){
                if(board[i-1][j-1] == 1){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]))+1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength*maxLength;
    }
}
