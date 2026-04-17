package Day72;

// 방향성이 없는 그래프가 주어짐 (양방향)

// 세준이는 1번 정점에서 N번 정점까지 최단 거리를 이동하려고함
// 두가지 조건을 만족하는 특정 최단 경로를 구해야함
// 임의로 주어진 두가지 정점을 반드시 통과해야함

// 세준이는 한번 이동햇던 정점도, 한번 이동했던 간선도 다시 통과할 수있음
// 하지만 최단 경로로 이동해야한다는 사실에 주의해야함

// 첫째줄에 정점의 개수 N, 간선의 개수 E가 주어짐
// 둘쨰 주부터는 세개의 정수 a,b,c가 주어짐
// a번 정점에서 b번 정점까지 양방향 길이 존재함, 그리고 그 거리가 c
// 다음줄에는 서로 다른 정점 번호 v1,v2가 주어짐

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
    static class Node implements Comparable<Node>{
        int dest;
        int weight;
        Node(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int N,E;
    static int v1, v2;

    static ArrayList<Node>[] graph;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[src].add(new Node(dest, weight));
            graph[dest].add(new Node(src, weight));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long pathA = 0;
        pathA += disktra_dest(1,v1);
        pathA += disktra_dest(v1,v2);
        pathA += disktra_dest(v2,N);

        long pathB = 0;
        pathB += disktra_dest(1,v2);
        pathB += disktra_dest(v2,v1);
        pathB += disktra_dest(v1,N);

        long totalDist = Math.min(pathA, pathB);
        if(totalDist >= INF){
            System.out.println(-1);
        }
        else
            System.out.println(totalDist);

    }

    private static int disktra_dest(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int []dist = new int[N+1];
        Arrays.fill(dist, INF);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curDest = cur.dest;
            int curWeight = cur.weight;

            if(curDest == end){
                return dist[curDest];
            }

            if(dist[curDest] < curWeight){
                continue;
            }

            for(Node next : graph[curDest]){
                int nextCost = dist[curDest] + next.weight;
                if(nextCost < dist[next.dest]){
                    dist[next.dest] = nextCost;
                    pq.add(new Node(next.dest, nextCost));
                }
            }
        }
        return INF;
    }
}
