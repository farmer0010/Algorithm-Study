package Day65;

// 섬의 개수

// 정사각형으로 이루어진 섬과 바다 지도가 주어지고
// 섬의 갯수를 세는 프로그램을 작성

// 한 정사각형과 가로 세로 또는 대각선으로 연결되어있는 사각형은 걸어갈수있음

// 입력 각 테스트 케이스의 첫째 줄에는 지도의 너비 w 높이 h가 주어짐
// w,h는 50보다 작음
// 둘째줄 부터 h개에 줄에는 지도가 주어짐 땅 1, 바다 0
// 입력의 마지막 줄에는 0이 2개 주어짐

// 일단 테스트 케이스가 반복되면 방문 배열이 초기화 되어야하는데
// 맵도 다시 초기화를 해줘야하고
// 0 0이 입력되면 종료되어야하고
// bfs는 그냥 하면 될것같은데 맵을 어떤식으로 읽고 그려나갈지가 관건인듯

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
    static int w;
    static int h;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];
            int count = 0;

            // 맵 그리기 까지는 성공
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        bfs_island(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs_island(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i = 0; i < 8; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >=0 && nextX < h && nextY >= 0 && nextY < w && !visited[nextX][nextY] && map[nextX][nextY] == 1){
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }
}
