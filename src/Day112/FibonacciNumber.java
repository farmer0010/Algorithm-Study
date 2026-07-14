package Day112;

// 피보나치 수
// f(n) = f(n-1) + f(n-2)
// 샌드박스
// 2이상이기떄문에 그 밑에는 굳이 처리할 필요없고
// 리턴할 때 저 정해진 숫자로 나눠서 리턴해주면 끝인 문제인가?
// 디비는 재귀와 단순 반복처럼 푸는 방법이 있고 요기 같은경우엔
// dp 동적 배열을 활용하여 품

class FibonacciNumber {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}
