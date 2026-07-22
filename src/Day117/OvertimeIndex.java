package Day117;

// 야근 지수

// 야근을 하면 야근 피로도가 쌓임
// 야근 피로도는 야근을 시작한 시점에서
// 남은 일의 작업량을 제곱하여 더한값
// 야근 피로도 =
// 야근자는 N시간동안 야근 피로도를 최소화 하도록 일함
// 야근자는 1시간동안 작업량 1만큼 처리 할 수있다고 할 때
// 퇴근까지 남은 N시간과 각 일에 대한 작업량 works에 대해
// 야근 피로도 값을 최소화한 값을 리턴하시오

// 샌드박스

// 그리디 알고리즘이 필요할 것같다는 생각이 듬
// 일단 계산을 하면서 든 생각이 우선 순위 큐(내림 차순)
// 을 활용하여 맨 앞에 나오는 큐를 1씩 줄이고
// n을 줄여야됨 근데 만약 큐가 다 끝났는데도 n이 남으면
// 그때는 0을 반환 하는식으로? 작업 해보면 될듯

import java.util.PriorityQueue;
import java.util.Collections;

class OvertimeIndex {
    public long solution(int n, int[] works) {
        long answer = 0;
        long checkNum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works){
            pq.offer(work);
            checkNum += work;
        }

        if(checkNum < n){
            return 0;
        }

        while (n > 0){
            int num = pq.poll();
            num --;
            pq.offer(num);
            n -= 1;
        }

        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += Math.pow(num, 2);
        }


        return answer;
    }
}
