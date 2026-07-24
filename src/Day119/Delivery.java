package Day119;

// 배달

// N개의 마을로 이루어진 나라가 있음
// 이 나라는 각 1번부터 N번까지 번호가 각각 부여되어있음
// 각 마을은 양방향으로 통행할 수 있음
// 이동 할 때는 이 도로를 지나야 이동이 가능함
// 도로를 지날 때 걸리는 시간은 도로별로 다르고
// 현재 1번 마을에 있는 음식점에서 각 마을로 배달하려고함
// N개 마을 중에서 K 시간 이하로 배달이 가능한 마을만 주문 받음

// 마을의 갯수는 N, 각 도로의 정보 road, 음식 배달이 가능한
// 시간 k개 (road: a,b는 마을 , c는 가중치)

// 샌드 박스
// 1. 하나의 마을에서 각 마을까지 걸리는 최단 시간을 찾아야하니
// 다익스트라로 풀어야겠다는 생각을 해봄
// 2. 일단 양방향이기 때문에 이 road 정보를 가지고
// 버스 시간 표를 만들어야함

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class Delivery {
    static class Node implements Comparable<Node>{
        int to;
        int weight;

        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.weight, o.weight);
        }
    }
    int[] dist;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<ArrayList<Node>> graph = new ArrayList<>();

        dist = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int r[] : road){
            int a = r[0];
            int b = r[1];
            int c = r[2];

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        for(int i = 0; i <= N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int to = cur.to;
            int weight = cur.weight;

            if(dist[to] < weight){
                continue;
            }

            for(Node next : graph.get(to)){
                if(dist[next.to] > next.weight + weight){
                    dist[next.to] = next.weight  + weight;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        for(int i = 0; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }

        return answer;
    }
}
