package Day64;

// 안전 영역

// 어떤 지역의 높이정보를 파악함
// 그 다음에 그 지역에 많은 비가 내렸을 때 물에 잠기지 않은 안전한
// 영역이 최대로 몇개가 만들어지는 조사하려고함

// 장마철에 내리는 비의 양에 따라 일정한 높이 이하의 모든 지점을 물에
// 잠긴다고 가정함

// 어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인 2차원 배열로 주어지며
// 배열의 각 원소는 해당 지점의 높이를 표시하는 함수이다

// 물에 잠기지 않은 안전한 영역이라 함은 물에 잠기지않은 지점들이
// 위, 아래, 오른쪽 혹은 , 왼쪽으로 인접해있으며 그 크기가 최대인
// 영역을 말한다

// 장마철에 비가 내리는 안전한 영역의 갯수는 비의 양에 따라 다르다
// 어떤 지역의 높이 정보가 주어졌을 때 장마철에 물에 잠기지않는 안전한
// 영역의 최대 수는?

// 입력 값: 첫째줄에는 어떤 지역을 나타내는 2차원 배열의 행과 열을
// 나타내는 수 N이 주어짐
// 둘째줄 부터는 높이 정보가 주어짐
// 높이는 1이상 100 이하의 정수이다

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int maxSafe = 0;
        int maxHeight = 0;

        // 맵 만들기
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
        for(int h = 0; h <= maxHeight; h++){
            visited = new boolean[N][N];
            int currentSafe = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(!visited[k][j] && map[k][j] > h){
                        bfs_rain(k,j, h);
                        currentSafe++;
                    }
                }
            }
            maxSafe = Math.max(maxSafe, currentSafe);
        }
        System.out.println(maxSafe);
    }

    private static void bfs_rain(int x, int y, int height) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                if(newX >= 0 && newX < N &&  newY >= 0 && newY < N){
                    if(!visited[newX][newY] && map[newX][newY] > height){
                        visited[newX][newY] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
