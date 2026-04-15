package Day70;

// 불 !

// 미로에서 지훈이의 위치와 불이 붙은 위치를 감안해서
// 탈출할 수 있는지 여부와, 얼마나 빨리 탈출 할 수 있는지
// 결정해야함
// 지훈이와 불은 한칸씩 수평 또는 수직으로 이동한다(동,서, 남, 북) -> 그대로
// 쪼개면 될것 같긴함

// 지훈이는 미로의 가장 자리에 접한 공간에서 탈출할 수 있음

// 입력: 첫째줄 R,C가 주어짐 r은 미로행의 개수, c는 열의 개수
// #: 벽
// .: 지나갈 수 있는 공간
// J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
// F: 불이 난 공간

// 출력 불이 도착하기전에 미로를 탈출 할수 없는 경우 IMPOSSIBLE
// 출력, 지훈이가 미로를 가장 빨리 탈출할수 있는 경우에는 가장 빠른 시간을
// 출력함

// 일단 힌트를 받았듯이 둘의 bfs를 돌려야함, 일단 먼저 불을 돌려야할것같은데
// 그 불이 움직인 시간을 바닥에 기록해서 지훈이가 그 시간전에 움직일수있다면
// 을 체크해야 지훈이의 bfs도 나가서 탈출할수 있을지를 아니깐?
// 약간 dp와 bfs 같이 써야되지않을까라는 생각이 듬

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
    static int R;
    static int C;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] fire_time;
    static int[][] jihun_time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Queue<int[]> fireque = new LinkedList<>();
        Queue<int[]> jihunque = new LinkedList<>();

        map = new char[R][C];
        fire_time = new int[R][C];
        jihun_time = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                fire_time[i][j] = -1;
                jihun_time[i][j] = -1;
            }
        }

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'F') {
                    fireque.offer(new int[]{i, j});
                    fire_time[i][j] = 0;
                } else if (map[i][j] == 'J') {
                    jihunque.offer(new int[]{i, j});
                    jihun_time[i][j] = 0;
                }
            }
        }

        bfs_fire(fireque);
        bfs_jihun(jihunque);
    }

    private static void bfs_jihun(Queue<int[]> jihunque) {
        while (!jihunque.isEmpty()) {
            int[] cur = jihunque.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
                    System.out.println(jihun_time[curX][curY] + 1);
                    return;
                }

                if (map[nextX][nextY] != '#' && jihun_time[nextX][nextY] == -1) {
                    if (fire_time[nextX][nextY] == -1 || jihun_time[curX][curY] + 1 < fire_time[nextX][nextY]) {
                        jihun_time[nextX][nextY] = jihun_time[curX][curY] + 1;
                        jihunque.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void bfs_fire(Queue<int[]> fireque) {
        while (!fireque.isEmpty()) {
            int cur[] = fireque.poll();
            int curx = cur[0];
            int cury = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (map[nx][ny] != '#' && fire_time[nx][ny] == -1) {
                        fire_time[nx][ny] = fire_time[curx][cury] + 1;
                        fireque.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}