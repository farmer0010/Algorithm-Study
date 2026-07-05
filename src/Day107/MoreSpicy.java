package Day107;

// 더 맵게

// 모든 음식의 스코빌 지수를 k이상으로 만들고싶음
// 그래서 스코빌 지수가 가장 낮은 2개의 음식을 아래와
// 같은 방법으로 섞어서 새로운 음식을 민들려고함

// 섞은 음식의 스코빌 지수 = 가장 맵지않은 스코빌 지수
// + 두번째로 맵지않은 스코빌지수 * 2
// 모든 음식이 스코빌 지수가 k이상 될떄까지 반복하여 섞음
// leo가 가진 음식의 스코빌 지수를 담은 배열과 원하는 스코빌
// 지수가 주어질 때 모든 음식을 k이상으로 만들기 위해섞어야하는
// 최소 함수를 리턴

// 샌드박스
// 1. 우선 순위 큐를 통해서 항상 낮은 순으로 배치해서
// 섞고 정렬해줘야 편할듯??
// 2. 일단 앞에 두개를 뽑고 이게 k보다 작다면 다시 넣어줘야되니깐
// 그러면 다시 우선순위 큐에 offer로 넣어줘야되고

import java.util.PriorityQueue;

class MoreSpicy {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        // 1. pq 자체에 낮게 배치를 해줌
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }

        while(pq.peek() < K){
            if(pq.size() < 2){
                return -1;
            }

            int first = pq.poll();
            int second = pq.poll();

            int newScoville = first + (second * 2);

            pq.offer(newScoville);
            answer++;
        }

        return answer;
    }
}
