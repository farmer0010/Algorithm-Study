package Day19;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        // 1. 범위 설정 (최소 1분 ~ 최대 시간)
        Arrays.sort(times);
        long left = 1;
        long right = (long) times[times.length -1] * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long complete = 0;

            for (int time : times) {
                complete += mid / time;
            }
            if(complete < n)
            {
                left = mid + 1;
            }
            else
            {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}
