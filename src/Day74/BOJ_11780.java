package Day74;

// 플로이드 2

// n개의 도시가 있고 한도시에서 출발하여 다른 도시에 도착하는
// m개의 버스가 있다
// 모든 도시의 쌍(A,B)에 대해서 A에서 B로 가는데 필요한 비용의 최솟값은?

// 입력: 첫째줄에 도시의 개수 n이 주어지고 둘째줄에는 버스의 개수 m이 주어짐
// 셋째줄 부터 m+2줄까지 다음과 같은 버스 정보가 주어짐

// 시작도시 a, 도착도시 b, 비용 c
// 먼저 n개의 줄 출력 i,j로 가는데 필요한 최소 비용
// 만약 i,j로 갈수 없는 경우 0 출력

// n * n개의 줄을 출력, 도시 i,j로 가는 최소비용에 포함되는 도시의 개수 k
// 를 출력해야함
// 만약 i에서 j로 갈수 없는 경우에는 0을 출력한다

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11780 {
    static final int INF = 1_000_000_000;
    static int dist[][];
    static int prevNode[][];
    static int n,m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1][n+1];
        prevNode = new int[n+1][n+1];

        // 비용은 정적 변수로 초기화하는게 낫지만
        // 거치도시는 0으로 초기화하는게 차후에 출력할떄 나을것같아서
        // 일단 이러한 방식으로 생각해봄
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j){
                    dist[i][j] = 0;
                    prevNode[i][j] = INF;
                }
                else{
                    dist[i][j] = INF;
                    prevNode[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(cost < dist[src][dest]){
                dist[src][dest] = cost;
                prevNode[src][dest] = dest;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        prevNode[i][j] = prevNode[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(dist[i][j] == INF || dist[i][j] == 0){
                    sb.append("0 ");
                }
                else{
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(dist[i][j] == INF || dist[i][j] == 0){
                    sb.append("0\n");
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                int curr = i;
                while(curr != 0){
                    list.add(curr);
                    if(curr == j) break;
                    curr = prevNode[curr][j];
                }
                sb.append(list.size()).append(" ");
                for (Integer integer : list) {
                    sb.append(integer).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
