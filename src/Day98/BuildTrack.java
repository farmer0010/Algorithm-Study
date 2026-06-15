package Day98;

// 경주로 건설

// 죠르디는 고객사로 부터 자동차 경주로 건설에 필요한 견적을 의뢰받음
// 제공된 경주로 설계 도면에 따르면 경주로 부지는 N * N
// 정사각형 격자형태이며 각 격자는 1 * 1 크기다

// 설계 도면에 각 격자의 칸은 0 또는 1로 채워져있으며 0은 칸이 비어있고
// 1은 해당 칸이 벽으로 채워져있음을 나타낸다.

// 경주로의 출발점은 0,0 도착점은 N-1, N-1이고
// 중간에 끊기지 않도록 경주로를 개설 해야된다
// 경주로는 상하좌우로 인전한 두 빈칸을 연결하여 건설할 수있으며
// 벽이 있는 칸에는 경주로를 건설할수 없다
// 상하 또는 좌우로 연결한 경주로를 직선도로라 하고
// 서로 만나는 지점을 코너라고하는데
// 직선 도로 하나를 만들때는 100원이 소요되고, 코너를 하나 만들
// 떄는 500원이 추가로 소요됨
// 이것에 대한 최소 비용을 구하시오
// 일단 bfs를 사용해야하는데 직선일 떄는 그냥 움직이면 그걸로 판단을 하는데
// 코너임을 어떻게 판별하고 가격을 더할것이냐?? 그 코너 판별 조건이 중요할듯?

// 샌드박스 피드백: 우리가 코너 판별조건을 사용하기 위해서 지금
// 움직이는 방향 자체를 기록하고 같이 저장해주면서 움직여야됨
// Arrays.fill() 함수는 한줄 밖에 칠하지 못함을 알아야함

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class BuildTrack {
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};

    class Node{
        int x;
        int y;
        int dir;
        int cost;

        public Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }


    public int solution(int[][] board) {
        int n = board.length;

        int dist[][][] = new int[n][n][4];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,-1,0));

        while(!q.isEmpty()){
           Node cur = q.poll();
           int curX = cur.x;
           int curY = cur.y;
           int curDir = cur.dir;
           int curCost = cur.cost;

           for (int i = 0; i < 4; i++) {
               int nx = curX + dx[i];
               int ny = curY + dy[i];

               if(nx >=0 && ny >= 0 && nx < n && ny < n  && board[nx][ny] == 0){
                   int nextCost = 0;
                   if(curDir == -1 || curDir == i){
                        nextCost = curCost + 100;
                   }
                   else{
                       nextCost +=  curCost + 600;
                   }
                   if(nextCost < dist[nx][ny][i]){
                       dist[nx][ny][i] = nextCost;
                       q.offer(new Node(nx,ny,i,nextCost));
                   }
               }
           }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            answer = Math.min(answer, dist[n-1][n-1][i]);
        }
        return answer;
    }
}
