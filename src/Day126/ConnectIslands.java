package Day126;

// n개의 섬 사이에 다리를 건설하는 비용이 주어질 때
// 최소의 비용으로 모든 섬이 서로 통해 가능하도록
// 만들 때 필요한 최소 비용을 리턴하도록 해라

// 다리를 여러 번 건너더라도 도달 할수만 있다면
// 통해 가능하다고 본다
// cost [i][0]과 1에는 다리가 연결되는 두번호가
// 있고 costs[i][2]에는 건설 비용이 적혀있음

import java.util.Arrays;

class ConnectIslands {
    int parent[];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        Arrays.sort(costs, ((a,b) ->
                a[2] - b[2]));

        for(int i = 0; i < costs.length; i++){
            if(union(costs[i][0], costs[i][1])){
                answer+= costs[i][2];
            }
        }

        return answer;
    }

    private int find(int x){
        if(parent[x] == x)
            return x;

        return find(parent[x]);
    }

    private boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return false;
        }
        else{
            parent[rootA] = rootB;
        }
        return true;
    }
}
