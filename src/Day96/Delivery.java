package Day96;

// 배달

// N개의 마을로 이루어진 나라고 있다
// 이 나라의 각 마을에는 1부터 N까지의 번호가 각각 하나씩 부여됨
// 각 마을은 양 방향으로 통행 할수 있는 도로가 연결 되어있고
// 서로 다른 마을을 이동 할떄는 이 도로를 지나야함
// 도로를 지날 때 걸리는 시간은 도로별로 다르며
// 현재 1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고함
// 근데 N개의 마을중에서 K시간 이하로 배달이 가능한 마을만 받으려고함
// 마을의 개수 N, 연결 하는 도로 road, 음식 배달이 가능한 시간 K
// road는 a,b,c 순서로 되는데 (a,b)가 도로가 연결하는 번호
// c가 도로를 지나는데 걸리는 시간임

// 일단 누적되어야하는 시간 k미만이여야되니깐 다익스트라나 bfs 두개가 생각이 드는데
// 그 배달해야되는 마을까지 최적의 수로 가야되니깐 그리디 적인 측면도
// 일부 섞여있고 일단 road의 정보를 담을수있는 클래스를 생성해주면 좋겟다?
// 라는 생각이 드는 정도임

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Delivery {
    class Node implements Comparable<Node>{
        int to;
        int cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
       ArrayList<ArrayList<Node>> graph = new ArrayList<>();
       for (int i = 0; i <= N; i++) {
           graph.add(new ArrayList<>());
       }
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int t = r[2];
            graph.get(a).add(new Node(b, t));
            graph.get(b).add(new Node(a, t));
        }

        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int dest =  cur.to;
            int cost = cur.cost;

            if(dist[dest] < cost){
                continue;
            }
            for(Node next : graph.get(dest)){
                int newCost = dist[dest] + next.cost;
                if(newCost < dist[next.to]){
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }

        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K)
                answer++;
        }
        return answer;
    }
}