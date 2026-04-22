package Day75;

// 합승 택시 요금

// 무지는 택시비를 아낄 비용 고민
// 무지는 자신이 택시를 이용 할 때 동료인 어피치 역시
// 자신과 비슷한 방향으로 가는 택시를 봄

// 무지는 어피치와 귀가 방향이 비슷하여 택시 합승을 이용하면
// 택시 요금을 얼마나 아낄수 있을지 계산해보고 어피치에게 합승을 제안하려고함

// n : 버스 정류장 번호
// s : 출발 지점
// a : a의 도착 지점
// b : b의 도착 지점
// farse[][] : 지점 사이의 도착 예상금액

// 다익스트라나 플루이드-워셜

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution_72413 {
    static class node implements Comparable<node>{
        int dest;
        int cost;

        public node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost-o.cost;
        }
    }
    ArrayList<node>[] graph;
    int distS[];
    int distA[];
    int distB[];
    static final int INF = 1_000_000_000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];
        distS = new int[n+1];
        distA = new int[n+1];
        distB = new int[n+1];

        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        // 노드(버스 표 만들기 완료)
        for (int[] fare : fares) {
            int src = fare[0];
            int dest = fare[1];
            int cost = fare[2];

            graph[dest].add(new node(src, cost));
            graph[src].add(new node(dest, cost));
        }

        dikstra_taxi(s, distS);
        dikstra_taxi(a, distA);
        dikstra_taxi(b, distB);

        int answer = INF;
        for(int i=1;i<=n;i++){
            if(distS[i] == INF || distA[i] == INF || distB[i] == INF){
                continue;
            }
            int totalPrice = distS[i] + distA[i] + distB[i];
            answer = Math.min(answer, totalPrice);
        }
        return answer;
    }

    private void dikstra_taxi(int start, int[] dist) {
        Arrays.fill(dist, INF);

        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.offer(new node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            node curr = pq.poll();
            int curDest = curr.dest;
            int curCost = curr.cost;

            if(dist[curDest] < curCost){
                continue;
            }
            for (node next :  graph[curDest]) {
                int nextCost = dist[curDest] + next.cost;
                if(nextCost < dist[next.dest]){
                    dist[next.dest] = nextCost;
                    pq.offer(new node(next.dest, nextCost));
                }
            }
        }
    }
}
