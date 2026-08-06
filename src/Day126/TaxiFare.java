package Day126;

// 합승 택시 요금

// 자신이 택시를 이용할 때 동료와 자신이 비슷한 방향으로
// 확인하여 택시 합승을 적절히 이용하면 택시 요금을 얼마나 아낄수 있을지
// 계산해보고 택시 합승을 적절히 이용해보려고 한다

// 지점은 n개, 지점간에 택시가 이동할 수있는 경로를 간선이라고 함, 간선에 표시된
// 숫자는 두 지점 사이의 택시 요금을 의미함
// 매개 변수: 출발지점 s, a의 도착지점 a, b의 도착지점 b
// 각 간선마다 지점 사이 예상 택시 요금 fares
// fares 배열은 출발지점, 도착지점, 비용 이렇게 정리됨

// 헷갈릴수 있는게 n빵으로 나눠서 각각의 최적 비용을 구하는게 아니라 a,b 둘다 귀가
// 완료되는데 드는 최소 비용을 구하는 것임을 인지

// 샌드박스
// 1. 모든 정점에서 모든 정점을 이동하는 최단 경로 예시를 생각해보니
// 플로이드 - 워셜에 대해서 생각해보자
// 2. 플루이드 워셜이 3중 for문을 활용해 뭐 작업했던거같은데 오랜만에 푸니
// 어떤식으로 활용했는지 미미함
// 3. 그래서 일단 이동 기록지를 만들어볼 배열을 세워보자 우선

import java.util.Arrays;

class TaxiFare {
    static final int INF = 100000000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;

        int dist[][] = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i = 0; i < fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int fee = fares[i][2];

            dist[start][end] = fee;
            dist[end][start] = fee;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                {
                    dist[i][j] = Math.min(dist[i][j], (dist[i][k] +dist[k][j]));
                }
        }

        for(int k = 1; k <= n; k++){
            int total_minute = dist[s][k] + dist[k][a] + dist[k][b];
            answer = Math.min(answer, total_minute);
        }

        return answer;
    }
}
