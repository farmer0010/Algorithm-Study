package Day69;

// 그림

// 어떤 큰 도화지에 그림을 그렸을 때 그 그림의 갯수와, 그 그림중
// 가장 넓이가 가장 넓이가 넓은 것의 넓이를 출력하라

// 단 그림이라는 것은 1로 연결될 것을 하나의 그림으로 잡고
// 가로 세로로 연결된것은 연결된것이고 대각선으로 연결된 것은 떨어진 그림

// 순수 bfs
// 첫째줄의 도화지 세로크기 n , 가로 크기 m
// 이거 배열 만들 떄 m, n 식으로 만들어야할듯

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
    static int m;
    static int n;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int map[][];
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        int count = 0;

        // 맵 만들기
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxSize=0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    int currentArea = bfs_art(i,j);
                    maxSize = Math.max(currentArea,maxSize);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(maxSize);
    }

    private static int bfs_art(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int area = 0;

        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            area++;
            int curX = cur[0];
            int curY = cur[1];
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m ){
                    if(!visited[nextX][nextY] && map[nextX][nextY] == 1){
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return area;
    }
}
