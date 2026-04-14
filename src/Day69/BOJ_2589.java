package Day69;

// 보물섬

// 보물섬 지도는 직사각형
// 각 칸은 육지L, 또는 바다 W로 표기
// 이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며
// 한칸을 이동하는데 1시간이 걸림
// 보물은 서로 간에 최단 거리로 이동하는데 있어서
// 가장 긴 시간이 걸리는 육지 두곳에 나뉘어 묻혀잇음
// 육지를 나타내는 두 곳 사이를 최단거리로 이동하려면 같은 곳을
// 두번이상 지나가거나 멀리 돌아가면 안됨

// 첫째줄에 보물 지도의 세로크기와 가로의 크기가 주어짐
// 이어 l과 w로 표시된 보물지도가 주어짐

// bfs랑 브루트 포스 스까서야될것 같은데
// 근데 주어진 보물의 위치가 없다보니 모든 경우의 수에서 다 돌려봐야되는게
// 맞지않나 싶긴함

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
    static int N;
    static int M;
    static char map[][];
    static boolean[][] visited;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int maxSafe = 0;

        map = new char[N][M];
        // 맵 만들기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'L'){
                    visited = new boolean[N][M];
                    int currentTime = bfs_time(i,j);
                    maxSafe = Math.max(maxSafe, currentTime);
                }
            }
        }
        System.out.println(maxSafe);
    }

    private static int bfs_time(int startX, int StartY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, StartY,0});
        visited[startX][StartY] = true;
        int maxtime = 0;

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int time = cur[2];
            maxtime = Math.max(maxtime, time);
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 0 && nextY >=0 && nextX < N && nextY < M ) {
                    if(!visited[nextX][nextY] && map[nextX][nextY] == 'L'){
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY , time + 1});
                    }
                }
            }
        }
        return maxtime;
    }
}
