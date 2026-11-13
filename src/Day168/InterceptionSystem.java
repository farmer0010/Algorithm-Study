package Day168;

// 요격 시스템

// 미사일을 최소로 사용해서 폭격 미사일을 요격
// 폭격 미사일은 x축에 평행한 직선 형태
// 정수 쌍 (s,e)로 표현 됨
// b 나라는 특정 x좌표에서 y축에 수평이 되도록 발사
// 그리고 이 경계값에서는 포함되지않음을 알아야함

// 얘도 종료지점을 기점으로 비교하면 횟수를 구하면 될것같은데
// 일단 정렬과정이 필요할듯 (우리는 종료지점을 기준으로 파악을 해야하니 종료지점을 기준으로 정렬)

import java.util.*;

class InterceptionSystem {
    public int solution(int[][] targets) {
        int answer = 1;

        Arrays.sort(targets, (a, b) -> {
            return a[1] - b[1];
        });

        int idx = targets[0][1];

        for(int i = 1; i < targets.length; i++){
            if(idx > targets[i][0]){
                continue;
            }
            else{
                idx = targets[i][1];
                answer++;
            }
        }

        return answer;
    }
}
