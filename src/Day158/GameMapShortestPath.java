package Day158;

// 두 팀으로 나누어서 진행하고, 상대 팀 진영을 먼저 파괴하면 이기는 게임
// 따라서 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리함
// 캐릭터의 위치는 1,1에 시작되고
// 0은 벽이 있는 자리, 1은 벽이 없는 자리

// 근데 좌표가 보통 0,0으로 시작하는데 여기에서 위치는 1,1인데
// 어차피 맵을 만들어주면 이게 큰 의미는 없지않을까 싶어서 기본적인 bfs로 시작

import java.util.*;

class GameMapShortestPath {
    int answer = 0;
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};

    boolean[][] isCheck;
    public int solution(int[][] maps) {

        isCheck = new boolean[maps.length][maps[0].length];

        answer = bfs_game(0,0, 0, maps);

        return answer;
    }

    public int bfs_game(int x, int y, int count, int[][] maps){
        Queue<int []> q = new LinkedList<>();

        q.offer(new int[]{x, y, 1});
        isCheck[x][y] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();

            int curx = cur[0];
            int cury = cur[1];
            int cnt = cur[2];

            if(curx == maps.length -1 && cury == maps[0].length -1){
                return cnt;
            }

            for(int i = 0; i < 4; i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if((nx >= 0 && nx < maps.length) && (ny >= 0 && ny < maps[0].length) && maps[nx][ny] != 0){
                    if(! isCheck[nx][ny]){
                        q.offer(new int[]{nx, ny, cnt+1});
                        isCheck[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}
