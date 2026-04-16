package Day71;

// 최소 비용 구하기

// N개의 도시가 있고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있음
// 우리는 A번째 도시에서 B번쨰 도시로 가는데 드는 버스 비용을 최소화 시키려고함
// 도시의 번호는 1부터 N까지

// 입력값: 첫째줄에 도시의 개수 N이 주어지고
// 둘쨰줄에는 버스의 개수 M이 주어짐

// 출발도시 번호, 도착 도시 번호, 버스 비용

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {
    static class Node implements Comparable<Node> {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int N;
    static int M;
    static ArrayList<Node>[]  graph;
    static int dist[];
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        // 그래프에 보관하기
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int ct = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(d,ct));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dikstra(start,end);
    }

    private static void dikstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curNode = cur.dest;
            int curCost = cur.cost;

            if(curNode == end){
                System.out.println(dist[curNode]);
                return;
            }

            if(dist[curNode] < curCost){
                continue;
            }
            for(Node next : graph[curNode]){
                int nextCost = dist[curNode] + next.cost;
                if(nextCost < dist[next.dest]){
                    dist[next.dest] = nextCost;
                    pq.offer(new Node(next.dest,nextCost));
                }
            }
        }
    }
}
