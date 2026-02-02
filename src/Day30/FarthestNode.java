package Day30;

// 최단 경로는 bfs가 신이야
// 일단 지도를 우리가 만들어줘야해
// 지도를 어떤 자료 구조로 하면좋을까?

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class FarthestNode {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];

        q.offer(1);
        visited[1] = true;
        dist[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nextIdx : graph.get(cur)) {
                if (!visited[nextIdx]) {
                    visited[nextIdx] = true;
                    dist[nextIdx] = dist[cur] + 1;
                    q.offer(nextIdx);
                }
            }
        }
        int maxDist = 0;
        for (int i : dist) {
            maxDist = Math.max(maxDist, i);
        }
        for (int i : dist) {
            if(i == maxDist)
                answer++;
        }
        return answer;
    }
}
