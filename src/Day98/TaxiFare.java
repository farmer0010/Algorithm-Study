package Day98;

// 합승 택시 요금
// 무지는 최근에 야근이 잦아지면서
// 택시를 많이 이용하게 되어 택시비를 아낄 수있는 방법을 고민중임
// 무지는 자신이 택시를 이용 할 떄 자신과 비슷한 방향으로 가는 택시를
// 종종 이용하는 것을 알게됨
// 무지는 어피치와 귀가 방향이 비슷하여 택시 합승을 적절히 이용하면
// 택시 요금을 얼마나 아낄수 있는지 계산해보고 어피치에게 합승을 제안하려고함

// 이동 방향 양방향에, 가중치가 있는 옵션이 있어서 클래스를 하나 만들어서
// 관리하면 괜찮을듯?
// 우리는 a와 b가 가는데 있어서 항상 최적의 경로와 비용을 생각해야되니깐
// 그리디도 정렬해야되는 부분이 필요한 것 같고, 모든 경로에 대한 도착지
// 의 최적의 선도 구해봐야하니 플로이드 워셜이 필요하지않을까 생각중임
// 만약 합승을 하지않고 각장 이동하는 경우에 예상 택시 요금이 더 낮다면
// 합승 하지않아도 됨
// 지점의 개수 n, s가 출발 지점, 도착지 a, 도착지 b
// 지점 사이의 예상 요금 fares

// 일단 생각든거 fares 표를 노드로 만들어줘서 저장해야됨
// 그러고 최적의 수를 찾기위해서 우선 순위 큐를 사용하지않을까 생각중인데
// 샌드박스 피드백: 내가 원래 하려던 방식은 다 익스트라 방식인데
// 플로이드 워셜 방식으로 할경우엔 이게 필요가 없어짐
// 이번엔 플로이드 워셜 방식을 다시 공부한 만큼 이 방식으로 진행해보자

import java.util.Arrays;

class TaxiFare {
    private static final int INF = 1_00_000_000;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int [][]dist = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 장부 채워주기
        for(int[] fare : fares) {
            int start = fare[0];
            int end = fare[1];
            int fee = fare[2];

            dist[start][end] = fee;
            dist[end][start] = fee;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], (dist[i][k] + dist[k][j]));
                }
            }
        }

        int answer = INF;

        for (int k=1; k <= n; k++) {
            int totalCost = dist[s][k] + dist[k][a] + dist[k][b];
            answer = Math.min(answer, totalCost);
        }
        return answer;
    }
}