package Day122;
// 미로 탈출

// 1*1 크기들의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출 하려고함
// 각 칸은 통로 또는 벽으로 구성됨
// 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸만 이동 가능
// 통로 중 한칸에 문이 배치 되어있는데 이 문은 레버를 당겨야 나갈수있음

// 미로에서 한칸 이동하는데 1초가 걸리고 최대한 빠르게 미로를 탈출 하는데 걸리는 시간
// 을 리턴 만약 탈출 할수 없다면 -1을 리턴

// 샌드박스
// 최소 시간이니깐 bfs로 문제를 해결해야하고
// bfs를 두번 끊어야함 시작 지점부터 레버, 레버 부터 도착지까지

import java.util.*;

class MazeEscape {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][] visited;

    public int solution(String[] maps) {
        int count1 = 0;
        int count2 = 0;

        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    count1 = bfs_miro(i,j,'L',maps);
                }
                if(maps[i].charAt(j) == 'L'){
                    count2 = bfs_miro(i,j,'E',maps);
                }
            }
        }
        if(count1 == -1 || count2 == -1)
            return -1;

        int answer = count1 + count2;
        return answer;
    }
    public int bfs_miro(int startX, int startY, char end, String[] maps){
        Queue<int []> q = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length()];

        q.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            int cur[] = q.poll();

            int curx = cur[0];
            int cury = cur[1];
            int count = cur[2];

            if(maps[curx].charAt(cury) == end){
                return count;
            }

            for(int i = 0; i < 4; i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if(nx >= 0 && nx < maps.length && ny >=0 && ny < maps[0].length()){
                    if(!visited[nx][ny] && maps[nx].charAt(ny) != 'X'){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, count+1});
                    }
                }
            }
        }
        return -1;
    }
}