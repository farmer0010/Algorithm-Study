package Day149;

// 상대팀의 진영에 도착하기 위해서 지나가야하는 칸의 개수의 최소값을 리턴
// 무조건 bfs 최단거리

import java.util.*;

class GameMapShortestPath {
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,-1,1};
    boolean visit[][];

    public int solution(int[][] maps) {
        visit = new boolean[maps.length + 1][maps[0].length + 1];
        int answer = 0;

        answer = bfs(0,0, maps);

        return answer;
    }

    public int bfs(int start_x, int start_y, int[][] maps){
        Queue<int []> q = new LinkedList<>();

        q.offer(new int[] {start_x, start_y, 1});
        visit[start_x][start_y] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();

            int cur_x = cur[0];
            int cur_y = cur[1];
            int count = cur[2];

            if(cur_x == maps.length -1 && cur_y == maps[0].length -1){
                return count;
            }

            for(int i = 0; i < 4; i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length){
                    if(!visit[nx][ny] && maps[nx][ny] != 0){
                        q.offer(new int[]{nx, ny, count+1});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}