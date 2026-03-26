package Day59;

// 신종 바이러스 웜 바이러스는 네트워크를 통해 전판
// 한 컴퓨터가 걸리면 그 컴퓨터와 네트워크에 있는 모든 컴퓨터는
// 다 걸림

// 1번 컴퓨터가 바이러스에 걸렸고 전파되는 컴퓨터의 수를 출력

// 첫째줄에 컴퓨터 수가 주어짐
// 둘쨰 줄에는 네트워크 상에서 직접 연결되어있는 컴퓨터의 쌍의 수가 주어짐

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static int[][] map;
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 컴퓨터의 수
        int N = Integer.parseInt(br.readLine());

        // 네트워크 상에서 직접 연결되어있는 컴퓨터 쌍의 수
        int M = Integer.parseInt(br.readLine());
        // 뭐 끼리 연결되어있는지 기록할 지도
        map = new int[N+1][N+1];
        int count = 0;
        visited = new boolean[N+1];

        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }
        bfs_virus(1);
    }

    public static void bfs_virus(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        int count = 0;

        visited[node] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int i =1; i < map.length; i++) {
                if(map[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
