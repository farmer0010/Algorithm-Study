package Day67;

// 인구이동

// N * N 크기의 땅이 있고 각각의 땅에는 나라가 하나씩 존재
// r행 c열에 있는 나라에는 A[r][c]명이 각각 살고있다
// 인접합 나라 사이에는 국경선이 존재하며 모든 나라의 크기는 1*1 크기

// 국경선을 공유하는 두 나라의 인구차이가 L명이상 R명 이하라면
// 두 나라가 공유하는 국경선을 오늘 하루동안 연다

// 위의 조건에 열어야하는 국경선이 모두 열려있다면 인구 이동을 시작한다
// 국경선이 열려있어 인접한 칸만을 이용해 그 나라를 오늘 하루동안은 연합이라고
// 하고 연합을 이루고 있는 각칸의 인구스는 (연합의 인구수) / (연합을 이루고
// 있는 칸의 개수가 된다)
// 연합을 해체하고 모든 국경선을 닫는다

// 경게선 체크가 중요할듯?

// 입력값 : N, L, R
// 둘째 줄에는 각나라의 인구수가 주어짐

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int L;
    static int R;
    static int map[][];
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 맵 만들기
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int days = 0;
        while(true){
            visited = new boolean[N][N];
            boolean isChanged = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        if(bfs_move(i,j,visited)){
                            isChanged = true;
                        }
                    }
                }
            }
            if(!isChanged){
                break;
            }
            days++;
        }
        System.out.println(days);
    }

    private static boolean bfs_move(int startX, int startY, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();

        int sum = map[startX][startY];
        q.offer(new int[]{startX,startY});
        list.add(new int[]{startX,startY});
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N){
                    int diff = Math.abs(map[curX][curY] - map[nextX][nextY]);
                    if(!visited[nextX][nextY] && (diff >= L && diff <= R)){
                        q.offer(new int[]{nextX,nextY});
                        list.add(new int[]{nextX,nextY});
                        sum += map[nextX][nextY];
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        if(list.size() > 1){
            int avg = sum / list.size();
            for(int i = 0; i < list.size(); i++){
                int[] pos = list.get(i);
                map[pos[0]][pos[1]] = avg;
            }
            return true;
        }
        return false;
    }
}
