package Day73;

// 최소 비용 구하기 2

// n개의 도시가 있고 한도시에 출발하여 다른 도시에 도착하는 m개의 버스가 있음
// a번째 도시에서 b번째 도시로 가는 버스 비용을 최소화하려고함
// a번쨰 도시에서 b번째 도시까지 가는데 최소 비용과 경로를 출력

// 첫째줄에 도시의 개수 n이 주어지고 두번째 줄에 버스의 개수 m이 주어진다
// 그리고 셋째 줄 부터 버스의 정보가 주어짐 (출발도시, 도착도시, 버스비용)
// 마지막 줄에는 우리가 구하고자하는 구간의 출발점, 도착점 주어짐

// 첫째줄에는 최소비용 출력
// 둘째줄에는 최소 비용을 갖는 경로에 포함되어있는 도시 개수 출력
// 셋째줄에는 최소 비용 경로에 있는 도시 순서대로 출력

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11779 {
    static class Node implements Comparable<Node> {
        int dest;
        int cost;
        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n, m;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int[] preNode;

    static int strat_point;
    static int end_point;

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        preNode = new int[n+1];
        dist = new int[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            preNode[i] = 0;
            dist[i] = INF;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[src].add(new Node(dest, cost));
        }
        st = new StringTokenizer(br.readLine());
        strat_point = Integer.parseInt(st.nextToken());
        end_point = Integer.parseInt(st.nextToken());

        int cost = dikstra_point(strat_point);
        System.out.println(cost);

        Stack<Integer> stack = new Stack<>();
        int curr = end_point;

        while (curr != 0){
            stack.push(curr);
            curr = preNode[curr];
        }
        System.out.println(stack.size());
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    private static int dikstra_point(int stratPoint) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(stratPoint, 0));
        dist[stratPoint] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int cur_cost = cur.cost;
            int cur_dest = cur.dest;

            if(dist[cur_dest] < cur_cost){
                continue;
            }
            if(cur_dest == end_point){
                return cur_cost;
            }
            for(Node next : graph[cur_dest]){
                int next_cost = dist[cur_dest] + next.cost;
                if(dist[next.dest] > next_cost){
                    dist[next.dest] = next_cost;
                    preNode[next.dest] = cur_dest;
                    pq.offer(new Node(next.dest, next_cost));
                }
            }
        }
        return 0;
    }
}
