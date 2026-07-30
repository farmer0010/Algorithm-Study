package Day121;

// 리코쳇 보드게임

// 이 보드게임은 격자 모양 게임판 위에서 말을 움직이는 게임이고, 시작 위치에서 출발 한뒤
// 목표 위치에 정확하게 멈추기 위해 최소 몇번의 이동이 필요한지 말하는 게임이다.
// 현재 위치에서 상,하,좌,우 중 한 방향으로 게임판 위의 장애물이나 게임판 가장 자리까지
// 부딪힐 때 까지 미끄러져 움직이는 것을 한번 정의 라고함

// 샌드박스
// 1. 최소한의 이동거리와 배열의 크기를 생각하자면 bfs를 통해 이 문제를 해결해야함
// 2. 하지만 한칸씩 이동하는 기존 형태와 다르게 게임판의 가장 자리에 부딫히거나
// 장애물에 대해 부딫 힐떄 그 크기가 늘어나게 됨
// 3. 그래서 이동 방향에 대해서도 저장하고 그걸 유지해야하나? 그래야 그 다음 좌표가 그거라는거 알수있으니
// 3번의 생각말고 벽에 부딫히거나 장애물을 만나지 않았을떄까지 움직이게 하고
// 이걸 만났을때 회수를 한번 체크하고 체크판을 처리하면 됨

// 배열의 크기인지, 문자열의 크기인지 체크

import java.util.*;

class RicochetRobot {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][] isVisited;

    public int solution(String[] board) {
        isVisited = new boolean[board.length][board[0].length()];
        int answer = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                if (board[i].charAt(j) == 'R'){
                    answer = bfs_rico(i, j, board);
                }
            }
        }


        return answer;
    }
    private int bfs_rico(int startX, int startY, String[] board){
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int []{startX, startY, 0});
        isVisited[startX][startY] = true;

        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int count = cur[2];

            if(board[curX].charAt(curY) == 'G')
            {
                return count;
            }

            for(int i = 0; i < 4; i++){
                int nx = curX;
                int ny = curY;

                while(nx + dx[i] >= 0 && nx + dx[i] < board.length && ny + dy[i] >= 0 && ny + dy[i] < board[0].length()
                        && board[nx + dx[i]].charAt(ny + dy[i]) != 'D' ){
                    nx += dx[i];
                    ny += dy[i];
                }
                if(!isVisited[nx][ny]){
                    isVisited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, count+1});
                }
            }
        }
        return -1;
    }
}