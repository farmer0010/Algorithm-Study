package Day120;

// 게임 맵 최단 거리

// 각 팀은 상대팀의 진영에 최대한 빨리 도착하는게 유리함
// 검은 부분은 벽으로 막혀 갈수 없는 부분임
// 캐릭터는 동, 서, 남, 북 4가지 방향으로 이동 가능하며
// 게임 맵을 벗어난 길은 없다.

// 만약 도착할수 없다면 -1을 리턴
// 0은 벽이 있는 자리 1은 벽이 없는 자리

// 샌드박스
// bfs를 활용해야함

// 시작 지점은 1,1이고 우측하단은 n,m에 도착지에 있음

import java.util.LinkedList;
import java.util.Queue;

class GameMapShortestPath {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    boolean[][] visited;

    public int solution(int[][] maps) {
        int answer = 0;

        answer = bfs_game(0,0,maps);

        return answer;
    }

    private int bfs_game(int startX, int startY, int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n+1][m+1];

        queue.offer(new int []{startX, startY, 1});
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            int[] cur =  queue.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if(x == n-1 && y == m-1){
                return cnt;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m){

                    if(!visited[nx][ny] && maps[nx][ny] == 1){
                        visited[nx][ny] = true;
                        queue.offer(new int []{nx, ny, cnt+1});
                    }
                }
            }
        }
        return -1;
    }
}
