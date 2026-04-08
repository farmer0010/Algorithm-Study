package Day65;

// 영역 구하기

// 눈금의 간격이 1인 M X N 크기의 모눈 종이가 있으면
// 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때
// 이들 k개의 직사각형 내부를 제외한 나머지 부분이 몇개의 분리 된 영역으로 나누어짐
// m이 가로 n이 세로

// M, N, 그리고 K개의 직사각형의 좌표가 주어질 때 k개의 직사각형 내부를
// 제외한 나머지 부분이 몇개의 분리된 영역으로 되는지
// 그리고 분리 된 각 영역의 넓이가 얼마인지를 구하여 출력하는 프로그램

// 첫째 쥴애는 m,n,k가 주어짐
// 둘째줄 부터 한줄에 하나씩 왼쪽 아래 꼭지점, 오른 쪽의 꼭지점 x,y의 좌표들이 주어짐

// 출력 첫째줄에 분리 되어서 나오는 갯수
// 둘째 줄에 오름 차순으로 정렬하여 넓이

// 일단 bfs로 저 영역은 체크해줘야할것같음
// 그리고 가지않은 영역의 갯수를 돌려주는 bfs를 써야할것같음

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2583 {
    static int M;
    static int N;
    static int K;
    static int map[][];
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for(int y = leftY; y < rightY; y++){
                for(int x = leftX; x < rightX; x++){
                    map[y][x] = 1;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 0){
                    int countSize = bfs_sep(i,j);
                    ans.add(countSize);
                }
            }
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i));
            if(i != ans.size()-1){
                System.out.print(" ");
            }
        }
    }

    private static int bfs_sep(int y, int x) {
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        int count = 1;
        while (!queue.isEmpty()){
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i = 0; i < 4; i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && map[nextX][nextY] == 0 && !visited[nextX][nextY]){
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
