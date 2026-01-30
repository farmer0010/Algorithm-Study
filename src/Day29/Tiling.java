package Day29;

// 1. 규칙 찾는게 중요 가로가 n일떄마다?
// 2. 1일때 1개 2일떄 2개 3일때 3개 4일떄 5개?
// 3. 메이커의 힌트에 따라 피보나치이지 않을까 의심
// 4. 이 힌트가 없다면 정말 어렵겠지만 수학점으로
// 5. 방법만 알면 쉽다

class Tiling {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2; // n이 1일떄 여기가 에러날수있으니 문제조건 확인 필요

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}
