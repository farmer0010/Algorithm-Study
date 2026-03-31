package Day61;

// 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고가 있음
// 토마토는 격자 모양 상장의 칸에 하나씩 넣어서 창고에 보관함

// 창고에 보관하는 토마토는 잘 익은 것도 있지만 아직 익지않은 토마토가
// 있을수도 있다

// 보관후 하루가 지나면 익은 토마토의 인접한 곳에 있는 익지않은 토마토들을
// 익은 토마토에 영향을 받아 익게 됨

// 하나의 토마토의 인접합 곳은 상화좌우, 대각선 방향에 있는 토마토들에게는
// 영향을 주지못하고 혼자 저절로 익는 경우는 없음 철수는 창고에 보관된
// 토마토들이 며칠 지나면 다 익는지 그 최소 일수를 알고 싶어함

// 며칠이 지나면 토마토 들이 익는지 그 최소 일수를 작성

// 입력값: 상자의 크기를 나타내는 가로칸수 M, N은 상자의 세로칸 수를 나타냄
// 배열을 만들 때 map[N][M]으로 만들어줘야할듯
// 둘쨰줄 부터 n째 줄에는 상자에 담긴 토마토 정보가 주어짐
// 하나의 줄에는 m개의 정수로 토마토가 주어잠

// 정수 1: 익은 토마토, 정수 0: 익지않은 토마토 정수 -1: 토마토가 들어있지않은 칸

// 리턴값 예외 : 모두 토마토가 익은 상황은 0을 출력, 모두 익지 못하는 상황이면 -1

// 여기서 생기는 첫번쨰 고민 안에 값이 1인 경우를 시작점으로 잡아줘야할텐디
// 그걸 어캐 찾을까 고민좀 해봐야할듯

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int[][] map;
    static boolean[][]  visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M;
    static int N;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.offer(new int[]{i, j});
                }
            }
        }
        bfs_tomato(q);
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max - 1);
    }

    private static void bfs_tomato(Queue<int[]> q) {
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int nx =  cur[0];
            int ny =  cur[1];

            for(int k = 0; k < 4; k++){
                int nxx = nx+dx[k];
                int nyy = ny+dy[k];
                if(nxx>=0 && nxx<N && nyy>=0 && nyy<M){
                    if(map[nxx][nyy] == 0){
                        map[nxx][nyy] = map[nx][ny]+1;
                        q.offer(new int[]{nxx, nyy});
                    }
                }
            }
        }
    }
}
