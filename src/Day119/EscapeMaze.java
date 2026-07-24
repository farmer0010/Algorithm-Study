package Day119;

// 1 * 1 크기의 칸들로 이루어진 직사각형 격자 형태의
// 미로를 탈출하려고함
// 각 칸은 통로 또는 벽으로 구성됨
// 통로로 된 칸만 지나갈수 있음
// 통로중 1칸은 미로로 빠져나가는 문이고 이 문은
// 레버를 당겨서야만 나갈 수 있다.
// 레버는 통로들 중 한 칸에 있다
// 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈수 있음
// 미로에서 한칸을 이동하는데 1초가 소요됨
// 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구해야함

// 탈출하지 못할 경우 return -1

// 시작 지점 s, 출구 e, 레버 l, 통로 o, 벽, x
// 샌드 박스:
// 1. 일단 bfs를 두개로 찢어야함 시작점 부터, 레버
// 레버  부터 끝 지점

import java.util.LinkedList;
import java.util.Queue;

class EscapeMaze {
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};

    boolean[][] isVisited;

    public int solution(String[] maps) {

        int fir_p = 0;
        int sec_p = 0;

        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    fir_p = bfs_miro2(i, j, 'S','L',maps);
                }
                if(maps[i].charAt(j) == 'L'){
                    sec_p = bfs_miro2(i, j, 'L','E',maps);
                }
            }
        }

        if(fir_p == -1 || sec_p == -1){
            return -1;
        }
        return fir_p + sec_p;
    }

    private int bfs_miro2(int startX, int StartY, char start, char end, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        isVisited = new boolean[maps.length][maps[0].length()];

        queue.offer(new int[]{startX, StartY, 0});
        isVisited[startX][StartY] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int depth = curr[2];

            if(maps[currX].charAt(currY) == end){
                return depth;
            }

            for(int i = 0; i < 4; i++){
                int newX = currX + dx[i];
                int newY = currY + dy[i];

                if(newX >= 0 && newX < maps.length && newY >= 0 && newY < maps[0].length()){
                    if(maps[newX].charAt(newY) != 'X' && !isVisited[newX][newY]){
                        isVisited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY, depth+1});
                    }
                }
            }
        }
        return -1;
    }

}
