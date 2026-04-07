package Day64;

// 적록색약

// 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못함
// 따라서 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과 좀 다를수있음
// 크키가 N * N 인 그리드의 각 칸에 R,G,B중 하나를 색칠한 그림이 있음

// 그림은 몇개 구역으로 나누어져있는데 그 구역은 같은 색깔로 이루어짐
// 또 같은 색상이 상하좌우로 인접해있는 경우 두 글자는 같은 구역에 속함

// 덩어리를 찾는 문제인데
// 적록색약인 사람이 아닌 사람이 봤을 때와 적록색약이 사람이 봤을때
// 구역의 수를 공백으로 구분해 출력

// bfs 두가지 경우를 생각해야 될듯한데?
// 입력 줄에는 첫째줄에 N개의 줄이 그어짐

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
    static char[][] map;
    static boolean[][] visited;
    static int N;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N+1][N+1];
        visited = new boolean[N+1][N+1];
        int countY = 0;
        int countX = 0;

        // 맵 만들기 까지는 성공
        for(int i = 1; i <= N; i++){
            String st  = br.readLine();
            for(int j = 1; j <= N; j++){
                map[i][j] = st.charAt(j-1);
            }
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(!visited[i][j])
                {
                    bfs_rgbY(i,j);
                    countY++;
                }
            }
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(map[i][j] == 'R')
                        map[i][j] = 'G';
            }
        }
        visited = new boolean[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(!visited[i][j])
                {
                    bfs_rgbX(i,j);
                    countX++;
                }
            }
        }
        System.out.print(countY + " "  + countX);
    }

    private static void bfs_rgbX(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        char color = map[x][y];
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i = 0; i < 4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx >= 1 && ny >= 1 && nx <= N && ny <= N){
                    if(!visited[nx][ny] && map[nx][ny] == color){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private static void bfs_rgbY(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        char color = map[x][y];

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                if(newX >= 1 && newX <= N && newY >= 1 && newY <= N ){
                    if(!visited[newX][newY] && map[newX][newY] == color){
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
