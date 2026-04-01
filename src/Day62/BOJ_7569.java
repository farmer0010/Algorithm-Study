package Day62;

// 토마토
// 격자모양의 상자를 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서
// 창고에 보관 (어제 문제와는 다르게 3차원 배열로 문제를 생각해야함)

// 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만 아직 익지않은
// 토마토 도 있음, 보관 후 하루가 지나면
// 익지않은 토마토들은 익은 토마토의 영향을 받아 익게된다

// 하나의 토마토에 인전한 곳은 상, 하, 좌, 우 , 위, 아래
// 모두 전파됨 dx,dy,dz 다 생각해야할듯

// 리턴값은 토마토가 얼마만에 익는지 최소값을 리턴 해야함

// 입력 첫줄에는 M은 가로칸, N은 세로칸, H는 높이
// 배열을 만들떄는 n,m,h 순서대로 만들면 될듯
// 둘째줄부터 가장 밑 상자부터 가장 위 상자까지 저장된 토마토 정보가 주어짐
// 정수 1은 익은 토마토, 정수 0은 익지않은 토마토, 정수 -1은 토마토가 들어있지
// 않은칸 토마토가 익어있는 상태면 0출력, 토마토를 모두 익히지 못하는 상황이면 -1

// dfs와 dp의 혼합

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static int[][][] map;
    static int[] dn = {-1, 1, 0, 0, 0, 0};
    static int[] dm = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int M, N, H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 1) {
                        q.offer(new int[]{h, n, m});
                    }
                }
            }
        }

        bfs_tomato2(q);

        int max = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, map[h][n][m]);
                }
            }
        }

        System.out.println(max - 1);
    }

    private static void bfs_tomato2(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int h = cur[0];
            int n = cur[1];
            int m = cur[2];

            for (int i = 0; i < 6; i++) {
                int nh = h + dh[i];
                int nn = n + dn[i];
                int nm = m + dm[i];

                if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M) {
                    if (map[nh][nn][nm] == 0) {
                        map[nh][nn][nm] = map[h][n][m] + 1;
                        q.add(new int[]{nh, nn, nm});
                    }
                }
            }
        }
    }
}
