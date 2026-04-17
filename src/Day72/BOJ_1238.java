package Day72;

// 파티

// N개의 숫자로 구분된 각각의 마을에 한명의 학생이 살고잇음

// 어느날 N명의 학생이 X마을에 모여서 파티를 하기로 함
// 이 마을 사이에는 M개의 단반향 도로가 있고 i번째 길을 지나가는데
// T i 시간을 소비함
// 각각 x마을 모였다가 다시 그들의 마을로 돌아가야함
// 학생들은 최단 시간내에 집으로 돌아가기를 원하고
// 이 도로는 단방향이기 떄문에 아마 그들이 오고 가는길이 다를지도 모름
// 이중에서 N명의 학생들이 오고가는데 가장 많은 시간을 소비하는데 학생은??

// 입력 : 첫째줄에 N과 M, X로 구분됨
// 두번째줄 부터 도로의 시작점, 끝점, 소요시간이 순으로 기재됨

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
    static class Node implements Comparable<Node>{
        int dest;
        int time;
        Node(int dest, int time){
            this.dest = dest;
            this.time = time;
        }
        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
    static int N;
    static int M;
    static int X;

    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] revGraph;
    static int[] dist;
    static int[] revDist;
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        revGraph = new ArrayList[N+1];
        dist = new int[N+1];
        revDist = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
            dist[i] = INF;
            revDist[i] = INF;
        }
        // 버스시간표에 버스표 기재완료
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, weight));
            revGraph[end].add(new Node(start, weight));
        }
        dikstra_norm(X, graph, dist);
        dikstra_norm(X, revGraph, revDist);
        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, dist[i]+revDist[i]);
        }
        System.out.println(maxTime);
    }

    private static void dikstra_norm(int start, ArrayList<Node>[] graphTo, int[] distTo) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distTo[start] = 0;

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int curNode = node.dest;
            int curCost = node.time;

            if(distTo[curNode] < curCost){
                continue;
            }
            for (Node next : graphTo[curNode]){
                int nextCost = distTo[curNode] + next.time;
                if(nextCost < distTo[next.dest]){
                    distTo[next.dest] = nextCost;
                    pq.offer(new Node(next.dest, nextCost));
                }
            }
        }
    }
}
