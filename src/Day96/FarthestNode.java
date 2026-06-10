package Day96;

// 가장 먼 노드

// n개의 노드가 있는 그래프가 있음
// 각 노드는 1부터 n까지 번호가 적혀있고
// 1번 노드에서 가장 멀리 떨어진 노드의 개수를 구하려고함
// 노드의 개수 n, 간선의 정보가 담기 2차원 배열 edge가 매개변수로
// 주어질 떄 1번 노드로 부터 가장 멀리 떨어진 노드가 몇개인지 리턴

// 최단 경로와 관련되었으니 bfs일 확률이 높음
// 모든 이동하는 간선 길이가 동일할테니?
// 일단 생각이 드는게 각 노드 번호까지 이동하는걸 기록하고
// 거기서 가장 큰 값 max 값을 찾고 그 값과 같은게 몇개 있는지
// 카운팅 하면 될것같은데?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class FarthestNode {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edge){
            int v1 = e[0];
            int v2 = e[1];
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        dist[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int neighbor : adj.get(cur)){
                if(dist[neighbor] == -1){
                    dist[neighbor] = dist[cur] + 1;
                    q.offer(neighbor);
                }
            }
        }
        int answer = 0;
        int maxVal = 0;
        for(int i = 0; i <= n; i++){
            maxVal = Math.max(maxVal, dist[i]);
        }
        for(int i = 0; i <= n; i++){
            if(dist[i] == maxVal)
                answer++;
        }
        return answer;
    }
}
