package Day173;

// 1은 이동, 0은 이동할 수 없는 칸
// (1,1) 에서 출발해서 (N,M)의 위치로 이동할 떄 지나야하는 최소의 칸 갯수
// 작성

// bfs로 풀되 맵 자체가 공백으로 들어오는게 아니니 토큰 나이저로 저 맵
// 파싱이 이뤄지면 안된다를 인지

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178_MazeSearch {
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        int map[][] = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

       int answer = bfs(0,0, map);

        System.out.println(answer);
    }

    public static int bfs(int x, int y, int[][] map){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y, 1});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();

            int startX = cur[0];
            int startY = cur[1];
            int count = cur[2];

            if(startX == map.length - 1 && startY == map[0].length - 1){
                return count;
            }

            for(int i = 0; i < 4; i++){
                int nextX = startX + dx[i];
                int nextY = startY + dy[i];

                if(nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[0].length){
                    if(!visited[nextX][nextY] && map[nextX][nextY] != 0){
                        q.offer(new int[]{nextX,nextY, count + 1});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return -1;
    }
}
