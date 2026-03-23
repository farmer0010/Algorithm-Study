package Day42;

// dp는 아직 익숙치않아서 샌드 박스 채우는 느낌보다는
// 코드를 치면서 감을 익히는 연습으로 해보자

import java.util.Arrays;

class ConvertNumber_DP {
    public int solution(int x, int y, int n) {
        int dp[] = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            int[] next = {i+n, i*2, i*3};
            for (int nex : next) {
                if(nex <=y)
                {
                    dp[nex] = Math.min(dp[nex], dp[i] + 1);
                }
            }
        }
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}
