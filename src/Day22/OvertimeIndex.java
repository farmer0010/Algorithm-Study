package Day22;

import java.util.Collections;
import java.util.PriorityQueue;

class OvertimeIndex {
    public long solution(int n, int[] works) {
        // 1. 큰 숫자가 나오는 우선 순위 큐 생성
        // 우선 순위큐는 항상 자기 상황에 맞게 자리를 찾아감
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 모든 작업량을 일단 q에 넣어줌
        for (int w : works) {
            pq.offer(w);
        }
        // 2. 남은 시간 n동안 제일 많이 남은 일부터 1씩 깎기
        for (int i = 0; i < n; i++) {
            if(pq.isEmpty())
                break;
            int maxFork = pq.poll();
            if(maxFork > 0){
                maxFork--;
                pq.offer(maxFork);
            }
        }
        long answer = 0;
        for (int w : pq) {
            answer += (long)w*w;
        }
        return answer;
    }
}
