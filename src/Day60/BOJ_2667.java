package Day60;

// 단지 번호 붙이기

// 정사각형 모형의 지도가 있고
// 1은 집이 있는 곳을, 0은 집이 없는것을 나타낸다
// 이 지도와 연결된 모임의 단지를 정의하고 단지에 번호를 붇이려고함
// 지도를 입력하여 단지수를 출력하고 각 단지에 속하는 집의 수를 오름
// 차순으로 정렬

// 첫번째 줄에는 지도의 크기 N , 가로 세로 크기 같음
// 그다음 N줄에 각각 N개의 자료가 입력됨

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667 {
    static int[][] map;
    static  int[] dx = {-1, 1, 0, 0};
    static  int[] dy = {0, 0, -1, 1};
    static  boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        ArrayList<Integer> list = new ArrayList<>();

        // 맵 만들기
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    int count = bfs(i,j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i);
        }

    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int nx = cur[0];
            int ny = cur[1];
            for(int i = 0; i < 4; i++){
                int nxx = nx + dx[i];
                int nyy = ny + dy[i];
                if(nxx < 0 || nyy <0 || nxx >map.length - 1 || nyy >map[0].length - 1){
                    continue;
                }
                if(!visited[nxx][nyy] && map[nxx][nyy] == 1){
                    visited[nxx][nyy] = true;
                    q.offer(new int[]{nxx, nyy});
                    count++;
                }
            }
        }
        return count;
    }
}
