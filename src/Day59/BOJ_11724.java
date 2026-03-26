package Day59;

// 연결 요소의 개수를 찾는 프로그램
// 첫째줄에는 정점의 개수 N개, 간선의 갯수 M개가 주어짐
// 둘째 줄 부터는 간선의 양 끝점 u,v가 주어짐

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                count++;
                bfs_node(i);
            }
        }
        System.out.println(count);
    }

    private static void bfs_node(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 0; i < map[cur].length; i++){
                if(!visited[i] && map[cur][i] == 1){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
