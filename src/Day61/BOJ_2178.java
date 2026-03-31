package Day61;

// N X M 크기의 배열로 표현되는 미로가 있다

// 미로에서 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸을 나타낸다
// 이러한 미로가 주어졌을 때 1,1에서 출발하여 N,M 위치로 이동할떄 지나야하는
// 최소간의 갯수 한칸에서 다른 칸으로 이동할떄 서로 다른 인접한 칸으로만
// 이동할 수 있다

// 1,1 시작점
// 입력값: 첫째줄은 N개 줄에 M개 정수가 미로로 주어짐
// 각각의 수는 붙어서 입력으로 주어짐 (토큰나이저 못쓴다는 말)

// 최단 거리 구해야하면 BFS

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int map[][];
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        isVisited = new boolean[N+1][M+1];

        // 맵 만들기
        for(int i=1;i <= N;i++){
            String line = br.readLine();
            for(int j=1;j <= M;j++){
                map[i][j] = line.charAt(j-1)-'0';
            }
        }
        int count = 0;
        count  = bfs_miro(1,1);
        System.out.println(count);
    }

    private static int bfs_miro(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        isVisited[i][j] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int nx = cur[0];
            int ny = cur[1];

            for(int k = 0;k < 4;k++){
                int nxx = nx + dx[k];
                int nyy = ny + dy[k];

                if(nxx < 1 || nyy < 1 || nxx > map.length-1 || nyy > map[0].length-1){
                    continue;
                }

                if(!isVisited[nxx][nyy] && map[nxx][nyy] == 1){
                    isVisited[nxx][nyy] = true;
                    map[nxx][nyy] = map[nx][ny]+1;
                    q.offer(new int[]{nxx, nyy});
                }
            }
        }
        return map[N][M];
    }
}
