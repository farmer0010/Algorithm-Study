package Day134;

// 보물 지도

// 보물 지도는 가로 길이가 n, 세로 길이가 m인 직사각형 모형이다
// 맨 왼쪽 아래 칸의 좌표를 1,1 맨 오른쪽은 위칸 좌표를 n,m;

// 1,1 좌표에서 출발해 보물이 있는 칸으로 이동하려고함
// 이동할떄 상하 좌우 이동 가능, 한칸을 걸어서 이동하는데 걸리는 시간은 1

// 근데 보물이 위치한 칸으로 수월하게 이동하기 위해 신비 신발이 있고
// 이 신발을 신고 띄면 한번에 두칸을 이동할 수있으며 함정이 있는 칸도 넘을수 있음
// 하지만 이 신발은 한번 밖에 이용할수 없고 이걸 사용하여 두칸을 이동하는 시간도 1임

// 이때 보물이 위치한 칸으로 이동하는 최소시간을 리턴해라

// 샌드박스
// bfs를 사용할 조건이 나왔는데 저 신발을 활용한 그것이 포인트임
// 일단 맵을 만들고, 거기에 장애물을 표기하자

import java.util.*;

class TreasureMap {
    int dy[] = {1,-1,0,0};
    int dx[] = {0,0,1,-1};
    boolean[][][] visit;
    int answer = 0;

    public int solution(int n, int m, int[][] hole) {

        int[][] map = new int[n+1][m+1];
        visit = new boolean[n+1][m+1][2];

        // 장애물 설치
        for(int i = 0; i < hole.length; i++){
            int ban_x = hole[i][0];
            int ban_y = hole[i][1];

            map[ban_x][ban_y] = -1;
        }

        bfs_map(1,1, n ,m ,map);

        return answer;
    }

    private void bfs_map(int start_x, int start_y, int end_x, int end_y, int[][] map){
        Queue<int []> q = new LinkedList<>();

        q.offer(new int[]{start_x, start_y, 0, 1});
        visit[start_x][start_y][1] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int cur_x = cur[0];
            int cur_y = cur[1];
            int count = cur[2];
            int magic_shoes = cur[3];

            if(cur_x == end_x && cur_y == end_y){
                answer = count;
                return ;
            }
            for(int i = 0; i < 4; i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                int nx_shoes = cur_x +( dx[i] * 2);
                int ny_shoes = cur_y +( dy[i] * 2);

                if((nx_shoes >= 1 && nx_shoes < map.length) && (ny_shoes >=1 && ny_shoes < map[0].length)){
                    if(!visit[nx_shoes][ny_shoes][magic_shoes] && map[nx_shoes][ny_shoes] != -1 && magic_shoes == 1){
                        q.offer(new int[]{nx_shoes, ny_shoes, count +1, magic_shoes-1});
                        visit[nx_shoes][ny_shoes][magic_shoes-1] = true;
                    }
                }

                if((nx >= 1 && nx < map.length) && (ny >= 1 && ny < map[0].length)){
                    if(!visit[nx][ny][magic_shoes] && map[nx][ny] != -1){
                        q.offer(new int[]{nx, ny, count +1, magic_shoes});
                        visit[nx][ny][magic_shoes] = true;
                    }
                }
            }
            answer = -1;
        }
    }
}
