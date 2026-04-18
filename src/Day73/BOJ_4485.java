package Day73;

// 녹색 옷 입은 얘가 젤다지?

// 링크는 N * N 크기의 동굴의 제일 위쪽에 있음
// [0][0]칸
// 동굴을 탈출하는데 제일 오른쪽 아래칸인 [N-1][N-1]까지 이동해야함
// 동굴의 각칸 마다 도둑 루피가 있고 이칸을 지나면 도둑루피 크기만큼
// 소지금을 잃음, 링크는 잃는 금액을 최소로 하여 목적지까지 도달해야함

// 한번에 상하 좌우 인접한 곳으로 1칸씩 이동가능 (bfs)일수도있으니 주의
// 링크가 잃을 수밖에 없는 최소 금액은?

// 입력: 여러개의 테스트 케이스가 있음 (방문 한 부분이나 지역 초기화 필요)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    static class Node implements Comparable<Node>{
        int r,c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int N;
    static int map[][];
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int dist[][];
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        while(true){
            N = Integer.parseInt(br.readLine());

            if(N == 0)
                break;
            map = new int[N][N];
            visited = new boolean[N][N];
            dist = new int[N][N];

            //맵 만들기
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 요금 계산서 채우기
            for(int i = 0; i < N; i++){
                Arrays.fill(dist[i],INF);
            }
            int answer = bfs_link2(0,0);
            System.out.println("Problem " + tc + ": " + answer);
            tc++;
        }
    }

    private static int bfs_link2(int startX, int startY) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startX, startY, map[startX][startY]));
        dist[startX][startY] = map[startX][startY];

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curx = cur.r, cury = cur.c;
            int cost = cur.cost;

            if(curx == N-1 && cury == N-1){
                return cost;
            }

            for(int i = 0; i < 4; i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                    int next_cost = cost + map[nx][ny];
                    if(dist[nx][ny] > next_cost){
                        dist[nx][ny] = next_cost;
                        pq.offer(new Node(nx, ny, next_cost));
                    }
                }
            }
        }
        return 0;
    }
}
