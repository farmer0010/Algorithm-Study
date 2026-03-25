package Day58;

// dfs와 bfs로 탐색한 결과를 출력하는 프로그램
// 단 방문할수있는 접점이 여러개인 경우는 정점 번호가 작은것을
// 먼저 방문하고 더 이상 방문할수있는 점이 없는 경우 종료

// 접점 번호는 1번 부터 N번
// 첫째줄의 정점의 개수, 간선의 개수, 탐색을 시작할 번호 v가 주어짐
// 다음 M개의 줄에는 간선이 연결하는 번호가 주어진다

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static int [][]map;
    static boolean [] visited;
    static int N,M,V;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 개수 잘라준 상황
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 이게 지도 만들기?
        map = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);

    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for (int i = 1; i <= N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && map[node][i] == 1) {
                dfs(i);
            }
        }
    }
}
