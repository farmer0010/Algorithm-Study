package Day95;

// 섬 연결하기
// n개의 섬 사이에 다리를 건설하는 비용(cost)가 주어질 때
// 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때
// 필요한 최소 비용을 return 하도록 함수를 완성하세요

// 다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 본다
// 예를 들어 A와 B섬 사이에 다리가 있고 B와 C섬에 다리가 있으면
// A섬과 C섬은 서로 통행 가능하다
// 제한 사항
// cost의 길이는 ((n-1) * n) / 2
// cost[i][0], cost[i][1] -> 다리가 연결되는 두 섬의 번호
// cost[i][2] -> 다리를 건설할 떄는 드는 비용
// 같은 연결은 두번 주어지지 x, 순서가 바뀌더라도 같은 연결로 봄
// 모든 섬 사이의 다리 건설 비용이 주어지지 X, 두 섬 사이의 건설이 불가능

// 그 상황마다 가장 최적의 수를 찾아야할 것 같으니깐 그리디 일것같긴한데
// 유니온-파인드 :
// 문제점 : 이미 연결 되어있어서 빙 돌아갈 수 있는 섬인데
// 거기에 다리를 놓으면 돈 낭비이니깐 두 섬이 하나의 네트워크에
// 속해있는지 감시하는 유니온 파인드라는 방어막이 필요하다
// 각 섬이 처음에는 자기 자신이 조장인 1인팀인데, 그러다가
// 다리가 연결되면 한쪽 팀이 다른쪽 밑으로 들어가면서 조장을 통합
// 그래서 조장의 번호를 적어두는 장부를 세팅하고, 조장을 찾고
// 서로 조장이 다르면 다리를 건설하고, 두 팀을 합쳐주는 함수

import java.util.Arrays;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (a, b)->{
            return a[2] - b[2];
        });
        // 장부 개설
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            if(find(from) != find(to))
            {
                union_island(from, to);
                answer += cost;
            }
        }
        return answer;
    }

    private void union_island(int from, int to) {
        int rootX = find(from);
        int rootY = find(to);
        if(rootX != rootY){
            parent[rootY] = rootX;
        }
    }

    private int find(int bestNum){
        if(parent[bestNum] == bestNum)
            return bestNum;
        return parent[bestNum] = find(parent[bestNum]);
    }
}

