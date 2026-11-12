package Day167;

// 정수 삼각형

// 삼각형에서 꼭대기로 이어지는 경로중 거쳐간 숫자의 합이
// 가장 큰 경우를 찾아보려고함
// 아래칸으로 이동할때는 대각선 방향 한칸 오른쪽 또는 왼쪽으로만
// 이동가능

// 샌드박스 한칸씩 이동하고 누적값을 구해야하기에 dp가 해결법
// 매순간 최고의 선택이 아니라 칸마다 누적되는 식으로 내려야함

class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;

        int r = triangle.length;

        int dp[][] = new int[r][r];

        dp[0][0] = triangle[0][0];

        for(int k = 1; k < triangle.length; k++){
            for(int i = 0; i < triangle[k].length; i++){
                if(i == 0){
                    dp[k][i] = triangle[k][i] + dp[k-1][i];
                }
                else if(i == triangle[k].length -1){
                    dp[k][i] = triangle[k][i] + dp[k-1][i-1];
                }
                else{
                    dp[k][i] = triangle[k][i] + Math.max(dp[k-1][i-1], dp[k-1][i]);
                }
            }
        }

        for(int f = 0; f < triangle.length; f++){
            answer = Math.max(answer ,dp[triangle.length - 1][f]);
        }

        return answer;
    }
}
