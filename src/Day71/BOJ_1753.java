package Day71;

// 최단 경로

// 방향 그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를
// 구하시오 (모든 간선의 가중치는 10이하의 자연수)

// 입력값 : 첫째줄에 정점의 개수 V와 간선의 개수 E가 주어진다
// 모든 정점에 1부터 V까지 번호가 매겨짐

// 둘째줄에는 시작 정점의 번호 k가 주어진다
// 셋째줄 부터 E개의 줄에 걸쳐 각 간선을 나타내는 세개의 정수 (u,v,w)가 주어짐
// u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻

// 첫째줄 부터 V개의 줄에 걸쳐 i번째 줄에 i번의 정점으로의 최단 경로의 경로값
// 출력 시작점 자신은 0으로 출력하고 경로가 존재하지않는 경우에 INF를 출력한다

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static class Node implements Comparable<Node>{
        int dest;
        int weight;

        public Node(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o)
        {
            return this.weight - o.weight;
        }
    }

    static int V;
    static int E;
    static int K;

    static ArrayList<Node>[] graph;
    static int dist[];
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        dist = new int[V+1];

        for(int i = 1; i <= V; i++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i = 1; i <= E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        shortest_miro(K);

        for (int i = 1; i <= V; i++){
            if(dist[i] == INF)
                System.out.println("INF");
            else{
                System.out.println(dist[i]);
            }
        }
    }

    private static void shortest_miro(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();
            int curNode = cur.dest;
            int curWeight = cur.weight;

            if(dist[curNode] < curWeight)
                continue;
            for (Node next : graph[curNode]) {
                int nextCost = dist[curNode] + next.weight;
                if(nextCost < dist[next.dest]){
                    dist[next.dest] = nextCost;
                    pq.offer(new Node(next.dest, nextCost));
                }
            }
        }
    }
}
