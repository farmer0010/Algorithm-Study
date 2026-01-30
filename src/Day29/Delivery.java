package Day29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Delivery {
    static class Node{
        int idx; // 도착지
        int cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        // 지도 만들기
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        // 다익스트라 알고리즘 : 횟수와 가중치 둘다 체크해야함
        // 1. 거리 기록표 만들기
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        // 우선 순위 큐 비용 순서가 적은대로 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost -o2.cost);
        pq.offer(new Node(1,0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.idx;
            int time = cur.cost;

            if(time > dist[now]){
                continue;
            }
            for (Node next : graph.get(now)) {
                int nextTime = time + next.cost;

                if(nextTime < dist[next.idx])
                {
                    dist[next.idx] = nextTime;
                    pq.offer(new Node(next.idx, nextTime));
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}
