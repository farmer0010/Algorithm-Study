package Day33;

import java.util.LinkedList;
import java.util.Queue;

class DividePowerGrid {
    // 송전탑의 연결정보를 저장할 2차원 배열
    static int[][] map;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n+1][n+1];
        // 모든 전선 연결정보를 map에 저장
        for (int[] w : wires) {
            int a = w[0];
            int b = w[1];
            map[a][b] = 1;
            map[b][a] = 1;
        }
        for (int[] w : wires) {
            int a = w[0];
            int b = w[1];
            // 1. 전선 끊기
            map[a][b] = 0;
            map[b][a] = 0;

            // 끊어진 상태에서 a와 연결된 애들이 몇명인지?
            int cnt = bfs(n, a);
            int diff = Math.abs(cnt - (n -cnt));
            answer = Math.min(answer, diff);

            map[a][b] = 1;
            map[b][a] = 1;
        }
        return answer;
    }

    private int bfs(int n, int start) {
        int count = 1;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 1; i <= n; i++)
            {
                if(map[cur][i] == 1 && !visited[i])
                {
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        return count;
    }
}
