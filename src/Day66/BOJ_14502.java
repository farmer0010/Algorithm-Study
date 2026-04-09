package Day66;

// 연구소

// 인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출됨
// 그래서 이 바이러스의 확산을 막기 위해서 벽을 세우려고함

// 연구소의 크기는 N * M인 직사각형으로 이루어져있고
// 직사각형의 크기는 1*1 크기의 정사각형임

// 연구소는 빈칸, 벽으로 이루어져있음
// 일부칸은 바이러스가 존재하며 이 바이러스는 상화 좌우로 인접한 빈칸으로 모두
// 퍼져 나갈수있다

// 새로 세울수있는 벽의 개수는 3개 이며 꼭 3개를 세워야한다
// 0은 빈칸, 1은 벽, 2는 바이러스가 있는곳

// 입력 첫째줄에는 세로 크기 N과 가로크기 M이 주어진다 (3 < n,m< 8)
// 둘째줄에는 지도의 모양이 주어짐, 2의 개수는 2보다 크거나 같고 10보다는 작음
// 빈 칸의 개수는 3개 이상

// 벽을 세우는 최적의 수는 dfs인데 나는 dfs 잘 못쓰는디 한번 해보자
// bfs는 벽을 세웠을떄 안전 갯수 최적을 찾는??

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
    static int N;
    static int M;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int map[][];
    static ArrayList<int []> list = new ArrayList<>();
    static int maxSafe;

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 맵 만들기
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    list.add(new int[]{i,j});
                }
            }
        }
        // 벽을 세우는 최적의 수는? 바이러스가 퍼트리지않게 세우는게 최적인데
        dfs_wall(0);
        System.out.println(maxSafe);
    }

    private static void dfs_wall(int count) {
        if(count==3){
            bfs_virus2();
            return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    dfs_wall(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs_virus2() {
        int[][] copy = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                copy[i][j] = map[i][j];
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<list.size();i++){
            q.offer(list.get(i));
        }

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int curx = cur[0];
            int cury = cur[1];

            for(int i=0;i<4;i++){
                int nx = curx+dx[i];
                int ny = cury+dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M && copy[nx][ny]==0){
                    copy[nx][ny] = 2;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        int currentSafe = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(copy[i][j]==0){
                    currentSafe++;
                }
            }
        }
        maxSafe = Math.max(maxSafe,currentSafe);
    }
}
