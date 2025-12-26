package Day10;

import java.util.LinkedList;
import java.util.Queue;

class GameMap {
    // 방향키 설정 상하 좌우
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    public int solution(int[][] maps) {
        int n = maps.length; // 세로크기 (행)
        int m = maps[0].length; // 가로크기 (열)

        // 큐 만들기 (좌표 x,y를 담을 예정)
        Queue<int[]> queue = new LinkedList<>();

        // 시작점 넣기
        queue.offer(new int[]{0,0});

        // BFS 시작(큐가 빌때까지 반복)
        while(!queue.isEmpty()) {
            int []current = queue.poll();
            // 현재 위치 확인
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 밖으로 나갔는지 (범위 확인)
                if(nx < 0 || ny < 0 ||nx >= n || ny >= m){
                    continue;
                }
                // 벽(0)이거나 이미 방문한 곳(1보다 큰수인지)
                if(maps[nx][ny] == 0 || maps[nx][ny] > 1) {
                    continue;
                }
                maps[nx][ny] = maps[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
        if(maps[n-1][m-1] == 1)
            return -1;
        else
            return maps[n-1][m-1];
    }
}
