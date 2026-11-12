package Day167;

// 타일링

// 가로 길이가 2이고, 세로 길이가 1인 직사각형 모양의 타일이 존재
// 타일을 채울때 가로로 배치하는 경우, 세로로 배치하는 경우 두가지로 타일을
// 채울수 있음
// 가로 길이 n인 매개변수가 주어질 때 이 직사각형을 채우는 방법의 수를 리턴

// 샌드박스
// n이 5일때까지 늘어나는 개수를 보니 피보나치의 특성을 가지고 있음

class Tiling2xN {
    int dp[];

    public int solution(int n) {
        int answer = 0;

        dp = new int[n+1];

        answer = fibo(n);

        return answer;
    }

    public int fibo(int n){
        dp[1] = 1;
        dp[2] = 2;

        for(int k = 3; k <= n; k++){
            dp[k] = (dp[k-2] + dp[k-1]) % 1000000007;
        }

        return dp[n];
    }
}
