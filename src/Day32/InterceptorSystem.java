package Day32;

import java.util.Arrays;

class InterceptorSystem {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(a,b)->{
            return a[1]-b[1];
        });
        int lateShot = -1;
        for (int[] missile : targets) {
            int start = missile[0];
            int end = missile[1];
            if (start >= lateShot) {
                answer++;
                lateShot = end;
            }
        }
        return answer;
    }
}
