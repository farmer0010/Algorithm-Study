package Day127;

//배달

// n개의 마을로 이루어진 나라가 있음
// 이 나라는 각 마을 1번부터 N번까지 번호가 부여됨
// 각 마을은 양방향으로 통행 할 수있는 도로로 연결되었고, 서로 다른 마을 간에 이동할떄는
// 도로를 지나야하며 지나는데 각 걸리는 시간은 다름
// 현재 1번 마을에서 각 마을로 음식을 배달하려고하는데 K 시간이하로 걸리는데만 배달 가능함
// 여기서 음식 주문을 받을수 있는 마을의 개수를 리턴해라

// road : a,b는 마을 번호 c는 걸리는 시간

// 샌드박스
// 하나에서 걸리는 모든 마을까지의 표를 파악해야하니 다익스트라를 사용해봐야할듯함
// 그러면 일단 요금표를 만들 dist[] 라는 배열과, 인접 배열리스트를 활용한 방법으로 풀어보면
// 어떨까 생각함

import java.util.*;

class Delivery {
    class Node implements Comparable<Node> {
        int dest;
        int cost;

        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    ArrayList<List<Node>> list = new ArrayList<>();
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        // 양방향 도로 성립
        for(int i = 0; i < road.length; i++){
            int start = road[i][0];
            int end = road[i][1];
            int cst = road[i][2];

            list.get(start).add(new Node(end, cst));
            list.get(end).add(new Node(start, cst));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            int dst = cur.dest;
            int cst = cur.cost;

            if(dist[dst] < cst)
                continue;

            for(Node next : list.get(dst)){
                if(dist[next.dest] > next.cost + cst){
                    dist[next.dest] = next.cost + cst;
                    pq.offer(new Node(next.dest, (next.cost + cst)));
                }
            }
        }

        for(int cost : dist){
            if(cost <= K)
                answer++;
        }

        return answer;
    }
}
