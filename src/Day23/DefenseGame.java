package Day23;

import java.util.Collections;
import java.util.PriorityQueue;

class DefenseGame {
    public int solution(int n, int k, int[] enemy) {
        // 지금까지 막은 적들중 제일 큰놈을 꺼내려면 정렬 필요
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : enemy) {
            n -= i;
            pq.offer(i);
            if (n < 0)
            {
                if(k > 0)
                {
                    int max = pq.poll();
                    n += max;
                    k--;
                }
                else
                    break;
            }
            answer++;
        }
        return answer;
    }
}
