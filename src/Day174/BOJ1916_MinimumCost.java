package Day174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916_MinimumCost {
    static class Node implements Comparable<Node>{
        int dest;
        int cost;

        Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Node n){
            return Integer.compare(this.cost, n.cost);
        }
    }

    static final int INF = 1_000_000_000;
    static int[] dist;
    static ArrayList<ArrayList<Node>> lst = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        for(int i = 0; i <= N; i++){
            dist[i] = INF;
            lst.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lst.get(start).add(new Node(dest, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        daikstra(start, end);
    }

    public static void daikstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            int dst = node.dest;
            int cst = node.cost;

            if(dst == end){
                System.out.println(dist[dst]);
                return;
            }

            if(dist[dst] < cst){
                continue;
            }

            for(Node next : lst.get(dst)){
                if(dist[next.dest] > cst + next.cost){
                    dist[next.dest] = cst  + next.cost;
                    pq.offer(new Node(next.dest, dist[next.dest]));
                }
            }
        }
    }
}
