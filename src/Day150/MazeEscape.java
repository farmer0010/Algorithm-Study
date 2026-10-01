package Day150;

// 미로 탈출

// 1*1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출
// 각 칸은 통로와 벽으로 구성
// 통로 -> 레버 -> 출구 이런식으로 가야함

// 이거는 통로에서 레버까지의 bfs를 돌리고 방문 기록 초기화하고
// 레버에서 통로까지 bfs를 돌리고 그 합산값을 더해주면 됨

import java.util.*;

class MazeEscape {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][] visit;

    public int solution(String[] maps) {
        int m = maps.length;
        int n = maps[0].length();

        int answer = 0;
        visit = new boolean[m][n];

        int mid_sum = 0;
        int end_sum = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(maps[i].charAt(j) == 'S'){
                    mid_sum = bfs(i, j, 'L', maps);
                }
            }
        }


        visit = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(maps[i].charAt(j) == 'L'){
                    end_sum = bfs(i, j, 'E', maps);
                }
            }
        }

        if(mid_sum == -1 || end_sum == -1)
            return -1;

        answer = mid_sum +end_sum;

        return answer;
    }

    public int bfs(int x, int y, char end ,String[] maps){
        Queue<int []> q = new LinkedList<>();

        q.offer(new int[]{x, y, 0});
        visit[x][y] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int count = cur[2];

            if(maps[cur_x].charAt(cur_y) == end){
                return count;
            }

            for(int i = 0; i < 4; i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length()){
                    if(!visit[nx][ny] && maps[nx].charAt(ny) != 'X'){
                        q.offer(new int[]{nx, ny, count +1});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}
