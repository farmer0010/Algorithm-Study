package Day74;

// n개의 도시가 있고 그리고 한 도시에 출발하여 다른 도식에 도착하는 m개의
// 버스가 있음, 각 버스는 한번 사용할 때 필요한 비용이 있다

// 모든 도시 쌍 (a,b)에 대해서 a에서 b로 가는데 필요한 비용의 최솟값은?
// 입력: 첫째줄에 도시의 개수 n이 주어지고, 둘째줄에는 버스의 개수 m이 주어진다
// 그리고 세째줄 부터 m+2줄 까지는 버스 정보가 주어짐
// 시작도시 a, 도착도시 b, 필요비용 c

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404 {
    static int n,m;
    static int dist[][];
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = INF;
            }
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[src][dest] = Math.min(dist[src][dest], cost);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+ dist[k][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    sb.append("0 ");
                }
                else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
