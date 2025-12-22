package Day7;

// 섞은 음식 스코빌 지수 = 가장 맵지않은 음식의 스코빌지수 + (두번째로 스코빌 지수가 낮은 음식 * 2)
// 우선 순위 큐를 활용해 낮은 순으로 정렬 시킨후 대입
// 조건을 걸어줘야하는데

import java.util.PriorityQueue;

class MoreSpicy {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int i : scoville) {
            pq.offer(i);
        }
        while(pq.peek() < K)
        {
            if(pq.size() < 2)
                return -1;
            int first = pq.poll();
            int second = pq.poll();
            int mix = first + (second * 2);
            pq.offer(mix);
            answer++;
        }
        return answer;
    }
}
