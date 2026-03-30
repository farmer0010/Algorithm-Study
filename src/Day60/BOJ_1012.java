package Day60;

// 유기농 배추

// 유기농 배추 재배, 농약을 쓰지 않고 배추를 재배 하려면
// 배추 흰 지렁이 필요
// 특히 어떤 배추에 배추 흰 지렁이가 한마라리도 살고있으면 인전한 다른
// 배추로 이동할수 있음

// 한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군대군대 심어둠
// 배추 흰지렁이가 몇마리 필요한지?

// 땅덩어리 개수 세는 문제
// 0은 배추가 심어져 있지않은 땅, 1은 배추가 심어져있는 땅

// 입력의 첫줄에는 테스트 케이스 개수 T가 주어짐
// 그 다음줄 각각의 테이스 케이스에 대해서 첫째줄에는 가로 길이 M
// 세로 길이 N, 그리고 배추가 심어져 있는 위치의 갯수 K
// 그리고 K줄에는 배추의 위치가 주어진다

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static int map[][];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!visited[i][j] && map[i][j] == 1){
                        bfs_bae(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static int bfs_bae(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int nx = cur[0];
            int ny = cur[1];
            for (int i = 0; i < 4; i++) {
                int nxx = nx + dx[i];
                int nyy = ny + dy[i];
                if(nxx < 0 || nyy < 0 || nxx > map.length-1 || nyy > map[0].length-1){
                    continue;
                }
                if(!visited[nxx][nyy] && map[nxx][nyy] == 1){
                    visited[nxx][nyy] = true;
                    q.offer(new int[]{nxx, nyy});
                    count++;
                }
            }
        }
        return count;
    }
}
