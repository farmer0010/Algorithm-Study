package Day54;

// 더 맵게
// leo는 모든 음식의 스코빌 지수를 k 이상으로
// 만들고 싶어함

// 모든 음식의 스코빌 지수를 k 이상으로 만들기 위해
// 가장 스코빌 지수가 낮은 두개의 음식을 섞음

// 섞은 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
// 리턴 값 : k 이상으로 만들기 위해서 섞어야하는
// 최소 횟수
// -1

import java.util.PriorityQueue;

class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.offer(i);
        }
        while (pq.peek() < K)
        {
            if(pq.size() < 2)
                return -1;

            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + second*2);
            answer++;
        }

        return answer;
    }
}
