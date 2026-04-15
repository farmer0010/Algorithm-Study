package Day70;

// 빙산

// 빙산은 2차원 배열로 표기
// 빙산의 각 부분별 높이 정보는 각칸의 양의 정소로 저장되고
// 빙산 이외에 바다에 해당하는 칸은 0이 저장된다

// 빙산의 높이는 바닷물에 많이 접해있는 부분에서 더 빨리 줄어들기 때문에
// 배열에서 빙산의 각 부분에 해당되는 칸에 있는 높이는
// 일년마다 0이 저장된 칸의 개수 만큼 줄어든다
// 단 각칸에 저장된 높이는 0보다 줄어들지않음
// 한 덩어리의 빙산이 주어질 때 이 빙산이 두 덩어리 이상으로 분리되는
// 프로그램을 작성하셈

// 만약 전부 다 녹을때 까지 두 덩어리 이상으로 분리되지않으면 프로그램을
// 0으로 출력한다

// 첫줄에는 행과 열의 개수 N,M으로 주어짐
// 일단 dfs로 돌긴 돌아야하는데 종료조건은 덩어리가 두개가 되었을때
// bfs로는 돌면서 체크해주는 역할?? 분리되었는지?

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
    static int N;
    static int M;
    static int map[][];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int year = 0;

        // 맵은 유지하면서 줄이되
        // visited는 계속 바뀌는 판을 유지해줘야하니깐 만들어줘야할듯한데
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            int count = iceLand();
            if (count >= 2) {
                System.out.println(year);
                break;
            }
            if(count == 0){
                System.out.println(0);
                break;
            }
            meltIce();
            year++;
        }
    }

    private static void meltIce() {
        int melt[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > 0){
                    int seacount = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                            if(map[nx][ny] ==  0){
                                seacount++;
                            }
                        }
                    }
                    melt[i][j] = seacount;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > 0){
                    map[i][j] -= melt[i][j];
                    if(map[i][j] < 0){
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    private static int iceLand() {
        visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] > 0){
                    bfs_ice(i,j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void bfs_ice(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curx = cur[0];
            int cury = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visited[nx][ny] && map[nx][ny] >0){
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

        }
    }
}
