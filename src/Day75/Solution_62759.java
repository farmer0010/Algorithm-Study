package Day75;

// 경주로 건설

// 제공된 경주로 설계 도면은 N * N 크기의 정사각형 격자형태이며
// 각 격자칸은 1 * 1
// 설계 도면에 각 격자칸에는 1,0인데
// 1은 벽, 0은 빈 공간

// 경주로의 출발점은 0,0 이고 도착점은 n-1, n-1
// 무사히 도착할수있게 중간에 끊기지않도로 경주로를 건설해야함
// 경주로는 상,하,좌,우로 인전합 두 빈칸을 연결하여 건설할 수 있으며
// 벽이 있는 칸은 경주로를 건설할수 x

// 상하 또는 좌우로 연결된 경주로는 직선도로
// 서로 직각으로 만나는 지점은 코너
// 직선도로 100원, 코너 500원

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution_62759 {
    static class Node implements Comparable<Node>{
        int x,y;
        int cost;
        int dir; // 0: 상, 1: 우, 2: 하, 3:좌

        public Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static final int INF = 1_000_000_000;
    static int dist[][][];

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    public int solution(int[][] board) {
        int n = board.length;

        dist = new int[4][n][n];
        for(int i=0;i<4;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dist[i][j],INF);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,0,-1));

        for(int i=0;i<4;i++){
            dist[i][0][0] = 0;
        }
        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(curr.x == n-1 && curr.y == n-1){
                return curr.cost;
            }
            for(int i=0;i<4;i++){
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<n && board[nx][ny] != 1){
                    int nextCost = curr.cost;;

                    if(curr.dir == -1 || curr.dir == i){
                        nextCost += 100;
                    }
                    else {
                        nextCost += 600;
                    }
                    if(nextCost < dist[i][nx][ny]){
                        dist[i][nx][ny] = nextCost;
                        pq.offer(new Node(nx,ny,nextCost,i));
                    }
                }
            }
        }
        return 0;
    }
}
