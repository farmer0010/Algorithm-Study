package Day37;

// 샌드박스
// 개수를 세보니 피보나치 수열이네?
// 리턴값은 1234567로 나눠서 리턴

class LongJump {
    public long solution(int n) {
        long[] dp = new long[n + 1];
        if(n == 1)
            return 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%1234567;
        }
        return dp[n];
    }
}
