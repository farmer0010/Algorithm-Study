package Day150;

// 배달

// 마을의 번호는 1 ~ N번까지 부여됨
// 양방향 통행 가능하고 서로 다른 마을을 이동할떄는 이 동로를 통해야 함
// 도로를 지나는 시간은 도로마다 다름
// 각 마을로 부터 음식 주문을 받으려고하는 N개의 마을 중에서 K시간 이하로 배달이 가능한
// 마을에서만 주문을 받으려고함

// 한마을에서 이동하는 각 최종의 경로를 구하려면 일단 버스 운행지가 필요함

import java.util.*;

class Delivery {
    class Node implements Comparable <Node>{
        int dest;
        int cost;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    int[] dist;
    ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static final int INF = 100000000;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        dist = new int[N+1];
        Arrays.fill(dist, INF);

        dist[1] = 0;

        for(int i = 0; i < road.length; i++){
            int[] road_map = road[i];

            int start = road[i][0];
            int dest = road[i][1];
            int cost = road[i][2];

            list.get(start).add(new Node(dest, cost));
            list.get(dest).add(new Node(start, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            int dest = cur.dest;
            int cost = cur.cost;

            if(dist[dest] < cost)
                continue;

            for(Node next : list.get(dest)){
                int next_cost = dist[dest] + next.cost;

                if(dist[next.dest] > next_cost){
                    dist[next.dest] = next_cost;
                    pq.offer(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        for(int o : dist){
            if(o <= K)
                answer++;
        }

        return answer;
    }
}
